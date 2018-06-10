package com.rankenstein.services.shiro;

import com.rankenstein.services.models.UnconfirmedUser;
import com.rankenstein.services.models.User;
import com.rankenstein.services.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RankensteinRealm extends AuthorizingRealm {
    @Autowired
    UserRepository userRepository;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(final PrincipalCollection principals) {
        final Set<String> roles = new HashSet<>();
        final Set<String> permissions = new HashSet<>();
        Collection<String> userIds = ((SimplePrincipalCollection) principals.getPrimaryPrincipal()).fromRealm(getName());
        for (String userId : userIds) {
            Optional.ofNullable(userId)
                    .flatMap(userRepository::findById)
                    .ifPresent(user -> {
                        if (user.getRoles() != null) {
                            roles.addAll(user.getRoles());
                        }
                        if (user.getPermissions() != null) {
                            permissions.addAll(user.getPermissions());
                        }
                    });
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        final String username = token.getUsername();
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new AuthenticationException("User " + username + " not found");
        } else if (user instanceof UnconfirmedUser) {
            throw new AuthenticationException("User " + username + " has not yet been confirmed");
        } else if (user.getAttemptsLeft() == 0) {
            throw new AuthenticationException("User " + username + " is locked");
        }
        SimplePrincipalCollection simplePrincipalCollection = new SimplePrincipalCollection();
        simplePrincipalCollection.add(user.getId(), getName());
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(simplePrincipalCollection,
                                                                user.getHashedPasswordBase64(),
                                                                ByteSource.Util.bytes(Base64.decode(user.getPasswordSalt())),
                                                                getName());
        if (!getCredentialsMatcher().doCredentialsMatch(token, simpleAuthenticationInfo)) {
            user.setAttemptsLeft(user.getAttemptsLeft() - 1);
            userRepository.save(user);
            throw new IncorrectCredentialsException();
        } else {
            user.setAttemptsLeft(User.BASE_ATTEMPTS_LEFT_FOR_LOGIN);
            userRepository.save(user);
        }
        return simpleAuthenticationInfo;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }
}

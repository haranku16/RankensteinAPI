package com.rankenstein.services.shiro;

import com.rankenstein.services.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@FieldDefaults(level = AccessLevel.PRIVATE)
@SpringBootTest
public class RankensteinRealmTest extends RankensteinRealm {
    @Mock
    UserRepository userRepository;

    UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("username", "password");

    @Before
    public void initialize() {
        MockitoAnnotations.initMocks(this);
        setUserRepository(userRepository);
    }

    @Test(expected = AuthenticationException.class)
    public void testDoGetAuthenticationInfo() {
        when(userRepository.findByUsername("username")).thenReturn(null);
        doGetAuthenticationInfo(usernamePasswordToken);
    }
}

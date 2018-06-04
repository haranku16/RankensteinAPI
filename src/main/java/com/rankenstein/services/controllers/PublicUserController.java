package com.rankenstein.services.controllers;

import com.google.common.collect.ImmutableSet;
import com.rankenstein.services.exceptions.AlreadyLoggedInException;
import com.rankenstein.services.exceptions.LoginValidationException;
import com.rankenstein.services.exceptions.RegistrationValidationException;
import com.rankenstein.services.exceptions.UserAlreadyExistsException;
import com.rankenstein.services.formInput.LoginForm;
import com.rankenstein.services.formInput.RegistrationForm;
import com.rankenstein.services.models.User;
import com.rankenstein.services.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

import static com.rankenstein.services.shiro.ShiroSpringConfig.HASHING_ITERATIONS;

@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping(path="/api/public")
@RestController
public class PublicUserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RandomNumberGenerator randomNumberGenerator;

    private static final Set<String> userRoles = ImmutableSet.of("USER");
    private static final Set<String> userPermissions = ImmutableSet.of();

    @RequestMapping(path="/login", method = RequestMethod.POST)
    public void login(@Valid @RequestBody LoginForm loginForm, BindingResult result) throws LoginValidationException, AlreadyLoggedInException {
        if (result.hasErrors()) {
            throw new LoginValidationException();
        }
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(loginForm.getUsername(), loginForm.getPassword());
            token.setRememberMe(true);
            subject.login(token);
        } else {
            throw new AlreadyLoggedInException();
        }
    }

    @RequestMapping(path="/logout", method = RequestMethod.POST)
    public void logout() throws UnauthenticatedException {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            throw new UnauthenticatedException();
        }
        subject.logout();
    }

    @RequestMapping(path="/register", method = RequestMethod.POST)
    public void register(@Valid @RequestBody RegistrationForm registrationForm, BindingResult result) throws RegistrationValidationException, AlreadyLoggedInException, UserAlreadyExistsException {
        if (result.hasErrors()) {
            throw new RegistrationValidationException();
        }
        if (SecurityUtils.getSubject().isAuthenticated()) {
            throw new AlreadyLoggedInException();
        }
        if (userRepository.findByUsername(registrationForm.getUsername()) != null) {
            throw new UserAlreadyExistsException();
        }
        ByteSource passwordSalt = randomNumberGenerator.nextBytes();
        String hashedPasswordBase64 = new Sha512Hash(registrationForm.getPassword(), passwordSalt, HASHING_ITERATIONS).toBase64();
        User user = User.builder().username(registrationForm.getUsername())
                .passwordSalt(passwordSalt.toBase64())
                .hashedPasswordBase64(hashedPasswordBase64)
                .name(registrationForm.getName())
                .nickname(registrationForm.getNickname())
                .email(registrationForm.getEmail())
                .phoneNumber(registrationForm.getPhoneNumber())
                .roles(userRoles)
                .permissions(userPermissions)
                .build();
        userRepository.save(user);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RegistrationValidationException.class)
    public void registrationConstraintViolations() {
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(LoginValidationException.class)
    public void loginConstraintViolation() {
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "ALREADY_LOGGED_IN")
    @ExceptionHandler(AlreadyLoggedInException.class)
    public void alreadyLoggedIn() {
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "UNAUTHENTICATED")
    @ExceptionHandler(UnauthenticatedException.class)
    public void unauthenticated() {
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "UNAUTHORIZED")
    @ExceptionHandler(UnauthorizedException.class)
    public void unauthorized() {
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "USER_EXISTS")
    @ExceptionHandler(UserAlreadyExistsException.class)
    public void userAlreadyExists() {
    }
}

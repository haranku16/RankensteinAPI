package com.rankenstein.services.validation.username;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class UsernameValidator implements ConstraintValidator<Username,String> {
    private static final Pattern PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{4,}$");

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return username != null && PATTERN.matcher(username).matches();
    }
}

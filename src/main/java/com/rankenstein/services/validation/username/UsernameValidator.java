package com.rankenstein.services.validation.username;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class UsernameValidator implements ConstraintValidator<Username,String> {
    private static final Pattern PATTERN = Pattern.compile("^[_]{0,1}[a-zA-Z][_]{0,1}(?:[a-zA-Z\\d][_]{0,1})*$");

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return username != null && PATTERN.matcher(username).matches() && username.length() >= 5;
    }
}

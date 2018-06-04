package com.rankenstein.services.validation.password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password,String> {
    private static Pattern PATTERN = Pattern.compile("^[a-zA-Z0-9~!@#$%^&\\*]{8,}$");
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return password != null && PATTERN.matcher(password).matches();
    }
}

package com.rankenstein.services.validation.phoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber,String> {
    private static final Pattern PATTERN = Pattern.compile("^\\+?[0-9. ()-]{10,25}$");

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        return phoneNumber != null && PATTERN.matcher(phoneNumber).matches();
    }
}

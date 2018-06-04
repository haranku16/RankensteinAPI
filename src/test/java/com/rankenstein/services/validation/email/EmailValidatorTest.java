package com.rankenstein.services.validation.email;

import com.rankenstein.services.validation.SimpleConstraintValidatorTest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailValidatorTest extends EmailValidator implements SimpleConstraintValidatorTest<Email,String> {
    @Test
    public void test() {
        testAllCases();
    }

    @Override
    public String[] getValidTestCases() {
        return new String[] {
            "panicFan@mail.com"
        };
    }

    @Override
    public String[] getInvalidTestCases() {
        return new String[] {
            "something", "123123123@mail"
        };
    }
}

package com.rankenstein.services.validation.password;

import com.rankenstein.services.validation.SimpleConstraintValidatorTest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PasswordValidatorTest extends PasswordValidator implements SimpleConstraintValidatorTest<Password,String> {
    @Test
    public void test() {
        testAllCases();
    }

    @Override
    public String[] getValidTestCases() {
        return new String[] {
            /* contains all valid characters */
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*~-_=+",
            "blahblah"
        };
    }

    @Override
    public String[] getInvalidTestCases() {
        return new String[] {
            /* only 7 characters, need at least 8 */
            "blahbla",
            /* invalid character (,) */
            "blah,blah"
        };
    }
}

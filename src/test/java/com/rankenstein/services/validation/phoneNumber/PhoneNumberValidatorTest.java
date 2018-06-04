package com.rankenstein.services.validation.phoneNumber;

import com.rankenstein.services.validation.SimpleConstraintValidatorTest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PhoneNumberValidatorTest extends PhoneNumberValidator implements SimpleConstraintValidatorTest<PhoneNumber,String> {
    @Test
    public void test() {
        testAllCases();
    }

    @Override
    public String[] getValidTestCases() {
        return new String[] {
            "15555555555",
            "+1 555 555 5555",
            "+09 555 5555555"
        };
    }

    @Override
    public String[] getInvalidTestCases() {
        return new String[] {
            "1800invader",
            "blahadf",
            "nonsense"
        };
    }
}

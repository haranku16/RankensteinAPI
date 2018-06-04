package com.rankenstein.services.validation.username;

import com.rankenstein.services.validation.SimpleConstraintValidatorTest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsernameValidatorTest extends UsernameValidator implements SimpleConstraintValidatorTest<Username, String> {
    @Test
    public void test() {
        testAllCases();
    }

    @Override
    public String[] getValidTestCases() {
        return new String[]{
            "blsfdsafd",
            "bwer234",
            "Zdfsdf32"
        };
    }

    @Override
    public String[] getInvalidTestCases() {
        return new String[]{
            "123sfsd",
            "sdf",
            "dsafsa#@!"
        };
    }
}

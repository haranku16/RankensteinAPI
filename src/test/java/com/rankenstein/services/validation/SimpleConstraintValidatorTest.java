package com.rankenstein.services.validation;

import javax.validation.ConstraintValidator;
import java.lang.annotation.Annotation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public interface SimpleConstraintValidatorTest<A extends Annotation,T> extends ConstraintValidator<A,T> {
    T[] getValidTestCases();
    T[] getInvalidTestCases();
    default void testAllCases() {
        for (T validTestCase : getValidTestCases()) {
            assertTrue(isValid(validTestCase, null));
        }
        for (T invalidTestCase : getInvalidTestCases()) {
            assertFalse(isValid(invalidTestCase, null));
        }
    }
}

package com.rankenstein.service.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConstraintViolationDocumentTest {
    @Getter
    @AllArgsConstructor
    static class Car {
        private String make;
        private String model;
        private Passenger passenger;
    }

    @Getter
    @AllArgsConstructor
    static class Passenger {
        private String name;
        private int age;
    }

    @Test
    public void test() {
        Car car = new Car("Toyota", "Corolla", new Passenger("Gary", 15));
        ConstraintViolationDocument constraintViolationDocument
                = ConstraintViolationDocument.of(car.getPassenger())
                                            .fromField("passenger")
                                            .because(ConstraintViolationDocument.of(car.getPassenger().getName())
                                                                                .fromField("name")
                                                                                .because("Gary isn't his real name!"));
        assertEquals("passenger", constraintViolationDocument.getField());
        assertEquals(car.getPassenger(), constraintViolationDocument.getValue());
        ConstraintViolation underlyingReason = constraintViolationDocument.getConstraintViolation();
        assertTrue(underlyingReason.getReason() instanceof ConstraintViolationDocument);
        ConstraintViolationDocument underlyingDocument = (ConstraintViolationDocument) underlyingReason.getReason();
        assertEquals("name", underlyingDocument.getField());
        assertEquals("Gary", underlyingDocument.getValue());
        assertEquals("Gary isn't his real name!", underlyingDocument.getConstraintViolation().getReason());
    }
}
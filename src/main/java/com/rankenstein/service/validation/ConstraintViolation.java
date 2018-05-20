package com.rankenstein.service.validation;

import lombok.Getter;

@Getter
public class ConstraintViolation<R> {
    private R reason;

    public ConstraintViolation(R reason) {
        this.reason = reason;
    }
}

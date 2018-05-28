package com.rankenstein.service.models;

import com.rankenstein.service.validation.Validation;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
public class Response<T> {
    enum Status {
        NOT_FOUND,
        CONNECTION_FAILURE,
        ILLEGAL_ACCESS,
        SUCCESS,
        CONSTRAINT_VIOLATION
    }
    private final boolean successful;
    private final Map<String,Validation> validations;
    T response;
}

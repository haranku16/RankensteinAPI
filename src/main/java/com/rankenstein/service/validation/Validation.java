package com.rankenstein.service.validation;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Validation {
    private final String field;
    private final String reason;
}

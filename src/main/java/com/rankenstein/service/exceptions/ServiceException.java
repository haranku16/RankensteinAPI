package com.rankenstein.service.exceptions;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ServiceException extends RuntimeException {
    private final ServiceError error;
}

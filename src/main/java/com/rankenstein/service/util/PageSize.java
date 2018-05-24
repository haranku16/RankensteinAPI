package com.rankenstein.service.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PageSize {
    TEN(10),
    TWENTY_FIVE(25),
    FORTY(50);

    private final int size;
}

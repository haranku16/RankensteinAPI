package com.rankenstein.service.annotations;

public @interface Hides {
    String[] value() default {};
}

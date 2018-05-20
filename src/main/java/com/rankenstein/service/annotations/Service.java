package com.rankenstein.service.annotations;

public @interface Service {
    enum Action {
        GET,
        POST
    }
    String path() default "";
    Action action() default Action.POST;
}

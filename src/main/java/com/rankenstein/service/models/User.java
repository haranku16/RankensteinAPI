package com.rankenstein.service.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
}

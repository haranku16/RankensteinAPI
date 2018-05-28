package com.rankenstein.service.models;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@Builder
public class User {
    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final List<User> friends;
    private final Map<String, Map<Relationship, Privilege>> relationshipPrivileges;
    private final Map<String, Map<User, Privilege>> userPrivileges;
}

package com.rankenstein.services.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class User {
    @Id
    String id;
    String username;
    String hashedPasswordBase64;
    String passwordSalt;
    String name;
    String nickname;
    String email;
    String phoneNumber;
    Set<String> roles;
    Set<String> permissions;
}

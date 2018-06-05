package com.rankenstein.services.models;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Set;

@Data
@Document
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    public static final long TTL = 1000L*60*60*24*365;

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

    @Field
    @Indexed(name = "expirationDateIndex", expireAfterSeconds = 0)
    Date expirationDate;

    @Version
    Long version;

    public void updateExpirationDate() {
        expirationDate.setTime(expirationDate.getTime() + TTL);
    }
}

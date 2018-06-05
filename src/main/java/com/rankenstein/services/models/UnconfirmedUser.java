package com.rankenstein.services.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UnconfirmedUser extends User {
    public static final long TTL = 1000*60*15;
    String confirmationCode;
}

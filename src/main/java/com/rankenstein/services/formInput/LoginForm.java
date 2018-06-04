package com.rankenstein.services.formInput;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginForm {
    @NotEmpty
    String username;
    @NotEmpty
    String password;
}

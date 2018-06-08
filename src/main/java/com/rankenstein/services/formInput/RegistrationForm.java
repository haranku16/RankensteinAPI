package com.rankenstein.services.formInput;

import com.rankenstein.services.validation.password.Password;
import com.rankenstein.services.validation.phoneNumber.PhoneNumber;
import com.rankenstein.services.validation.username.Username;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegistrationForm {
    @Username
    String username;
    @Password
    String password;
    @PhoneNumber
    String phoneNumber;
}

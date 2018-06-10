package com.rankenstein.services.formInput;

import com.rankenstein.services.validation.username.Username;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConfirmationForm {
    @Username
    String username;
    @NotEmpty
    String confirmationCode;
}

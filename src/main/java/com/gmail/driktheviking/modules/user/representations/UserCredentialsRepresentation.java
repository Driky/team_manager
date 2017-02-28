package com.gmail.driktheviking.modules.user.representations;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class UserCredentialsRepresentation {

    @NotNull
    private String username;

    @NotNull
    private String password;

    public UserCredentialsRepresentation(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
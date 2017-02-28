package com.gmail.driktheviking.modules.user.representations;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = {"username"})
public class UserRepresentation {

    private String username;

    private String firstName;

    private String lastName;

    private String emailAddress;

    public UserRepresentation(
            String username,
            String firstName,
            String lastName,
            String emailAddress) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }
}
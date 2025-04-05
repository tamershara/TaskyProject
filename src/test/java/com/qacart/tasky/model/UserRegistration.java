package com.qacart.tasky.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(setterPrefix = "set")
public class UserRegistration {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userType;
}

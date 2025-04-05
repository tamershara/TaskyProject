package com.qacart.tasky.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(setterPrefix = "set")
public class UserLogin {
    private String email;
    private String password;
}

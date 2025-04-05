package com.qacart.tasky.fixtures;

import com.qacart.tasky.model.UserLogin;
import com.qacart.tasky.model.UserRegistration;

import static com.qacart.tasky.utilites.RandomDataUtil.getRandomEmail;

public final class UserFixture {
    private UserFixture() {
    }

    private final static String email = getRandomEmail();

    public static UserRegistration getDefaultUserForRegister() {
        return UserRegistration.builder().setEmail(email).setFirstName("test").setLastName("automation").setPassword("test12").setUserType("regular").build();
    }

    public static UserLogin getDefaultUserForLogin() {
        return UserLogin.builder().setEmail(email).setPassword("test12").build();
    }
}

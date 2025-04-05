package com.qacart.tasky.clients;

import com.qacart.tasky.model.UserLogin;
import com.qacart.tasky.model.UserRegistration;
import io.restassured.response.Response;

import static com.qacart.tasky.clients.BaseClient.getDefaultRequestSpec;


public final class UserClient {
    private UserClient() {}

    public static Response registerAPI(UserRegistration user) {

        return getDefaultRequestSpec()
                .body(user)
                .when()
                .post("/auth/register")
                .then()
                .extract().response();
    }

    public static Response loginAPI(UserLogin user) {
        return getDefaultRequestSpec()
                .body(user)
                .when()
                .post("/auth/login")
                .then()
                .extract().response();
    }
}

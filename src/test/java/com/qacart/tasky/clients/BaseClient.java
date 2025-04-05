package com.qacart.tasky.clients;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static com.qacart.tasky.configs.ConfigFactory.getConfig;
import static io.restassured.RestAssured.given;

public final class BaseClient {
    private BaseClient() {}
    public static RequestSpecification getDefaultRequestSpec() {
        return given()
                .baseUri(getConfig().apiURL())
                .contentType(ContentType.JSON);
    }

    public static RequestSpecification getAuthenticatedRequestSpec(String token) {
        return getDefaultRequestSpec()
                .auth().oauth2(token);
    }
}

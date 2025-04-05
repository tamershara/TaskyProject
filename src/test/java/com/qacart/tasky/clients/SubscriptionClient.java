package com.qacart.tasky.clients;

import com.qacart.tasky.model.SubscriptionData;
import io.restassured.response.Response;

import static com.qacart.tasky.clients.BaseClient.getAuthenticatedRequestSpec;

public final class SubscriptionClient {
    private SubscriptionClient() {}
    public static Response subscribeAPI(SubscriptionData subscriptionData, String token) {
        return getAuthenticatedRequestSpec(token)
                .body(subscriptionData)
                .when()
                .post("/subscriptions")
                .then()
                .extract().response();

    }
}

package com.qacart.tasky.mocker;

import io.qameta.allure.Step;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public final class MockCurrentSubscription {
    private MockCurrentSubscription() {
    }

    @Step
    public static void makeTheSubscriptionCloseToExpiration() {
        stubFor(get(urlEqualTo("/api/subscriptions/current")).willReturn(aResponse().withBodyFile("current_subscription.json")));
    }
}

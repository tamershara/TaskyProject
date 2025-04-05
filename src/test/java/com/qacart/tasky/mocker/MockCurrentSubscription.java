package com.qacart.tasky.mocker;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public final class MockCurrentSubscription {
    private MockCurrentSubscription() {}

    public static void makeTheSubscriptionCloseToExpiration() {
        stubFor(
               get(urlEqualTo("/api/subscriptions/current"))
                       .willReturn(aResponse().withBodyFile("current_subscription.json"))
        );
    }
}

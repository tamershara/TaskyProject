package com.qacart.tasky.fixtures;

import com.qacart.tasky.model.SubscriptionData;

public final class subscriptionFixture {
    private subscriptionFixture() {}

    public static SubscriptionData getSubscriptionData() {
        return SubscriptionData
                .builder()
                .setCardNumber("4111111111111111")
                .setCvv("123")
                .setExpiryMonth("03")
                .setExpiryYear("2090")
                .setSubscriptionType("advanced")
                .build();
    }
}

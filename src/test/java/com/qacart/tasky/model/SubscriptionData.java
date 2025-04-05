package com.qacart.tasky.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(setterPrefix = "set")
public class SubscriptionData {
    private String cardNumber;
    private String cvv;
    private String expiryMonth;
    private String expiryYear;
    private String subscriptionType;
}

package com.qacart.tasky.pages;

import com.qacart.tasky.bases.BasePage;
import com.qacart.tasky.model.SubscriptionData;
import io.qameta.allure.Step;

import static com.qacart.tasky.clients.SubscriptionClient.subscribeAPI;
import static com.qacart.tasky.configs.ConfigFactory.getConfig;
import static com.qacart.tasky.driver.managers.DriverManager.getDriver;

public class SubscriptionPage implements BasePage {
    @Step
    @Override
    public void loadPage() {
        getDriver().get(getConfig().pageBaseURL() + "/dashboard/subscription");
    }

    @Step
    public void subscribeUsingAPI(SubscriptionData subscription,String token) {
        subscribeAPI(subscription,token);
    }
}

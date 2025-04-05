package com.qacart.tasky.pages;

import static com.qacart.tasky.configs.ConfigFactory.getConfig;
import static com.qacart.tasky.driver.managers.DriverManager.getDriver;

public class SubscriptionPage implements BasePage {
    @Override
    public void loadPage() {
        getDriver().get(getConfig().pageBaseURL() + "/dashboard/subscription");
    }
}

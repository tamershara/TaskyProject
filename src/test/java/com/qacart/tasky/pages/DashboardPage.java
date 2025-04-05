package com.qacart.tasky.pages;

import org.openqa.selenium.By;

import static com.qacart.tasky.configs.ConfigFactory.getConfig;
import static com.qacart.tasky.driver.managers.DriverManager.getDriver;

public class DashboardPage implements BasePage {
    private final By subscriptionButtonLocator = By.cssSelector("[data-testid=SubscriptionsIcon]");
    private final By renewButtonLocator = By.id(":r5:");
    @Override
    public void loadPage() {
        getDriver().get(getConfig().pageBaseURL() + "/dashboard");
    }

    public void clickSubscriptionButton() {
        getDriver().findElement(subscriptionButtonLocator).click();
    }

    public boolean isRenewButtonPresent() {
        return getDriver().findElement(renewButtonLocator).isDisplayed();
    }
}

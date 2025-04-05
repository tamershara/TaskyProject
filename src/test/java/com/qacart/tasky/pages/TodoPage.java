package com.qacart.tasky.pages;

import com.qacart.tasky.bases.BasePage;
import org.openqa.selenium.By;

import static com.qacart.tasky.configs.ConfigFactory.getConfig;
import static com.qacart.tasky.driver.managers.DriverManager.getDriver;

public class TodoPage implements BasePage {
    private final By LimiterMessageLocator = By.cssSelector("div.MuiAlert-message");
    @Override
    public void loadPage() {
        getDriver().get(getConfig().pageBaseURL() + "/dashboard");
    }

    public String getLimiterMessage() {
        return getDriver().findElement(LimiterMessageLocator).getText();
    }
}

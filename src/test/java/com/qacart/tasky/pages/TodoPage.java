package com.qacart.tasky.pages;

import com.qacart.tasky.bases.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.qacart.tasky.configs.ConfigFactory.getConfig;
import static com.qacart.tasky.driver.managers.DriverManager.getDriver;

public class TodoPage implements BasePage {
    private final By LimiterMessageLocator = By.cssSelector("div.MuiAlert-message");

    @Step
    @Override
    public void loadPage() {
        getDriver().get(getConfig().pageBaseURL() + "/dashboard/todos");
    }

    @Step
    public String getLimiterMessage() {
        return getDriver().findElement(LimiterMessageLocator).getText();
    }
}

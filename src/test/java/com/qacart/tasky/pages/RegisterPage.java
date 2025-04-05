package com.qacart.tasky.pages;

import com.qacart.tasky.bases.BasePage;
import com.qacart.tasky.model.UserRegistration;
import io.qameta.allure.Step;

import static com.qacart.tasky.clients.UserClient.registerAPI;
import static com.qacart.tasky.configs.ConfigFactory.getConfig;
import static com.qacart.tasky.driver.managers.DriverManager.getDriver;

public class RegisterPage implements BasePage {
    @Step
    @Override
    public void loadPage() {
        getDriver().get(getConfig().pageBaseURL() + "/register");
    }

    @Step
    public void registerUser(UserRegistration user) {
        registerAPI(user);
    }
}

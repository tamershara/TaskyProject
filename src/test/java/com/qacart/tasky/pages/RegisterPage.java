package com.qacart.tasky.pages;

import com.qacart.tasky.model.UserRegistration;

import static com.qacart.tasky.clients.UserClient.registerAPI;
import static com.qacart.tasky.configs.ConfigFactory.getConfig;
import static com.qacart.tasky.driver.managers.DriverManager.getDriver;

public class RegisterPage implements BasePage {
    @Override
    public void loadPage() {
        getDriver().get(getConfig().pageBaseURL() + "/register");
    }

    public void registerUsingAPI(UserRegistration user) {
        registerAPI(user);
    }
}

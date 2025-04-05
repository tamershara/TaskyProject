package com.qacart.tasky.pages;

import com.qacart.tasky.model.LoginResponse;
import com.qacart.tasky.model.UserLogin;
import io.restassured.response.Response;

import static com.qacart.tasky.clients.UserClient.loginAPI;
import static com.qacart.tasky.configs.ConfigFactory.getConfig;
import static com.qacart.tasky.driver.managers.DriverManager.getDriver;
import static com.qacart.tasky.utilites.CookiesUtil.setCookies;

public class LoginPage implements BasePage {
    @Override
    public void loadPage() {
        getDriver().get(getConfig().pageBaseURL() + "/login");
    }

    public String loginUsingAPI(UserLogin user) {
        Response loginResponse = loginAPI(user);
        setCookies(loginResponse);
        LoginResponse login = loginResponse.as(LoginResponse.class);
        return login.getToken();
    }
}

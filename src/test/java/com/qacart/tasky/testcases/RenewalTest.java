package com.qacart.tasky.testcases;

import com.qacart.tasky.bases.BaseTest;
import com.qacart.tasky.model.SubscriptionData;
import com.qacart.tasky.model.UserLogin;
import com.qacart.tasky.model.UserRegistration;
import com.qacart.tasky.pages.DashboardPage;
import com.qacart.tasky.pages.LoginPage;
import com.qacart.tasky.pages.RegisterPage;
import com.qacart.tasky.pages.SubscriptionPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.qacart.tasky.fixtures.UserFixture.getDefaultUserForLogin;
import static com.qacart.tasky.fixtures.UserFixture.getDefaultUserForRegister;
import static com.qacart.tasky.fixtures.subscriptionFixture.getSubscriptionData;
import static com.qacart.tasky.mocker.MockCurrentSubscription.makeTheSubscriptionCloseToExpiration;

@Feature("Subscription Test Cases")
public class RenewalTest extends BaseTest {
    private final RegisterPage registerPage = new RegisterPage();
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final SubscriptionPage subscriptionPage = new SubscriptionPage();

    @BeforeMethod
    public void setUp() throws InterruptedException {
        registerPage.loadPage();
        UserRegistration userDataRegistration = getDefaultUserForRegister();
        registerPage.registerUser(userDataRegistration);
        loginPage.loadPage();
        UserLogin userForLogin = getDefaultUserForLogin();
        String accessToken = loginPage.loginUser(userForLogin);
        dashboardPage.loadPage();
        dashboardPage.clickSubscriptionTab();
        SubscriptionData subscriptionData = getSubscriptionData();
        subscriptionPage.subscribeUsingAPI(subscriptionData, accessToken);
    }

    @Story("Test Renewal Alert")
    @Test(description = "Renewal Button should be shown if the subscription is close to expired before two days")
    void renewalMessageShouldBeDisplayedBeforeTwoDaysOfSubscriptionExpiration() {
        makeTheSubscriptionCloseToExpiration();
        dashboardPage.loadPage();
        Assert.assertTrue(dashboardPage.isRenewButtonPresent());
    }
}

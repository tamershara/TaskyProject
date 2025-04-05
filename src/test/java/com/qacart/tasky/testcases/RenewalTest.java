package com.qacart.tasky.testcases;

import com.qacart.tasky.bases.BaseTest;
import com.qacart.tasky.model.SubscriptionData;
import com.qacart.tasky.model.UserLogin;
import com.qacart.tasky.model.UserRegistration;
import com.qacart.tasky.pages.DashboardPage;
import com.qacart.tasky.pages.LoginPage;
import com.qacart.tasky.pages.RegisterPage;
import com.qacart.tasky.pages.SubscriptionPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.qacart.tasky.fixtures.UserFixture.getDefaultUserForLogin;
import static com.qacart.tasky.fixtures.UserFixture.getDefaultUserForRegister;
import static com.qacart.tasky.fixtures.subscriptionFixture.getSubscriptionData;
import static com.qacart.tasky.mocker.MockCurrentSubscription.makeTheSubscriptionCloseToExpiration;

public class RenewalTest extends BaseTest {
    private final RegisterPage registerPage = new RegisterPage();
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final SubscriptionPage subscriptionPage = new SubscriptionPage();
    @BeforeMethod
    public void setUp() throws InterruptedException {
        registerPage.loadPage();
        UserRegistration userDataRegistration = getDefaultUserForRegister();
        registerPage.registerUsingAPI(userDataRegistration);
        loginPage.loadPage();
        UserLogin userForLogin = getDefaultUserForLogin();
        String accessToken = loginPage.loginUsingAPI(userForLogin);
        dashboardPage.loadPage();
        dashboardPage.clickSubscriptionButton();
        SubscriptionData subscriptionData = getSubscriptionData();
        subscriptionPage.subscribeUsingAPI(subscriptionData,accessToken);
    }

    @Test
    void renewalMessageShouldBeDisplayedBeforeTwoDaysOfSubscriptionExpiration() throws InterruptedException {
        makeTheSubscriptionCloseToExpiration();
        dashboardPage.loadPage();
        Assert.assertTrue(dashboardPage.isRenewButtonPresent());
    }
}

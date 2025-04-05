package com.qacart.tasky.testcases;

import com.qacart.tasky.bases.BaseTest;
import com.qacart.tasky.model.UserLogin;
import com.qacart.tasky.model.UserRegistration;
import com.qacart.tasky.pages.DashboardPage;
import com.qacart.tasky.pages.LoginPage;
import com.qacart.tasky.pages.RegisterPage;
import com.qacart.tasky.pages.TodoPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.qacart.tasky.fixtures.UserFixture.getDefaultUserForLogin;
import static com.qacart.tasky.fixtures.UserFixture.getDefaultUserForRegister;
import static com.qacart.tasky.mocker.TodosMocker.mockTodosForRegularUser;

public class MaximumTodosAlertRegularUserTest extends BaseTest {
    private final RegisterPage registerPage = new RegisterPage();
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final TodoPage todoPage = new TodoPage();
    @BeforeMethod
    public void setUp() {
        registerPage.loadPage();
        UserRegistration userDataRegistration = getDefaultUserForRegister();
        registerPage.registerUsingAPI(userDataRegistration);
        loginPage.loadPage();
        UserLogin userForLogin = getDefaultUserForLogin();
        loginPage.loginUsingAPI(userForLogin);
        dashboardPage.loadPage();
        todoPage.loadPage();
    }

    @Test
    public void MaximumAlertMessageShouldBeShownIfTheRegularUserHaveThreeTodos() {
        mockTodosForRegularUser();
        todoPage.loadPage();
        Assert.assertTrue(todoPage.getLimiterMessage().contains("maximum number of todos"));
    }
}

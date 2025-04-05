package com.qacart.tasky.utilites;

import io.restassured.response.Response;
import org.openqa.selenium.Cookie;

import java.util.Set;
import java.util.stream.Collectors;

import static com.qacart.tasky.driver.managers.DriverManager.getDriver;

public final class CookiesUtil {
    private CookiesUtil() {}
    public static void setCookies(Response response) {
        Set<Cookie> cookies = response.getDetailedCookies().asList().stream().map(cookie -> new Cookie(cookie.getName(), cookie.getValue())).collect(Collectors.toSet());
        cookies.forEach(cookie -> {getDriver().manage().addCookie(cookie);});
        getDriver().navigate().refresh();
    }
}

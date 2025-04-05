package com.qacart.tasky.driver.managers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class FirefoxManager {
    private FirefoxManager() {}
    public static FirefoxDriver getFirefoxDriver() {
        return new FirefoxDriver(getFirefoxOptions());
    }
    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        return options;
    }
}

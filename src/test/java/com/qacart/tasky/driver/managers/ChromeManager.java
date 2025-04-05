package com.qacart.tasky.driver.managers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class ChromeManager {
    private ChromeManager() {}

    public static ChromeDriver getChromeDriver() {
        return new ChromeDriver(getChromeOptions());
    }
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return options;
    }
}

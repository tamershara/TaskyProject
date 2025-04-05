package com.qacart.tasky.utilites;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.qacart.tasky.driver.managers.DriverManager.getDriver;

public final class ScreenshotUtils {
    private ScreenshotUtils() {}

    public static void takeScreenShot(ITestResult result) throws IOException {
        TakesScreenshot screenshot = ((TakesScreenshot) getDriver());
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        String imagePath = "target"
                + File.separator
                + "screenshots"
                + File.separator
                + result.getMethod().getMethodName()
                + ".png";
        InputStream inputStream = new FileInputStream(file);
        FileUtils.copyFile(file,new File(imagePath));
        Allure.addAttachment(result.getMethod().getMethodName(),inputStream);
    }
}

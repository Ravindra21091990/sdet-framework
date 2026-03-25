package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        Object testClass = result.getInstance();
        WebDriver driver = ((base.BaseTest) testClass).driver;

        byte[] screenshot = ScreenshotUtil.captureScreenshot(driver);

        Allure.addAttachment("Failure Screenshot",
                new ByteArrayInputStream(screenshot));
    }
}
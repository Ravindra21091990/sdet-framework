package utils;

import base.BaseTest;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        Object testClass = result.getInstance();
        if (!(testClass instanceof BaseTest)) {
            return;
        }

        BaseTest base = (BaseTest) testClass;
        WebDriver driver = base.getDriver();
        if (driver == null) {
            return;
        }

        try {
            byte[] screenshot = ScreenshotUtil.captureScreenshot(driver);
            if (screenshot.length > 0) {
                Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(screenshot));
            }
        } catch (Exception ignored) {
            // Do not override root test failure with listener errors.
        }
    }
}
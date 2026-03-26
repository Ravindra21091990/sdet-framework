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

        // ✅ Get current test instance
        Object testClass = result.getInstance();

        // ✅ Cast to BaseTest
        BaseTest base = (BaseTest) testClass;

        // ✅ Get driver using getter (ThreadLocal safe)
        WebDriver driver = base.getDriver();

        // ✅ Capture screenshot
        byte[] screenshot = ScreenshotUtil.captureScreenshot(driver);

        // ✅ Attach to Allure
        Allure.addAttachment("Failure Screenshot",
                new ByteArrayInputStream(screenshot));
    }
}
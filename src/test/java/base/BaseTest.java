package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.net.URL;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    ConfigReader config = new ConfigReader();

    @BeforeMethod
    public void setup() {

        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            // ✅ Correct way
            WebDriver remoteDriver = new RemoteWebDriver(
                    new URL("http://localhost:4444/wd/hub"),
                    options
            );

            driver.set(remoteDriver);

            getDriver().manage().window().maximize();
            getDriver().get(config.getProperty("url"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown(){
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove(); // ✅ very important for parallel execution
        }
    }
}
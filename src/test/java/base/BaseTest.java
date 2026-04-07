package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.net.URL;
import java.util.Locale;

public class BaseTest {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    ConfigReader config = new ConfigReader();

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        boolean headless = Boolean.parseBoolean(config.getProperty("headless"));
        String runMode = config.getProperty("run.mode");
        String gridUrl = config.getProperty("grid.url");

        if (headless) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver webDriver = initializeDriver(runMode, gridUrl, options);
        driver.set(webDriver);
        getDriver().manage().window().maximize();
        getDriver().get(config.getProperty("url"));
    }

    private WebDriver initializeDriver(String runMode, String gridUrl, ChromeOptions options) {
        String normalizedMode = (runMode == null || runMode.isBlank()) ? "auto"
                : runMode.toLowerCase(Locale.ROOT);
        switch (normalizedMode) {
            case "local":
                return createLocalDriver(options);
            case "remote":
                return createRemoteDriver(gridUrl, options);
            case "auto":
                try {
                    return createRemoteDriver(gridUrl, options);
                } catch (Exception remoteError) {
                    System.out.println("Remote Grid unavailable, falling back to local Chrome: "
                            + remoteError.getMessage());
                    return createLocalDriver(options);
                }
            default:
                throw new RuntimeException("Invalid run.mode value: " + runMode
                        + ". Supported values are auto, remote, local.");
        }
    }

    private WebDriver createRemoteDriver(String gridUrl, ChromeOptions options) {
        try {
            return new RemoteWebDriver(new URL(gridUrl), options);
        } catch (Exception e) {
            throw new RuntimeException("Unable to initialize remote WebDriver at " + gridUrl, e);
        }
    }

    private WebDriver createLocalDriver(ChromeOptions options) {
        try {
            return new ChromeDriver(options);
        } catch (Exception e) {
            throw new RuntimeException("Unable to initialize local ChromeDriver", e);
        }
    }

    @AfterMethod
    public void tearDown(){
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}
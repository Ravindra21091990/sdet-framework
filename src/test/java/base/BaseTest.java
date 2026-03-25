package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {

    public WebDriver driver;
    ConfigReader config = new ConfigReader();

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(config.getProperty("url"));
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}

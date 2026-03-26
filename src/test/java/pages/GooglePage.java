package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class GooglePage {

    WebDriver driver;
    WebDriverWait wait;

    public GooglePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By searchBox = By.name("q");

    public void enterSearchText(String searchString){

        // ✅ Wait until element is visible
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchBox)
        );

        element.sendKeys(searchString);
    }
}
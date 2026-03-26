package tests;

import base.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.GooglePage;

@Listeners(utils.TestListener.class)
public class SampleTest extends BaseTest {

    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void verifyTitle(){

        System.out.println("executing verifyTitle");

        SoftAssert softAssert = new SoftAssert();

        // ✅ FIXED
        String title = getDriver().getTitle();

        System.out.println("Title: " + title);

        softAssert.assertTrue(title.contains("Google"));
        softAssert.assertAll();
    }

    @Test
    public void verifySearchFunctionality() throws InterruptedException {

        System.out.println("executing verifySearchFunctionality");

        // ✅ FIXED: pass driver correctly
        GooglePage googlePage = new GooglePage(getDriver());

        googlePage.enterSearchText("SDET framework");

        Thread.sleep(2000);
    }
}
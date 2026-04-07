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
    public void verifySearchFunctionality() {

        System.out.println("executing verifySearchFunctionality");

        // ✅ FIXED: pass driver correctly
        GooglePage googlePage = new GooglePage(getDriver());
        SoftAssert softAssert = new SoftAssert();

        googlePage.enterSearchText("SDET framework");
        String typedValue = googlePage.getSearchBoxValue();
        softAssert.assertEquals(typedValue, "SDET framework");

        softAssert.assertAll();
    }
}
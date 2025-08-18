package tests.ZRecylbin;

import Pages.LFCPages;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class US_002_F {
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
    }



    @DataProvider (name = "buttonProvider")
    public static Object[][] buttonProvider() {
        // < --
        //Driver.getDriver().get(ConfigReader.getProperty("lfcurl"));
        // -- >
        LFCPages loyalfriendcarePages = new LFCPages() ;

        return new Object[][]{
                {loyalfriendcarePages.signInButton, "signInButton", "loginPage"} ,
                {loyalfriendcarePages.signUpButton,"Sign Up", "register"}
        } ;
    }

    @Test (dataProvider = "buttonProvider")

    public void dataproviderli(WebElement element, String buttonName, String expectedUrlPart){
        Assert.assertTrue(element.isDisplayed(),buttonName +"görünür değil");
        Assert.assertTrue(element.isEnabled(),buttonName +"tıklanabilir değil");

        element.click();
        String actualUrlIcerik = Driver.getDriver().getCurrentUrl() ;
        Assert.assertTrue(actualUrlIcerik.contains(expectedUrlPart));


    }
    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }

}

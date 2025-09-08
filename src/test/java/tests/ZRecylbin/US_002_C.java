package tests.ZRecylbin;

import Pages.HeaderPages;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;



public class US_002_C {
    @DataProvider(name = "buttonProvider")
    public Object[][] buttonProvider() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        HeaderPages page = new HeaderPages();
        return new Object[][]{
                {page.logoButton, "Logo", "home"},
                {page.signInButton, "Sign In", "loginPage"},
                {page.signUpButton, "Sign UP", "register"},
        };
    }

    @Test(dataProvider = "buttonProvider")
    public void TC_01(WebElement element, String buttonName, String UrlUzantitisi) {
        SoftAssert softAssert = new SoftAssert();


        softAssert.assertTrue(element.isDisplayed(), buttonName + " görünür değil ❌");
        softAssert.assertTrue(element.isEnabled(), buttonName + " tıklanabilir değil ❌");
        element.click();



        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(UrlUzantitisi),
                "URL hatası! Beklenen: " + UrlUzantitisi + ", Mevcut: " + actualUrl);

        System.out.println("✅ " + buttonName + " butonu doğrulandı");
        softAssert.assertAll();  // satır 42 hata veriyor

        Driver.quitDriver();
    }


}
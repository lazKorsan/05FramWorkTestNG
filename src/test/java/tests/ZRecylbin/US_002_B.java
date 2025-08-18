package tests.ZRecylbin;

import Pages.LFCPages;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;

public class US_002_B {
    @DataProvider(name = "buttonProvider")
    public Object[][] buttonProvider() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc")); // Sayfa önce yüklenmeli
        LFCPages page = new LFCPages();

        return new Object[][]{
                {page.logoButton, "Logo", ""},
                {page.signInButton, "Sign In", "loginPage"},
                {page.signUpButton, "Sign UP", "register"},

        };
    }
    @Test(dataProvider = "buttonProvider")
    public void TC_01(WebElement element, String buttonName,String UrlUzantitisi) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(element.isDisplayed(), buttonName + " görünür değil ❌");
        softAssert.assertTrue(element.isEnabled(), buttonName + " tıklanabilir değil ❌");
        element.click();
        Thread.sleep(3000); // Sayfa yüklenmesi için kısa bekleme
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(UrlUzantitisi),
                "URL hatası! Beklenen: " + UrlUzantitisi + ", Mevcut: " + actualUrl);

        System.out.println("✅ " + UrlUzantitisi + " butonu doğrulandı");
            element.click();

            String actualUrlIcerik = Driver.getDriver().getCurrentUrl() ;


        softAssert.assertTrue(actualUrlIcerik.contains(UrlUzantitisi),"URL Doğrulama Hatası: Aktüel URL " + actualUrlIcerik + " beklenen" ) ;

        softAssert.assertAll();



    }

}

package tests.ZRecylbin;

import Pages.LFCPages;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;

public class US_002_pD {

    @DataProvider(name = "buttonProvider")
    public Object[][] buttonProvider() {
        return new Object[][]{
                {"logoButton", "Logo", "home"},
                {"signInButton", "Sign In", "loginPage"},
                {"signUpButton", "Sign UP", "register"},
        };
    }

    @Test(dataProvider = "buttonProvider")
    public void TC_01(String buttonFieldName, String buttonName, String expectedUrlPart) {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages page = new LFCPages();
        SoftAssert softAssert = new SoftAssert();

        try {
            // Dinamik olarak WebElement'e eriş
            java.lang.reflect.Field field = LFCPages.class.getDeclaredField(buttonFieldName);
            field.setAccessible(true);
            Object obj = field.get(page);

            if (obj instanceof org.openqa.selenium.WebElement) {
                org.openqa.selenium.WebElement element = (org.openqa.selenium.WebElement) obj;

                softAssert.assertTrue(element.isDisplayed(), buttonName + " görünür değil ❌");
                softAssert.assertTrue(element.isEnabled(), buttonName + " tıklanabilir değil ❌");

                element.click();
                String actualUrl = Driver.getDriver().getCurrentUrl();

                softAssert.assertTrue(actualUrl.contains(expectedUrlPart),
                        "URL hatası! Beklenen: " + expectedUrlPart + ", Mevcut: " + actualUrl);

                System.out.println("✅ " + buttonName + " butonu doğrulandı");
            } else {
                softAssert.fail("❌ " + buttonName + " WebElement değil!");
            }

        } catch (Exception e) {
            softAssert.fail("❌ " + buttonName + " için hata oluştu: " + e.getMessage());
        } finally {
            softAssert.assertAll();
            Driver.quitDriver();  // Her testten sonra driver kapatılır
        }
    }
}
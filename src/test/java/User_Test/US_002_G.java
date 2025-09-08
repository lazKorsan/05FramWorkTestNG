package User_Test;

import Pages.HeaderPages;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.ConfigReader;
import utilities.Driver;

public class US_002_G {

    HeaderPages headerPages;

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        headerPages = new HeaderPages();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

    @DataProvider(name = "buttonProvider")
    public Object[][] buttonProvider() {
        return new Object[][]{
                {"signInButton", "signInButton", "loginPage"},
                {"signUpButton", "Sign Up", "register"}
        };
    }

    @Test(dataProvider = "buttonProvider")
    public void dataproviderli(String buttonField, String buttonName, String expectedUrlPart) {
        WebElement element = getButtonElement(buttonField);

        Assert.assertTrue(element.isDisplayed(), buttonName + " görünür değil");
        Assert.assertTrue(element.isEnabled(), buttonName + " tıklanabilir değil");

        element.click();
        String actualUrlIcerik = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrlIcerik.contains(expectedUrlPart));
    }

    // Sayfa objesindeki alan adına göre WebElement döndürür
    private WebElement getButtonElement(String fieldName) {
        switch (fieldName) {
            case "signInButton":
                return headerPages.signInButton;
            case "signUpButton":
                return headerPages.signUpButton;
            default:
                throw new IllegalArgumentException("Böyle bir buton yok: " + fieldName);
        }
    }
}
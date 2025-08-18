package tests.ZRecylbin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class dataprovider2 {

    // Örnek düzeltilmiş metod
    @Test(dataProvider = "buttonProvider")
    public void TC_01(WebElement element, String buttonName) {
        WebDriver driver = Driver.getDriver();



        String url = ConfigReader.getProperty("lfc");
        System.out.println("Açılmaya çalışılan URL: " + url); // URL'yi konsolda gör

        try {
            driver.get(url);
            Assert.assertTrue(element.isDisplayed());
        } catch (WebDriverException e) {
            System.out.println("Driver hatası: " + e.getMessage());
            Assert.fail("Driver exception: " + e.getCause());
        }
    }

}

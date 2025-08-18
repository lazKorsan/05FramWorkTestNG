package tests.ZRecylbin;

import Pages.LFCPages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class dataproviderda {

    LFCPages loyalfriendcarePages;

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("lrcurl"));
        loyalfriendcarePages = new LFCPages();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    @DataProvider(name = "buttonProvider")
    public Object[][] buttonProvider() {
        return new Object[][]{
                {loyalfriendcarePages.departmentsButton, "Departments"},
                {loyalfriendcarePages.doctorsButton, "Doctors"},
                {loyalfriendcarePages.vaccinationsButton, "Vaccinations"},
                {loyalfriendcarePages.medicinesButton, "Medicines"}
        };
    }

    @Test(dataProvider = "buttonProvider")
    public void TC_01(ButtonSupplier buttonSupplier, String buttonName) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(buttonSupplier.get()));

        Assert.assertTrue(element.isDisplayed(), buttonName + " butonu görünür değil");
        Assert.assertTrue(element.isEnabled(), buttonName + " butonu tıklanabilir değil");
        System.out.println(buttonName + " butonu doğrulandı");
    }

    @FunctionalInterface
    interface ButtonSupplier {
        WebElement get();
    }
}
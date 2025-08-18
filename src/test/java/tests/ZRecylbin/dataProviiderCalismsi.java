package tests.ZRecylbin;

import Pages.LFCPages;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class dataProviiderCalismsi {
    LFCPages loyalfriendcarePages = new LFCPages();

    @DataProvider(name = "buttonProvider")
    public Object[][] testEdilecekButtonsProvider() {
        return new Object[][]{
                {loyalfriendcarePages.departmentsButton, "Departments"},
                {loyalfriendcarePages.doctorsButton, "Doctors"},
                {loyalfriendcarePages.vaccinationsButton, "Vaccinations"},
                {loyalfriendcarePages.medicinesButton, "Medicines"}
        };
    }

    @Test(dataProvider = "buttonProvider")
    public void TC_01(WebElement element, String buttonName) {
        //Driver.getDriver().get(ConfigReader.getProperty("lfcurl"));
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        try {
            Assert.assertTrue(element.isDisplayed(), buttonName + " butonu görünür değil");
            Assert.assertTrue(element.isEnabled(), buttonName + " butonu tıklanabilir değil");
            System.out.println(buttonName + " butonu doğrulandı");
        } catch (Exception e) {
            Assert.fail(buttonName + " buton testinde hata: " + e.getMessage());
        }
    }

}

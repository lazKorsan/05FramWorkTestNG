package User_Test;

import Pages.LFCPages;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class US_005 {

    @DataProvider(name = "buttonProvider")
    public Object[][] buttonProvider() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc")); // Sayfa önce yüklenmeli
        LFCPages page = new LFCPages();

        return new Object[][]{
                {page.departmentsButton, "Departments"},
                {page.doctorsButton, "Doctors"},
                {page.vaccinationsButton, "Vaccinations"},
                {page.medicinesButton, "Medicines"}
        };
    }

    @Test(dataProvider = "buttonProvider")
    public void TC_01(WebElement element, String buttonName) {
        try {
            Assert.assertTrue(element.isDisplayed(), buttonName + " butonu görünür değil ❌");
            Assert.assertTrue(element.isEnabled(), buttonName + " butonu tıklanabilir değil ❌");
            // < --
            //element.click();
            // -- >
            System.out.println("✅ " + buttonName + " butonu doğrulandı");
        } catch (Exception e) {
            Assert.fail("❌ " + buttonName + " buton testinde hata: " + e.getMessage());
        }
    }
}
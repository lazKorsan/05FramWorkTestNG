package User_Test;

import Pages.HeaderPages;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_007 {
    //Bir ziyaretçi olarak, siteye üye olabilmek için
    // üye kayıt formuna erisebilmek
    // ve üye kayıt formunu doldurup
    // kaydımı tamamlayabilmek istiyorum. (signUp)
    HeaderPages headerPages = new HeaderPages() ;
    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        headerPages = new HeaderPages();}
    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
    @Test
    public void TC_01(){
        headerPages.signUpButton.click();
        headerPages.userNameBox.sendKeys("alfaRomeo3");
        headerPages.mailBox.sendKeys("alfaromeo3@gmail.com");
        headerPages.passwordBox.sendKeys("alfaRomeo123.");
        headerPages.confirmPasswordBox.sendKeys("alfaRomeo123.");
        ReusableMethods.bekle(12);
        headerPages.registerButton.click();

        ReusableMethods.bekle(15);

    }


}

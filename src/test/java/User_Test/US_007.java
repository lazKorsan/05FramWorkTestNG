package User_Test;

import Pages.LFCPages;
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
    LFCPages lfcPages = new LFCPages() ;
    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        lfcPages = new LFCPages();}
    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
    @Test
    public void TC_01(){
        lfcPages.signUpButton.click();
        lfcPages.userNameBox.sendKeys("alfaRomeo3");
        lfcPages.mailBox.sendKeys("alfaromeo3@gmail.com");
        lfcPages.passwordBox.sendKeys("alfaRomeo123.");
        lfcPages.confirmPasswordBox.sendKeys("alfaRomeo123.");
        ReusableMethods.bekle(12);
        lfcPages.registerButton.click();

        ReusableMethods.bekle(15);

    }


}

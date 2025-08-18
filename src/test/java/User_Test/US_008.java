package User_Test;

import Pages.LFCPages;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_008 {
    //Bir kullanici olarak, siteye giriş yapabilmek için
    // Login sayfasına erişebilmeli
    // ve giriş formunu doldurarak
    // hesabıma giriş yapabilmek istiyorum. (signIn)
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages loyalfriendcarePages = new LFCPages() ;

    }
    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
    @Test
    public void TC_01(){


        LFCPages lfcPages = new LFCPages() ;

        lfcPages.signInButton.click();
        lfcPages.mailBox.sendKeys(ConfigReader.getProperty("usermail"));
        lfcPages.passwordBox.sendKeys("userPassword");
        ReusableMethods.bekle(4);

        lfcPages.loginPageSigInButton.click();

    }
}

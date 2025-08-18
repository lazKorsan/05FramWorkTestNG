package User_Test;

import Pages.LFCPages;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_041 {
    //Bir yönetici olarak,
    // oluşturulan tüm randevuları görüntüleyebilmek istiyorum.

    @Test
    public void TC_01(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        LFCPages lfcPages = new LFCPages() ;

        lfcPages.signInButton.click();

        lfcPages.mailBox.sendKeys(ConfigReader.getProperty("userMail"));

        lfcPages.passwordBox.sendKeys(ConfigReader.getProperty("userPassword"));
        ReusableMethods.bekle(3);
        lfcPages.loginPageSigInButton.click();
        ReusableMethods.bekle(1);
        lfcPages.accountButton.click();
    }
}

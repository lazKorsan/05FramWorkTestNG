package User_Test;

import Pages.HeaderPages;
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

        HeaderPages headerPages = new HeaderPages() ;

        headerPages.signInButton.click();

        headerPages.mailBox.sendKeys(ConfigReader.getProperty("userMail"));

        headerPages.passwordBox.sendKeys(ConfigReader.getProperty("userPassword"));
        ReusableMethods.bekle(3);
        headerPages.loginPageSigInButton.click();
        ReusableMethods.bekle(1);
        headerPages.accountButton.click();
    }
}

package User_Test;

import Pages.AdminPages;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_039 {
    //Bir yönetici olarak,
    // sol açılır menüdeki Vaccinations
    // menüsüne erişebilmeli, mevcut aşı
    // listesini görüntüleyebilmeli ve bu
    // aşılar üzerinde görüntüleme, arama
    // ve silme işlemleri yapabilmeliyim.

    @Test
    public void TC_01(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        AdminPages adminPages = new AdminPages() ;
        adminPages.signInButton.click();
        adminPages.mailBox.sendKeys("admin.ahmet@loyalfriendcare.com");
        adminPages.passwordBox.sendKeys("LFCare.0201");
        adminPages.loginPageSignInButton.click();
        adminPages.accountButton.click();
        adminPages.dashBoard.click();
        adminPages.vaccinationsButton.click();
        ReusableMethods.bekle(1);
        ReusableMethods.printProductsInCategory(Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/Dashboard/Galleries?page=1",
               "//td[@class='v-align-middle semi-bold']" );
    }
}

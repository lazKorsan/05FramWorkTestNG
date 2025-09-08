package User_Test;

import Pages.AdminPages;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class US_040 {
    AdminPages adminPages = new AdminPages() ;
    //Bir yönetici olarak,
    // yeni bir aşı ekleyebilmeli ve
    // bu aşıyı mevcut aşılar listesine kaydedebilmeliyim.

    @Test
    public void TC_01(){
        // 1 loyalfiendcare.com ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        // sighUp buttona tıkla
        adminPages.signInButton.click();

        // login sayfasına geçerli mail ve password gir.
        adminPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        adminPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminPages.loginPageSignInButton.click();

        // account buttona tıklayarak admin sayfasına ulaş
        adminPages.accountButton.click();

        // dashboard sekmesine tıkla
        adminPages.dashBoard.click();

        // dashboardan vaccination buttonu tıkla
        adminPages.vaccinationsButton.click();






    }
}

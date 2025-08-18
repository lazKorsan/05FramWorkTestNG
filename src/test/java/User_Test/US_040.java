package User_Test;

import Pages.DBPages;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class US_040 {
    DBPages dbPages = new DBPages() ;
    //Bir yönetici olarak,
    // yeni bir aşı ekleyebilmeli ve
    // bu aşıyı mevcut aşılar listesine kaydedebilmeliyim.

    @Test
    public void TC_01(){
        // 1 loyalfiendcare.com ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        // sighUp buttona tıkla
        dbPages.signInButton.click();

        // login sayfasına geçerli mail ve password gir.
        dbPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        dbPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        dbPages.loginPageSignInButton.click();

        // account buttona tıklayarak admin sayfasına ulaş
        dbPages.accountButton.click();

        // dashboard sekmesine tıkla
        dbPages.dashBoard.click();

        // dashboardan vaccination buttonu tıkla
        dbPages.vaccinationsButton.click();






    }
}

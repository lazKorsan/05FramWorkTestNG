package User_Test;

import Pages.AdminPages;
import Pages.HeaderPages;
import org.testng.annotations.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_045 extends TestBaseRapor {
    // 1nci aşama : raporlu testin patlamaması için kurulul aşamaları
    HeaderPages headerPages = new HeaderPages() ;
    AdminPages adminPages = new AdminPages();

    @BeforeClass  // 2nci aşama class seviyesinde sayfalar tanıtılıyor
    public void setupClass() {
        headerPages = new HeaderPages();
        adminPages = new AdminPages();

    }

    // 3ncü aşama
    @BeforeMethod
    public void loginAdmin() { // method kullanımından önce login işlemleri
        // 1  sayfayı aç
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        // 2 SİGıN BUTTONA TIKLA
        headerPages.signInButton.click();

        // 3 mailbox a geçerli mail gönder
        headerPages.mailBox.sendKeys(ConfigReader.getProperty("userMail"));

        // 4 geçerli password gir
        adminPages.passwordBox.sendKeys(ConfigReader.getProperty("user.userPassword"));

        // 5 login tuşuna bas
        adminPages.loginPageSignInButton.click();
        // 6 admin girişi tamamlandı


        // Eğer zaten login değilse login ol
       // if (!headerPages.isUserLoggedIn()) {
        //    headerPages.loginButton.click();
        //    headerPages.usernameField.sendKeys(ConfigReader.getProperty("adminUsername"));
        //    headerPages.passwordField.sendKeys(ConfigReader.getProperty("adminPassword"));
        //    headerPages.loginSubmitButton.click();
        //}
    }

    @Test (priority = 1)
    public void TC_01(){
        extentTest = extentReports.createTest("İlaç Randevu Sistemi Testi ",
                "Kullanıcı İlaç Randevu Sistemini Test eder");
        headerPages.accountButton.click();
    }

    @Test (priority = 2)
    public void TC_02(){
        extentTest = extentReports.createTest("İlaç Randevu Sistemi Testi ",
                "Kullanıcı İlaç Randevu Sistemini Test eder");
        headerPages.medicinesButton.click();
    }

    @Test (priority = 3)
    public void TC_03(){
        extentTest = extentReports.createTest("İlaç Randevu Sistemi Testi ",
                "Kullanıcı İlaç Randevu Sistemini Test eder");
        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/Medicines");
        headerPages.rimadylButton.click();
    }


    @AfterMethod
    public void tearDownMethod() {
        // Her test sonrası logları temizleme veya screenshot alma
    }

    @AfterClass
    public void tearDownClass() {
        Driver.closeDriver();
    }
}





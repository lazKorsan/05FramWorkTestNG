package User_Test;

import Pages.LFCPages;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_007_B extends TestBaseRapor {
    /*
     DENK GETİREMEDİM .
     KULLANICI sıgnUp butonuno basar
     // register sayfasına gider
     // usernameBox Kullanıcı adı girer
     // mailBox  mail adresine girer
     // passwordBox   şifresini girer
     // confirmPasswordBox şifreyi doğrular
     // registerButonuna Basar

     */
    //Bir ziyaretçi olarak, siteye üye olabilmek için
    // üye kayıt formuna erisebilmek
    // ve üye kayıt formunu doldurup
    // kaydımı tamamlayabilmek istiyorum. (signUp)
    LFCPages lfcPages = new LFCPages();
    //1. Sınıf adına sağ tıkla → Refactor → Rename (Shift+F6)
    //2. "loyalfriendcarePages" → "lfcPages" yaz
    //3. "Search in comments and strings" seçeneğini kapat (opsiyonel)
    //4. "Scope" ayarını "Project Files" olarak seç
    //5. Preview ile tüm değişiklikleri kontrol et → Refactor'u onayla

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        lfcPages = new LFCPages();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

    @DataProvider
    public static Object[][] sendKeysProviders() {
        return new Object[][]{
                {"alfaRomeo8", "alfaRomeo8@gmail.com", "alfaRomeo8123.", "alfaRomeo8123."},
                {"alfaRomeo9", "alfaRomeo9@gmail.com", "alfaRomeo9123.", "alfaRomeo9123."},
        };
    }

    @Test(dataProvider = "sendKeysProviders")
    public void TC_01(String username, String email, String password, String confirmPassword) {

        extentTest = extentReports.createTest("SıgnUp Testi",
                "Kullanıcı SıgnUp Butonuna basarak kayıt işlemi yapabilmeli");
        SoftAssert softAssert = new SoftAssert();

        // Kullanıcı SıgnUp Butonuna Basar
        lfcPages.signUpButton.click();
        extentTest.info("Kullanıcı SıgnUp Butonuna Basar") ;

        // Kullanıcı usernameBox Kutusuna Kullanıcı adını girer
        lfcPages.userNameBox.sendKeys(username);
        extentTest.info("") ;

        // Kullanıcı mailBox Kutusuna Mail adresini girer
        lfcPages.mailBox.sendKeys(email);
        extentTest.info("Kullanıcı mailBox Kutusuna Mail adresini girer") ;

        // Kullanıcı passwordBox Kutusuna şifresini girer
        lfcPages.passwordBox.sendKeys(password);
        extentTest.info("Kullanıcı passwordBox Kutusuna şifresini girer") ;

        // Kullanıcı confirmPassword Kutusuna şifresini girer
        lfcPages.confirmPasswordBox.sendKeys(confirmPassword);
        extentTest.info("Kullanıcı confirmPassword Kutusuna şifresini girer") ;

        // Kullanıcı registerButonuna Tıklar ve Kayıt olur
        lfcPages.registerButton.click();
        extentTest.info("Kullanıcı registerButonuna Tıklar ve Kayıt olur") ;

        // Kullanıcı kayıt işleminden sonra ana sayfaya yönlendirildiğini doğrular
        String expectedUrl = "https://qa.loyalfriendcare.com/en" ;
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.equals(expectedUrl),"Beklenen url ana sayfa ile aynı değil");
        extentTest.pass("Kullanıcı kayıt işleminden sonra ana sayfaya yönlendirildiğini doğrular") ;

        // Kullanıcı SignIn Butonunda Kullanıcı adını görür.
        String expectedUserNameText = username ;
        String actualUserNameText = lfcPages.signInButton.getText() ;
        softAssert.assertTrue(actualUserNameText.equals(expectedUserNameText),"Hesap oluşturma başarısız");
        extentTest.pass("Kullanıcı SignIn Butonunda Kullanıcı adını görür.") ;

        // Kullanıcı anaSayfa ekran alıntısını alır
        ReusableMethods.takeFullPageScreenshot("SINGuOdOĞRULAMA");
        extentTest.info("Kullanıcı anaSayfa ekran alıntısını alır");

        // Kullanıcı sıgnInButtonunun fotoğrafını alır
        ReusableMethods.getWebElementScreenshot(lfcPages.signInButton, "doğrulama");
        extentTest.info("Kullanıcı sıgnInButtonunun fotoğrafını alır ") ;


        ReusableMethods.bekle(3);



        softAssert.assertAll();
    }
}
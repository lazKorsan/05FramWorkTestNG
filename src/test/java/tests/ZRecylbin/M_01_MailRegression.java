package tests.ZRecylbin;

import Pages.LFCPages;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.*;

public class M_01_MailRegression extends TestBaseRapor {

     // <-- MailBox Dayanıklılık Testi -- >
    //Bir ziyaretçi olarak, siteye üye olabilmek için
    // üye kayıt formuna erisebilmek
    // ve üye kayıt formunu doldurup
    // kaydımı tamamlayabilmek istiyorum. (signUp)
    LFCPages loyalfriendcarePages = new LFCPages();

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        loyalfriendcarePages = new LFCPages();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

    @DataProvider
    public static Object[][] sendKeysProviders() {
        return new Object[][]{
                {"ali.......Kamil", "a.l.i.K.a.m.i.l@gmail.com", "ali.......Kamil7123.", "ali.......Kamil7123."},// 7 NOKTA
               // {"ali......Kamil", "a.l.iK.a.m.i.l@gmail.com", "ali......Kamil6123.", "ali......Kamil6123."},// 6 NOKTA
                {"ali.....Kamil", "a.l.i.Ka.m.il@gmail.com", "ali.....Kamil5123.", "ali.....Kamil5123."},// 5 NOKTA
                {"ali....Kamil", "a.l.iKam.i.l@gmail.com", "ali....Kamil4123.", "ali....Kamil4123."},// 4 NOKTA
                {"ali...Kamil", "a.l.iKami.l@gmail.com", "ali...Kamil3123.", "ali...Kamil3123."},// 3 NOKTA
                {"ali..Kamil", "a.l.i.Kamil@gmail.com", "ali..Kamil2123.", "ali..Kamil2123."},// 2 NOKTA
        };
    }

    @Test(dataProvider = "sendKeysProviders")
    public void TC_01(String username, String email, String password, String confirmPassword) {

        extentTest = extentReports.createTest("SıgnUp Testi",
                "Kullanıcı SıgnUp Butonuna basarak kayıt işlemi yapabilmeli");
        SoftAssert softAssert = new SoftAssert();

        // Kullanıcı SıgnUp Butonuna Basar
        loyalfriendcarePages.signUpButton.click();
        extentTest.info("Kullanıcı SıgnUp Butonuna Basar") ;

        // Kullanıcı usernameBox Kutusuna Kullanıcı adını girer
        loyalfriendcarePages.userNameBox.sendKeys(username);
        extentTest.info("") ;

        // Kullanıcı mailBox Kutusuna Mail adresini girer
        loyalfriendcarePages.mailBox.sendKeys(email);
        extentTest.info("Kullanıcı mailBox Kutusuna Mail adresini girer") ;

        // Kullanıcı passwordBox Kutusuna şifresini girer
        loyalfriendcarePages.passwordBox.sendKeys(password);
        extentTest.info("Kullanıcı passwordBox Kutusuna şifresini girer") ;

        // Kullanıcı confirmPassword Kutusuna şifresini girer
        loyalfriendcarePages.confirmPasswordBox.sendKeys(confirmPassword);
        extentTest.info("Kullanıcı confirmPassword Kutusuna şifresini girer") ;

        // Kullanıcı registerButonuna Tıklar ve Kayıt olur
        loyalfriendcarePages.registerButton.click();
        extentTest.info("Kullanıcı registerButonuna Tıklar ve Kayıt olur") ;

        // Kullanıcı kayıt işleminden sonra ana sayfaya yönlendirildiğini doğrular
        String expectedUrl = "https://qa.loyalfriendcare.com/en" ;
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.equals(expectedUrl),"Beklenen url ana sayfa ile aynı değil");
        extentTest.pass("Kullanıcı kayıt işleminden sonra ana sayfaya yönlendirildiğini doğrular") ;

        // Kullanıcı SignIn Butonunda Kullanıcı adını görür.
        String expectedUserNameText = username ;
        String actualUserNameText = loyalfriendcarePages.signInButton.getText() ;
        softAssert.assertTrue(actualUserNameText.equals(expectedUserNameText),"Hesap oluşturma başarısız");
        extentTest.pass("Kullanıcı SignIn Butonunda Kullanıcı adını görür.") ;

        // Kullanıcı anaSayfa üzerinde  sıgnIn butonunun ekran alıntısını alır
        TakeScreenShootWithGreenLine.captureFullScreenWithGreenCheck(loyalfriendcarePages.signUpButton, "signInButton") ;
        extentTest.info("Kullanıcı anaSayfa üzerinde  sıgnIn butonunun ekran alıntısını alır") ;

        // Kullanıcı sıgnInButtonunun fotoğrafını alır
        GetWebelementScreenShotWithGreenCheck.captureButtonWithGreenCheck(loyalfriendcarePages.signInButton, "signInButton") ;
        extentTest.info("Kullanıcı sıgnInButtonunun fotoğrafını alır") ;


        ReusableMethods.bekle(3);



        softAssert.assertAll();
    }
}
package tests.ZRecylbin;

import Pages.LFCPages;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.*;

public class M_02_MailRegression extends TestBaseRapor{

    LFCPages loyalfriendcarePages = new LFCPages();

    @DataProvider
    public static Object[][] sendKeysProviders() {
        return new Object[][]{
                {"a.l.iKam.i.l@gmail.com", "ali.......Kamil7123."},// 7 NOKTALI ŞİFRE
                {"a.l.iKam.i.l@gmail.com", "ali......Kamil6123."}, // 6 NOKTALI ŞİFRE
                {"a.l.iKam.i.l@gmail.com", "ali.....Kamil5123."}, // 5 NOKTALI ŞİFRE
                {"a.l.iKam.i.l@gmail.com", "ali....Kamil4123."}, // 4 NOKTALI ŞİFRE
                {"a.l.iKam.i.l@gmail.com", "ali...Kamil3123."}, // 3 NOKTALI ŞİFRE
                {"a.l.iKam.i.l@gmail.com", "ali..Kamil2123."}, // 2 NOKTALI ŞİFRE

        };
    }

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        loyalfriendcarePages = new LFCPages();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

    @Test (dataProvider = "sendKeysProviders")
    public void TC_01(String email, String password){
        extentTest = extentReports.createTest("YanlışKullanıcı Adı ,Yanlış Şifre",
                "Kullanıcı hatalı kullanıcı ve hatalı şifreyi test eder");

        SoftAssert softAssert = new SoftAssert();

        // Kullanıcı signInButton a tıklar
        loyalfriendcarePages.signInButton.click();
        extentTest.info("Kullanıcı signInButton a tıklar ") ;

        // Kullanıcı mailBox kutusuna email i girer
        loyalfriendcarePages.mailBox.sendKeys(email);
        extentTest.info("Kullanıcı mailBox kutusuna email i girer ") ;

        // passwordBox kutusuna şifresini girer
        loyalfriendcarePages.passwordBox.sendKeys(password);
        extentTest.info("passwordBox kutusuna şifresini girer") ;

        // loginPage sayfasında SigInButton a tıklar
        loyalfriendcarePages.loginPageSigInButton.click();
        extentTest.info("loginPage sayfasında SigInButton a tıklar ") ;

        // anaSayfa uzeinde SıgnIn butonu Kırmızı cerceve icine alir
        TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(loyalfriendcarePages.signInButton,"signInButton");
        extentTest.info("anaSayfa uzerinde SıgnIn butonu Kırmızı cerceve icine alir") ;

        //
        GetWebelementScreenShotWithRedSquare.captureButtonWithRedSquare(loyalfriendcarePages.signInButton, "signInButton") ;
        extentTest.info("sıgnInButton ekran alıntısını alır") ;


    }
}

package User_Test;

import Pages.HeaderPages;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;


public class US_002 extends TestBaseRapor {
    @Test (groups = "smoke")
    public void TC_01(){
        /**
         * TC_01 - Logo İşlevsellik Testi
         * 1. Ana sayfanın açılması
         * 2. Logo görünürlük kontrolü
         * 3. Logo tıklanabilirlik kontrolü
         * 4. Logo tıklama işlemi
         * 5. URL değişmezlik kontrolü
         */
        extentTest = extentReports.createTest("Logo Buton Testi",
                "Kullanici AnaSayfa Header Bölümünde Bulunan Logoya bastığında Url Değişmemeli");

        // 1. Ana sayfanın açılması
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        extentTest.info("Kullanıcı loyalfriendcare ana sayfasına gider") ;
        HeaderPages headerPages = new HeaderPages() ;

        // 2. Logo görünürlük kontrolü

        Assert.assertTrue(headerPages.logoButton.isDisplayed(),"Logo görünür değil");
        extentTest.pass("Kullanıcı AnaSayfa Header Bölününde yer alan Logo'nun görünürlüğünü test eder");

        // 3. Logo tıklanabilirlik kontrolü
       Assert.assertTrue(headerPages.logoButton.isEnabled(),"Logo tıklanabilir değil");
       extentTest.pass("Kullanıcı LogoButonunun tıklanabilir olduğunu test eder") ;

       // 4. Logo tıklama işlemi
        headerPages.logoButton.click();
        extentTest.info("Kullanıcı Logoya tıklar");

        //5. URL değişmezlik kontrolü

        String expectedUrl = "https://qa.loyalfriendcare.com/en" ;
        String actualUrl = Driver.getDriver().getCurrentUrl() ;
        Assert.assertEquals(actualUrl,expectedUrl,"Logo tıklandığında ana sayfaya yönlendirme yapılmadı");
        extentTest.pass("LogoButonuna bastığında Url değişmediğini test eder") ;
        extentTest.info("Logo Butonu Testi Başarılı ") ;
        Driver.quitDriver();



    }

    @Test (groups = "smoke")
    public void TC_02(){
        /*
        TC_02 SignInButonu işlevsellik testi
        1. Ana Sayfanın Açılması
        2. SignIn butonunun görünürlüğünü test eder.
        3. Butonun tıklanabilir olduğunu test eder.
        4. Butona tıklar
        5. URL uzantısında "login" olduğunu test eder
        6. Driver kapatır.
         */

        extentTest = extentReports.createTest("SignIn Buton Testi",
                "Kullanici AnaSayfa Header Bölümünde SignIn Butonuna   Login sayfasına Yönlendirilmeli");
        SoftAssert softAssert = new SoftAssert();
        // 1. Ana Sayfanın Açılması
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        extentTest.info("AnaSayfa Yüklendi") ;
        HeaderPages loyalfriendcarePages = new HeaderPages() ;

        // 2. SignIn butonunun görünürlüğünü test eder.
        softAssert.assertTrue(loyalfriendcarePages.signInButton.isDisplayed(), "Görünürlük hatası");
        extentTest.pass("SignIn butonunun görünürlüğünü test eder.") ;

        // 3. Butonun tıklanabilir olduğunu test eder.
        softAssert.assertTrue(loyalfriendcarePages.signInButton.isEnabled(), "Tıklanabilirlik hatası");
        extentTest.pass("SignIn butonunun tıklanabilir olduğunu test eder") ;

        // 4. SignIn Butonuna tıklar
        loyalfriendcarePages.signInButton.click();
        extentTest.info("Kullanıcı SignIn Butonuna tıklar") ;

        // 5. URL uzantısında "login" olduğunu test eder
        String expectedUrlIcerik = "login";
        String actualUrlIcerik = Driver.getDriver().getCurrentUrl() ;

        Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik)
                ,"Login sayfası Url uzantısı beklenen uzantıyı karşılamıyor"

                );

        extentTest.pass("URL içerik doğrulaması başarılı: " + expectedUrlIcerik) ;


        softAssert.assertAll();

        // 6. Driver kapatır.
        Driver.quitDriver();
    }

    @Test (groups = "smoke")
    public void TC_03(){
        /*
        TC_03 SignUp Butonu işlevsellik testi
        1. Ana Sayfanın Açılması
        2. SignUp butonunun görünürlüğünü test eder.
        3. Butonun tıklanabilir olduğunu test eder.
        4. Butona tıklar
        5. URL uzantısında "register" olduğunu test eder
        6. Driver kapatır.
         */


        extentTest = extentReports.createTest("SignUP Buton Testi",
                "Kullanici AnaSayfa Header Bölümünde SignUp Butonuna   Register sayfasına Yönlendirilmeli");

        SoftAssert softAssert = new SoftAssert();
        // 1. Ana Sayfanın Açılması
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        extentTest.info("AnaSayfa Yüklendi") ;
        HeaderPages loyalfriendcarePages = new HeaderPages() ;

        //2. SignUp butonunun görünürlüğünü test eder.

        softAssert.assertTrue(loyalfriendcarePages.signUpButton.isDisplayed(),"SıgnUp Butonu Görünürlük hatası");
        extentTest.pass("SıgnUp Butonunun görünürlüğünü test eder ") ;

        //        3. Butonun tıklanabilir olduğunu test eder.
        softAssert.assertTrue(loyalfriendcarePages.signUpButton.isEnabled(),"SıgnUp Butonu tılanabilir değil");
        extentTest.pass("SıgnUp Butonunun tıklanabilirliğini test eder") ;

        //        4. Butona tıklar
        loyalfriendcarePages.signUpButton.click();
        extentTest.info("Kullanıcı SıgnUp Butonuna Tıklar ") ;

        //        5. URL uzantısında "register" olduğunu test eder
        String expecctedUrlIcerik = "register" ;
        String actualUrlIcerik = Driver.getDriver().getCurrentUrl() ;
        softAssert.assertTrue(actualUrlIcerik.contains(expecctedUrlIcerik),"\"URL Doğrulama Hatası: Aktüel URL '\\\" + actualUrlIcerik + \\\"' beklenen '\\\" + \\n\" +\n" +
                "                        \"");
        extentTest.pass("URL içerik doğrulaması başarılı: \" + expectedUrlIcerik" ) ;
        softAssert.assertAll();

        //        6. Driver kapatır.
        Driver.quitDriver();

    }
}

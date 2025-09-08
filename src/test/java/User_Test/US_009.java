package User_Test;

import Pages.HeaderPages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;
import utilities.TestBaseRaporInLine;

import java.time.Duration;


public class US_009 extends TestBaseRaporInLine {

    HeaderPages adminPages = new HeaderPages() ;
    // test
    //Bir kullanıcı olarak, giriş yaparken şifremi unuttuğumda,
    // 'Şifremi Unuttum' bağlantısını kullanarak
    // şifremi sıfırlama sürecini başlatabilmek ve
    // yeni bir şifre oluşturabilmek istiyorum.

    @Test
    public void TC_01(){
        // Geçerli mail adresi ile şifrenin sıfırlanabildiğini test etmek
        // test geçmez

        extentTest = extentReports.createTest("Şifre Sıfırlama Testi",
                "Kullanıcı şifre sıfırlama işleminin başarılı olmasını test eder");
        SoftAssert softAssert = new SoftAssert();

        // 1. Ana sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        extentTest.info("Ana sayfa başarıyla yüklendi");

        // 2. Sign In butonuna tıkla
        adminPages.signInButton.click();
        extentTest.info("Sign In butonuna tıklandı");

        // 3. Forgot Password butonuna tıkla
        adminPages.forgotPasswordButton.click();
        extentTest.info("Forgot Password butonuna tıklandı");

        // 4. Sayfanın şifre sıfırlama sayfasına yönlendirildiğini doğrula
        String expectedUrlIcerik = "reset" ;
        String currentUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains(expectedUrlIcerik),
                "Şifre sıfırlama sayfasına yönlendirilemedi. Mevcut URL: " + currentUrl);
        extentTest.pass("Şifre sıfırlama sayfasına yönlendirildi:  " + currentUrl);

        // 5. Mail adresini girin
        adminPages.mailBox.sendKeys(ConfigReader.getProperty("userMail"));
        extentTest.info("Geçerli mail adresi girildi: " + ConfigReader.getProperty("userMail"));

        // 6. Send Password Reset Link butonuna tıklayın
        adminPages.sendPassWordLinkButton.click();
        extentTest.info("Send Password Linkine tıklandı");

        // 7. Alert yazısının içeriğini test eder
        String expectedAlertText = "Password reset link has been sent to your email";

        // çıkan PopUp Menüden text alma adımları
        // 8 Alert yazısının çıkmasını bekler
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(4));
        // Duration.ofSeconds( )  4 saniyeden az olmamalı. Alert yazısının çıkması bekleniyor
        wait.until(ExpectedConditions.alertIsPresent()); //alert yazsını bekle
        extentTest.info("Alert yazısının çıkmasını bekledi ") ;

        // 9 alert yazısını kaydeder
        Alert alert = Driver.getDriver().switchTo().alert(); // alerte geç

        String actualAlertText = alert.getText();  // alert yazısını al
        System.out.println("Alert metni: " + actualAlertText);
        alert.accept();
        extentTest.info("alert yazısı kaydedildi ") ;

        // alert text beklenen içerikle karşılatırır
        Assert.assertTrue(actualAlertText.equals(expectedAlertText), "şifre sıfırlama maili gönderilmedi ");
        extentTest.pass("Şifre sıfırlama linki gönderilmedi ");
        extentTest.fail("Şifre sıfırlama  linki çalışmıyor");

    }

    @Test
    public void TC_02(){
        // Geçerli mail adresi ile şifrenin sıfırlanmadığını test etmek
        // test geçer
        extentTest = extentReports.createTest("Şifre Sıfırlama Testi",
                "Kullanıcı Şifresini sıfırlayamadığını doğrular");

        // 1 Kayıtlı Kullanıcı ana Sayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        extentTest.info("Anasayfa Başarı ile yüklendi ");

        // 2 Kullanıcı Login Sayfasına gider
        wait.until(ExpectedConditions.elementToBeClickable(adminPages.signInButton)).click();
        extentTest.info("Kullanıcı Login Sayfasına yönlendirildi ");

        // 3 Kullanıcı Şifre sıfırlama sayfasına yönlendirilir
        wait.until(ExpectedConditions.elementToBeClickable(adminPages.forgotPasswordButton)).click();
        extentTest.info("Kullanıcı Şifre sıfırlama sayfasına yönlendirildi");

        // 4 Kullanıcı Mail Adresini gönderir
        wait.until(ExpectedConditions.visibilityOf(adminPages.mailBox))
                .sendKeys(ConfigReader.getProperty("userMail"));
        extentTest.info("Geçerli mail adresi girildi");

        // 5 Şifre sıfırlama linkine tıklar
        adminPages.sendPassWordLinkButton.click();
        extentTest.info("şifre sıfırlama Linkine tıklandı");


        // 6 Kullanıcı alert yazısının çıkmasını bekler
        wait.until(ExpectedConditions.alertIsPresent());
        extentTest.info("Kullanıcı alert yazısının çıkmasını bekledi ");

        // 7 Kullanıcı alert yazısını kaydeder
        Alert alert = Driver.getDriver().switchTo().alert();
        extentTest.info("Kullanıcı alert yazısını kaydetti");
        String actualAlertText = alert.getText();
        String expectedAlertText = "Password reset link has been sent to your email";


        // 8 Kullanıcı çıkan alert yazısı ile beklenen alert yazısını karşılaştırır
        Assert.assertNotEquals(actualAlertText,
                expectedAlertText, "Şifre sıfırlama linki gönderildi");
        extentTest.pass("Şifre sıfırlama linki gönderilmedi");
        alert.accept();
        extentTest.fail("Şifre sıfırlama linki gönderilmedi - Beklenen: FAİL");


    }



}


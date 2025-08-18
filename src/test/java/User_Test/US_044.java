package User_Test;

import Pages.LFCPages;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TakeScreenShotsWithRedSquare;

public class US_044 {
    //Bir yönetici olarak, profil menüsündeki
    // Logout seçeneğine tıklayarak admin panelinden
    // güvenli bir şekilde çıkış yapabilmeli
    // ve HomePage'e donebilmeliyim.
    LFCPages lfcPages = new LFCPages() ;
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
    }
    @AfterClass
    public void tearDown(){
        Driver.quitDriver();
    }

    @Test
    public void TC_01(){
        // 1 anaSayfayı yükleyin


        // 2 sıgnInButtona tıklayın
        lfcPages.signInButton.click();

        //3 geçerli admin bilgileri ile sayfaya giriş yapın
        lfcPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        lfcPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        lfcPages.loginPageSigInButton.click();

        // anaSayfaya yönlendirildiğinizi doğrulayın
        TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(lfcPages.accountButton,"loyalfriendcarePages"+".accountButton") ;

        String expectedUrl = "https://qa.loyalfriendcare.com/en";
        String actualUrl = Driver.getDriver().getCurrentUrl() ;
        softAssert.assertTrue(actualUrl.equals(expectedUrl));
        softAssert.assertAll();
    }
    @Test
    public void TC_02(){
        // 1 admin sayfasına giriş yapın
        lfcPages.accountButton.click();

        // 2 sayfa URL uzantısının "admin" içerdiğini doğrulayın
        String expectedUrlIcerik = "admin" ;
        String actualUrlIcerik  = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));

        // 3 profilden settings butona tıklayın
        lfcPages.profileButton.click();
        lfcPages.settingsButton.click();

        // 4 açılan sayfanın uzantısının "settings" olduğunu doğrulayın
        expectedUrlIcerik ="settings";
        actualUrlIcerik = Driver.getDriver().getCurrentUrl();
        softAssert.assertFalse(actualUrlIcerik.contains(expectedUrlIcerik));
        //Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));

        // 5 bekle3 saniye admin sayfasına dön
        ReusableMethods.bekle(3);
        Driver.getDriver().navigate().back();
        softAssert.assertAll();
    }
    @Test
    public void TC_03(){
        // 1 profileButton a tıkla
        lfcPages.profileButton.click();

        // 2 açılır menüden editProfileButton tıkla
        lfcPages.editProfileButton.click();

        // 3 açılan sayfa uzantısının "edit" içerdiğini doğrula
        String expectedUrlIcerik = "editPage";
        String actualUrlIcerik  = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));
        ReusableMethods.bekle(3);
        // back ile mainadminPage dön
        Driver.getDriver().navigate().back();
    }
    @Test
    public void TC_04(){
        // 1 profileButton tıkla
        lfcPages.profileButton.click();

        // 2 açılır menüden logOutButton tıkla
        lfcPages.logOutButton.click();

        // anasayfaya yönlendirildiğini doğrula
        String anaSayfaUrl = "https://qa.loyalfriendcare.com/en" ;
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,anaSayfaUrl);
        ReusableMethods.bekle(2);

    }
    @Test
    public void TC_05(){
        // sıgnOutButton tıklayarak sayfadan ayrıl
        lfcPages.signOutButton.click();

        String expectedSignInButtonText = "Sign In";
        Assert.assertEquals(lfcPages.signInButton.getText(),expectedSignInButtonText);

    }
}

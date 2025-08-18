package User_Test;

import Pages.LFCPages;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.MultiScreenShootsMethods;
import utilities.TakeScreenShotsWithRedSquare;

public class US_043 {
    LFCPages lfcPages = new LFCPages() ;

    @BeforeClass
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
    }

    //Bir yönetici olarak,
    // profil menüsündeki Edit Profile seçeneğine
    // tıklayarak kişisel bilgilerimi düzenleyebilmeliyim.

    @Test
    public void TC_01(){

        // 1 anaSayfa signInButton tıkla
        lfcPages.signInButton.click();

        // login sayfassında geçerli bilgileri girerek admin girişi yap
        lfcPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        lfcPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        lfcPages.loginPageSigInButton.click();

        // 2 anaSayfaya yönlendirildiğini doğrula
        String expectedUrl = "https://qa.loyalfriendcare.com/en" ;
        String actualUrl = Driver.getDriver().getCurrentUrl() ;

        Assert.assertEquals(actualUrl,expectedUrl);

        // 3 accountButton linkine tıklayın
        lfcPages.accountButton.click();

        // yönlendirildiğiniz sayfa URL uzantısının "admin" içerdiğini doğrulayın
        String expectedUrlIcerik = "admin";
        actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // profileButton dan editProfileButton tıklayarak ilgili sayfaya ulaşın
        lfcPages.profileButton.click();
        lfcPages.editProfileButton.click();

        // sayfa uzantısının "edit" içerdiğini doğrulayın
        expectedUrlIcerik = "edit" ;
        actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        MultiScreenShootsMethods.getWebelementWithRedBorder(
                Driver.getDriver(),
                ConfigReader.getProperty("lfc"),
                lfcPages.errorContainerWebelement
        );



        TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(lfcPages.errorContainerWebelement,"hatalısayfa");







    }
}

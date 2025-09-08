package User_Test;

import Pages.HeaderPages;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.MultiScreenShootsMethods;
import utilities.TakeScreenShotsWithRedSquare;

public class US_043 {
    HeaderPages headerPages = new HeaderPages() ;

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
        headerPages.signInButton.click();

        // login sayfassında geçerli bilgileri girerek admin girişi yap
        headerPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        headerPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        headerPages.loginPageSigInButton.click();

        // 2 anaSayfaya yönlendirildiğini doğrula
        String expectedUrl = "https://qa.loyalfriendcare.com/en" ;
        String actualUrl = Driver.getDriver().getCurrentUrl() ;

        //Assert.assertEquals(actualUrl,expectedUrl);

        // 3 accountButton linkine tıklayın
        headerPages.accountButton.click();

        // yönlendirildiğiniz sayfa URL uzantısının "admin" içerdiğini doğrulayın
        String expectedUrlIcerik = "admin";
        actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // profileButton dan editProfileButton tıklayarak ilgili sayfaya ulaşın
        headerPages.profileButton.click();
        headerPages.editProfileButton.click();

        // sayfa uzantısının "edit" içerdiğini doğrulayın
        expectedUrlIcerik = "edit" ;
        actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        MultiScreenShootsMethods.getWebelementWithRedBorder(
                Driver.getDriver(),
                actualUrl,
                headerPages.errorContainerWebelement
        );



        TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(headerPages.errorContainerWebelement,"hatalısayfa");

    }

    @Test
    public void sonrasilIseYaramaz(){
        Driver.getDriver().get(ConfigReader.getProperty("mdcn"));
        headerPages.rimadylButton.click();
        String expectedUrl = "rimadly";
        String actualUrl = "https://qa.loyalfriendcare.com/en/Medicines/suretin-mipen-ruma";

        MultiScreenShootsMethods.getWebelementWithRedBorder(
                Driver.getDriver(),
                actualUrl,
                headerPages.statusBar
        );

        }

        @Test
    public void sonraSilIseYaramaz2(){
        Driver.getDriver().get(ConfigReader.getProperty("mdcn"));

        headerPages.alpinaButton.click();
        String expectedUrlIcerik = "alpinia-officinarum";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        MultiScreenShootsMethods.getWebelementWithGreenLine(
                Driver.getDriver(),
                actualUrl,
                headerPages.statusBar
        );

        }
}


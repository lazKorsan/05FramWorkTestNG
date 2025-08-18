package tests.ZRecylbin;

import Pages.LFCPages;
import org.testng.annotations.Test;
import utilities.*;

public class M_03_MailRegressionHookers {
    @Test
    public void TC_01(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages loyalfriendcarePages = new LFCPages() ;

        loyalfriendcarePages.signInButton.click();
        loyalfriendcarePages.mailBox.sendKeys("alfaRomeo8@gmail.com");
        loyalfriendcarePages.passwordBox.sendKeys("alfaRomeo8123.");
        ReusableMethods.bekle(4);

        loyalfriendcarePages.loginPageSigInButton.click();

        TakeScreenShootWithGreenLine.captureFullScreenWithGreenCheck(loyalfriendcarePages.signInButton,"signInButton") ;
        GetWebelementScreenShotWithGreenCheck.captureButtonWithGreenCheck(loyalfriendcarePages.signInButton,"signInButton") ;
        TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(loyalfriendcarePages.signInButton,"signInButton") ;
        GetWebelementScreenShotWithRedSquare.captureButtonWithRedSquare(loyalfriendcarePages.signInButton,"signInButton") ;



        XTakeScreenShootWithGreenLine.captureFullScreenWithGreenCheck(loyalfriendcarePages.signInButton,"asdf") ;


       // WWWTakeScreenShootWithGreenLine.captureFullScreenWithGreenCheck(loyalfriendcarePages.signInButton,"signInButton") ;







        ReusableMethods.bekle(3);

    }
}

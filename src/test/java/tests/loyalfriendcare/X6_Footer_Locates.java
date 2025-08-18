package tests.loyalfriendcare;

import Pages.LFCPages;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class X6_Footer_Locates {
    @Test
    public void footerLocateTests() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        ReusableMethods.bekle(1);
        ReusableMethods.scrollToBottom();
        LFCPages lfcPages = new LFCPages();
        lfcPages.footerLogoButtons.click();
        ReusableMethods.scrollToBottom();

        lfcPages.footerWellnesButton.click();
        ReusableMethods.takeFullPageScreenshot("1111");
        Driver.getDriver().navigate().back();

        lfcPages.footerDentalCareButton.click();
        ReusableMethods.takeFullPageScreenshot("2222");
        Driver.getDriver().navigate().back();

        lfcPages.footerAnaesthesiaButton.click();
        ReusableMethods.takeFullPageScreenshot("3333");
        Driver.getDriver().navigate().back();

        lfcPages.footerDermatologyButton.click();
        ReusableMethods.takeFullPageScreenshot("4444");
        Driver.getDriver().navigate().back();

        lfcPages.footerDiagnosticsButton.click();
        ReusableMethods.takeFullPageScreenshot("5555");
        Driver.getDriver().navigate().back();

        lfcPages.footerFacebookButton.click();
        ReusableMethods.bekle(3); // zorunlu sayfanın yuklenmesi için
        ReusableMethods.takeFullPageScreenshot("6666");
        Driver.getDriver().navigate().back();

        lfcPages.footerXButton.click();
        ReusableMethods.takeFullPageScreenshot("7777");
        Driver.getDriver().navigate().back();

        lfcPages.footerYoutubeButton.click();
        ReusableMethods.takeFullPageScreenshot("8888");
        Driver.getDriver().navigate().back();

        lfcPages.footerPinterestButton.click();
        ReusableMethods.takeFullPageScreenshot("9999");
        Driver.getDriver().navigate().back();

        lfcPages.footerInstagramButton.click();
        ReusableMethods.takeFullPageScreenshot("10101010");
        Driver.getDriver().navigate().back();
    }
}



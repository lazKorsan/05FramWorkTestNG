package tests.loyalfriendcare;

import Pages.LFCPages;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class X1_DriverKontrolTesti {
    @Test
    public void DriverTestiConfigReaderTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages lfcPages = new LFCPages() ;

        ReusableMethods.getWebElementScreenshot(lfcPages.logoButton,"logoButton");
    }
}

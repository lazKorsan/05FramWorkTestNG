package tests.loyalfriendcare;

import Pages.LFCPages;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class X7_Header_Links {
    @Test
    public void headerLinksTest(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages lfcPages = new LFCPages() ;

        lfcPages.aboutUsButton.click();
    }


}

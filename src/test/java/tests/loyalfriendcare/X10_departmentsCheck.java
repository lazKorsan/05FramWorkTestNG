package tests.loyalfriendcare;

import Pages.LFCPages;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class X10_departmentsCheck {
    @Test
    public void departmentsButtonCheck(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages lfcPages = new LFCPages() ;

        lfcPages.departmentsButton.click();

















       // Driver.quitDriver();
    }
}

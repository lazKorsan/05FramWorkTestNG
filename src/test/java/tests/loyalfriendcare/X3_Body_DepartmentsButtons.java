package tests.loyalfriendcare;

import Pages.LFCPages;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class X3_Body_DepartmentsButtons {
    @Test
    public void DepartmentsLocateTest(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages lfcPages = new LFCPages() ;


        lfcPages.wellnessButton.click();
        ReusableMethods.bekle(2);
        Driver.getDriver().navigate().back();

        lfcPages.dentalCareButton.click();
        ReusableMethods.bekle(5);

        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(2);


        lfcPages.anaesthesiaButton.click();
        ReusableMethods.bekle(5);

        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(1);


        lfcPages.dermatologyButton.click();
        ReusableMethods.bekle(5);

        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(1);

        lfcPages.diagnosticsButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().navigate().back();

        ReusableMethods.bekle(2);

        lfcPages.bodyvaccinationsButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().navigate().back();

        lfcPages.painControlButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().navigate().back();

        lfcPages.boardingButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().navigate().back();

        lfcPages.ilaveButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().navigate().back();

        lfcPages.yeniButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().navigate().back();

       // Driver.quitDriver();

    }
}

package tests.loyalfriendcare;

import Pages.LFCPages;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class X2_Header_LocatersTest {

    @Test
    public void locaterTesti1(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages lfcPages = new LFCPages();

        ReusableMethods.getWebElementScreenshot(lfcPages.homeButton,"12345");

        //ReusableMethods.takeFullPageScreenshot("LFCANADAKKO");

        ReusableMethods.getWebElementScreenshot(lfcPages.aboutUsButton, "helloworld");

        lfcPages.aboutUsButton.click();
    }
    @Test
    public void locaterTesti2(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages loyalfriendcarePages = new LFCPages() ;
        loyalfriendcarePages.aboutUsButton.click();

    }
    @Test
    public void locaterTesti3(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages loyalfriendcarePages = new LFCPages() ;
        loyalfriendcarePages.departmentsButton.click();
    }
    @Test
    public void headerDoctorsButtons(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages loyalfriendcarePages = new LFCPages() ;
        loyalfriendcarePages.doctorsButton.click();
        ReusableMethods.bekle(2);
        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }
    @Test
    public void headerMedicineButtons(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        LFCPages loyalfriendcarePages = new LFCPages() ;
        loyalfriendcarePages.medicinesButton.click();
    }
    @Test
    public void headerVaccinationsButtons(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages loyalfriendcarePages = new LFCPages() ;
        ReusableMethods.getWebElementScreenshot(loyalfriendcarePages.vaccinationsButton,"sdf");

        loyalfriendcarePages.vaccinationsButton.click();
    }
    @Test
    public void headerSignTest(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages loyalfriendcarePages = new LFCPages() ;

        loyalfriendcarePages.signInButton.click();
        ReusableMethods.bekle(2);
        Driver.getDriver().navigate().back();

        loyalfriendcarePages.signUpButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(2);
        Driver.quitDriver();

    }
}

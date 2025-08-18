package tests.loyalfriendcare;

import Pages.LFCPages;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class X9_ContactUsPages_Locate {

    @Test
    public void contactUsLocate(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages lfcPages = new LFCPages() ;

        // <--
        lfcPages.aboutUsButton.click();
        ReusableMethods.takeFullPageScreenshot(
               "qa.loyalfriendcare.com/en/about" );

        lfcPages.budgetVetCareButton.click();
        ReusableMethods.takeFullPageScreenshot(
                "VetCare_Budget_");
        // -->
        //<-- dateButton ; phoneBox ;  departmentButton ; doctorsButton
        //   lfcPages.dateButton  ;

        ReusableMethods.getWebElementScreenshot(lfcPages.dateButton,"dateButton");
        ReusableMethods.getWebElementScreenshot(lfcPages.phoneBox,"phoneBox");
        ReusableMethods.getWebElementScreenshot(lfcPages.departmentButton,"departmentButton");
        ReusableMethods.getWebElementScreenshot(lfcPages.selectDoctorsButton,"doctorsButton");
        ReusableMethods.getWebElementScreenshot(lfcPages.messageBox,"messageBox");
        ReusableMethods.getWebElementScreenshot(lfcPages.submitButton,"submitButton");





    //Driver.quitDriver();
    }

}

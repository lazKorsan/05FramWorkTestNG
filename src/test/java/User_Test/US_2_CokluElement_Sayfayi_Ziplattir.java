package User_Test;

import Pages.HeaderPages;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_2_CokluElement_Sayfayi_Ziplattir {

    @Test
    public void contactUsLocate(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        HeaderPages headerPages = new HeaderPages() ;

        // <--
        headerPages.aboutUsButton.click();
        ReusableMethods.takeFullPageScreenshot(
               "qa.loyalfriendcare.com/en/about" );

        headerPages.budgetVetCareButton.click();
        ReusableMethods.takeFullPageScreenshot(
                "VetCare_Budget_");
        // -->
        //<-- dateButton ; phoneBox ;  departmentButton ; doctorsButton
        //   lfcPages.dateButton  ;

        ReusableMethods.getWebElementScreenshot(headerPages.dateButton,"dateButton");
        ReusableMethods.getWebElementScreenshot(headerPages.phoneBox,"phoneBox");
        ReusableMethods.getWebElementScreenshot(headerPages.departmentButton,"departmentButton");
        ReusableMethods.getWebElementScreenshot(headerPages.selectDoctorsButton,"doctorsButton");
        ReusableMethods.getWebElementScreenshot(headerPages.messageBox,"messageBox");
        ReusableMethods.getWebElementScreenshot(headerPages.submitButton,"submitButton");





    //Driver.quitDriver();
    }

}

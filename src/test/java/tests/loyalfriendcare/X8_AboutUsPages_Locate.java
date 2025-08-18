package tests.loyalfriendcare;

import Pages.LFCPages;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class X8_AboutUsPages_Locate {

    @Test
    public void aboutUsPageTest(){
        // budgetVetCareButton ; petShelterButton  ;  certifiedVetButton ; nutritionShop ;
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages lfcPages = new LFCPages() ;
        lfcPages.aboutUsButton.click();
        ReusableMethods.takeFullPageScreenshot("loyalfriendcare.com/en/about");

        ReusableMethods.getWebElementScreenshot(
                lfcPages.budgetVetCareButton,
                "budgetVetCareButton"
                +LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        lfcPages.budgetVetCareButton.click();
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(
                lfcPages.petShelterButton,
                "petShelterButton"
                        +LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        lfcPages.petShelterButton.click();
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(
                lfcPages.certifiedVetButton,
                "certifiedVetButton"
                        +LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        lfcPages.certifiedVetButton.click();
        Driver.getDriver().navigate().back();


        ReusableMethods.getWebElementScreenshot(
                lfcPages.nutritionShop,
                "nutritionShop"
                        +LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        lfcPages.nutritionShop.click();
        Driver.getDriver().navigate().back();

        ReusableMethods.bekle(5);

        //Driver.quitDriver();
    }

}

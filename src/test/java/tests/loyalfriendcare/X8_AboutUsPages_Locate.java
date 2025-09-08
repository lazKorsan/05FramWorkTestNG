package tests.loyalfriendcare;

import Pages.HeaderPages;
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
        HeaderPages headerPages = new HeaderPages() ;
        headerPages.aboutUsButton.click();
        ReusableMethods.takeFullPageScreenshot("loyalfriendcare.com/en/about");

        ReusableMethods.getWebElementScreenshot(
                headerPages.budgetVetCareButton,
                "budgetVetCareButton"
                +LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        headerPages.budgetVetCareButton.click();
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(
                headerPages.petShelterButton,
                "petShelterButton"
                        +LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        headerPages.petShelterButton.click();
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(
                headerPages.certifiedVetButton,
                "certifiedVetButton"
                        +LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        headerPages.certifiedVetButton.click();
        Driver.getDriver().navigate().back();


        ReusableMethods.getWebElementScreenshot(
                headerPages.nutritionShop,
                "nutritionShop"
                        +LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        headerPages.nutritionShop.click();
        Driver.getDriver().navigate().back();

        ReusableMethods.bekle(5);

        //Driver.quitDriver();
    }

}

package tests.loyalfriendcare;

import Pages.LFCPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.XPathGenerator;

public class X5_Body_VaccinationButtonsTests {

    @Test
    public void bodyLocaterTests(){

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages lfcPages = new LFCPages() ;

        ReusableMethods.getWebElementScreenshot(lfcPages.wellnessButton,"wellnessButton");
        lfcPages.wellnessButton.click();
        ReusableMethods.bekle(2);
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(lfcPages.dentalCareButton,"dentalCareButton");
        lfcPages.dentalCareButton.click();
        ReusableMethods.bekle(5);

        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(2);

        ReusableMethods.getWebElementScreenshot(lfcPages.anaesthesiaButton,"anaesthesiaButton");
        lfcPages.anaesthesiaButton.click();
        ReusableMethods.bekle(5);

        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(1);

        ReusableMethods.getWebElementScreenshot(lfcPages.dermatologyButton,"dermatologyButton");
        lfcPages.dermatologyButton.click();
        ReusableMethods.bekle(5);

        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(1);

        ReusableMethods.getWebElementScreenshot(lfcPages.diagnosticsButton,"diagnosticsButton");
        lfcPages.diagnosticsButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().navigate().back();

        ReusableMethods.bekle(2);

        ReusableMethods.getWebElementScreenshot(lfcPages.bodyvaccinationsButton,"bodyvaccinationsButton");
        lfcPages.bodyvaccinationsButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().navigate().back();

        WebElement vaccanitonsRoom =Driver.getDriver().findElement(By.xpath("//*[@id=\"page\"]/main/div[2]/div[3]/div/a/figure/img")) ;
        XPathGenerator.printXpathFormulas(vaccanitonsRoom);
        ReusableMethods.getWebElementScreenshot(vaccanitonsRoom,"//img[@alt='Vaccinations Room']");
        vaccanitonsRoom.click();
        ReusableMethods.takeFullPageScreenshot("BEDS");
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().back();


        ReusableMethods.getWebElementScreenshot(lfcPages.painControlButton,"painControlButton");
        lfcPages.painControlButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(lfcPages.boardingButton,"boardingButton");
        lfcPages.boardingButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(lfcPages.ilaveButton,"ilaveButton");
        lfcPages.ilaveButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(lfcPages.yeniButton,"yeniButton");
        lfcPages.yeniButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().navigate().back();
    }
    @Test
    public void bodyMainButtonsTest(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages loyalfriendcarePages = new LFCPages() ;

        //XPathGenerator.printXpathFormulas(loyalfriendcarePages.bodyDepartmentsButton);
        loyalfriendcarePages.miniDepartmentsButton.click();
        ReusableMethods.bekle(5);
        Driver.getDriver().navigate().back();
        XPathGenerator.printXpathFormulas(loyalfriendcarePages.miniDoctorsButton);
        loyalfriendcarePages.miniDoctorsButton.click();
        ReusableMethods.bekle(5);
        Driver.getDriver().navigate().back();

        loyalfriendcarePages.miniMainVaccinationsButton.click();
        ReusableMethods.bekle(5);
        Driver.getDriver().navigate().back();

    }
    @Test
    public void vacinationForPetsButtonsTest(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        ReusableMethods.bekle(1);
        ReusableMethods.scrollToBottom();

        LFCPages loyalfriendcarePages = new LFCPages() ;


        loyalfriendcarePages.rabiesVaccineButton.click();
        ReusableMethods.takeFullPageScreenshot("111loyalfriendcarePages.bodyRabiesVaccineButton");
        //ReusableMethods.bekle(3);
        Driver.getDriver().navigate().back();




        loyalfriendcarePages.DHPPVaccineButton.click();
        ReusableMethods.takeFullPageScreenshot("222dhhp aşisı");
        //ReusableMethods.bekle(3);
        Driver.getDriver().navigate().back();

        ReusableMethods.bekle(1);
        loyalfriendcarePages.felineLeukemiaVaccineButton.click();
        ReusableMethods.takeFullPageScreenshot("333FELLİNİAŞISI");
        //ReusableMethods.bekle(3);
        Driver.getDriver().navigate().back();
        loyalfriendcarePages.felineImmunoeficenyVirusButton.click();
        ReusableMethods.takeFullPageScreenshot("4444loyalfriendcarePages.bodyFelineImmunoeficenyVirusButton.click();");
        Driver.getDriver().navigate().back();

        ReusableMethods.bekle(1);
        loyalfriendcarePages.bordetellaVaccineButton.click();
        ReusableMethods.takeFullPageScreenshot("555444bordetelle");
        //ReusableMethods.bekle(2);
        Driver.getDriver().navigate().back();

        ReusableMethods.bekle(1);
        loyalfriendcarePages.felinePanleukopeniaVaccineButton.click();
        ReusableMethods.takeFullPageScreenshot("6666555Feline panelue vacca");
        //ReusableMethods.bekle(2);
        Driver.getDriver().navigate().back();

        ReusableMethods.bekle(2);
        loyalfriendcarePages.felineHerpesvirusVaccineButton.click();
        ReusableMethods.takeFullPageScreenshot("7777666HERPES AŞİSI");
        //ReusableMethods.bekle(2);
        Driver.getDriver().navigate().back();

        ReusableMethods.bekle(2);
        loyalfriendcarePages.surgicalProcedureButton.click();
        ReusableMethods.takeFullPageScreenshot("8888777SURGİCAL PRODUCURE");
        //ReusableMethods.bekle(2);
        Driver.getDriver().navigate().back();

        // Driver.quitDriver();


    }

}

package User_Test;

import Pages.LFCPages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.*;

import java.time.Duration;

public class US_001 {
    LFCPages lfcPages = new LFCPages() ;
    @Test
    public void TC_01(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
    }

    @Test
    public void multiScreenShotsMetodlarininCagirilmasi(){

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        // cağırılan elementlerin kırmızı cizgiye alınması
        MultiScreenShootsMethods.getWebelementWithRedBorder( // Kırmızı cerceve
                Driver.getDriver(),
                ConfigReader.getProperty("lfc"),
                lfcPages.logoButton,
                lfcPages.signInButton,
                lfcPages.signUpButton
        );

        // cağırılan elementlerin altına yeşil chick işareti koyar
        MultiScreenShootsMethods.getWebelementWithGreenLine(
                Driver.getDriver(),
                ConfigReader.getProperty("lfc"),
                lfcPages.homeButton,
                lfcPages.aboutUsButton,
                lfcPages.doctorsButton,
                lfcPages.doctorsButton
        );

        // hem kırmızı hem yeşil birlikte

        MultiScreenShootsMethods.getWebelementWithRedBorderAndGreenLine(
                Driver.getDriver(),
                ConfigReader.getProperty("lfc"),
                new WebElement[]{
                        lfcPages.logoButton,
                        lfcPages.signInButton,
                        lfcPages.signUpButton
                } ,
                new WebElement[]{
                        lfcPages.homeButton,
                        lfcPages.aboutUsButton,
                        lfcPages.doctorsButton,
                        lfcPages.departmentsButton,
                        lfcPages.medicinesButton
                }

        );

    }
    @Test
    public void DropDownTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        Actions actions = new Actions(Driver.getDriver(), Duration.ofSeconds(1));
        actions.moveToElement(lfcPages.departmentsButton).perform();

       // XPathGenerator.printXpathFormulas(lfcPages.ddWelnesButton);
       // XPathGenerator.printXpathFormulas(lfcPages.ddDentalCareButton);
       // XPathGenerator.printXpathFormulas(lfcPages.ddAnaesthesia);
       // XPathGenerator.printXpathFormulas(lfcPages.ddDermatology);
        XPathGenerator.printXpathFormulas(lfcPages.ddDiagnostics);
















    }
}

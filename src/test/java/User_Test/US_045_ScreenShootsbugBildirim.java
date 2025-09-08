package User_Test;

import Pages.HeaderPages;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.MultiScreenShootsMethods;
import utilities.ReusableMethods;
// bug bildirimi için if-else method

public class US_045_ScreenShootsbugBildirim {
    HeaderPages headerPages = new HeaderPages();

    @Test
    public void TC_01(){ // HATALI URL BİLDİRİMİ GEÇER
        Driver.getDriver().get(ConfigReader.getProperty("mdcn"));
        headerPages.rimadylButton.click();
        String expectedUrlIcerik = " rimadyl-carprofen";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            MultiScreenShootsMethods.getWebelementWithGreenLine(
                    Driver.getDriver(),
                    actualUrl,
                    headerPages.statusBar

            );
        } else {
            MultiScreenShootsMethods.getWebelementWithRedBorder(
                    Driver.getDriver(),
                    actualUrl,
                    headerPages.statusBar

            );
        }

    }

    @Test
    public void TC02(){ // DOĞRU URL BİLİDİRİMİ
        Driver.getDriver().get(ConfigReader.getProperty("mdcn"));
        headerPages.alpinaButton.click();
        ReusableMethods.bekle(2);

        String expectedUrlIcerik= "alpinia-officinarum";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            MultiScreenShootsMethods.getWebelementWithGreenLine(
                    Driver.getDriver(),
                    actualUrl,
                    headerPages.statusBar

            );
        } else {
            MultiScreenShootsMethods.getWebelementWithRedBorder(
                    Driver.getDriver(),
                    actualUrl,
                    headerPages.statusBar

            );
        }

    }
}

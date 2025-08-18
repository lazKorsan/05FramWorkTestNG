package User_Test;

import Pages.LFCPages;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_004 {
    @DataProvider
    public static Object[][] aranacakUrunProvideri() {  // satır13
        String[][] aranacakUrunler = {
                {"Rimadyl"}, {"Revolution"}, {"Baytril"}, {"Apoquel"}, {"Metacam"},
                {"Rabies"}, {"DHPP Vaccine"}, {"Bordetella"}
        };

        return aranacakUrunler;  // satır19

    }

    @Test (dataProvider = "aranacakUrunProvideri")
    public void TC_01(String aranacakUrun){
        Driver.getDriver().get(ConfigReader.getProperty("lfc")); // satır25
        LFCPages lfcPages = new LFCPages() ;


        lfcPages.searchBox.sendKeys(aranacakUrun+ Keys.ENTER);
        lfcPages.searchResult.click();
        ReusableMethods.scrollToBottom();


        String unExpectedSonucYazisi = ConfigReader.getProperty("lfcBulunamadiYazisi"); // 0 Products Found
        String searchResultTextContent = lfcPages.searchResultElementi.getText() ;

        Assert.assertNotEquals(searchResultTextContent,unExpectedSonucYazisi,
                aranacakUrun+"için arama sonucu"+searchResultTextContent);

        Driver.quitDriver();
    }

}

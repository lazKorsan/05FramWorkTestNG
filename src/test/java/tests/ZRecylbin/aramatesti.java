package tests.ZRecylbin;

import Pages.AdminPages;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class aramatesti {

    AdminPages adminPages = new AdminPages() ;
    @Test
    public void aramaTesti(){

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        adminPages.searchBox.sendKeys("ad"+ Keys.ENTER);
        ReusableMethods.bekle(5);
    }

}

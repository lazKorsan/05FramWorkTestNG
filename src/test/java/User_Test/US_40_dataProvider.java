package User_Test;

import Pages.AdminPages;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_40_dataProvider {

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        AdminPages adminPages = new AdminPages() ;
        adminPages.signInButton.click();

        adminPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        adminPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminPages.loginPageSignInButton.click();
        ReusableMethods.bekle(2);


    }
    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }


    @DataProvider
    public static Object[][] sendKeysProviders() {
        return new Object[][]{
                {"dataprovidertesti1", "sendContent1", "670"},
                {"dataprovidertesti2", "sendContent12", "670"},
                {"dataprovidertesti3", "sendContent13", "670"},
                {"dataprovidertesti4", "sendContent14", "670"},
                {"dataprovidertesti5", "sendContent15", "670"},

        };
    }

    @Test (dataProvider = "sendKeysProviders")
    public void dataProviderTesti(String Title, String content, String Price ){

        AdminPages adminPages = new AdminPages() ;

        adminPages.accountButton.click();

        ReusableMethods.bekle(2);

        adminPages.dashBoard.click();
        adminPages.vaccinationsButton.click();
        ReusableMethods.bekle(2);

        adminPages.addVaccinationsButton.click();
        ReusableMethods.bekle(2);

        // < -- ============== DataProvider   ============== -- >

        adminPages.petsTitleBox.sendKeys(Title);
        adminPages.petsContentBox.sendKeys(content);
        adminPages.petPriceBox.sendKeys(Price);

        // < -- =====^^^^====== DataProvider   ====^^^^======= -- >



        ReusableMethods.bekle(2);

        adminPages.saveButton.click();

        Driver.getDriver().navigate().refresh();
        ReusableMethods.scrollToBottom();
        adminPages.deleteVaccinationsButton.click();


    }
}

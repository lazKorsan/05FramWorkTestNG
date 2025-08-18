package User_Test;

import Pages.DBPages;
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
        DBPages dbPages = new DBPages() ;
        dbPages.signInButton.click();

        dbPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        dbPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        dbPages.loginPageSignInButton.click();
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

        DBPages dbPages = new DBPages() ;

        dbPages.accountButton.click();

        ReusableMethods.bekle(2);

        dbPages.dashBoard.click();
        dbPages.vaccinationsButton.click();
        ReusableMethods.bekle(2);

        dbPages.addVaccinationsButton.click();
        ReusableMethods.bekle(2);

        // < -- ============== DataProvider   ============== -- >

        dbPages.petsTitleBox.sendKeys(Title);
        dbPages.petsContentBox.sendKeys(content);
        dbPages.petPriceBox.sendKeys(Price);


        // < -- =====^^^^====== DataProvider   ====^^^^======= -- >
        ReusableMethods.bekle(2);

        dbPages.saveButton.click();

        Driver.getDriver().navigate().refresh();
        ReusableMethods.scrollToBottom();
        dbPages.deleteVaccinationsButton.click();


    }
}

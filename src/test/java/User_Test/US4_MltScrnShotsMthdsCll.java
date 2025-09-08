package User_Test;

import Pages.AdminPages;
import Pages.HeaderPages;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.MultiScreenShootsMethods;
import utilities.ReusableMethods;

public class US4_MltScrnShotsMthdsCll {
    HeaderPages headerPages = new HeaderPages() ;

    @Test
    public void Test_001(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        headerPages.signInButton.click();
        ReusableMethods.bekle(1);

        // box lar kırmızı çizgi buttonlar yeşil çizgi
        MultiScreenShootsMethods.getWebelementWithRedBorderAndGreenLine(
                Driver.getDriver(),
                ConfigReader.getProperty("loginPage"),
                new WebElement[]{
                        headerPages.mailBox,
                        headerPages.passwordBox,
                } ,
                new WebElement[]{
                        headerPages.rememberMeButton,
                        headerPages.forgotPasswordButton,
                        headerPages.loginPageSigInButton
                }

        );

        headerPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        headerPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        headerPages.loginPageSigInButton.click();

        MultiScreenShootsMethods.getWebelementWithRedBorder(
                Driver.getDriver(),
                ConfigReader.getProperty("lfc"),
                headerPages.accountButton

                );

        headerPages.accountButton.click();
        ReusableMethods.bekle(2);

        headerPages.profileButton.click();
        headerPages.editProfileButton.click();

        MultiScreenShootsMethods.getWebelementWithRedBorder(
                Driver.getDriver(),
                ConfigReader.getProperty("editPage"),
                headerPages.errorContainerWebelement

        );



    }
    @Test
    public void TC_02(){
        AdminPages adminPages = new AdminPages();
        Driver.getDriver().get(ConfigReader.getProperty("mdcn"));
        headerPages.medicinesButton.click();
        headerPages.rimadylButton.click();

        MultiScreenShootsMethods.getWebelementWithRedBorder(
                Driver.getDriver(),
                ConfigReader.getProperty("https://qa.loyalfriendcare.com/en/Medicines/suretin-mipen-ruma"),
                headerPages.statusBar
        );
    }
}

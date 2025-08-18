package tests.MethodCall;

import Pages.LFCPages;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.MultiScreenShootsMethods;
import utilities.ReusableMethods;

public class MltScrnShotsMthdsCll {
    LFCPages lfcPages = new LFCPages() ;

    @Test
    public void Test_001(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        lfcPages.signInButton.click();
        ReusableMethods.bekle(1);

        // box lar kırmızı çizgi buttonlar yeşil çizgi
        MultiScreenShootsMethods.getWebelementWithRedBorderAndGreenLine(
                Driver.getDriver(),
                ConfigReader.getProperty("loginPage"),
                new WebElement[]{
                        lfcPages.mailBox,
                        lfcPages.passwordBox,
                } ,
                new WebElement[]{
                        lfcPages.rememberMeButton,
                        lfcPages.forgotPasswordButton,
                        lfcPages.loginPageSigInButton
                }

        );

        lfcPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        lfcPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        lfcPages.loginPageSigInButton.click();

        MultiScreenShootsMethods.getWebelementWithRedBorder(
                Driver.getDriver(),
                ConfigReader.getProperty("lfc"),
                lfcPages.accountButton

                );

        lfcPages.accountButton.click();
        ReusableMethods.bekle(2);

        lfcPages.profileButton.click();
        lfcPages.editProfileButton.click();

        MultiScreenShootsMethods.getWebelementWithRedBorder(
                Driver.getDriver(),
                ConfigReader.getProperty("editPage"),
                lfcPages.errorContainerWebelement

        );



    }
}

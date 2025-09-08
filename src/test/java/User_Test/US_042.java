package User_Test;

import Pages.HeaderPages;
import org.testng.annotations.Test;
import utilities.*;

public class US_042 {
    HeaderPages headerPages = new HeaderPages() ;

    //Bir yönetici olarak, admin paneldeki profil menüsüne erişebilmeli
    // ve profilime ait seçenekleri (Settings,  Edit Profil, Logout) görüntüleyebilmeliyim.
  @Test
  public void TC_01(){
      Driver.getDriver().get(ConfigReader.getProperty("lfc"));
      headerPages.signInButton.click();
      headerPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
      headerPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
      headerPages.loginPageSigInButton.click();
      ReusableMethods.bekle(2);

      TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(
              headerPages.accountButton,
              "accountButton");

      headerPages.accountButton.click();
      ReusableMethods.bekle(1);

      headerPages.profileButton.click();

      MultiScreenShootsMethods.getWebelementWithRedBorder(
              Driver.getDriver(),
              ConfigReader.getProperty("adminPage"),
              headerPages.profileButton,
              headerPages.settingsButton,
              headerPages.editProfileButton,
              headerPages.logOutButton
      );
      headerPages.settingsButton.isDisplayed();
      headerPages.editProfileButton.isDisplayed();
      headerPages.logOutButton.isDisplayed();

      headerPages.settingsButton.isEnabled();
      headerPages.editProfileButton.isEnabled();
      headerPages.logOutButton.isEnabled();

      headerPages.settingsButton.click();
      ReusableMethods.takeFullPageScreenshot("settingPage");
      ReusableMethods.bekle(1);
      Driver.getDriver().navigate().back();

      ReusableMethods.bekle(1);
      headerPages.profileButton.click();
      headerPages.editProfileButton.click();
      MultiScreenShootsMethods.getWebelementWithRedBorder(
              Driver.getDriver(),
              ConfigReader.getProperty("editPage"),
              headerPages.errorContainerWebelement
      );
      ReusableMethods.bekle(1);
      Driver.getDriver().navigate().back();

      headerPages.profileButton.click();
      headerPages.logOutButton.click();

      TakeScreenShootWithGreenLine.captureFullScreenWithGreenCheck(
              headerPages.accountButton,"accountButton"
      );

      headerPages.signOutButton.click();





  }
}

package User_Test;

import Pages.LFCPages;
import org.testng.annotations.Test;
import utilities.*;

public class US_042 {
    LFCPages lfcPages = new LFCPages() ;

    //Bir yönetici olarak, admin paneldeki profil menüsüne erişebilmeli
    // ve profilime ait seçenekleri (Settings,  Edit Profil, Logout) görüntüleyebilmeliyim.
  @Test
  public void TC_01(){
      Driver.getDriver().get(ConfigReader.getProperty("lfc"));
      lfcPages.signInButton.click();
      lfcPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
      lfcPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
      lfcPages.loginPageSigInButton.click();
      ReusableMethods.bekle(2);

      TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(
              lfcPages.accountButton,
              "accountButton");

      lfcPages.accountButton.click();
      ReusableMethods.bekle(1);

      lfcPages.profileButton.click();

      MultiScreenShootsMethods.getWebelementWithRedBorder(
              Driver.getDriver(),
              ConfigReader.getProperty("adminPage"),
              lfcPages.profileButton,
              lfcPages.settingsButton,
              lfcPages.editProfileButton,
              lfcPages.logOutButton

      );
      lfcPages.settingsButton.isDisplayed();
      lfcPages.editProfileButton.isDisplayed();
      lfcPages.logOutButton.isDisplayed();

      lfcPages.settingsButton.isEnabled();
      lfcPages.editProfileButton.isEnabled();
      lfcPages.logOutButton.isEnabled();

      lfcPages.settingsButton.click();
      ReusableMethods.takeFullPageScreenshot("settingPage");
      ReusableMethods.bekle(1);
      Driver.getDriver().navigate().back();

      ReusableMethods.bekle(1);
      lfcPages.profileButton.click();
      lfcPages.editProfileButton.click();
      MultiScreenShootsMethods.getWebelementWithRedBorder(
              Driver.getDriver(),
              ConfigReader.getProperty("editPage"),
              lfcPages.errorContainerWebelement
      );
      ReusableMethods.bekle(1);
      Driver.getDriver().navigate().back();

      lfcPages.profileButton.click();
      lfcPages.logOutButton.click();

      TakeScreenShootWithGreenLine.captureFullScreenWithGreenCheck(
              lfcPages.accountButton,"accountButton"
      );

      lfcPages.signOutButton.click();





  }
}

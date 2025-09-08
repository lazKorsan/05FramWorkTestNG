package User_Test;

import Pages.AdminPages;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.*;

public class US_038 {
    //Bir yönetici olarak,
    // yeni bir reklam oluşturabilmeli ve
    // bu kaydı reklam listesine ekleyebilmeliyim.
    @Test
    public void TC_01(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        AdminPages adminPages = new AdminPages() ;
        adminPages.signInButton.click();
        adminPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        adminPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminPages.loginPageSignInButton.click();
        adminPages.accountButton.click();
        adminPages.dashBoard.click();
        adminPages.petsAdsenseButton.click();
        adminPages.createPetAdSenseButton.click();

        adminPages.addForumLocationButtons.click();
        adminPages.addForumFieldBox.sendKeys("Header"+Keys.ENTER);

        adminPages.addForumPetTitle.sendKeys("lililili");

        adminPages.addForumDisplayName.sendKeys("KEDİLERİ SEVERİZ");
        adminPages.addForumRadioButton.click();

        adminPages.addForumTypeButton.click();

        adminPages.addForumTypeBox.sendKeys("Code" +Keys.ENTER);

        adminPages.addForumImageButton.click();

        ReusableMethods.bekle(1);
        ReusableMethods.scrollToBottom();



        adminPages.addForumImageUrlBox.sendKeys("https://images.app.goo.gl/CkTiMnWUD13iv4ew8");

        adminPages.addForumAdSenseButton.click();

        ReusableMethods.scrollToBottom();

       adminPages.addForumTextBox.sendKeys("DJHUIOJHJOI");

       ReusableMethods.scrollToBottom();
       ReusableMethods.bekle(1);


        adminPages.addForumSaveButton.click();

        ReusableMethods.bekle(2);

        adminPages.dashBoard.click();
        adminPages.petsAdsenseButton.click();

        adminPages.subPetAdsenseButton.click();
        ReusableMethods.bekle(1);


        adminPages.deleteButton.click();

    }

}

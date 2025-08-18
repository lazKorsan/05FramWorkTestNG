package User_Test;

import Pages.DBPages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.*;

public class US_038 {
    //Bir yönetici olarak,
    // yeni bir reklam oluşturabilmeli ve
    // bu kaydı reklam listesine ekleyebilmeliyim.
    @Test
    public void TC_01(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        DBPages dbPages = new DBPages() ;
        dbPages.signInButton.click();
        dbPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        dbPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        dbPages.loginPageSignInButton.click();
        dbPages.accountButton.click();
        dbPages.dashBoard.click();
        dbPages.petsAdsenseButton.click();
        dbPages.createPetAdSenseButton.click();

        dbPages.addForumLocationButtons.click();
        dbPages.addForumFieldBox.sendKeys("Header"+Keys.ENTER);

        dbPages.addForumPetTitle.sendKeys("lililili");

        dbPages.addForumDisplayName.sendKeys("KEDİLERİ SEVERİZ");
        dbPages.addForumRadioButton.click();

        dbPages.addForumTypeButton.click();

        dbPages.addForumTypeBox.sendKeys("Code" +Keys.ENTER);

        dbPages.addForumImageButton.click();

        ReusableMethods.bekle(1);
        ReusableMethods.scrollToBottom();



        dbPages.addForumImageUrlBox.sendKeys("https://images.app.goo.gl/CkTiMnWUD13iv4ew8");

        dbPages.addForumAdSenseButton.click();

        ReusableMethods.scrollToBottom();

       dbPages.addForumTextBox.sendKeys("DJHUIOJHJOI");

       ReusableMethods.scrollToBottom();
       ReusableMethods.bekle(1);


        dbPages.addForumSaveButton.click();

        ReusableMethods.bekle(2);

        dbPages.dashBoard.click();
        dbPages.petsAdsenseButton.click();

        dbPages.subPetAdsenseButton.click();
        ReusableMethods.bekle(1);


        dbPages.addSenseDeleteButton.click();

    }

}

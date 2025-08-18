package User_Test;

import Pages.DBPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import utilities.*;

public class US_040_hkrs2 {
    DBPages dbPages = new DBPages() ;
    //Bir yönetici olarak,
    // yeni bir aşı ekleyebilmeli ve
    // bu aşıyı mevcut aşılar listesine kaydedebilmeliyim.

    @Test
    public void TC_01(){
        // 1 loyalfiendcare.com ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        // sighUp buttona tıkla
        dbPages.signInButton.click();

        // login sayfasına geçerli mail ve password gir.
        dbPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        dbPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        dbPages.loginPageSignInButton.click();

        // account buttona tıklayarak admin sayfasına ulaş
        dbPages.accountButton.click();

        // dashboard sekmesine tıkla
        dbPages.dashBoard.click();

        // dashboardan vaccination buttonu tıkla
        dbPages.vaccinationsButton.click();

        // addVaccinationsButton a tıkla
        WebElement addVaccinationsButtons = Driver.getDriver().findElement(By.xpath("//*[@class='btn btn-tag btn-success btn-tag-rounded']"));
        addVaccinationsButtons.click();



        // petsTitleBox A başlık ekle
        System.out.println("petsTitleBox   locaters");
        WebElement petsTitleBox = Driver.getDriver().findElement(By.xpath("(//input[@id='Title_en'])"));
        XPathGenerator.printXpathFormulas(petsTitleBox);
        petsTitleBox.sendKeys("cats");
        System.out.println("<--=======================-->");



        // pets content box içerik gir
        System.out.println("petsContentBox");
        WebElement petsContentBox = Driver.getDriver().findElement(By.xpath("//input[@id='body_en']"));
        XPathGenerator.printXpathFormulas(petsContentBox);
        petsContentBox.sendKeys("kediler için özenle üretildi ");
        System.out.println("<--=======petsContentBox================-->");



        // petPriceBox geçerli bir değer gir
        System.out.println("petpriceBox");
        WebElement petPriceBox = Driver.getDriver().findElement(By.xpath("//input[@id='price']")) ;
        petPriceBox.sendKeys("800");
        XPathGenerator.printXpathFormulas(petPriceBox);



        // saveButtona basarak ilacı yayınlayın
        System.out.println("saveButton");
        WebElement saveButton = Driver.getDriver().findElement(By.xpath("//*[@type='submit']")) ;
        saveButton.click();



        // aşınız eklendi yazsısının text i al
        WebElement vaccinationsAddFlashText = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));
        System.out.println(vaccinationsAddFlashText.getText());

        // saayfayı aşağıya kaydır
        ReusableMethods.scrollToBottom();

        // delete buttona tıklayarak ekleme yapın
        WebElement vaccinationDeleteButton = Driver.getDriver().findElement(By.xpath("//*[@class='displayinline-block']"));
        vaccinationDeleteButton.click();

        // aşı silindi yazısını alın "Pets deleted successfully"
        WebElement vaccinationsDeleteFlashText = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-danger']")) ;
        System.out.println(vaccinationsDeleteFlashText.getText());


    }
    @Test
    public void sadeceVarOlanasiyiSilme(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        dbPages.signInButton.click();
        dbPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        dbPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        dbPages.loginPageSignInButton.click();
        dbPages.accountButton.click();

        dbPages.dashBoard.click();
        dbPages.vaccinationsButton.click();
        ReusableMethods.scrollToBottom();
        dbPages.deleteVaccinationsButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.scrollToBottom();
        dbPages.deleteVaccinationsButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.scrollToBottom();
        dbPages.deleteVaccinationsButton.click();

        ReusableMethods.bekle(1);
















    }
}

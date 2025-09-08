package User_Test;

import Pages.AdminPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.*;

public class US_040_hkrs2 {
    AdminPages adminPages = new AdminPages() ;
    //Bir yönetici olarak,
    // yeni bir aşı ekleyebilmeli ve
    // bu aşıyı mevcut aşılar listesine kaydedebilmeliyim.

    @Test
    public void TC_01(){
        // 1 loyalfiendcare.com ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        // sighUp buttona tıkla
        adminPages.signInButton.click();

        // login sayfasına geçerli mail ve password gir.
        adminPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        adminPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminPages.loginPageSignInButton.click();

        // account buttona tıklayarak admin sayfasına ulaş
        adminPages.accountButton.click();

        // dashboard sekmesine tıkla
        adminPages.dashBoard.click();

        // dashboardan vaccination buttonu tıkla
        adminPages.vaccinationsButton.click();

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

        adminPages.signInButton.click();
        adminPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        adminPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminPages.loginPageSignInButton.click();
        adminPages.accountButton.click();

        adminPages.dashBoard.click();
        adminPages.vaccinationsButton.click();
        ReusableMethods.scrollToBottom();
        adminPages.deleteVaccinationsButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.scrollToBottom();
        adminPages.deleteVaccinationsButton.click();
        ReusableMethods.bekle(1);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.scrollToBottom();
        adminPages.deleteVaccinationsButton.click();

        ReusableMethods.bekle(1);
















    }
}

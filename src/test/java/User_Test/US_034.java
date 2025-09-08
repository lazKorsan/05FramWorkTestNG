package User_Test;

import Pages.AdminPages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.*;

public class US_034 {
    //Bir yönetici olarak,
    // yeni bir ilaç oluşturabilmeli
    // ve bu kaydı ilaçlar listesine ekleyebilmeliyim.
    AdminPages adminPages = new AdminPages() ;
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


   @Test
   public void TC_01(){
        // MEDİCİNES EKLEME

       // 1 ANASAYFA accountButton görünür haldedir

       // Admin sayfasına gidin
       adminPages.accountButton.click();

       // 2 ilaç oluşturma sayfasına gidin
       adminPages.dashBoard.click();
       adminPages.medicinesButton.click();
       adminPages.createMedicinesButtons.click();



       WebElement medicineTitleBox = Driver.getDriver().findElement(By.xpath("//input[@placeholder='ex: Medicines']"));
       medicineTitleBox.sendKeys("Alpinia officinarum");

       WebElement medicineContentBox = Driver.getDriver().findElement(By.xpath("//input[@placeholder='ex:Content Medicines']"));
       medicineContentBox.sendKeys("Gliserin, Potasyum Sorbat, Sodyum Benzoat");





       WebElement fileInput = Driver.getDriver().findElement(By.xpath("//input[@type='file']"));
       ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].style.display='block';", fileInput);
       fileInput.sendKeys("C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\uploadImage.png");
       ReusableMethods.bekle(1);
      // upLoadFilesButton.sendKeys(filePath);
       adminPages.saveButton.click();  // saatır 64
       ReusableMethods.bekle(2);

       WebElement webtabloElementi = Driver.getDriver().findElement(By.xpath("//*[@id=\"tableWithSearch_wrapper\"]"));
       TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(webtabloElementi,"weblelemet") ;
       XPathGenerator.printXpathFormulas(webtabloElementi);

       // 3 oluşturulan ilacı kontrol edin
       // "(//td[@class='v-align-middle semi-bold'])"

       ReusableMethods.bekle(1);




       // ÖRNEK 2: Tüm satırda arama yap (sütun belirtme)
       ReusableMethods.verifyTextInTable(
               Driver.getDriver(),
               "https://qa.loyalfriendcare.com/en/Dashboard/Instagrams",
               "//*[@id=\"tableWithSearch\"]/tbody/tr[1]", // Daha spesifik bir tablo locator'ü
               "Rimadyl Carprofen"
               // columnIndex vermiyoruz, tüm satırda arar
       );

       // ÖRNEK 3: Mevcut sayfada arama yap (URL verme)
       ReusableMethods.verifyTextInTable(
               Driver.getDriver(),
               null, // URL verme, mevcut sayfada kal
               "//*[@id=\"tableWithSearch\"]/tbody/tr[1]",
               "Rimadyl Carprofen",
               1
       );

       // ÖRNEK 1: Belirli bir sütunda arama yap (3. sütunda - index 2)
       ReusableMethods.verifyTextInTable(
               Driver.getDriver(),
               "https://qa.loyalfriendcare.com/en/Dashboard/Instagrams",
               "//table[@class='table table-hover demo-table-search table-responsive-block dataTable no-footer']", // Tüm satırları veren XPath
               "Rimadyl Carprofen",
               1 // 2. sütunda ara (0'dan başlar)
       );

    }

    @Test
    public void hkrs3(){
        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/Dashboard/Instagrams");

        WebElement webtablo = Driver.getDriver().findElement(By.xpath("//table[@id='tableWithSearch']"));
        //XPathGenerator.printXpathFormulas(webtablo);
        //TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(webtablo,"webtablo");

        ReusableMethods.printProductsInCategory(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/Dashboard/Instagrams",
                "//table[@id='tableWithSearch']"
        );

        System.out.println("zingers");

        ReusableMethods.verifyTextInTable(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/Dashboard/Instagrams",
                "//tr[@class='odd']",
                "Rimadyl (Carprofen)",
                2

        );

    }
}

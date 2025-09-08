package User_Test;

import Pages.AdminPages;
import Pages.HeaderPages;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class US_018  extends TestBaseRapor {
    HeaderPages headerPages = new HeaderPages();
    AdminPages adminPages = new AdminPages() ;
     //Bir kayıtlı kullanıcı olarak,
     // Home Page sayfasından İlaçlar sayfasına erişebilmeli,
     // İlaçlar sayfasındaki ilaç bilgilerini inceleyebilmeli
     // ve seçtiğim ilacın sayfasına erişerek
     // o ilaç için randevu talebi oluşturabilmeliyim

    @BeforeClass
    public void setUp(){
        // Gerekli ayarlar yapılır
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        // Kullanıcı girişi yapar.
        headerPages.signInButton.click();
        headerPages.mailBox.sendKeys(ConfigReader.getProperty("userMail"));
        headerPages.passwordBox.sendKeys(ConfigReader.getProperty("userPassword"));
        headerPages.loginPageSigInButton.click();
        ReusableMethods.bekle(3);
    }
    @Test
    public void TC_01(){
        // ilaç randevusu alma testi

        extentTest = extentReports.createTest("İlaç Randevu Sistemi Testi ",
                "Kullanıcı İlaç Randevu Sistemini Test eder");
        SoftAssert softAssert = new SoftAssert();


        // Kullanıcı giriş  yaptığını doğrular
        String expectedAccountButtonText = "Ahmet";
        String actualAccountButtonText = headerPages.accountButton.getText() ;
        Assert.assertTrue(actualAccountButtonText.equals(expectedAccountButtonText),
                "Kullanıcı giriş yapamadı");
        extentTest.pass("Kullanıcı oturumu başarı ile oluşturuldu");

        // Mededicine sayfasına gider
        headerPages.medicinesButton.click();

        // medicines sayfasının URL uzantısını test eder
        String expectedUrl = "medicines";
        expectedUrl =expectedUrl.toLowerCase() ;
        String actualUrl = Driver.getDriver().getCurrentUrl().toLowerCase();
        Assert.assertTrue(actualUrl.contains(expectedUrl),
                "Medicines sayfasının Url Uzantısı: "+expectedUrl+"değil");
        extentTest.pass("Medicines sayfasının Url  uzantısı "+expectedUrl+ " dir");


        // Medicine sayfasında ilaçları listeler
        ReusableMethods.printProductsInCategory(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/Medicines",
                "//div[@class='wrapper']"
        );

        // Kullanıcı ilaçlar listesinden seçim yapar
        headerPages.rimadylButton.click();
        ReusableMethods.bekle(3);
        extentTest.info("Kullanıcı ilaç listesinden seçimini yaptı") ;
       // method kol
        LocalDate futureDate = LocalDate.now().plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String targetDate = futureDate.format(formatter); // methodkol

        // 4 Kullanıcı randevu defterini doldurur
        Faker  faker = new Faker(); // method kol
        Actions actions = new Actions(Driver.getDriver()); // method kol
        headerPages.dateButton.click();
        actions.sendKeys(targetDate)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .perform();

        ReusableMethods.bekle(2);
        headerPages.messageBox.sendKeys(faker.lorem().characters(17));
       extentTest.info("Kullanıcı randevu defterini doldurdu");

       // 5 Kullanıcı Randevuyu kayt eder
        headerPages.appoinmentBookingButton.click();
        extentTest.info("Kayıtlı kullanıcı randevusunu oluşturdu") ;

        extentTest.pass("Randevu başarı ile oluşturuldu") ;









    }





    }



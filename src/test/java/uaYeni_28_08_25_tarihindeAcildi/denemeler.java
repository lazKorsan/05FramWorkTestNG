package uaYeni_28_08_25_tarihindeAcildi;

import Pages.AdminPages;
import Pages.HeaderPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.*;

public class denemeler   {
    AdminPages adminPages = new AdminPages();
    HeaderPages headerPages = new HeaderPages();
    SoftAssert softAssert = new SoftAssert();
    String expectedUrl = null;
    String actualContainerText = null;
    String expectedUrlContainerText = null;
    String expectedDepartmentDetailText;
    String actualDepartmentsDetailText;

    String actualUrl = Driver.getDriver().getCurrentUrl().toLowerCase();


    @BeforeClass
    public void setUp() {

        // kullanıcı ana sayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        // signInButtona basarak Login sayfasına yönlenir
        adminPages.signInButton.click();

        // Login sayfasında mail adresini girer
        adminPages.mailBox.sendKeys(ConfigReader.getProperty("adm"));

        // login sayfasında şifresini girer
        adminPages.passwordBox.sendKeys(ConfigReader.getProperty("usp"));

        // Login sayfasında giriş tuşuna basar
        adminPages.loginPageSignInButton.click();

        // Kullanıcı ana sayfaya yönlendirilir

    }


    @Test
    public void Test01() {

        // kullanıcı account butonu üzerindeki kayıtlı ismi kayt eder
        String actualAcoountName = headerPages.accountButton.getText();
        headerPages.accountButton.getText();

        // Kullanıcı beklenen ismi kayt eder.
        String expectedAcoountName = ConfigReader.getProperty("adn") + "ş";

        //isim karşılatırmasını raporlar
        Assert.assertTrue(actualAcoountName.equals(expectedAcoountName),
                "giriş yapılan kullanıcı ismi beklenenle uyuşmuyor");

    }

    @Test
    public void Test02() {


        // kullanıcı medicine syafasına gidebilmeli
        headerPages.medicinesButton.click();


        // KK  Url beklenen Url  uzantısını kayt eder
        expectedUrl = "medicines";


        // KK medicines sayfası url uzantısını Driver dan alır
        actualUrl = Driver.getDriver().getCurrentUrl().toLowerCase();


        // KK beklenen Url İle gerçekleşen Url karşılaştırır
        Assert.assertTrue(actualUrl.contains(expectedUrl), "Url uzantısı uyuşmuyor");


        //KK medicines sayfasında bulunan container bölümünden sayfanın adı kay eder
        actualContainerText = headerPages.statusBar.getText().toLowerCase();


        // KK beklenen sayfa uzantısını kayt eder
        expectedUrlContainerText = "medicines";


        // beklenen isimle Driverdan alınan ismi karşılaştırır
        Assert.assertTrue(actualContainerText.equals(expectedUrlContainerText),
                "Beklenen isim ile gerçekleşen isim aynı değil");


        // KK kullanıcı anasayfaya döner
        Driver.getDriver().navigate().back();


    }

    @Test
    public void TC_03() { // VACCİNATİONS URL,CONTAİNER TESTİ


        //KK vaccinations sayfasına gider
        headerPages.vaccinationsButton.click();

        // KK beklene sayfa uzantısını kayt eder
        expectedUrl = "Vaccinations";
        actualUrl = Driver.getDriver().getCurrentUrl().toLowerCase();
        softAssert.assertTrue(
                actualUrl.contains("vaccinations"),
                "'Vaccinations' segmenti eksik"
        );


        actualContainerText = headerPages.statusBar.getText();
        expectedUrlContainerText = "Vaccinations";

        Assert.assertTrue(actualContainerText.contains(expectedUrlContainerText));

        softAssert.assertAll();

        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(3);
    }

    @Test
    public void TC_05() {//DOCTORS  PAGES URL VE STATUS BAR TESTİ

        headerPages.doctorsButton.click();

        actualUrl = Driver.getDriver().getCurrentUrl().toLowerCase();
        expectedUrl = "doctors";
        Assert.assertTrue(actualUrl.contains(expectedUrl),
                "Urller aynı değil");

        actualContainerText = headerPages.statusBar.getText();
        expectedUrlContainerText = "Doctors";
        Assert.assertTrue(actualContainerText.equals(expectedUrlContainerText),
                "sayfa ismi beklenenle aynı değil");

        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(3);

    }

    @Test
    public void TC_06() { // DEPARTMENTS PAGE URL VE STATUSBAR TESTİ

        headerPages.departmentsButton.click();

        actualUrl = Driver.getDriver().getCurrentUrl().toLowerCase();
        expectedUrl = "departments";
        Assert.assertTrue(actualUrl.contains(expectedUrl),
                "url uzantısı beklenenle aynı değil ");

        actualContainerText = headerPages.statusBar.getText();
        expectedUrlContainerText = "Departments";
        Assert.assertTrue(actualContainerText.equals(expectedUrlContainerText),
                "sayfa adı beklenenle aynı değil ");


        softAssert.assertAll();

        Driver.getDriver().navigate().back();

    }

    @Test
    public void Test_07() {

        headerPages.aboutUsButton.click();

        expectedUrl = "about";
        actualUrl = Driver.getDriver().getCurrentUrl().toLowerCase();
        Assert.assertTrue(actualUrl.contains(expectedUrl));


        expectedUrlContainerText = "About us";
        actualContainerText = headerPages.statusBar.getText();
        Assert.assertTrue(actualContainerText.contains(expectedUrl));

        Driver.getDriver().navigate().back();

    }

    @Test
    public void TC_08() {

        headerPages.homeButton.click();

        expectedUrl = "";
        actualUrl = Driver.getDriver().getCurrentUrl().toLowerCase();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        expectedUrlContainerText = "Home";
        actualContainerText = Driver.getDriver().getCurrentUrl().toLowerCase();
        Assert.assertTrue(actualContainerText.equals(expectedUrlContainerText));
    }

    @Test
    public void TC_09() {
        headerPages.logoButton.click();
        expectedUrl = "";
        actualUrl = Driver.getDriver().getCurrentUrl().toLowerCase();
        Assert.assertTrue(actualUrl.contains(expectedUrl));


    }

    @Test
    public void TC_10() {// İLAÇ kAPSÜLÜNÜN YANINDAKİ YAZIYI ALMA

        // KK departments bölümüne gider
        headerPages.departmentsButton.click();

        // KK wellnes sekmesine tıklar
        headerPages.wellnessButton.click();

        // KK detail WebElement içindeki yazıyı alır
        // aşağıdaki satırda yapılan işlemler sadece
        // ilaç kapsülünün içindeki yazıyı almak için
        // < -- ===vvv=== İlaç kapsülündeki yazıyı al ===vvv=== -- >
        WebElement icon = Driver.getDriver().findElement(By.xpath("//*[@id=\"description\"]/h1/i"));
        WebElement parent = icon.findElement(By.xpath("./parent::*")); // Doğrudan üst elementi al
        String fullText = parent.getText().trim();
        String iconText = icon.getText().trim();
        String targetText = fullText.replace(iconText, "").trim();
        System.out.println(targetText);
        // < -- ===^^^^=== İlaç kapsülündeki yazı alındı ===^^^^=== -- >
        String actualDepartmentsDetailText = targetText;
        String expectedDepartmentDetailText = "Wellness";

        Assert.assertTrue(actualDepartmentsDetailText.equals(expectedDepartmentDetailText));
        Driver.getDriver().navigate().back();
    }

    @Test
    public void TC_11() {

        headerPages.dentalCareButton.click();

        WebElement icon = Driver.getDriver().findElement(By.xpath("//*[@id=\"description\"]/h1/i"));
        WebElement parent = icon.findElement(By.xpath("./parent::*")); // Doğrudan üst elementi al
        String fullText = parent.getText().trim();
        String iconText = icon.getText().trim();
        String targetText = fullText.replace(iconText, "").trim();
        System.out.println(targetText);
        // < -- ===^^^^=== İlaç kapsülündeki yazı alındı ===^^^^=== -- >
        String actualDepartmentsDetailText = targetText;
        String expectedDepartmentDetailText = "Dental Care";
        Assert.assertTrue(actualDepartmentsDetailText.equals(expectedDepartmentDetailText));

        Driver.getDriver().navigate().back();

    }

    @Test
    public void TC_12() {
        headerPages.anaesthesiaButton.click();

        WebElement icon = Driver.getDriver().findElement(By.xpath("//*[@id=\"description\"]/h1/i"));
        WebElement parent = icon.findElement(By.xpath("./parent::*")); // Doğrudan üst elementi al
        String fullText = parent.getText().trim();
        String iconText = icon.getText().trim();
        String targetText = fullText.replace(iconText, "").trim();
        System.out.println(targetText);
        // < -- ===^^^^=== İlaç kapsülündeki yazı alındı ===^^^^=== -- >
        String actualDepartmentsDetailText = targetText;
        String expectedDepartmentDetailText = "Anaesthesia";
        Assert.assertTrue(actualDepartmentsDetailText.equals(expectedDepartmentDetailText));

        Driver.getDriver().navigate().back();


    }

    @Test
    public void TC_13() {// ilaç kapsül iconunun yanındaki yazı
        headerPages.dermatologyButton.click();
        WebElement icon = Driver.getDriver().findElement(By.xpath("//*[@id=\"description\"]/h1/i"));
        WebElement parent = icon.findElement(By.xpath("./parent::*")); // Doğrudan üst elementi al
        String fullText = parent.getText().trim();
        String iconText = icon.getText().trim();
        String targetText = fullText.replace(iconText, "").trim();
        System.out.println(targetText);
        // < -- ===^^^^=== İlaç kapsülündeki yazı alındı ===^^^^=== -- >
        String actualDepartmentsDetailText = targetText;
        String expectedDepartmentDetailText = "Dermatology";
        Assert.assertTrue(actualDepartmentsDetailText.equals(expectedDepartmentDetailText));

        Driver.getDriver().navigate().back();

    }

    @Test
    public void TC_14() {// ilaç kapsül iconunun yanındaki yazı
        headerPages.diagnosticsButton.click();
        WebElement icon = Driver.getDriver().findElement(By.xpath("//*[@id=\"description\"]/h1/i"));
        WebElement parent = icon.findElement(By.xpath("./parent::*")); // Doğrudan üst elementi al
        String fullText = parent.getText().trim();
        String iconText = icon.getText().trim();
        String targetText = fullText.replace(iconText, "").trim();
        System.out.println(targetText);
        // < -- ===^^^^=== İlaç kapsülündeki yazı alındı ===^^^^=== -- >
        String actualDepartmentsDetailText = targetText;
        String expectedDepartmentDetailText = "Diagnostics";
        Assert.assertTrue(actualDepartmentsDetailText.equals(expectedDepartmentDetailText));
        headerPages.homeButton.click();
        //Driver.getDriver().navigate().back();
        ReusableMethods.bekle(5);

    }

    @Test
    public void TC_15() {// Rimadyl (Carprofen) ilaç kapsül iconunun yanındaki yazı

     headerPages.medicinesButton.click();
     headerPages.rimadylButton.click();
        WebElement icon = Driver.getDriver().findElement(By.xpath("//*[@id=\"description\"]/h1/i"));
        WebElement parent = icon.findElement(By.xpath("./parent::*")); // Doğrudan üst elementi al
        String fullText = parent.getText().trim();
        String iconText = icon.getText().trim();
        String targetText = fullText.replace(iconText, "").trim();
        System.out.println(targetText);
        // < -- ===^^^^=== İlaç kapsülündeki yazı alındı ===^^^^=== -- >
        String actualDepartmentsDetailText = targetText;
        String expectedDepartmentDetailText = "Rimadyl (Carprofen)";
        Assert.assertTrue(actualDepartmentsDetailText.equals(expectedDepartmentDetailText));
      Driver.getDriver().navigate().back();
      ReusableMethods.bekle(3);


    }

    @Test
    public void TC_16() {// Revolution (Selamectin) ilaç kapsül iconunun yanındaki yazı
     headerPages.revolutionButton.click();
        WebElement icon = Driver.getDriver().findElement(By.xpath("//*[@id=\"description\"]/h1/i"));
        WebElement parent = icon.findElement(By.xpath("./parent::*")); // Doğrudan üst elementi al
        String fullText = parent.getText().trim();
        String iconText = icon.getText().trim();
        String targetText = fullText.replace(iconText, "").trim();
        System.out.println(targetText);
        // < -- ===^^^^=== İlaç kapsülündeki yazı alındı ===^^^^=== -- >
        String actualDepartmentsDetailText = targetText;
        String expectedDepartmentDetailText = "Revolution (Selamectin))";
        Assert.assertTrue(actualDepartmentsDetailText.equals(expectedDepartmentDetailText));
        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(3);


    }

    @Test
    public void TC_17() {//  Baytril (Enrofloxacin) ilaç kapsül iconunun yanındaki yazı
        headerPages.baytrilButton.click();
        WebElement icon = Driver.getDriver().findElement(By.xpath("//*[@id=\"description\"]/h1/i"));
        WebElement parent = icon.findElement(By.xpath("./parent::*")); // Doğrudan üst elementi al
        String fullText = parent.getText().trim();
        String iconText = icon.getText().trim();
        String targetText = fullText.replace(iconText, "").trim();
        System.out.println(targetText);
        // < -- ===^^^^=== İlaç kapsülündeki yazı alındı ===^^^^=== -- >
        String actualDepartmentsDetailText = targetText;
        String expectedDepartmentDetailText = "Baytril (Enrofloxacin)";
        Assert.assertTrue(actualDepartmentsDetailText.equals(expectedDepartmentDetailText));
        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(3);






    }

    @Test
    public void TC_18(){ // Apoquel (Oclacitinib)
       headerPages.apoquelButton.click();
        WebElement icon = Driver.getDriver().findElement(By.xpath("//*[@id=\"description\"]/h1/i"));
        WebElement parent = icon.findElement(By.xpath("./parent::*")); // Doğrudan üst elementi al
        String fullText = parent.getText().trim();
        String iconText = icon.getText().trim();
        String targetText = fullText.replace(iconText, "").trim();
        System.out.println(targetText);
        // < -- ===^^^^=== İlaç kapsülündeki yazı alındı ===^^^^=== -- >
        String actualDepartmentsDetailText = targetText;
        String expectedDepartmentDetailText = "Apoquel (Oclacitinib)";
        Assert.assertTrue(actualDepartmentsDetailText.equals(expectedDepartmentDetailText));
        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(3);

    }


    @Test
    public void TC_19(){ // Apoquel (Oclacitinib)
        headerPages.apoquelButton.click();
        WebElement icon = Driver.getDriver().findElement(By.xpath("//*[@id=\"description\"]/h1/i"));
        WebElement parent = icon.findElement(By.xpath("./parent::*")); // Doğrudan üst elementi al
        String fullText = parent.getText().trim();
        String iconText = icon.getText().trim();
        String targetText = fullText.replace(iconText, "").trim();
        System.out.println(targetText);
        // < -- ===^^^^=== İlaç kapsülündeki yazı alındı ===^^^^=== -- >
        String actualDepartmentsDetailText = targetText;
        String expectedDepartmentDetailText = "Apoquel (Oclacitinib)";
        Assert.assertTrue(actualDepartmentsDetailText.equals(expectedDepartmentDetailText));
        Driver.getDriver().navigate().back();
        ReusableMethods.bekle(3);

    }



}
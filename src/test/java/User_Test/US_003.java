package User_Test;

import Pages.HeaderPages;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class US_003 extends TestBaseRapor {
    //Home Page sayfasinda Header bölümünde yer alan menü ögeleri
    // (Home,About Us,Deparments,vb) net olarak görünür olmali
    //Her menü ögesine tiklandiginda ilgili sayfaya ve url yönlendirme yapmali.
    //Her menü ögesine tiklandiginda acilan sayfada
    // menü ismi baslik olarak görünmeli

    @Test
    public void TC_01() {
        extentTest = extentReports.createTest("Header Butonlarının Görünürlük Testi",
                "Kullanici AnaSayfa Header Bölümünde Bulunan Butonları görebilmeli");
        SoftAssert softAssert = new SoftAssert();

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        HeaderPages loyalfriendcarePages = new HeaderPages();

        // 1 Header Bölümü Butonlarının Görünürlüğünü test eder.
        softAssert.assertTrue(loyalfriendcarePages.homeButton.isDisplayed(),
                "Görünürlük hatası: Home button görülmüyor");
        extentTest.pass("Home butonunun görünürlüğünü test eder");


        softAssert.assertTrue(loyalfriendcarePages.aboutUsButton.isDisplayed(),
                "Görünürlük hatası: About Us button görülmüyor");
        extentTest.pass("About Us butonunun görünürlüğünü test eder");


        softAssert.assertTrue(loyalfriendcarePages.departmentsButton.isDisplayed(),
                "Görünürlük hatası: Department  button görülmüyor");
        extentTest.pass("Department butonunun görünürlüğünü test eder");

        softAssert.assertTrue(loyalfriendcarePages.doctorsButton.isDisplayed(),
                "Görünürlük hatası: Doctors button görülmüyor");
        extentTest.pass("Doctors butonunun görünürlüğünü test eder");


        softAssert.assertTrue(loyalfriendcarePages.medicinesButton.isDisplayed(),
                "Görünürlük hatası: Medicines button görülmüyor");
        extentTest.pass("Medicines butonunun görünürlüğünü test eder");

        softAssert.assertTrue(loyalfriendcarePages.vaccinationsButton.isDisplayed(),
                "Görünürlük hatası: Vaccinations button görülmüyor");
        extentTest.pass("Vaccinations butonunun görünürlüğünü test eder");

        // 2 Header Bölümü butonlarının tıklanabilriliğini kontrol eder .
        // <--
        softAssert.assertTrue(loyalfriendcarePages.homeButton.isEnabled(),
                "Tıklanma hatası: Home button tıklanamayor");
        extentTest.pass("Home butonunun tıklanabilirliğini test eder");
        // <--
        softAssert.assertTrue(loyalfriendcarePages.aboutUsButton.isEnabled(),
                "Tıklanma hatası: About us button tıklanamayor");
        extentTest.pass("About us butonunun tıklanabilirliğini test eder");
        // <--
        softAssert.assertTrue(loyalfriendcarePages.departmentsButton.isEnabled(),
                "Tıklanma hatası: Departments button tıklanamayor");
        extentTest.pass("Departments butonunun tıklanabilirliğini test eder");
        // <--
        softAssert.assertTrue(loyalfriendcarePages.homeButton.isEnabled(),
                "Tıklanma hatası: Home button tıklanamayor");
        extentTest.pass("Home butonunun tıklanabilirliğini test eder");
        // <--
        softAssert.assertTrue(loyalfriendcarePages.doctorsButton.isEnabled(),
                "Tıklanma hatası: Doctors button tıklanamayor");
        extentTest.pass("Doctors butonunun tıklanabilirliğini test eder");
        // <--
        softAssert.assertTrue(loyalfriendcarePages.medicinesButton.isEnabled(),
                "Tıklanma hatası: Medicines button tıklanamayor");
        extentTest.pass("Medicines butonunun tıklanabilirliğini test eder");
        // <--
        softAssert.assertTrue(loyalfriendcarePages.vaccinationsButton.isEnabled(),
                "Tıklanma hatası: Vacinations button tıklanamayor");
        extentTest.pass("Vacinations butonunun tıklanabilirliğini test eder");

        softAssert.assertAll();
        Driver.quitDriver();

    }


   @Test
           public void TC_02(){
       extentTest = extentReports.createTest("Header Butonlarının Tıklama ve Başlık Testleri",
               "Kullanici AnaSayfa Header Bölümünde Bulunan Butonlara Basa bilmeli ve ilgili sayfaya gidebilmeli ");

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        HeaderPages headerPages = new HeaderPages() ;
       SoftAssert softAssert = new SoftAssert();
        // 3 Header Menusundeki butonlar ilgili sayfaya gitmeli
        // sayfa uzantısı Buton ismi ile aynı olalıdır
        // <--
        headerPages.homeButton.click();
        ReusableMethods.getWebElementScreenshot(headerPages.homeButton,"homeButton");
        extentTest.info("Home butonuna tıklar ") ;
        String expectedUrl = "https://qa.loyalfriendcare.com/en" ;
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Beklenen Url farklı");
        extentTest.pass("Home butonuna basıldığında Url değişmediğini test eder") ;
        //String expectedTitle = "Home";
        //String actualTitle = lfcPages.titleContainer.getText() ;
        //softAssert.assertEquals(actualTitle,expectedTitle,"Beklenen Başlık ile Sayfa Başlığı aynı değil");
        //extentTest.pass(expectedTitle +"ile" +actualTitle +"test eder") ;

        // <--
        headerPages.aboutUsButton.click();
        ReusableMethods.getWebElementScreenshot(headerPages.aboutUsButton,"aboutUsButton");
        extentTest.info("About Us Butonuna tıklar ") ;
        String expectedUrlIcerik = "about" ;
        String actualUrlIcerik = Driver.getDriver().getCurrentUrl() ;
        softAssert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik),
                "Sayfa Url :"+ actualUrlIcerik);
        extentTest.pass("About Us butona basıldığında açılan sayfa Url test eder") ;
        String expectedTitle = "About Us";
        String actualTitle = headerPages.titleContainer.getText().trim() ;
        softAssert.assertEquals(actualTitle,expectedTitle,"Beklenen Başlık Saya Başlığı ile uyumlu değil ");
        extentTest.pass(expectedTitle +"ile" +actualTitle +"test eder") ;


        // < --
        Driver.getDriver().navigate().back();
        headerPages.departmentsButton.click();
        ReusableMethods.takeFullPageScreenshot("departmentsButton");
        extentTest.info("About Us Butonuna tıklar ") ;
        expectedUrlIcerik = "Departments" ;
        actualUrlIcerik = Driver.getDriver().getCurrentUrl() ;
        softAssert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik),
                "Sayfa Url :"+ actualUrlIcerik);
        extentTest.pass("Departments Butona basarak açılan sayfanın Url uzantısını test eder") ;
        expectedTitle = "Departments";
        actualTitle = headerPages.titleContainer.getText() ;
        softAssert.assertEquals(actualTitle,expectedTitle,"Beklenen Başlık Saya Başlığı ile uyumlu değil");
        extentTest.pass(expectedTitle +"ile" +actualTitle +"test eder") ;

        // < --
        Driver.getDriver().navigate().back();
        headerPages.doctorsButton.click();
        ReusableMethods.takeFullPageScreenshot("doctorsButton");
        extentTest.info("Doctors  Butonuna tıklar ") ;
        expectedUrlIcerik = "Doctors" ;
        actualUrlIcerik = Driver.getDriver().getCurrentUrl() ;
        softAssert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik),
                "Sayfa Url :"+ actualUrlIcerik);
        extentTest.pass("Doctors Butona basarak açılan sayfanın Url uzantısını test eder") ;
        expectedTitle = "Doctors";
        actualTitle = headerPages.titleContainer.getText() ;
        softAssert.assertEquals(actualTitle,expectedTitle,"Beklenen Başlık Saya Başlığı ile uyumlu değil");
        extentTest.pass(expectedTitle +"ile" +actualTitle +"test eder") ;

        // <--
        Driver.getDriver().navigate().back();
        headerPages.medicinesButton.click();
        ReusableMethods.takeFullPageScreenshot("medicinesButton");
        extentTest.info("Medicines  Butonuna tıklar ") ;
        expectedUrlIcerik = "Medicines" ;
        actualUrlIcerik = Driver.getDriver().getCurrentUrl() ;
        softAssert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik),
                "Sayfa Url :"+ actualUrlIcerik);
        extentTest.pass("Medicines Butona basarak açılan sayfanın Url uzantısını test eder") ;
        expectedTitle = "Medicines";
       actualTitle = headerPages.titleContainer.getText() ;
       softAssert.assertEquals(actualTitle,expectedTitle,"Beklenen Başlık Saya Başlığı ile uyumlu değil");
        extentTest.pass(expectedTitle +"ile" +actualTitle +"test eder") ;

        // <--
        Driver.getDriver().navigate().back();
        headerPages.vaccinationsButton.click();
        ReusableMethods.takeFullPageScreenshot("vaccinationsButton");
        extentTest.info("Vaccinations Butonuna tıklar ") ;
        expectedUrlIcerik = "Vaccinations" ;
        actualUrlIcerik = Driver.getDriver().getCurrentUrl() ;
        softAssert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik),
                "Sayfa Url :"+ actualUrlIcerik);
        extentTest.pass("Vaccinations Butona basarak açılan sayfanın Url uzantısını test eder") ;
        expectedTitle = "Vaccinations";
       actualTitle = headerPages.titleContainer.getText() ;
        softAssert.assertEquals(actualTitle,expectedTitle,"Beklenen Başlık Saya Başlığı ile uyumlu değil");
        extentTest.pass(expectedTitle +"ile" +actualTitle +"test eder") ;

        // <--
        headerPages.homeButton.click();
        extentTest.info("Home butonuna basarak ana sayfaya döner ");


        softAssert.assertAll();
        Driver.quitDriver();

    }



}

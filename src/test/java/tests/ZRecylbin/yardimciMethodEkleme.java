/*

 */
        package tests.ZRecylbin;

import org.testng.annotations.*;
import utilities.TestBaseRapor;

public class yardimciMethodEkleme extends TestBaseRapor {

    @Test
    public void tc() {

    }
}

    /*


    private WebDriver driver;
    private DBPages dbPages;
    private LFCPages lfcPages;
    private ExtentTest extentTest;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        new DBPages();
        LFCPages LFCPages = new LFCPages();
        driver.get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

    @Test
    public void TC_01_Logo_Islevsellik_Testi() {
        extentTest = extentReports.createTest("TC_01 Logo İşlevsellik Testi",
                "Logo tıklamada URL değişimi ve görünürlük kontrolleri");

        try {
            // 1. Logo görünürlük ve etkinlik kontrolleri
            performBasicElementChecks(headerPages.logoButton, "Logo", extentTest);

            // 2. URL değişim kontrolü
            String expectedUrl = ConfigReader.getProperty("url");
            headerPages.logoButton.click();
            assertUrlEquals(expectedUrl, "Logo tıklandıktan sonra URL", extentTest);

            // 3. Alt metin kontrolü
            String expectedAltText = "LoyalFriendCare";
            String actualAltText = headerPages.logoButton.getAttribute("alt");
            assertTextEquals(actualAltText, expectedAltText, "Logo alt metni", extentTest);

        } catch (Exception e) {
            extentTest.log(Status.FAIL, "Test sırasında beklenmeyen hata: " + e.getMessage());
            Assert.fail("Test hatası: " + e.getMessage());
        }
    }

    @Test
    public void TC_02_SignIn_Islevsellik_Testi() {
        extentTest = extentReports.createTest("TC_02 SignIn İşlevsellik Testi",
                "SignIn butonu login sayfası yönlendirme testi");

        try {
            // 1. Buton temel kontroller
            performBasicElementChecks(adminPages.signInButton, "Sign In", extentTest);

            // 2. Sayfa yönlendirme kontrolü
            adminPages.signInButton.click();
            assertUrlContains("login", "SignIn tıklandıktan sonra URL", extentTest);

        } catch (Exception e) {
            handleTestFailure(e, extentTest);
        }
    }

    @Test
    public void TC_03_SignUp_Islevsellik_Testi() {
        extentTest = extentReports.createTest("TC_03 SignUp İşlevsellik Testi",
                "SignUp butonu register sayfası yönlendirme testi");

        try {
            // 1. Buton temel kontroller
            performBasicElementChecks(adminPages.signUpButton, "Sign Up", extentTest);

            // 2. Sayfa yönlendirme kontrolü
            adminPages.signUpButton.click();
            assertUrlContains("register", "SignUp tıklandıktan sonra URL", extentTest);

        } catch (Exception e) {
            handleTestFailure(e, extentTest);
        }
    }

    // ----------- Yardımcı Metotlar -----------
    private void performBasicElementChecks(WebElement element, String elementName, ExtentTest test) {
        Assert.assertTrue(element.isDisplayed(), elementName + " görünür değil");
        test.log(Status.PASS, elementName + " görünürlüğü doğrulandı");

        Assert.assertTrue(element.isEnabled(), elementName + " etkin değil");
        test.log(Status.PASS, elementName + " etkinliği doğrulandı");
    }

    private void assertUrlEquals(String expectedUrl, String description, ExtentTest test) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, description + " uyuşmuyor");
        test.log(Status.PASS, description + " başarıyla doğrulandı");
    }

    private void assertUrlContains(String expectedText, String description, ExtentTest test) {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedText), description + " beklenen metni içermiyor");
        test.log(Status.PASS, description + " doğrulandı: " + expectedText);
    }

    private void assertTextEquals(String actual, String expected, String elementName, ExtentTest test) {
        Assert.assertEquals(actual, expected, elementName + " metin uyuşmazlığı");
        test.log(Status.PASS, elementName + " metni doğrulandı: " + expected);
    }

    private void handleTestFailure(Exception e, ExtentTest test) {
        test.log(Status.FAIL, "Test hatası: " + e.getMessage());
        Assert.fail("Test hatası: " + e.getMessage());
    }
}

     */

package User_Test;

import Pages.HeaderPages;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_006 extends TestBaseRapor {
    //Bir ziyaretçi olarak,
    // Home page sayfasının footer bölümündeki
    // tüm textlerin okunabilir olduğunu
    // ve butonların/linklerin aktif çalıştığını görmek istiyorum.
    HeaderPages headerPages;


    @DataProvider
    public static Object[][] buttonProvider() {
        return new Object[][]{
                {"footerLogoButtons", "footerLogoButtons", "loyalfriendcare"},
                {"footerWellnesButton", "footerWellnesButton", "wellness"},
                {"footerWellnesButton", "footerWellnesButton", "wellness"},
                {"footerDentalCareButton", "footerDentalCareButton", "dental-care"},
                {"footerAnaesthesiaButton", "footerAnaesthesiaButton", "anaesthesia"},
                {"footerDermatologyButton", "footerDermatologyButton", "dermatology"},
                {"footerDiagnosticsButton", "footerDiagnosticsButton", "diagnostics"},
                {"footerFacebookButton", "footerFacebookButton", "facebook"},
                {"footerYoutubeButton", "footerYoutubeButton", "youtube"},
                {"footerPinterestButton", "footerPinterestButton", "pinterest"},
                {"footerInstagramButton", "footerInstagramButton", "instagram"},

        };
    }

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        headerPages = new HeaderPages();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

    @Test (dataProvider = "buttonProvider")
    public void TC_01  (String buttonField, String buttonName, String expectedUrlPart){
        WebElement element = getButtonElement(buttonField);
        ReusableMethods.scrollToBottom();
        extentTest = extentReports.createTest("Footer Bölümü Logo Testi",
                "Kullanici AnaSayfa footer Bölümünde "+buttonName  + "görünürlüğünü,tıklanabilirliğini ve doğru sayfaya gittiğini Kontrol edebilmelidir");

        Assert.assertTrue(element.isDisplayed(),buttonName +" görünür değil");
        extentTest.pass(buttonName +" görünür") ;
        Assert.assertTrue(element.isEnabled(),buttonName+ " tıklanabilir değil");
        extentTest.pass(buttonName +"tıklanabilir");
        element.click();
        extentTest.info(buttonName +"tıklar") ;
        String actualUrlFull = Driver.getDriver().getCurrentUrl() ;
        extentTest.info(actualUrlFull.replaceAll("([&=])[^&]+", "$1***" +"kaydeder")) ;
        Assert.assertTrue(actualUrlFull.contains(expectedUrlPart));
        extentTest.pass("Başarılı URL doğrulama: '" + expectedUrlPart + "' uzantısı tespit edildi");



    }




    private WebElement getButtonElement(String fieldName) {
        switch (fieldName) {
            case "footerLogoButtons":
                return headerPages.footerLogoButtons;
            case "footerWellnesButton":
                return headerPages.footerWellnesButton;
            case "footerDentalCareButton":
                return headerPages.footerDentalCareButton;
            case "footerAnaesthesiaButton":
                return headerPages.footerAnaesthesiaButton;
            case "footerDermatologyButton":
                return headerPages.footerDermatologyButton;
            case "footerDiagnosticsButton":
                return headerPages.footerDiagnosticsButton;
            case "footerFacebookButton":
                return headerPages.footerFacebookButton;
            case "footerXButton":
                return headerPages.footerXButton;
            case "footerYoutubeButton":
                return headerPages.footerYoutubeButton;
            case "footerPinterestButton":
                return headerPages.footerPinterestButton;
            case "footerInstagramButton":
                return headerPages.footerInstagramButton;

            default:
                throw new IllegalArgumentException("Böyle bir buton yok: " + fieldName);
        }
    }


}

package User_Test;

import Pages.AdminPages;
import Pages.HeaderPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_018_raporlu_test_sunum_icin extends TestBaseRapor {
    HeaderPages headerPages = new HeaderPages() ;
    AdminPages adminPages = new AdminPages() ;
    TextExtractor extractor = new TextExtractor(Driver.getDriver());


    @Test
    public void TC_01(){
        // Rimadyl (Carprofen) testi
        TextExtractor extractor = new TextExtractor(Driver.getDriver());
        extentTest = extentReports.createTest("Rimadyl (Carprofen) İlaç Testi",
                "Kullanıcının Rimadyl (Carprofen) ilacı için doğru sayfada olduğunu ve ilaç bilgilerinin tutarlılığını doğrular");
        SoftAssert softAssert = new SoftAssert();

        // 1. ADIM: Kayıtlı kullanıcı ilaçlar sayfasına yönlendirilir
        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/Medicines");
        extentTest.info("Kullanıcı ilaçlar sayfasına başarıyla yönlendirildi");

        // 2. ADIM: Kullanıcı Rimadyl ilacını seçer ve detay sayfasına gider
        WebElement rimadylButton = Driver.getDriver().findElement(By.xpath("(//div[@class='wrapper'])[1]"));
        rimadylButton.click();

        extentTest.info("Rimadyl (Carprofen) ilaç detay sayfasına yönlendirildi");

        // 3. ADIM: Kullanıcı status bar'daki ilaç ismini alır ve kaydeder
        WebElement statusBarElement = Driver.getDriver().findElement(By.xpath("(//div[@class='container'])[1]"));
        String statusBarDrugName = statusBarElement.getText().trim();
        extentTest.info("Status bar'daki ilaç ismi kaydedildi: " + statusBarDrugName);

        // 4. ADIM: Kullanıcı sayfadaki ilaç ismini alır ve kaydeder
        String pageDrugName = extractor.getTextNextToElement("(//*[@class='fas fa-capsules'])[2]").trim();
        extentTest.info("İlaç resminde bulunan : " + pageDrugName +" ismi kaydedildi");

        // 5. ADIM: İki kaynaktaki ilaç isimlerinin tutarlılığı kontrol edilir
        softAssert.assertEquals(statusBarDrugName, pageDrugName,
                "Status bar ve sayfadaki ilaç isimleri uyuşmuyor: Status bar='" + statusBarDrugName +
                        "', Sayfa='" + pageDrugName + "'");

        //6.ADIM  Kullanıcı sayfa Url uzantısında ilac ismini arar
        String expectedUrlIcerik = "rimadyl-carprofen"  ;
        extentTest.info("Kullanıcı sayfa url uzantısında "+expectedUrlIcerik+ "olmasını bekler ");

       // 7.Adım Kullanıcı sayfanın Url uzantısını alır kaydeder.
        String actualUrl = Driver.getDriver().getCurrentUrl().toLowerCase();
        extentTest.info("Kullanıcı sayfa Url ini kayt etti.");

        // 8.ADIM kullanıcı beklenen Url uzantısı ile Sayfa Url uzantısını karşılaştırır.
        Assert.assertNotEquals(actualUrl.contains(expectedUrlIcerik),
                "URL uzantısı: " + expectedUrlIcerik + " içeriyor");
        extentTest.pass("Kullanıcı sayfa Url uzantısında " +expectedUrlIcerik+" olmadığını doğrular");
        extentTest.fail("SAYfa Url uzantısında"+ expectedUrlIcerik+ "bulunmuyor--TEST: FAİLED");



// 6. ADIM: Tüm assertion'lar doğrulanır
        softAssert.assertAll();
        extentTest.info("Rimadyl (Carprofen) ilaç doğrulama testi başarıyla tamamlandı");

        // Kayıtlı kullanıcı  Randevu alınacak ilaç ile sayfadaki ilaç ismini  test eder
        // yeşil kontaynır içindeki Randevusu alınacak ilacın ismini kaydeder.
      //  WebElement actualStatusText = Driver.getDriver().findElement(By.xpath("(//div[@class='container'])[1]")) ;
        // 1.İlaç Kapsulu ikonu elementini bul
        // WebElement icon = Driver.getDriver().findElement(By.xpath("(//*[@class='fas fa-capsules'])[2]"));

        // 2. İlaçKapsulu ikonu ile başlayan elementin ;   Parent elementini bul
        //  Bu durumda ilaçKapsulu elementini bulur
        //WebElement parent = icon.findElement(By.xpath(".."));
        // 3. Parent'ın tüm metnini al ve temizle
        //String fullText = parent.getText().trim();

        // 4. İkonun kendi metnini al ve temizle
        //String iconText = icon.getText().trim();

        // 5. Hedef metni ayıkla
        //String targetText = fullText.replace(iconText, "").trim();

/*



        Assert.assertTrue(actualStatusText.(actualDrugName),
                "Sayfa başlığı ilaç ismi ile uyuşmuyor");
        extentTest.info("sayfa başlığı ile ilaç ismi uyuşuyor ");

        // Kullanıcı sayfa Url uzantısının medicines içerdiğini kontrol eder
        String expectedUrl= "Rimadyl-Carprofen";  // gerçek Url uzantısı "suretin-mipen-ruma"
        expectedUrl = expectedTitle.toLowerCase() ;
        Driver.getDriver().getCurrentUrl().toLowerCase();
        Assert.assertNotEquals(actualTitle.contains(expectedTitle),
                "Sayfa url uzantısı "+expectedUrl+" içeriyor");
        extentTest.pass("sayfa url uzantısının"+expectedUrl+"içerdiği test edildi");
        extentTest.fail("Sayfa uzantısının"+expectedUrl +" içermediği görüldü--FAİLED");
*/
    }
    @Test
    public void TC_02() {

        //Medicines sayfası Revolution (Selamectin)

        extentTest = extentReports.createTest("Revolution (Selamectin) İlaç Testi",
                "Kullanıcının Revolution (Selamectin) ilacı için doğru sayfada olduğunu ve ilaç bilgilerinin tutarlılığını doğrular");
        SoftAssert softAssert = new SoftAssert();

        // 1. ADIM: Kayıtlı kullanıcı ilaçlar sayfasına yönlendirilir
        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/Medicines");
        extentTest.info("Kullanıcı ilaçlar sayfasına başarıyla yönlendirildi");

        // 2. ADIM: Kullanıcı Rimadyl ilacını seçer ve detay sayfasına gider
        WebElement revolotionButton = Driver.getDriver().findElement(By.xpath("(//div[@class='wrapper'])[2]"));
        revolotionButton.click();
        extentTest.info("Revolution (Selamectin) ilaç detay sayfasına yönlendirildi");

        // 3. ADIM: Kullanıcı status bar'daki ilaç ismini alır ve kaydeder
        WebElement statusBarElement = Driver.getDriver().findElement(By.xpath("(//div[@class='container'])[1]"));
        String statusBarDrugName = statusBarElement.getText().trim();
        //< --


        extentTest.info("Status bar'daki ilaç ismi kaydedildi: " + statusBarDrugName);

        // 4. ADIM: Kullanıcı sayfadaki ilaç ismini alır ve kaydeder
        String pageDrugName = extractor.getTextNextToElement("(//*[@class='fas fa-capsules'])[2]").trim();
        extentTest.info("İlaç resminde bulunan : " + pageDrugName + " ismi kaydedildi");


        // 5. ADIM: İki kaynaktaki ilaç isimlerinin tutarlılığı kontrol edilir
        softAssert.assertEquals(statusBarDrugName, pageDrugName,
                "Status bar ve sayfadaki ilaç isimleri uyuşmuyor: Status bar='" + statusBarDrugName +
                        "', Sayfa='" + pageDrugName + "'");
        extentTest.info("Randevu status bar ile sayfadaki ilaç isimleri aynı");

        //6.ADIM  Kullanıcı sayfa Url uzantısında ilac ismini arar
        String expectedUrlIcerik = "revolution-selamectin";
        extentTest.info("Kullanıcı sayfa url uzantısında " + expectedUrlIcerik + "olmasını bekler ");

        // 7.Adım Kullanıcı sayfanın Url uzantısını alır kaydeder.
        String actualUrl = Driver.getDriver().getCurrentUrl().toLowerCase();
        extentTest.info("Kullanıcı sayfa Url ini kayt etti.");

        // 8.ADIM kullanıcı beklenen Url uzantısı ile Sayfa Url uzantısını karşılaştırır.
        Assert.assertNotEquals(actualUrl.contains(expectedUrlIcerik),
                "URL uzantısı: " + expectedUrlIcerik + " içeriyor");
        extentTest.pass("Kullanıcı sayfa Url uzantısında " + expectedUrlIcerik + " olmadığını doğrular");
        extentTest.fail("SAYfa Url uzantısında: " + expectedUrlIcerik + " bulunmuyor--TEST: FAİLED");


// 6. ADIM: Tüm assertion'lar doğrulanır
        softAssert.assertAll();
        extentTest.info("Revolution (Selamectin) ilaç doğrulama testi başarıyla tamamlandı");


    }

    public static class TextExtractor {



        // Constructor
        public TextExtractor(WebDriver driver) {

        }

        /**
         * Verilen XPath'teki elementin sağındaki metni döndürür
         * @param elementXpath Elementin XPath'i
         * @return Elementin yanındaki metin
         */
        public String getTextNextToElement(String elementXpath) {
            try {
                // 1. Elementi bul
                WebElement element = Driver.getDriver().findElement(By.xpath(elementXpath));

                // 2. Parent elementini bul
                WebElement parent = element.findElement(By.xpath(".."));

                // 3. Parent'ın tüm metnini al ve temizle
                String fullText = parent.getText().trim();

                // 4. Elementin kendi metnini al ve temizle
                String elementText = element.getText().trim();

                // 5. Hedef metni ayıkla
                String targetText = fullText.replace(elementText, "").trim();

                return targetText;

            } catch (Exception e) {
                System.out.println("Element bulunamadı veya işlem sırasında hata: " + e.getMessage());
                return null;
            }
        }
}

}

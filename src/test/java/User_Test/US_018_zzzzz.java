package User_Test;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class US_018_zzzzz extends TestBaseRapor {

    MedicinesPages medicinesPages = new MedicinesPages() ;
    TextExtractor textExtractor = new TextExtractor() ;

    @DataProvider
    public static Object[][] sendKeysProviders() {
        return new Object[][]{
                {"Rimadyl (Carprofen)"},
                //{"Revolution (Selamectin)"},
               // {"Baytril (Enrofloxacin)"},
               // {"Apoquel (Oclacitinib)"},
               // {"Metacam (Meloxicam)"},
               // {"Alpinia officinarum"}

        };
    }

    @Test (dataProvider = "sendKeysProviders")
    public void TC_01(String dragName ){
        WebDriver driver = Driver.getDriver();

        extentTest = extentReports.createTest(dragName+" İlaç Testi",
                "Kullanıcı"+dragName+ " ilacı için Randevu alinabilirliğini test eder");
        SoftAssert softAssert = new SoftAssert();
        extentTest.info("KK: Kayıtlı kullanıcı");

        // KK anasayfayı yükler
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        extentTest.info("KK anasayfayı yükledi");

        // Randevulu ilaçlar sayfasına yönlendirilir
        medicinesPages.medicinesButton.click();
        extentTest.info("İlaçlar sayfasına yönlendirildi");

        // KK ilaçları listeler
        writeProductsToExcel(
               Driver.getDriver(),
                "//div[@class='wrapper']",
                2

        );




        // KK ilaçlar sayfasındaki ilaçların listesini alır


        // Seçtiği ilaç sayfasına gider
        medicinesPages.rimadylButton.click();
        extentTest.info("KK"+dragName+" ilacı detay sayfasına yönlendirildi");

        // seçtiği ilacın sayfasına yönlendirildiğini doğrular
        medicinesPages.statusBar.getText();
        String statusBarDragName = medicinesPages.statusBar.getText();
        extentTest.info("KK seçtiği "+dragName+" ilacının adını kayt etti");




        // seçtiği ilacın detaylarını inceler ve ilacın adını kayt eder
        medicinesPages.pageDrugName.getText();
        extentTest.info("KK " +dragName +" ilacının adını kayt etti");

        // Randevusu alınacak ilaç ile ilaç detayının aynı olduğunu doğrular




    }




































    // < -- ======= Constructor Parameters(Fields) ===== -- >
    // < -- vvvvvvvvvvvv Constructor Region vvvvvvvvvv -- >
    public static class MedicinesPages {                                         // s1

        // < -- ==vv=== Start Locater Area ==vv=== -- >

        @FindBy(xpath = "(//a[@href='https://qa.loyalfriendcare.com/Medicines'])[2]")  // 6
        public WebElement medicinesButton ;

        @FindBy(xpath = "(//a[@class='btn_add'])[1]")                  //s2
        public WebElement signInButton;                                //s3

        @FindBy(xpath = "//div[@class='wrapper']")
        public List<WebElement>  drugList ;

        @FindBy(xpath = "(//div[@class='wrapper'])[1]")
        public WebElement rimadylButton ;

        @FindBy(xpath = "(//div[@class='wrapper'])[2]")
        public WebElement revolotionButton ;

        @FindBy(xpath = "(//div[@class='wrapper'])[3]")
        public WebElement baytrilButton ;

        @FindBy(xpath = "(//div[@class='wrapper'])[4]")
        public WebElement apoquelButton ;

        @FindBy(xpath = "(//div[@class='wrapper'])[5]")
        public WebElement metacamButton ;

        @FindBy(xpath = "(//div[@class='wrapper'])[6]")
        public WebElement alpinaButton ;

       // < --vvvvvvvvv DataProvider Variables2 vvvvvvvvv -- >
       @FindBy(xpath = "(//div[@class='container'])[1]")
       public WebElement statusBar ;

        // < --vvvvvvvvv DataProvider Variables3 vvvvvvvvv -- >
        @FindBy(xpath = "(//*[@class='fas fa-capsules'])[2]")
        public WebElement pageDrugName ;

        // < -- Appointment Booking Variables -- >

        @FindBy(xpath = "//a[text()='Departments']")
        public WebElement departmentsLink;

        @FindBy(xpath = "//a[@class='grid_item small']")
        public List<WebElement> departmentCards;

        @FindBy(xpath = "//div[@class='box_detail booking']")
        public WebElement appointmentBookingForm;

        @FindBy(xpath = "//input[@id='Date']")
        public WebElement dateInput;

        @FindBy(xpath = "//input[@id='serial']")
        public WebElement phoneNumberInput;

        @FindBy(xpath = "//select[@name='category_id']")
        public WebElement departmentDropdown;

        @FindBy(xpath = "//select[@name='doctor_id']")
        public WebElement doctorDropdown;

        @FindBy(xpath = "//textarea[@name='problem']")
        public WebElement messageTextarea;

        @FindBy(xpath = "//input[@id='submit-contact-detail']")
        public WebElement submitButton;

        @FindBy(xpath = "//div[@class='alert alert-success']")
        public WebElement successAlert;


        // < -- ==^^==== End Lacater Area ==^^==== -- >

        // < -- ===v== Begin Definition Constructor  ===v== -->
        public MedicinesPages() {                                         //s4
            PageFactory.initElements(Driver.getDriver(), this);  //s5
        }                                                              // s6
        // < -- ===^== End Definitions Constructor  ==^=== -- >
    }                                                                  //s7
    // < -- ^^^^^^ Constructor Definition Area ^^^^^^ -- >




    public static class TextExtractor {



        // Constructor
        public TextExtractor() {

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
    public static void writeProductsToExcel(WebDriver driver, String categoryUrl, int baslangicSatir) {
        // 1. Ürün listesini çek
        Driver.getDriver().get(categoryUrl);
        String productLocator = "" ;
        List<WebElement> products = Driver.getDriver().findElements(By.xpath(productLocator));

        // 2. Excel dosya yolu
        String dosyaYolu = "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\medicinesList.ods";

        try {
            // 3. Excel dosyasını aç
            FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            // 4. Her ürünü ayrı satıra yaz
            for(int i=0; i<products.size(); i++) {
                Row row = sheet.getRow(baslangicSatir + i);
                if(row == null) {
                    row = sheet.createRow(baslangicSatir + i);
                }

                // 5. İlk sütuna ürün bilgisi yaz (0. index)
                Cell cell = row.createCell(0);
                cell.setCellValue(products.get(i).getText());
            }

            // 6. Değişiklikleri kaydet
            fileInputStream.close();
            FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);
            workbook.write(fileOutputStream);
            workbook.close();
            fileOutputStream.close();

            System.out.println("Toplam " + products.size() + " ürün Excel'e kaydedildi.");

        } catch (IOException e) {
            System.err.println("Excel kaydetme hatası: " + e.getMessage());
        }
    }



}

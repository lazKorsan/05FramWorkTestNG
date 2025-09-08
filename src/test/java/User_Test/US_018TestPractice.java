package User_Test;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sun.tools.javac.util.Constants.format;

public class US_018TestPractice {
    XyzPages xyzPages = new XyzPages() ;
    TextExtractor textExtractor = new TextExtractor() ;
    Faker faker = new Faker();




    @Test
    public void TC_01() {
        WebDriver driver = Driver.getDriver();

        // KK KULLANICI ana sayfaya yönlendirilir
        Driver.getDriver().get(ConfigReader.getProperty("lfc")); // giriş yaptıktan sonra gerek yok

        // Kullanıcı ilaçlar sayfasına gider
        xyzPages.medicinesButton.click();


        // Kullanıcı ilçaları listeler
        writeProductsToExcel(
                driver,
                "https://qa.loyalfriendcare.com/en/Medicines",
                "//div[@class='wrapper']",
                2
        );

        // Kullanıcı seçtiği ilacın sayfasına gider

        xyzPages.rimadylButton.click();

        // Randevu Bencdeki ilacın ismini kayt eder

        String statusBarText = xyzPages.statusBar.getText();

        // Randevu sayfasındaki ilacın ismini kayt eder
        String pageDrugName = textExtractor.getTextNextToElement(
                "(//*[@class='fas fa-capsules'])[2]") ;

        // Randevu sayfasındaki : Bench ilaç ismi ile Detayı bulunan ilacın ismini karşılaştırır.

        Assert.assertEquals(pageDrugName, statusBarText,
                "Randevu Benchdeki ilaç ismi ile Sayfadaki ilaç ismi farklı");

        // Kullanıcı Randevu defterine :Randevu tarihi girer.
        // Şimdiki tarihten 3 gün sonrası
        LocalDate currentDate = LocalDate.now().plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = currentDate.format(formatter);
        xyzPages.dateInput.sendKeys(formattedDate);
        // Kullanıcı Phone kutusuna numarasını girer.
        // faker classdan
        String phoneNumber = faker.phoneNumber().cellPhone();
        xyzPages.phoneNumberInput.sendKeys(phoneNumber);

        // Kullanıcı istedeği doktoru seçer
        // Test sonunda driver'ı kapat
        Driver.closeDriver();
    }

    @Test
    public void tC02(){
        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/Medicines/suretin-mipen-ruma");
        LocalDate currentDate = LocalDate.now().plusDays(3);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = currentDate.format(formatter);

        // WebElement'e formatlanmış tarihi gönder
        xyzPages.dateInput.sendKeys(formattedDate);
        xyzPages.phoneNumberInput.sendKeys(faker.phoneNumber().cellPhone());

       // WebElement appointmentBookDepartmentsDDM = Driver.getDriver().findElement(By.xpath("//span[@class='current']"));
      //  appointmentBookDepartmentsDDM.click();
      //  Select objSelect = new Select(appointmentBookDepartmentsDDM);
     //   objSelect.selectByIndex(2);

       // appointmentBookDepartmentsDDM.click();
       // ReusableMethods.selectByIndex(appointmentBookDepartmentsDDM,3);

        ReusableMethods.bekle(3);

        String randomText = faker.lorem().characters(100);
        xyzPages.messageTextarea.sendKeys(randomText);
        xyzPages.submitButton.click();

        // Thank you! Your appointment is now confirmed.
        // "We’ve received your request. You’ll get a confirmation email shortly."
    }



    public static void selectByIndex(WebElement element, int index) {
        Select objSelect = new Select(element);
        objSelect.selectByIndex(index);
    }



    public static void writeProductsToExcel(WebDriver driver, String categoryUrl, String productLocator, int baslangicSatir) {
        try {
            driver.get(categoryUrl);
            List<WebElement> products = driver.findElements(By.xpath(productLocator));
            String dosyaYolu = "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\medicinesList.xlsx";

            Workbook workbook;
            Sheet sheet;

            try {
                FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
                workbook = WorkbookFactory.create(fileInputStream);
                sheet = workbook.getSheetAt(0);
                fileInputStream.close();
            } catch (IOException e) {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Medicines");
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("İlaç Adı");
                headerRow.createCell(1).setCellValue("Eklenme Tarihi");
            }

            Pattern datePattern = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");

            for (int i = 0; i < products.size(); i++) {
                String productText = products.get(i).getText();
                String ilacAdi = productText;
                String eklenmeTarihi = "";

                Matcher matcher = datePattern.matcher(productText);
                if (matcher.find()) {
                    eklenmeTarihi = matcher.group();
                    ilacAdi = productText.replace(eklenmeTarihi, "").replace("\n", "").trim();
                }

                Row row = sheet.getRow(baslangicSatir + i);
                if (row == null) {
                    row = sheet.createRow(baslangicSatir + i);
                }

                row.createCell(0).setCellValue(ilacAdi);
                row.createCell(1).setCellValue(eklenmeTarihi);
            }

            try (FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu)) {
                workbook.write(fileOutputStream);
            }

            workbook.close();
            System.out.println("Toplam " + products.size() + " ürün Excel'e kaydedildi.");

        } catch (IOException e) {
            System.err.println("Excel kaydetme hatası: " + e.getMessage());
            e.printStackTrace();
        }
    }


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



    // < -- ======= Constructor Parameters(Fields) ===== -- >
    // < -- vvvvvvvvvvvv Constructor Region vvvvvvvvvv -- >
    public static class XyzPages {                                         // s1

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
        public WebElement appointmentBookingForm; // submit-contact-detail

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
        public XyzPages() {                                         //s4
            PageFactory.initElements(Driver.getDriver(), this);  //s5
        }                                                              // s6
        // < -- ===^== End Definitions Constructor  ==^=== -- >
    }                                                                  //s7
    // < -- ^^^^^^ Constructor Definition Area ^^^^^^ -- >


}






package User_Test;

import Pages.AdminPages;
import Pages.HeaderPages;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Uplloadookers5 extends TestBaseRapor {
    private static final String REPORT_PATH = "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\reports\\";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

    HeaderPages headerPages = new HeaderPages();
    AdminPages adminPages = new AdminPages();
    //Bir yönetici olarak,
    // sol açılır menüdeki Bed Managers
    // ve alt menülerine erişebilmeli,
    // mevcut yatak listesini görüntüleyebilmeli
    // ve bu yataklar üzerinde
    // görüntüleme, arama, düzenleme ve silme işlemleri yapabilmeliyim.


    @Test
    public void TC_01() {// Admin Girişi
        extentTest = extentReports.createTest("Kullanıcı Admin Girişi",
                "Kullanici AnaSayfa Header Bölümünde Bulunan Logoya bastığında Url Değişmemeli");
        // 1 Kullanıcı ana sayfayı açar
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        extentTest.info("Kullanıcı anasayfayı açtı ");
        ReusableMethods.bekle(3);

        // 2 Kullanıcı SignInButtona Basarak Login sayfasına yönlenir
        headerPages.signInButton.click();
        extentTest.info("Kullanıcı Login Sayfasına yönlendirildi");

        // 3 Kullanıcı mail kutusuna AdminMail adresini girer
        headerPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        extentTest.info("Kullanıcı mailKutusuna admin mailini yazdı");

        // 4 Kullanıcı passwordBox Kutusuna geçerli şifreyi girer
        headerPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Kullanıcı geçerli şifreyi girdi");

        // Kullanıcı rememberMe butununa tıklar
        headerPages.rememberMeButton.click();
        extentTest.info("Kullanıcı rememberMe kUtusunu işaretler");

        // Kullanıcı signIn butona basarak admin girişi yapar
        headerPages.loginPageSigInButton.click();
        extentTest.info("Kullanıcı admin girişi yaptı");

        ReusableMethods.bekle(3);



        // admin account Button üzerinde ismini kaydeder
        System.out.println(headerPages.accountButton.getText());
        extentTest.info("Kullanıcı Account Buton üzerindeki ismi kayt etti");
        System.out.println("<--===isimalma testi geçti===--> ");

        // admin buton üzerindeki isimleri karşılaştırır.
        String expectedName = ConfigReader.getProperty("adminName");
        String actualName = headerPages.accountButton.getText();
        System.out.println(headerPages.accountButton.getText());
        Assert.assertFalse(actualName.equals(expectedName));
        extentTest.pass("Admin Isim Doğrulaması yapıldı");

        System.out.println("<--===isimleri karşılaştırır testi geçti===-->");
        ReusableMethods.bekle(2);

        // admin admin sayfasına yönlendirilir.
        headerPages.accountButton.click();
        extentTest.info("Kullanıcı Admin sayfasına yönlendirildi");
        System.out.println("<--===Admine yönlenme geçti===-->");

        // admin dashboard menüsünü açar
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(headerPages.dashBoard).perform();
        extentTest.info("Admin dashboard menüsünü açtı");
        System.out.println("<<--===doshboard açma başarılı ");

        ReusableMethods.bekle(2);




        if (adminPages.dashboardTables.isDisplayed()){
            MultiScreenShootsMethods.getWebelementWithRedBorder(
                    Driver.getDriver(),
                    ConfigReader.getProperty("adminPage"),
                    adminPages.dashboardTables
            );
            extentTest.pass("DashboarTable görünür");
        }else {
            extentTest.fail("Dashboard menü görünür değil");
        }
        System.out.println("Dashboard resim alma tesit geçti");

        // Admin sahboard menusuundan BedMangers menüsünü açar.
        adminPages.bedManagersButton.click();
        extentTest.info("admin menüden BedManagesr kısmını seçti");
        System.out.println("<-- ===== admin menüden BedManagesr açma testi geçti     ===== -- >");
        System.out.println("<--==bedMangersButton test geçti  ");

        ReusableMethods.bekle(2);

        // Admin açlır menüden BedManegers Button seçer
        adminPages.subBedManagersButton.click();
        extentTest.info("Admin açlır menüden BedManegers Button seçer ") ;
        System.out.println("<--==subBedManagersButton test geçti  ");

        // Admin yatak listesini inceler ve kayt eder(excell tabloya kayt eder)
        // excell tablonun adı: bedManagerList
        // açılan sheet ismi : bedManagerList

        writeProductsToExcel(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/Dashboard/Posts",
                "//td[@class='v-align-middle semi-bold']",
                1
        );
        //"//td[@class='v-align-middle semi-bold']"
        System.out.println("<-- === excelle yazma testi geçti === -->");

        // Admin Yatak Listesi için Rapor oluşturur
        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/Dashboard/Posts");

        // Raporda Kullananılacak dosya adı
        String timestamp = LocalDateTime.now().format(DATE_FORMATTER);
        String fileName = "bedMangersReport" + timestamp + ".xlsx";
        String fullPath = REPORT_PATH + fileName;
        extentTest.info("Rapor oluşturma başarılı");

        // Admin WebTablodaki yatakları Raporlar
        generateMedicineReport(
                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/Dashboard/Posts",
                "//td[@class='v-align-middle semi-bold']",
                fullPath
        );

        extentTest.pass("Liste Raporlama başarı ile gerçekleştirildi") ;

        System.out.println("Rapor başarıyla oluşturuldu: " + fullPath);

        // admin yeni bir yatak oluşturma sayfasına yönlendirilir
        adminPages.addBedManagersButton.click();
        extentTest.info("Admin add Bed Managers sayfasına yönlendirildi") ;
        System.out.println("<-- ==== yatak oluşturma sayfasına geçiş PASS");

        // Admin oluşturmak istediği başlığın adını girer
        adminPages.bedManagersTitleBox.sendKeys("Purr Haven");
        extentTest.info("Admin yatak başlığını yazdı");
        System.out.println("<-- ===== yatak title test geçti ==== -- >");

        // Admin oluşturmak istediği yatağın içeriğini girer
        adminPages.bedManagersContentBox.sendKeys("Safe Snug Cat Sanctuary");
        extentTest.info("admin content kutusuna ekleme yaptı");
        System.out.println(" content ekleme testi geçti");
        ReusableMethods.bekle(2);

        // <--==================================================-->
        adminPages.selectDepartmentsButton.click();

        adminPages.inputDepartmentsBox.sendKeys("Dental Care" +Keys.ENTER);
        ReusableMethods.bekle(2);
        actions.moveToElement(adminPages.selectDoctorsButton).perform();
        adminPages.selectDoctorsButton.click();
        adminPages.inputDoctorsBox.sendKeys("Dr. Olivia Bennett"+Keys.ENTER);

        adminPages.selectMedicinesButton.click();
        adminPages.inputMedicinesBox.sendKeys("Revolution (Selamectin)"+Keys.ENTER);


        // Driver.getDriver().execute_script("arguments[0].click();", dbPages.selectMedicinesButton);


        adminPages.inputPriceBox.sendKeys("657"+Keys.ENTER);
        ReusableMethods.bekle(5);
        ReusableMethods.scrollToBottom();

       // Driver.getDriver().get("https://qa.loyalfriendcare.com/Dashboard/Audio/upload/store");
      WebElement ability = Driver.getDriver().findElement(By.xpath("//*[@class='switchery switchery-default']"));
      ability.click();
        WebElement fileUplOadELEMENT = Driver.getDriver().findElement(By.xpath("//*[@id=\"dropzone\"]"));
       // fileUplOadELEMENT.click(); // bunu deyince bilgisayara normal yükleme kutusu açılıyor
        //fileUplOadELEMENT.sendKeys("C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\upload.png");
        // sendKeys ile yükleme olmuyor
        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']")) ;
      ReusableMethods.bekle(3);
      submitButton.click();
      ReusableMethods.bekle(9);

      // resim yükleme özellliği kapalı
        //https://qa.loyalfriendcare.com/Dashboard/Audio/upload/store
































    }

























































    // < -- ===== excelle listeyi çeker Method başlangıcı

    public static void writeProductsToExcel(WebDriver driver, String categoryUrl, String productLocator, int baslangicSatir) {
        try {
            driver.get(categoryUrl);
            List<WebElement> products = driver.findElements(By.xpath(productLocator));
            String dosyaYolu = "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\bedManagerList.xlsx";

            Workbook workbook;
            Sheet sheet;

            try {
                FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
                workbook = WorkbookFactory.create(fileInputStream);
                sheet = workbook.getSheetAt(0);
                fileInputStream.close();
            } catch (IOException e) {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("bedManagerList");
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("İlaç Adı");
                headerRow.createCell(1).setCellValue("Eklenme Tarihi");
            }

            Pattern datePattern = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");

            for(int i = 0; i < products.size(); i++) {
                String productText = products.get(i).getText();
                String ilacAdi = productText;
                String eklenmeTarihi = "";

                Matcher matcher = datePattern.matcher(productText);
                if (matcher.find()) {
                    eklenmeTarihi = matcher.group();
                    ilacAdi = productText.replace(eklenmeTarihi, "").replace("\n", "").trim();
                }

                Row row = sheet.getRow(baslangicSatir + i);
                if(row == null) {
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

    // < -- ===== excelle Liste çekme sonu  -- ===== >


    // < -- ===== excellReportBaslanici ===== -- >


    public static void generateMedicineReport(WebDriver driver, String categoryUrl,
                                              String productLocator, String filePath) {
        try {
            // 1. Ürün listesini çek
            driver.get(categoryUrl);
            List<WebElement> products = driver.findElements(By.xpath(productLocator));

            // 2. Yeni workbook oluştur
            Workbook workbook = new XSSFWorkbook();

            // 3. Stilleri oluştur
            CellStyle headerStyle = createHeaderStyle(workbook);
            CellStyle dateStyle = createDateStyle(workbook);
            CellStyle defaultStyle = createDefaultStyle(workbook);

            // 4. Sayfa oluştur
            Sheet sheet = workbook.createSheet("Yatak Listesi");

            // 5. Rapor başlıkları
            createReportHeaders(sheet, headerStyle);

            // 6. Rapor bilgileri
            addReportInfo(sheet, defaultStyle, products.size(), categoryUrl);

            // 7. İlaç verilerini yaz
            writeMedicineData(sheet, products, dateStyle, defaultStyle);

            // 8. Sütun genişliklerini ayarla
            autoSizeColumns(sheet);

            // 9. Dosyayı kaydet
            saveWorkbook(workbook, filePath);

            System.out.println("Rapor oluşturma tamamlandı: " + filePath);
            System.out.println("Toplam " + products.size() + " ilaç kaydedildi.");

        } catch (Exception e) {
            System.err.println("Rapor oluşturma hatası: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);
        style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }

    private static CellStyle createDateStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        style.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
        style.setAlignment(HorizontalAlignment.CENTER);
        return style;
    }

    private static CellStyle createDefaultStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setWrapText(true);
        return style;
    }

    private static void createReportHeaders(Sheet sheet, CellStyle headerStyle) {
        Row headerRow = sheet.createRow(3);
        String[] headers = {"Sıra No", "İlaç Adı", "Eklenme Tarihi", "Durum", "Notlar"};

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }
    }

    private static void addReportInfo(Sheet sheet, CellStyle style, int productCount, String categoryUrl) {
        // Rapor başlığı
        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("LOYAL FRIEND CARE - YATAK LİSTESİ  RAPORU");
        titleCell.setCellStyle(style);

        // Rapor tarihi
        Row dateRow = sheet.createRow(1);
        dateRow.createCell(0).setCellValue("Rapor Tarihi: " +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));

        // Toplam ilaç sayısı
        Row countRow = sheet.createRow(1);
        countRow.createCell(2).setCellValue("Toplam İlaç: " + productCount);

        // URL bilgisi
        Row urlRow = sheet.createRow(2);
        urlRow.createCell(0).setCellValue("Kaynak: " + categoryUrl);
    }

    private static void writeMedicineData(Sheet sheet, List<WebElement> products,
                                          CellStyle dateStyle, CellStyle defaultStyle) {
        Pattern datePattern = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");
        int startRow = 4;

        for (int i = 0; i < products.size(); i++) {
            String productText = products.get(i).getText();
            String ilacAdi = productText;
            String eklenmeTarihi = "";
            String durum = "Aktif";

            // Tarihi ayır
            Matcher matcher = datePattern.matcher(productText);
            if (matcher.find()) {
                eklenmeTarihi = matcher.group();
                ilacAdi = productText.replace(eklenmeTarihi, "").replace("\n", "").trim();
            }

            // Satır oluştur
            Row row = sheet.createRow(startRow + i);

            // Sıra No
            Cell cell0 = row.createCell(0);
            cell0.setCellValue(i + 1);
            cell0.setCellStyle(defaultStyle);

            // İlaç Adı
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(ilacAdi);
            cell1.setCellStyle(defaultStyle);

            // Eklenme Tarihi
            Cell cell2 = row.createCell(2);
            cell2.setCellValue(eklenmeTarihi);
            cell2.setCellStyle(dateStyle);

            // Durum
            Cell cell3 = row.createCell(3);
            cell3.setCellValue(durum);
            cell3.setCellStyle(defaultStyle);

            // Notlar (boş bırakılabilir)
            row.createCell(4).setCellValue("");
        }
    }

    private static void autoSizeColumns(Sheet sheet) {
        for (int i = 0; i < 5; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    private static void saveWorkbook(Workbook workbook, String filePath) throws IOException {
        // Klasörü kontrol et ve oluştur
        java.io.File directory = new java.io.File(filePath).getParentFile();
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            workbook.write(fileOutputStream);
            workbook.close();
        }
    }

    // Farklı isimlerle rapor oluşturmak için yardımcı method
    public static String generateCustomReport(WebDriver driver, String categoryUrl,
                                              String productLocator, String reportName) {
        String timestamp = LocalDateTime.now().format(DATE_FORMATTER);
        String fileName = reportName + "_" + timestamp + ".xlsx";
        String fullPath = REPORT_PATH + fileName;

        generateMedicineReport(driver, categoryUrl, productLocator, fullPath);
        return fullPath;
    }


    // < -- ===== excellReportSonu ===== -- >



}




package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Pages.AdminPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelSearchUtility {

    public static void searchAndUpdateExcel(WebDriver driver, String pageUrl, String searchXpath,
                                            String excelFilePath, String sheetName) {
        try {
            // Excel dosyasını oku veya oluştur
            File file = new File(excelFilePath);
            Workbook workbook;
            Sheet sheet;

            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                workbook = new XSSFWorkbook(fis);
                sheet = workbook.getSheet(sheetName);
                if (sheet == null) {
                    sheet = workbook.createSheet(sheetName);
                }
                fis.close();
            } else {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet(sheetName);
            }

            // Excel'den ürünleri oku (A sütunu, 2. satırdan başla)
            int rowIndex = 1; // 2. satır (1-based index)
            while (sheet.getRow(rowIndex) != null &&
                    sheet.getRow(rowIndex).getCell(0) != null) {
                Row row = sheet.getRow(rowIndex);
                String productName = row.getCell(0).getStringCellValue();
                int stockQuantity = (int) (row.getCell(1) != null ?
                        row.getCell(1).getNumericCellValue() : 0);

                // Web sayfasında arama yap
                driver.get(pageUrl);
                WebElement searchBox = driver.findElement(By.xpath(searchXpath));
                searchBox.clear();
                searchBox.sendKeys(productName);
                searchBox.submit();

                // Arama sonucunu al (örnek olarak ilk sonucu alıyoruz)
                List<WebElement> results = driver.findElements(By.xpath("//div[contains(@class, 'search-result')]"));
                String searchResult = results.isEmpty() ? "Bulunamadı" : results.get(0).getText();

                // Sonucu C sütununa yaz
                Cell resultCell = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                resultCell.setCellValue(searchResult);

                // Stock kontrolü ve renklendirme
                if (stockQuantity < 10) { // Örnek eşik: 10
                    CellStyle style = workbook.createCellStyle();
                    style.setFillForegroundColor(IndexedColors.RED.getIndex());
                    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    row.getCell(0).setCellStyle(style);
                    row.getCell(1).setCellStyle(style);
                    row.getCell(2).setCellStyle(style);
                }

                rowIndex++;
            }

            // Excel dosyasını kaydet
            FileOutputStream fos = new FileOutputStream(excelFilePath);
            workbook.write(fos);
            fos.close();
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    AdminPages adminPages = new AdminPages();

    @Test
    public void excellAramaTesti() {
        // Sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));



        // Excel arama işlemini gerçekleştir
        ExcelSearchUtility.searchAndUpdateExcel(
                Driver.getDriver(),
                ConfigReader.getProperty("lfc"),
                "//*[@id=\"page\"]/main/div[2]/div/div/div/div[1]/div/figure/a/img", // Örnek xpath
                "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\urunler.xlsx",
                "UrunListesi"
        );

        // Örnek ürün araması
        adminPages.searchBox.sendKeys("re");

    }

    @Test
    public void trackProductAvailability() {

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        ExcelSearchUtility.searchAndUpdateExcel(


                Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en",
                "//*[@id=\"page\"]/main/div[2]/div/div/div/div[1]/div/figure/a/img",
                "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\urunler.xlsx",
                "Stoklar"
        );
    }
}
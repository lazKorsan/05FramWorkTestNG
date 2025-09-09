package uaYeni_28_08_25_tarihindeAcildi;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.TestBaseRapor;

import java.util.Map;

public class StockTest extends TestBaseRapor {

    @Test
    public void testExcelStockVsSite() {
        // %%%excell yolu görüyor

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        String excelPath = "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\urunler.xlsx";
        Map<String, ExcelUtils.SearchResult> results =
                ExcelUtils.checkStockWithSite(Driver.getDriver(), excelPath, "Sayfa1", 0, 1);

        // Assert örneği → her ürün için stok >= siteCount olmalı
        for (ExcelUtils.SearchResult result : results.values()) {
            Assert.assertTrue(result.excelStock >= result.siteCount,
                    "Stok yetersiz! Ürün: " + result.productName +
                            " Excel stok: " + result.excelStock +
                            " Site sayısı: " + result.siteCount +
                            " URL: " + result.finalUrl);
        }
    }
}

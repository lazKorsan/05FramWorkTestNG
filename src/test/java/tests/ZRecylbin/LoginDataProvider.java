
        package tests.ZRecylbin;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class LoginDataProvider {

    @DataProvider(name = "excelLoginData")
    public static Object[][] provideLoginCredentials() {
        try {
            return excellOkuyucu.getExcelData(
                    "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\urunler.xlsx",
                    "Sayfa1" // Excel'deki sayfa adı
            );
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException("Excel veri okuma hatası: " + e.getMessage(), e);
        }
    }
}


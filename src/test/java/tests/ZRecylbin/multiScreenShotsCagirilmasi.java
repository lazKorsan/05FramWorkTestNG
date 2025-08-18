package tests.ZRecylbin;

import com.google.zxing.WriterException;
import org.testng.annotations.Test;
import utilities.Driver;

import java.io.IOException;

public class multiScreenShotsCagirilmasi {
    @Test
    public void twss() throws IOException, WriterException {

        Driver.getDriver().get("https://qa.loyalfriendcare.com");
        // QR'ı masaüstüne kaydetme
        MultiScreenShots.saveQRToFile("https://loyalfriendcare.com/pet-profile-123");

// Tarayıcıda QR gösterme (Mevcut fonksiyon)
        MultiScreenShots.addUrlWithQRCode(Driver.getDriver(), "https://loyalfriendcare.com/pet-profile-123");



    }
}

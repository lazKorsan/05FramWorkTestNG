package tests.ZRecylbin;

import Pages.AdminPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;

public class MultiScreenShots {

    private static final String BASE_PATH = "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\"; // DÜZELTİLMİŞ DOSYA YOLU

    private MultiScreenShots() {
        throw new IllegalStateException("Utility class - instantiation yasak!");
    }

    // QR KODU FİZİKSEL DOSYAYA KAYDETME METODU (YENİ EKLENDİ)
    public static void saveQRToFile(String url) throws WriterException, IOException {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix matrix = writer.encode(url, BarcodeFormat.QR_CODE, 300, 300);

        String fileName = "QR_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".png";
        String fullPath = BASE_PATH + fileName;

        Files.createDirectories(Paths.get(BASE_PATH)); // Klasör yoksa oluştur
        MatrixToImageWriter.writeToPath(matrix, "PNG", Paths.get(fullPath));
    }

    // DİĞER METODLAR (DEĞİŞMEDİ)
    public static void highlightButtonsWithDescription(WebDriver driver, List<WebElement> buttons, String description) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        buttons.forEach(btn -> {
            try {
                js.executeScript(
                        "arguments[0].style.setProperty('border', '3px solid #ff0000', 'important');" +
                                "arguments[0].style.setProperty('border-radius', '5px', 'important');" +
                                "arguments[0].style.setProperty('box-shadow', '0 0 8px rgba(255,0,0,0.5)', 'important');",
                        btn
                );

                js.executeScript(
                        "var desc = document.createElement('div');" +
                                "desc.style.cssText = 'color:#ff4444; font-size:12px; margin-top:5px; font-family:Arial;';" +
                                "desc.textContent = arguments[1];" +
                                "arguments[0].parentNode.insertBefore(desc, arguments[0].nextSibling);",
                        btn, description
                );
            } catch (Exception e) {
                System.err.println("Element manipülasyon hatası: " + e.getMessage());
            }
        });
    }

    public static void addGreenCheckmark(WebDriver driver, List<WebElement> buttons) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        buttons.forEach(btn -> {
            js.executeScript(
                    "var check = document.createElement('span');" +
                            "check.style.cssText = 'color:#00cc66; margin-left:10px; font-size:18px; font-weight:bold;';" +
                            "check.innerHTML = '✓';" +
                            "arguments[0].parentNode.insertBefore(check, arguments[0].nextSibling);",
                    btn
            );
        });
    }

    public static void addUrlWithQRCode(WebDriver driver, String url) throws WriterException, IOException {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix matrix = writer.encode(url, BarcodeFormat.QR_CODE, 200, 200);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix, "PNG", baos);
        String qrCodeImage = Base64.getEncoder().encodeToString(baos.toByteArray());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "var container = document.createElement('div');" +
                        "container.style.cssText = 'position:fixed; top:20px; right:20px; z-index:9999; " +
                        "background:#ffffff; padding:15px; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.15);';" +

                        "var closeBtn = document.createElement('button');" +
                        "closeBtn.textContent = '×';" +
                        "closeBtn.style.cssText = 'position:absolute; top:5px; right:5px; border:none; " +
                        "background:transparent; font-size:18px; cursor:pointer; color:#666;';" +
                        "closeBtn.onclick = function() { container.remove(); };" +

                        "var urlText = document.createElement('div');" +
                        "urlText.style.cssText = 'margin-bottom:10px; font-family:Arial; font-size:14px; color:#333;';" +
                        "urlText.textContent = 'QR Kodu: ' + arguments[0];" +

                        "var qrImg = document.createElement('img');" +
                        "qrImg.src = 'data:image/png;base64,' + arguments[1];" +
                        "qrImg.style.cssText = 'width:150px; height:150px; display:block; margin:0 auto; border:1px solid #eee;';" +

                        "container.appendChild(closeBtn);" +
                        "container.appendChild(urlText);" +
                        "container.appendChild(qrImg);" +
                        "document.body.appendChild(container);",
                url, qrCodeImage
        );
    }

    @Test
    public void t(){
        AdminPages adminPages = new AdminPages();

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));



    }
}

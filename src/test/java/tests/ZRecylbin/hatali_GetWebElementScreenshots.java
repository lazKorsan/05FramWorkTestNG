package tests.ZRecylbin;

import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class hatali_GetWebElementScreenshots {

    private static final String SCREENSHOT_DIR = "target/screenshots/";

    /**
     * Belirtilen WebElement'i bulur, ekran görüntüsünü alır ve kırmızı çerçeve ekler.
     *
     * @param xpath       WebElement'in xpath'i
     * @param elementName Ekran görüntüsü dosyasına eklenecek isim (örneğin: "login_button")
     * @return Çerçeveli ekran görüntüsünün dosya yolu
     */
    public static String captureWebElementWithHighlight(String xpath, String elementName) {
        WebDriver driver = Driver.getDriver(); // Driver sınıfınızın adına göre ayarlayın
        WebElement element = null;
        File screenshotFile = null;

        try {
            // WebElement'i bul ve beklemeye al
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

            // WebElement'in ekran görüntüsünü al
            screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // WebElement'in koordinatlarını al
            Point location = element.getLocation();
            int width = element.getSize().getWidth();
            int height = element.getSize().getHeight();

            // Ekran görüntüsünü BufferedImage'e çevir
            BufferedImage fullImage = ImageIO.read(screenshotFile);
            BufferedImage elementImage = fullImage.getSubimage(location.getX(), location.getY(), width, height);

            // Kırmızı çerçeve ekle
            Graphics2D g = elementImage.createGraphics();
            g.setColor(Color.RED);
            g.setStroke(new BasicStroke(3)); // Çerçeve kalınlığı
            g.drawRect(0, 0, width - 1, height - 1); // Çerçeve çiz
            g.dispose();

            // Yeni görüntüyü kaydet
            String fileName = elementName + "_" + System.currentTimeMillis() + ".png";
            String filePath = SCREENSHOT_DIR + fileName;
            File outputFile = new File(filePath);

            // Screenshots klasörü yoksa oluştur
            new File(SCREENSHOT_DIR).mkdirs();

            ImageIO.write(elementImage, "png", outputFile);
            System.out.println("Screenshot saved: " + filePath);
            return filePath;

        } catch (NoSuchElementException e) {
            System.err.println("Element bulunamadı: " + xpath);
            return null;
        } catch (IOException e) {
            System.err.println("Ekran görüntüsü alınırken hata oluştu: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("Beklenmeyen hata: " + e.getMessage());
            return null;
        }
    }

    @Test
    public void t(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        hatali_GetWebElementScreenshots.captureWebElementWithHighlight(
                "//*[@class='btn_add']","signini"
        );
    }
}
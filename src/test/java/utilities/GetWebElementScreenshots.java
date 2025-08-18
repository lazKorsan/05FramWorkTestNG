package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;

public class GetWebElementScreenshots {

    //private static final String SCREENSHOT_DIR = "target/screenshots/";
    private static final String SCREENSHOT_DIR = "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\";


    public static String captureWebElementWithHighlight(String xpath, String elementName) {
        WebDriver driver = Driver.getDriver();
        WebElement element = null;
        File screenshotFile = null;

        try {
            // 1. Elementin görünür ve tıklanabilir olana kadar bekle
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

            // 2. Sayfayı elementin olduğu pozisyona kaydır
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500); // Animasyon için kısa bekleme

            // 3. Ekran görüntüsünü al
            screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage fullImage = ImageIO.read(screenshotFile);

            // 4. Koordinatları düzgün almak için JavaScript kullan
            Long x = (Long) ((JavascriptExecutor) driver).executeScript(
                    "return Math.round(arguments[0].getBoundingClientRect().left);", element);
            Long y = (Long) ((JavascriptExecutor) driver).executeScript(
                    "return Math.round(arguments[0].getBoundingClientRect().top);", element);
            Long width = (Long) ((JavascriptExecutor) driver).executeScript(
                    "return Math.round(arguments[0].getBoundingClientRect().width);", element);
            Long height = (Long) ((JavascriptExecutor) driver).executeScript(
                    "return Math.round(arguments[0].getBoundingClientRect().height);", element);

            // 5. Subimage'i güvenli bir şekilde oluştur
            if (x >= 0 && y >= 0 && width > 0 && height > 0 &&
                    (x + width) <= fullImage.getWidth() &&
                    (y + height) <= fullImage.getHeight()) {

                BufferedImage elementImage = fullImage.getSubimage(x.intValue(), y.intValue(),
                        width.intValue(), height.intValue());

                // 6. Kırmızı çerçeve ekle
                Graphics2D g = elementImage.createGraphics();
                g.setColor(Color.RED);
                g.setStroke(new BasicStroke(3));
                g.drawRect(0, 0, width.intValue() - 1, height.intValue() - 1);
                g.dispose();

                // 7. Dosyayı kaydet
                String fileName = elementName + "_" + System.currentTimeMillis() + ".png";
                String filePath = SCREENSHOT_DIR + fileName;
                new File(SCREENSHOT_DIR).mkdirs();
                ImageIO.write(elementImage, "png", new File(filePath));
                return filePath;
            } else {
                throw new RuntimeException("Element koordinatları geçersiz!");
            }

        } catch (Exception e) {
            System.err.println("Hata: " + e.getMessage());
            return null;
        }
    }
}
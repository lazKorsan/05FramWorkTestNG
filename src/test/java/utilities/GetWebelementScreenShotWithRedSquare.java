package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class GetWebelementScreenShotWithRedSquare {

    private static final String SCREENSHOT_DIR = "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\";

    /**
     * Belirtilen butonun ekran görüntüsünü alır ve etrafına kırmızı çerçeve çizer.
     *
     * @param button      WebElement nesnesi (buton)
     * @param buttonName  Ekran görüntüsü dosya adı (ör: "homeButton")
     * @return Kaydedilen screenshot dosya yolu
     */
    public static String captureButtonWithRedSquare(WebElement button, String buttonName) {
        WebDriver driver = Driver.getDriver();
        File screenshotFile = null;

        try {
            // 1. Buton görünür olana kadar bekle ve sayfayı kaydır
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(button));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            Thread.sleep(500); // Animasyon için bekle

            // 2. Tam ekran screenshot al
            screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage fullImage = ImageIO.read(screenshotFile);

            // 3. Butonun koordinatlarını ve boyutlarını al (JavaScript ile daha doğru sonuç için)
            Long x = (Long) ((JavascriptExecutor) driver).executeScript(
                    "return Math.round(arguments[0].getBoundingClientRect().left + window.scrollX);", button);
            Long y = (Long) ((JavascriptExecutor) driver).executeScript(
                    "return Math.round(arguments[0].getBoundingClientRect().top + window.scrollY);", button);
            Long width = (Long) ((JavascriptExecutor) driver).executeScript(
                    "return Math.round(arguments[0].getBoundingClientRect().width);", button);
            Long height = (Long) ((JavascriptExecutor) driver).executeScript(
                    "return Math.round(arguments[0].getBoundingClientRect().height);", button);

            // 4. Sadece butonun bölgesini kırp
            BufferedImage buttonImage = fullImage.getSubimage(
                    x.intValue(), y.intValue(), width.intValue(), height.intValue());

            // 5. Kırmızı çerçeve çiz
            Graphics2D g = buttonImage.createGraphics();
            g.setColor(Color.RED);
            g.setStroke(new BasicStroke(5)); // Çerçevenin kalınlığı

            // Butonun etrafına kırmızı çerçeve çiz (kırpılmış görüntüye)
            g.drawRect(0, 0, width.intValue() - 1, height.intValue() - 1);
            g.dispose();

            // 6. Dosyayı kaydet
            String fileName = (buttonName == null || buttonName.trim().isEmpty() ? "button_screenshot" : buttonName)
                    + "_red_square_" + System.currentTimeMillis() + ".png";
            String filePath = SCREENSHOT_DIR + fileName;
            new File(SCREENSHOT_DIR).mkdirs();
            ImageIO.write(buttonImage, "png", new File(filePath));

            return filePath;

        } catch (IOException e) {
            System.err.println("Dosya işlemi hatası: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("Hata: " + e.getMessage());
            return null;
        }
    }
}
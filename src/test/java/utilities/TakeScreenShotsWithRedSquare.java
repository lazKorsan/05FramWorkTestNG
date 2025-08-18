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

public class TakeScreenShotsWithRedSquare {

    private static final String SCREENSHOT_DIR = "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\";

    /**
     * Tam ekran screenshot alır ve belirtilen elementi kırmızı çerçeve ile çevreler.
     *
     * @param element     WebElement nesnesi
     * @param elementName Ekran görüntüsü dosya adı (ör: "homeButton")
     * @return Kaydedilen screenshot dosya yolu
     */
    public static String captureScreenshotWithRedBorder(WebElement element, String elementName) {
        WebDriver driver = Driver.getDriver();
        File screenshotFile = null;

        try {
            // 1. Element görünür olana kadar bekle ve sayfayı kaydır
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500); // Animasyon için bekle

            // 2. Tam ekran screenshot al
            screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage fullImage = ImageIO.read(screenshotFile);

            // 3. Elementin koordinatlarını ve boyutlarını al (JavaScript ile daha doğru sonuç için)
            Long x = (Long) ((JavascriptExecutor) driver).executeScript(
                    "return Math.round(arguments[0].getBoundingClientRect().left + window.scrollX);", element);
            Long y = (Long) ((JavascriptExecutor) driver).executeScript(
                    "return Math.round(arguments[0].getBoundingClientRect().top + window.scrollY);", element);
            Long width = (Long) ((JavascriptExecutor) driver).executeScript(
                    "return Math.round(arguments[0].getBoundingClientRect().width);", element);
            Long height = (Long) ((JavascriptExecutor) driver).executeScript(
                    "return Math.round(arguments[0].getBoundingClientRect().height);", element);

            // 4. Kırmızı çerçeve çiz
            Graphics2D g = fullImage.createGraphics();
            g.setColor(Color.RED);
            g.setStroke(new BasicStroke(5)); // Çerçevenin kalınlığı

            // Elementin etrafına kırmızı çerçeve çiz
            g.drawRect(x.intValue(), y.intValue(), width.intValue(), height.intValue());
            g.dispose();

            // 5. Dosyayı kaydet
            String fileName = (elementName == null || elementName.trim().isEmpty() ? "screenshot" : elementName)
                    + "_border_" + System.currentTimeMillis() + ".png";
            String filePath = SCREENSHOT_DIR + fileName;
            new File(SCREENSHOT_DIR).mkdirs();
            ImageIO.write(fullImage, "png", new File(filePath));

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
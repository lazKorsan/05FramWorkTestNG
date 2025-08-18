package tests.ZRecylbin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;

public class WWWTakeScreenShootWithGreenLine {

    // private static final String SCREENSHOT_DIR = "target/screenshots/";
    private static final String SCREENSHOT_DIR = "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\";

    /**
     * Tam ekran screenshot alır ve belirtilen elementin altına yeşil ok (✓) ekler.
     *
     * @param xpath       WebElement'in xpath'i
     * @param elementName Ekran görüntüsü dosya adı (ör: "login_success")
     * @return Kaydedilen screenshot dosya yolu
     */
    public static String captureFullScreenWithGreenCheck(String xpath, String elementName) {
        WebDriver driver = Driver.getDriver();
        WebElement element = null;
        File screenshotFile = null;

        try {
            // 1. Element görünür olana kadar bekle ve sayfayı kaydır
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500); // Animasyon için bekle

            // 2. Tam ekran screenshot al
            screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage fullImage = ImageIO.read(screenshotFile);

            // 3. Elementin koordinatlarını al (JavaScript ile daha doğru sonuç için)
            Long x = (Long) ((JavascriptExecutor) driver).executeScript(
                    "return Math.round(arguments[0].getBoundingClientRect().left + window.scrollX);", element);
            Long y = (Long) ((JavascriptExecutor) driver).executeScript(
                    "return Math.round(arguments[0].getBoundingClientRect().top + window.scrollY);", element);
            Long width = (Long) ((JavascriptExecutor) driver).executeScript(
                    "return Math.round(arguments[0].getBoundingClientRect().width);", element);

            // 4. Yeşil ok (✓) çiz
            Graphics2D g = fullImage.createGraphics();

            // Okun rengi ve kalınlığı
            g.setColor(Color.GREEN);
            //<-- ==========satır55 orjinal kod parçası
            //***** g.setStroke(new BasicStroke(5));
            g.setStroke(new BasicStroke(25));
            //================================= ->

            // Okun pozisyonu (elementin altına)
            int arrowX = x.intValue() + (width.intValue() / 2); // Elementin ortası
            int arrowY = y.intValue() + element.getSize().getHeight() + 20; // Elementin 20px altı

            // Ok çiz (✓ simgesi)
            g.drawLine(arrowX - 10, arrowY - 10, arrowX, arrowY); // Sol çizgi
            g.drawLine(arrowX, arrowY, arrowX + 20, arrowY - 20); // Sağ çizgi
            g.dispose();

            // 5. Dosyayı kaydet
            String fileName = elementName + "_check_" + System.currentTimeMillis() + ".png";
            String filePath = SCREENSHOT_DIR + fileName;
            new File(SCREENSHOT_DIR).mkdirs();
            ImageIO.write(fullImage, "png", new File(filePath));

            return filePath;

        } catch (Exception e) {
            System.err.println("Hata: " + e.getMessage());
            return null;
        }
    }
}
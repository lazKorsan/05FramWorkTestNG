package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GelismisEkranKaydirmaMethodu {
    private WebElement element;
    private int offsetY = 0;
    private int speed = 500; // Varsayılan hız: 500 ms
    private int maxRetries = 0;
    private boolean screenshotOnFail = false;

    // Yapıcı metot
    public GelismisEkranKaydirmaMethodu(WebElement element) {
        this.element = element;
    }

    // Builder metodları
    public GelismisEkranKaydirmaMethodu withOffset(int y) {
        this.offsetY = y;
        return this.withScreenshotOnFail();
    }

    public GelismisEkranKaydirmaMethodu withSpeed(int milliseconds) {
        if (milliseconds < 0) {
            throw new IllegalArgumentException("Speed cannot be negative");
        }
        this.speed = milliseconds;
        return this.withScreenshotOnFail();
    }

    public GelismisEkranKaydirmaMethodu withRetry(int retryCount) {
        if (retryCount < 0) {
            throw new IllegalArgumentException("Retry count cannot be negative");
        }
        this.maxRetries = retryCount;
        return this.withScreenshotOnFail();
    }

    public GelismisEkranKaydirmaMethodu withScreenshotOnFail() {
        this.screenshotOnFail = true;
        return this;
    }

    public void execute() {
        int attempts = 0;
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        while (attempts <= maxRetries) {
            try {
                // Öğenin ekranın görünür alanında olup olmadığını kontrol et
                boolean isElementInView = (Boolean) js.executeScript(
                        "var elem = arguments[0], " +
                                "box = elem.getBoundingClientRect(), " +
                                "cx = box.left + box.width / 2, " +
                                "cy = box.top + box.height / 2, " +
                                "e = document.elementFromPoint(cx, cy); " +
                                "return e === elem;",
                        element
                );

                if (isElementInView) {
                    return; // Öğe zaten görünür, kaydırmaya gerek yok
                }

                // Kaydırma işlemi için JavaScript
                String script = "arguments[0].scrollIntoView({"
                        + "behavior: 'smooth'," // Animasyonlu kaydırma
                        + "block: 'center',"
                        + "inline: 'center'"
                        + "});"
                        + (offsetY != 0 ? "window.scrollBy(0, " + offsetY + ");" : "")
                        + (speed > 0 ? "await new Promise(resolve => setTimeout(resolve, " + speed + "));" : "");

                js.executeScript(script, element);

                // Kaydırmadan sonra öğenin görünür olduğunu kontrol et
                isElementInView = (Boolean) js.executeScript(
                        "var elem = arguments[0], " +
                                "box = elem.getBoundingClientRect(), " +
                                "cx = box.left + box.width / 2, " +
                                "cy = box.top + box.height / 2, " +
                                "e = document.elementFromPoint(cx, cy); " +
                                "return e === elem;",
                        element
                );

                if (isElementInView) {
                    return; // Başarılı, döngüden çık
                } else {
                    throw new RuntimeException("Element is not in view after scrolling");
                }
            } catch (Exception e) {
                attempts++;
                if (screenshotOnFail && attempts <= maxRetries) {
                    takeScreenshot();
                }
                if (attempts > maxRetries) {
                    throw new RuntimeException("Failed to scroll to element after " + maxRetries + " retries", e);
                }
                try {
                    Thread.sleep(500); // Tekrar denemeden önce kısa bir bekleme
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private void takeScreenshot() {

    }

    public static void takeFullPageScreenshot(String fileName) {
        try {
            TakesScreenshot tss = (TakesScreenshot) Driver.getDriver();
            String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String finalFileName = fileName + "_" + timeStamp + ".png";
            // Not: Bu yol, sadece sizin bilgisayarınızda çalışacaktır.
            String directoryPath = "C:/Users/Hp/OneDrive/Desktop/PracticeExpandtesting";
            Path fullPath = Paths.get(directoryPath, finalFileName);

            Files.createDirectories(Paths.get(directoryPath));
            File sourceFile = tss.getScreenshotAs(OutputType.FILE);
            Files.copy(sourceFile.toPath(), fullPath);
            System.out.println("Tam sayfa ekran görüntüsü başarıyla kaydedildi: " + fullPath);
        } catch (IOException e) {
            System.err.println("Tam sayfa ekran görüntüsü alınırken bir hata oluştu: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
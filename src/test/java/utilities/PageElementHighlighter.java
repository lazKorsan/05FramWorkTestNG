package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.commons.io.FileUtils;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.*;

public class PageElementHighlighter {
    private static final String SCREENSHOT_DIR = "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\";

    public static void highlightAndCaptureElements(WebDriver driver, Map<String, By> elementsToHighlight,
                                                   String screenshotName) {
        try {
            // 1. Önce sayfanın tamamen yüklendiğinden emin ol
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                    webDriver -> ((JavascriptExecutor) webDriver)
                            .executeScript("return document.readyState").equals("complete"));

            // 2. Tüm elementleri bul ve highlight et
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Map<WebElement, String> highlightedElements = new HashMap<>();

            for (Map.Entry<String, By> entry : elementsToHighlight.entrySet()) {
                String elementName = entry.getKey();
                By locator = entry.getValue();

                try {
                    WebElement element = driver.findElement(locator);
                    if (element.isDisplayed()) {
                        // Orijinal style'ı sakla
                        String originalStyle = element.getAttribute("style");
                        js.executeScript(
                                "arguments[0].setAttribute('data-original-style', arguments[1]);",
                                element, originalStyle
                        );

                        // Kırmızı çerçeve ve label ekle
                        js.executeScript(
                                "arguments[0].style.border = '3px solid red !important';" +
                                        "arguments[0].style.background = 'rgba(255,0,0,0.1) !important';" +
                                        "arguments[0].style.padding = '2px !important';" +

                                        "var label = document.createElement('div');" +
                                        "label.innerHTML = '🔍 ' + arguments[1];" +
                                        "label.style.position = 'absolute';" +
                                        "label.style.background = 'red';" +
                                        "label.style.color = 'white';" +
                                        "label.style.padding = '2px 8px';" +
                                        "label.style.fontSize = '12px';" +
                                        "label.style.fontWeight = 'bold';" +
                                        "label.style.borderRadius = '3px';" +
                                        "label.style.zIndex = '10000';" +
                                        "label.style.whiteSpace = 'nowrap';" +

                                        "var rect = arguments[0].getBoundingClientRect();" +
                                        "label.style.top = (rect.bottom + window.scrollY + 5) + 'px';" +
                                        "label.style.left = (rect.left + window.scrollX) + 'px';" +

                                        "document.body.appendChild(label);" +
                                        "arguments[0].setAttribute('data-highlight-label', label.outerHTML);",
                                element, elementName
                        );

                        highlightedElements.put(element, elementName);
                    }
                } catch (Exception e) {
                    System.out.println("Element bulunamadı: " + elementName + " - " + e.getMessage());
                }
            }

            // 3. Kısa bekleme (render için)
            Thread.sleep(1000);

            // 4. EKRAN GÖRÜNTÜSÜ AL
            takeScreenshotWithHighlights(driver, screenshotName, highlightedElements);

            // 5. Highlight'ları temizle
            for (WebElement element : highlightedElements.keySet()) {
                js.executeScript(
                        "arguments[0].style = arguments[0].getAttribute('data-original-style') || '';" +
                                "arguments[0].removeAttribute('data-original-style');" +
                                "arguments[0].removeAttribute('data-highlight-label');",
                        element
                );
            }

            // Label'ları temizle
            js.executeScript(
                    "var labels = document.querySelectorAll('div[style*=\"background: red\"]');" +
                            "labels.forEach(function(label) { label.parentNode.removeChild(label); });"
            );

        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void takeScreenshotWithHighlights(WebDriver driver, String fileName, Map<WebElement, String> elements) {
        try {
            // Tarayıcıyı maksimize et
            driver.manage().window().maximize();

            // Selenium screenshot al
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(screenshot);

            // Graphics2D için çevirim
            Graphics2D g2d = image.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            // Her element için sadece çerçeve çiz
            for (WebElement element : elements.keySet()) {
                Point location = element.getLocation();
                Dimension size = element.getSize();

                // Kırmızı çerçeve çiz
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawRect(location.getX(), location.getY(), size.getWidth(), size.getHeight());

                // Arkaplan highlight
                g2d.setColor(new Color(255, 0, 0, 30)); // Şeffaf kırmızı
                g2d.fillRect(location.getX(), location.getY(), size.getWidth(), size.getHeight());
            }

            g2d.dispose();

            // Dosyaya kaydet
            File outputFile = new File("C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\" + fileName + "_highlighted.png");
            FileUtils.forceMkdirParent(outputFile);
            ImageIO.write(image, "png", outputFile);

            System.out.println("Screenshot kaydedildi: " + outputFile.getAbsolutePath());

        } catch (Exception e) {
            System.out.println("Screenshot alınamadı: " + e.getMessage());
        }
    }
}
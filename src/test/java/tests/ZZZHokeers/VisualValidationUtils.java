package tests.ZZZHokeers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;
import java.util.HashMap;
import java.util.Map;

public class VisualValidationUtils {

    private static final ThreadLocal<Map<WebElement, String>> originalStyles = new ThreadLocal<>();

    /**
     * Web elementlerini belirli renklerle vurgular ve ekran görüntüsü alır
     * @param driver - Aktif WebDriver instance'ı
     * @param elementGroups - Gruplar halinde WebElement ve açıklama çiftleri
     * @return Screenshot dosya yolu
     */
    public static String highlightElementsAndTakeScreenshot(WebDriver driver, Object[][]... elementGroups) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            originalStyles.set(new HashMap<>());

            // 1. Element stillerini değiştir ve orijinallerini sakla
            for (Object[][] group : elementGroups) {
                for (Object[] elementWithDesc : group) {
                    WebElement element = (WebElement) elementWithDesc[0];
                    String description = (String) elementWithDesc[1];

                    originalStyles.get().put(element, element.getAttribute("style"));
                    js.executeScript(
                            "arguments[0].setAttribute('style', arguments[1]);",
                            element,
                            "border: 3px solid #FF0000; background-color: rgba(255,0,0,0.1);"
                    );
                }
            }

            // 2. Ekran görüntüsü al
            String screenshotPath = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE)
                    .getAbsolutePath();

            return screenshotPath;

        } finally {
            // 3. Orijinal stilleri geri yükle
            originalStyles.get().forEach((element, style) -> {
                if (element.isDisplayed()) {
                    ((JavascriptExecutor) driver).executeScript(
                            "arguments[0].setAttribute('style', arguments[1]);",
                            element,
                            style
                    );
                }
            });
            originalStyles.remove();
        }
    }

    /**
     * Element grupları arasına çizgi çizer
     * @param driver - Aktif WebDriver
     * @param color - HEX formatında renk kodu
     * @param elementPairs - Çizgiyle bağlanacak element çiftleri
     */
    public static void drawConnectingLines(WebDriver driver, String color, WebElement[]... elementPairs) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script =
                "var canvas = document.createElement('canvas');" +
                        "canvas.style.position='absolute';" +
                        "canvas.style.zIndex='9999';" +
                        "document.body.appendChild(canvas);" +
                        "var ctx = canvas.getContext('2d');" +
                        "ctx.strokeStyle = arguments[0];" +
                        "ctx.lineWidth = 2;";

        for (WebElement[] pair : elementPairs) {
            Point from = pair[0].getLocation();
            Point to = pair[1].getLocation();
            script += String.format(
                    "ctx.beginPath();" +
                            "ctx.moveTo(%d, %d);" +
                            "ctx.lineTo(%d, %d);" +
                            "ctx.stroke();",
                    from.getX(), from.getY(), to.getX(), to.getY()
            );
        }
        js.executeScript(script, color);
    }
}

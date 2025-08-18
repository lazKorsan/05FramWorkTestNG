package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class MultiScreenShootsMethods {

    private static final int RED_BORDER_THICKNESS = 5; // Kırmızı çerçevenin kalınlığı
    private static final int GREEN_CHECK_THICKNESS = 5; // Yeşil check işaretinin kalınlığı

    /**
     * Sayfa görüntüsü alır, URL ve QR kod ekler, WebElement'leri kırmızı çerçeve içinde,
     * farklı WebElement'lere ise yeşil check işareti koyar. Çıktıyı belirtilen yola png olarak kaydeder.
     *
     * @param driver WebDriver instance
     * @param url    Sayfanın URL'si
     * @param redBorderElements Kırmızı çerçeve için WebElement'ler (variadic)
     * @param greenCheckElements Yeşil check işareti için WebElement'ler (variadic)
     */
    public static void capturePageWithAnnotations(WebDriver driver,
                                                  String url,
                                                  WebElement[] redBorderElements,
                                                  WebElement[] greenCheckElements) {
        try {
            // Sayfanın tam ekran görüntüsünü al
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage fullImg = ImageIO.read(screenshotFile);

            Graphics2D graphics = fullImg.createGraphics();

            int imgWidth = fullImg.getWidth();
            int imgHeight = fullImg.getHeight();

            // Yazı ayarları - Sağ orta konum
            String urlText = url;

            Font font = new Font("Arial", Font.BOLD, 20);
            graphics.setFont(font);
            FontMetrics metrics = graphics.getFontMetrics(font);

            int textWidth = metrics.stringWidth(urlText);
            int textHeight = metrics.getHeight();

            // Sağ orta konumda URL yazısı
            int xText = imgWidth - textWidth - 30;
            int yText = imgHeight / 2;

            graphics.setColor(Color.BLACK);
            graphics.fillRect(xText - 10, yText - textHeight, textWidth + 20, textHeight + 10);

            graphics.setColor(Color.WHITE);
            graphics.drawString(urlText, xText, yText);

            // QR Kod oluşturma
            int qrSize = 150;
            BufferedImage qrImage = generateQRCodeImage(url, qrSize, qrSize);

            // QR Kod konumu - hemen URL yazısının altı (yText + 10 piksel boşluk)
            // ------------ QR Kod Konumu ------------
            int qrX = imgWidth - qrSize - 30;
            int qrY = yText + 10;
            // --------------------------------------

            graphics.drawImage(qrImage, qrX, qrY, null);

            // Kırmızı çerçeve çiz (kalınlığı RED_BORDER_THICKNESS)
            graphics.setColor(Color.RED);
            graphics.setStroke(new BasicStroke(RED_BORDER_THICKNESS));

            if (redBorderElements != null) {
                for (WebElement elem : redBorderElements) {
                    if (elem == null) continue;
                    Rectangle rect = getElementRect(elem, driver);
                    if (rect != null) {
                        graphics.drawRect(rect.x - RED_BORDER_THICKNESS / 2, rect.y - RED_BORDER_THICKNESS / 2,
                                rect.width + RED_BORDER_THICKNESS, rect.height + RED_BORDER_THICKNESS);
                    }
                }
            }

            // Yeşil check işareti çiz (kalınlığı GREEN_CHECK_THICKNESS)
            graphics.setColor(Color.GREEN);
            graphics.setStroke(new BasicStroke(GREEN_CHECK_THICKNESS));

            if (greenCheckElements != null) {
                for (WebElement elem : greenCheckElements) {
                    if (elem == null) continue;
                    Rectangle rect = getElementRect(elem, driver);
                    if (rect != null) {
                        // Check işaretinin konumu elementin altı
                        int checkStartX = rect.x + rect.width / 4;
                        int checkStartY = rect.y + rect.height + 10;
                        int checkMidX = checkStartX + rect.width / 6;
                        int checkMidY = checkStartY + rect.height / 6;
                        int checkEndX = checkStartX + rect.width / 2;
                        int checkEndY = checkStartY - rect.height / 6;

                        // Basit bir "✔" şekli çizimi
                        graphics.drawLine(checkStartX, checkStartY, checkMidX, checkMidY);
                        graphics.drawLine(checkMidX, checkMidY, checkEndX, checkEndY);
                    }
                }
            }

            graphics.dispose();

            // PNG olarak kaydetme
            String outputPath = "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\";
            String fileName = "Screenshot_" + System.currentTimeMillis() + ".png";
            ImageIO.write(fullImg, "png", new File(outputPath + fileName));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Rectangle getElementRect(WebElement elem, WebDriver driver) {
        try {
            // Sayfa kaydırma (element görünür kılmak için)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);

            Point loc = elem.getLocation();
            Dimension dim = elem.getSize();

            // Selenium koordinatlarının ekran görüntüsündeki piksel koordinatı ile uyumlu olduğunu varsayıyoruz
            return new Rectangle(loc.getX(), loc.getY(), dim.getWidth(), dim.getHeight());
        } catch (Exception e) {
            return null;
        }
    }

    private static BufferedImage generateQRCodeImage(String text, int width, int height) throws WriterException {
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    // Kullanım kolaylığı için variadic metodlar

    public static void getWebelementWithRedBorder(WebDriver driver, String url, WebElement... elements){
        capturePageWithAnnotations(driver, url, elements, null);
    }

    public static void getWebelementWithGreenLine(WebDriver driver, String url, WebElement... elements){
        capturePageWithAnnotations(driver, url, null, elements);
    }

    public static void getWebelementWithRedBorderAndGreenLine(WebDriver driver, String url,
                                                              WebElement[] redElements,
                                                              WebElement[] greenElements){
        capturePageWithAnnotations(driver, url, redElements, greenElements);
    }

}

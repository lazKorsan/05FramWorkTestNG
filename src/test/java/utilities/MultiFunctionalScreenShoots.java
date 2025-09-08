package utilities;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

public class MultiFunctionalScreenShoots {
    private static final int RED_BORDER_THICKNESS = 5; // Kırmızı çerçevenin kalınlığı
    private static final int GREEN_CHECK_THICKNESS = 5; // Yeşil check işaretinin kalınlığı

    /**
     * Sayfa görüntüsü alır, URL ve QR kod ekler, WebElement'leri kırmızı çerçeve içinde,
     * farklı WebElement'lere ise yeşil check işareti koyar. Çıktıyı belirtilen yola png olarak kaydeder.
     *
     * @param driver WebDriver instance
     * @param url    Sayfanın URL'si
     * @param greenCheckElementsWithNotes Kırmızı çerçeve için WebElement'ler (variadic)
     * @param redBorderElementsWithNotes Yeşil check işareti için WebElement'ler (variadic)
     */
    public static void capturePageWithAnnotations(WebDriver driver,
                                                  String url,
                                                  Object[][] redBorderElementsWithNotes,
                                                  Object[][] greenCheckElementsWithNotes) {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage fullImg = ImageIO.read(screenshotFile);
            Graphics2D graphics = fullImg.createGraphics();

            int imgWidth = fullImg.getWidth();
            int imgHeight = fullImg.getHeight();

            Font font = new Font("Arial", Font.BOLD, 16);
            graphics.setFont(font);
            FontMetrics metrics = graphics.getFontMetrics(font);

            // URL ve QR kod ekleme
            int textWidth = metrics.stringWidth(url);
            int textHeight = metrics.getHeight();
            int xText = imgWidth - textWidth - 30;
            int yText = imgHeight / 2;

            graphics.setColor(Color.BLACK);
            graphics.fillRect(xText - 10, yText - textHeight, textWidth + 20, textHeight + 10);
            graphics.setColor(Color.WHITE);
            graphics.drawString(url, xText, yText);

            BufferedImage qrImage = generateQRCodeImage(url, 150, 150);
            graphics.drawImage(qrImage, xText, yText + 10, null);

            // Kırmızı çerçeve ve açıklama
            graphics.setColor(Color.RED);
            graphics.setStroke(new BasicStroke(RED_BORDER_THICKNESS));
            if (redBorderElementsWithNotes != null) {
                for (Object[] pair : redBorderElementsWithNotes) {
                    WebElement elem = (WebElement) pair[0];
                    String note = (String) pair[1];
                    Rectangle rect = getElementRect(elem, driver);
                    if (rect != null) {
                        graphics.drawRect(rect.x - 2, rect.y - 2, rect.width + 4, rect.height + 4);
                        graphics.setColor(Color.BLACK);
                        graphics.fillRect(rect.x, rect.y + rect.height + 5, metrics.stringWidth(note) + 10, textHeight + 4);
                        graphics.setColor(Color.WHITE);
                        graphics.drawString(note, rect.x + 5, rect.y + rect.height + textHeight);
                        graphics.setColor(Color.RED);
                    }
                }
            }

            // Yeşil check ve açıklama
            graphics.setColor(Color.GREEN);
            graphics.setStroke(new BasicStroke(GREEN_CHECK_THICKNESS));
            if (greenCheckElementsWithNotes != null) {
                for (Object[] pair : greenCheckElementsWithNotes) {
                    WebElement elem = (WebElement) pair[0];
                    String note = (String) pair[1];
                    Rectangle rect = getElementRect(elem, driver);
                    if (rect != null) {
                        int x1 = rect.x + rect.width / 4;
                        int y1 = rect.y + rect.height + 10;
                        int x2 = x1 + rect.width / 6;
                        int y2 = y1 + rect.height / 6;
                        int x3 = x1 + rect.width / 2;
                        int y3 = y1 - rect.height / 6;

                        graphics.drawLine(x1, y1, x2, y2);
                        graphics.drawLine(x2, y2, x3, y3);

                        graphics.setColor(Color.BLACK);
                        graphics.fillRect(rect.x, rect.y + rect.height + 20, metrics.stringWidth(note) + 10, textHeight + 4);
                        graphics.setColor(Color.WHITE);
                        graphics.drawString(note, rect.x + 5, rect.y + rect.height + 20 + textHeight);
                        graphics.setColor(Color.GREEN);
                    }
                }
            }

            graphics.dispose();
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

    // public static void getWebelementWithRedBorder(WebDriver driver, String url, WebElement... elements){


}

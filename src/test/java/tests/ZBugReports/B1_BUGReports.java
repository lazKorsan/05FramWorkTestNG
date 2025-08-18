package tests.ZBugReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.ZRecylbin.hatali_GetWebElementScreenshots;
import utilities.GetWebElementScreenshots;

public class B1_BUGReports {
    @Test
    public void testElementHighlight() {

        String xpath = "//button[contains(text(),'Gönder')]";
        String screenshotPath = GetWebElementScreenshots.captureWebElementWithHighlight(xpath, "submit_button");

        if (screenshotPath != null) {
            System.out.println("Çerçeveli ekran görüntüsü: " + screenshotPath);
        } else {
            Assert.fail("Element ekran görüntüsü alınamadı!");
        }
    }
}

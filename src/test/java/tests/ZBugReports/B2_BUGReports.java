package tests.ZBugReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.ZRecylbin.WWWTakeScreenShootWithGreenLine;
import utilities.ConfigReader;
import utilities.Driver;

public class B2_BUGReports {
    @Test
    public void testSuccessWithCheckmark() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        String xpath = "//*[@class='btn_add']";
        String screenshotPath = WWWTakeScreenShootWithGreenLine.captureFullScreenWithGreenCheck(xpath, "success_validation");

        if (screenshotPath != null) {
            System.out.println("✓ Onay işaretli screenshot: " + screenshotPath);
        } else {
            Assert.fail("Screenshot alınamadı!");
        }
    }
}

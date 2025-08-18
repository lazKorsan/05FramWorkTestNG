package tests.ZBugReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.ZRecylbin.WWWTakeScreenShootWithGreenLine;

public class B2_BUGReports {
    @Test
    public void testSuccessWithCheckmark() {
        String xpath = "//button[@id='successButton']";
        String screenshotPath = WWWTakeScreenShootWithGreenLine.captureFullScreenWithGreenCheck(xpath, "success_validation");

        if (screenshotPath != null) {
            System.out.println("✓ Onay işaretli screenshot: " + screenshotPath);
        } else {
            Assert.fail("Screenshot alınamadı!");
        }
    }
}

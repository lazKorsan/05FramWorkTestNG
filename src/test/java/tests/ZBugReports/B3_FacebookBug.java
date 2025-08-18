package tests.ZBugReports;

import Pages.LFCPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.ZRecylbin.hatali_TakeScreenShootWithGreenLine;
import utilities.*;

public class B3_FacebookBug {
    @Test
    public void facebookBug(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages lfcPages = new LFCPages() ;
        ReusableMethods.scrollToBottom();

        WebElement facebookButton = Driver.getDriver().findElement(By.xpath("//*[@class='fab fa-facebook-square']")) ;
        String xpath = "//*[@class='fab fa-facebook-square']" ;
        String screenshotPath = GetWebElementScreenshots.captureWebElementWithHighlight(xpath,"youtube") ;

        if (screenshotPath != null) {
            System.out.println("Çerçeveli ekran görüntüsü: " + screenshotPath);
        } else {
            Assert.fail("Element ekran görüntüsü alınamadı!");
        }
    }
    @Test
    public void focebookWithGreenLine(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        LFCPages loyalfriendcarePages = new LFCPages();

      //  hatali_TakeScreenShootWithGreenLine.captureFullScreenWithGreenCheck(loyalfriendcarePages.homeButton,"doktor") ;



    }

    @Test
    public void cekimliSinif(){
        LFCPages loyalfriendcarePages = new LFCPages();
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        LFCPages loyalfriendcarePages1 = new LFCPages() ;
        
        hatali_TakeScreenShootWithGreenLine.captureFullScreenWithGreenCheck(loyalfriendcarePages.homeButton,"homeButton") ;





        //

    }
}

package tests.loyalfriendcare;

import Pages.LFCPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class X12_MedinePagesXpathTesti {
    @Test
    public void medicinePagesXPathTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc")) ;
        LFCPages lfcPages = new LFCPages() ;
        lfcPages.medicinesButton.click();

        WebElement rimadylButton = Driver.getDriver().findElement(By.xpath("(//*[@class='img-fluid'])[1]")) ;
        ReusableMethods.getWebElementScreenshot(rimadylButton,"rimadylButton");
        rimadylButton.click();
        ReusableMethods.takeFullPageScreenshot("1rimadylButton");
        Driver.getDriver().navigate().back();

        WebElement revolutionButton = Driver.getDriver().findElement(By.xpath("(//*[@class='img-fluid'])[2]")) ;
        ReusableMethods.getWebElementScreenshot(revolutionButton,"revolutionButton");
        revolutionButton.click();
        ReusableMethods.takeFullPageScreenshot("2revolutionButton");
        Driver.getDriver().navigate().back();

        WebElement baytrilButton = Driver.getDriver().findElement(By.xpath("(//*[@class='img-fluid'])[3]")) ;
        ReusableMethods.getWebElementScreenshot(baytrilButton,"baytrilButton");
        baytrilButton.click();
        ReusableMethods.takeFullPageScreenshot("3revolutionButton");
        Driver.getDriver().navigate().back();

        WebElement apoquelButton = Driver.getDriver().findElement(By.xpath("(//*[@class='img-fluid'])[4]")) ;
        ReusableMethods.getWebElementScreenshot(apoquelButton,"apoquelButton");
        apoquelButton.click();
        ReusableMethods.takeFullPageScreenshot("4apoquelButton");
        Driver.getDriver().navigate().back();


        ReusableMethods.scrollToBottom();
        WebElement metacamButton = Driver.getDriver().findElement(By.xpath("(//*[@class='img-fluid'])[5]")) ;
        ReusableMethods.getWebElementScreenshot(metacamButton,"metacamButton");
        metacamButton.click();
        ReusableMethods.takeFullPageScreenshot("5metacamButton");
        Driver.getDriver().navigate().back();

        WebElement tobramycinOphthalmicButton = Driver.getDriver().findElement(By.xpath("(//*[@class='img-fluid'])[6]")) ;
        ReusableMethods.getWebElementScreenshot(tobramycinOphthalmicButton,"tobramycinOphthalmicButton");
        tobramycinOphthalmicButton.click();
        ReusableMethods.takeFullPageScreenshot("6tobramycinOphthalmicButton");
        Driver.getDriver().navigate().back();

        Driver.quitDriver();

    }
}

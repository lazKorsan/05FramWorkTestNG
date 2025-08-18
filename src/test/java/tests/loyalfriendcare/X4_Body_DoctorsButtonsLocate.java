package tests.loyalfriendcare;

import Pages.LFCPages;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.XPathGenerator;

public class X4_Body_DoctorsButtonsLocate {

    @Test
    public void doctorsButtonsLocaters(){

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        LFCPages lfcPages = new LFCPages();

        ReusableMethods.getWebElementScreenshot(lfcPages.DrAlejandroMartinezButton,"DrAlejandroMartinezButton");
        lfcPages.DrAlejandroMartinezButton.click();

        //ReusableMethods.bekle(2);
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(lfcPages.DrMarcusRodriguezButton,"DrMarcusRodriguezButton");
        lfcPages.DrMarcusRodriguezButton.click();
        //ReusableMethods.bekle(2);
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(lfcPages.DrOliviaBennettButton,"DrOliviaBennettButton");
        lfcPages.DrOliviaBennettButton.click();
        //ReusableMethods.bekle(2);
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(lfcPages.DrEmilyChangButton,"DrEmilyChangButton");
        lfcPages.DrEmilyChangButton.click();
        //ReusableMethods.bekle(2);
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(lfcPages.DrNathanPatelButton,"DrNathanPatelButton");
        lfcPages.DrNathanPatelButton.click();
        //ReusableMethods.bekle(5);
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(lfcPages.DrIsabellaWongButton,"DrIsabellaWongButton");
        lfcPages.DrIsabellaWongButton.click();
        //ReusableMethods.bekle(5);
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(lfcPages.DrLiamOConnerButton,"DrLiamOConnerButton");
        lfcPages.DrLiamOConnerButton.click();
        //ReusableMethods.bekle(5);
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(lfcPages.DrSophiaKimButton,"DrSophiaKimButton");
        lfcPages.DrSophiaKimButton.click();
        //ReusableMethods.bekle(5);
        Driver.getDriver().navigate().back();


        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,300)");
        ReusableMethods.bekle(4);
        ReusableMethods.getWebElementScreenshot(lfcPages.MrAliButton,"MrAliButton");
        XPathGenerator.printXpathFormulas(lfcPages.MrAliButton);
        lfcPages.MrAliButton.click();
        ReusableMethods.bekle(5);
        Driver.getDriver().navigate().back();

        Driver.quitDriver();
    }

}

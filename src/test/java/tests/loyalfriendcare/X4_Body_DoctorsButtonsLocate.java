package tests.loyalfriendcare;

import Pages.HeaderPages;
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

        HeaderPages headerPages = new HeaderPages();

        ReusableMethods.getWebElementScreenshot(headerPages.DrAlejandroMartinezButton,"DrAlejandroMartinezButton");
        headerPages.DrAlejandroMartinezButton.click();

        //ReusableMethods.bekle(2);
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(headerPages.DrMarcusRodriguezButton,"DrMarcusRodriguezButton");
        headerPages.DrMarcusRodriguezButton.click();
        //ReusableMethods.bekle(2);
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(headerPages.DrOliviaBennettButton,"DrOliviaBennettButton");
        headerPages.DrOliviaBennettButton.click();
        //ReusableMethods.bekle(2);
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(headerPages.DrEmilyChangButton,"DrEmilyChangButton");
        headerPages.DrEmilyChangButton.click();
        //ReusableMethods.bekle(2);
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(headerPages.DrNathanPatelButton,"DrNathanPatelButton");
        headerPages.DrNathanPatelButton.click();
        //ReusableMethods.bekle(5);
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(headerPages.DrIsabellaWongButton,"DrIsabellaWongButton");
        headerPages.DrIsabellaWongButton.click();
        //ReusableMethods.bekle(5);
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(headerPages.DrLiamOConnerButton,"DrLiamOConnerButton");
        headerPages.DrLiamOConnerButton.click();
        //ReusableMethods.bekle(5);
        Driver.getDriver().navigate().back();

        ReusableMethods.getWebElementScreenshot(headerPages.DrSophiaKimButton,"DrSophiaKimButton");
        headerPages.DrSophiaKimButton.click();
        //ReusableMethods.bekle(5);
        Driver.getDriver().navigate().back();


        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,300)");
        ReusableMethods.bekle(4);
        ReusableMethods.getWebElementScreenshot(headerPages.MrAliButton,"MrAliButton");
        XPathGenerator.printXpathFormulas(headerPages.MrAliButton);
        headerPages.MrAliButton.click();
        ReusableMethods.bekle(5);
        Driver.getDriver().navigate().back();

        Driver.quitDriver();
    }

}

package tests.loyalfriendcare;

import Pages.HeaderPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class X11_DoctorsPageXpath {

    @Test
    public void doctorspageXpathTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        HeaderPages headerPages = new HeaderPages() ;

        headerPages.doctorsButton.click();

        WebElement drAlejandroMartinezButton =Driver.getDriver().findElement(By.xpath("(//img[@class='img-fluid'])[1]")) ;
        ReusableMethods.getWebElementScreenshot(drAlejandroMartinezButton,"drAlejandroMartinezButton");



        WebElement drMarcusRodriguezButton = Driver.getDriver().findElement(By.xpath("(//img[@class='img-fluid'])[2]")) ;
        ReusableMethods.getWebElementScreenshot(drMarcusRodriguezButton,"drMarcusRodriguezButton");

        WebElement drOliviaBennettButton = Driver.getDriver().findElement(By.xpath("(//img[@class='img-fluid'])[3]")) ;
        ReusableMethods.getWebElementScreenshot(drOliviaBennettButton,"drOliviaBennettButton");

        WebElement drEmilyChangButton = Driver.getDriver().findElement(By.xpath("(//img[@class='img-fluid'])[4]")) ;
        ReusableMethods.getWebElementScreenshot(drEmilyChangButton,"drEmilyChangButton");

        WebElement drNathanPatelButton = Driver.getDriver().findElement(By.xpath("(//img[@class='img-fluid'])[5]")) ;
        ReusableMethods.getWebElementScreenshot(drNathanPatelButton,"drNathanPatelButton");

        WebElement drIsabellaWongButton = Driver.getDriver().findElement(By.xpath("(//img[@class='img-fluid'])[6]")) ;
        ReusableMethods.getWebElementScreenshot(drIsabellaWongButton,"drIsabellaWongButton");

        WebElement drLiamOConnorButton = Driver.getDriver().findElement(By.xpath("(//img[@class='img-fluid'])[7]")) ;
        ReusableMethods.getWebElementScreenshot(drLiamOConnorButton,"drLiamOConnorButton");

        WebElement drSophiaKimButtonButton = Driver.getDriver().findElement(By.xpath("(//img[@class='img-fluid'])[8]")) ;
        ReusableMethods.getWebElementScreenshot(drSophiaKimButtonButton,"drSophiaKimButtonButton");

        WebElement drMrALiButtonButton = Driver.getDriver().findElement(By.xpath("(//img[@class='img-fluid'])[9]")) ;
        ReusableMethods.getWebElementScreenshot(drMrALiButtonButton,"drMrALiButtonButton");

    }
}

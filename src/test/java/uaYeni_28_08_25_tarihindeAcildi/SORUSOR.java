package uaYeni_28_08_25_tarihindeAcildi;

import Pages.AdminPages;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRaporInLine;

public class SORUSOR extends TestBaseRaporInLine {

    AdminPages adminPages = new AdminPages();

    @Test
    public void TC_01(){

        extentTest = extentReports.createTest("POZİTİF TEST",
                "Geçerli bilgilerle sisteme giriş test edilir");

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        // test adımları

        Driver.quitDriver();


    }

    @Test
    public void TC_02() {

        extentTest = extentReports.createTest("vvvvvv TEST",
                "Geçerli bilgilerle sisteme giriş test edilir");

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        // test adımları

        Driver.quitDriver();

    }


    @Test
    public void TC_03() {

        extentTest = extentReports.createTest("aaaaa TEST",
                "Geçerli bilgilerle sisteme giriş test edilir");

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        // test adımları

        Driver.quitDriver();

    }




























}

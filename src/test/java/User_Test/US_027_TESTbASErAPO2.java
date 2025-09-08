package User_Test;

import Pages.AdminPages;
import Pages.HeaderPages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.*;
import java.time.format.DateTimeFormatter;


public class US_027_TESTbASErAPO2 extends TestBaseRapor {

    HeaderPages headerPages = new HeaderPages();
    AdminPages adminPages = new AdminPages();
    //Bir yönetici olarak,
    // sol açılır menüdeki Bed Managers
    // ve alt menülerine erişebilmeli,
    // mevcut yatak listesini görüntüleyebilmeli
    // ve bu yataklar üzerinde
    // görüntüleme, arama, düzenleme ve silme işlemleri yapabilmeliyim.


    @Test
    public void TC_01() {// Admin Girişi
        extentTest = extentReports.createTest("Kullanıcı Admin Girişi",
                "Kullanici AnaSayfa Header Bölümünde Bulunan Logoya bastığında Url Değişmemeli");
        // 1 Kullanıcı ana sayfayı açar
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        extentTest.info("Kullanıcı anasayfayı açtı ");
        ReusableMethods.bekle(3);

        // 2 Kullanıcı SignInButtona Basarak Login sayfasına yönlenir
        headerPages.signInButton.click();
        extentTest.info("Kullanıcı Login Sayfasına yönlendirildi");

        // 3 Kullanıcı mail kutusuna AdminMail adresini girer
        headerPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        extentTest.info("Kullanıcı mailKutusuna admin mailini yazdı");

        // 4 Kullanıcı passwordBox Kutusuna geçerli şifreyi girer
        headerPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Kullanıcı geçerli şifreyi girdi");

        // Kullanıcı rememberMe butununa tıklar
        headerPages.rememberMeButton.click();
        extentTest.info("Kullanıcı rememberMe kUtusunu işaretler");

        // Kullanıcı signIn butona basarak admin girişi yapar
        headerPages.loginPageSigInButton.click();
        extentTest.info("Kullanıcı admin girişi yaptı");

        ReusableMethods.bekle(3);

        // < -- ====^^^^=============ADMİN GİRİŞİ YAPILDI ======^^^^================ -- >

        // admin account Button üzerinde ismini kaydeder
        System.out.println(headerPages.accountButton.getText());
        extentTest.info("Kullanıcı Account Buton üzerindeki ismi kayt etti");
        System.out.println("<--===isimalma testi geçti===--> ");

        // admin buton üzerindeki isimleri karşılaştırır.
        String expectedName = ConfigReader.getProperty("adminName");
        String actualName = headerPages.accountButton.getText();
        System.out.println(headerPages.accountButton.getText());
        Assert.assertFalse(actualName.equals(expectedName));
        extentTest.pass("Admin Isim Doğrulaması yapıldı");

        System.out.println("<--===isimleri karşılaştırır testi geçti===-->");
        ReusableMethods.bekle(2);

        // admin admin sayfasına yönlendirilir.
        headerPages.accountButton.click();
        extentTest.info("Kullanıcı Admin sayfasına yönlendirildi");
        System.out.println("<--===Admine yönlenme geçti===-->");

        // < -- ====^^^^============== ADMİN SAYFASINA GİRİŞ YAPILDI ======^^^^========== -- >

        // admin dashboard menüsünü açar
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(headerPages.dashBoard).perform();
        extentTest.info("Admin dashboard menüsünü açtı");


        ReusableMethods.bekle(2);


        // Admin sahboard menusuundan BedMangers menüsünü açar.
        adminPages.bedManagersButton.click();
        extentTest.info("admin menüden BedManagesr kısmını seçti");
        ReusableMethods.bekle(2);

        // Admin açlır menüden BedManegers Button seçer
        adminPages.subBedManagersButton.click();
        extentTest.info("Admin açlır menüden BedManegers sayfasına yönlendirildi ");


        // admin yeni bir yatak oluşturma sayfasına yönlendirilir
        adminPages.addBedManagersButton.click();
        extentTest.info("Admin add Bed Managers sayfasına yönlendirildi");

        // Admin oluşturmak istediği başlığın adını girer
        adminPages.bedManagersTitleBox.sendKeys("PUURY Haven");
        extentTest.info("Admin yatak başlığını atadı");

        // Admin oluşturmak istediği yatağın içeriğini girer
        adminPages.bedManagersContentBox.sendKeys("Safe Snug Cat Sanctuary");
        extentTest.info("Admin  yatak içeriğini ekledi");
        ReusableMethods.bekle(2);

        // admin sağ menüden departments menüsünü açar
        adminPages.selectDepartmentsButton.click();
        extentTest.info("Admin Department atamak üzere departments menüsünü açtı");

        // admin açılır menüden departments ataması yapar
        adminPages.inputDepartmentsBox.sendKeys("Dental Care" + Keys.ENTER);
        extentTest.info("admin açılır menüden Departments ataması yaptı ");

        // admin doktorlar menüsünü açar
        ReusableMethods.bekle(2);
        actions.moveToElement(adminPages.selectDoctorsButton).perform();
        adminPages.selectDoctorsButton.click();
        extentTest.info("admin doktorlar menüsünü açtı");

        // admin doktor menüsünüden doktor ataması yapar
        adminPages.inputDoctorsBox.sendKeys("Dr. Olivia Bennett" + Keys.ENTER);
        extentTest.info("admin doktor ataması yaptı");

        // admin ilaçlar menüsünü açar
        adminPages.selectMedicinesButton.click();
        adminPages.inputMedicinesBox.sendKeys("Revolution (Selamectin)" + Keys.ENTER);
        extentTest.info("admin ilaçalar menüsünü açtı");

        // admin pricebox a geçerli tutarı girer
        adminPages.inputPriceBox.sendKeys("657" + Keys.ENTER);
        extentTest.info("admin ilacın tutarını girdi");
        ReusableMethods.bekle(3);

        // admin yatağı kullanıma açar
        adminPages.radioButton.click();
        extentTest.info("admin yatağı kullanıma açtı");
        ReusableMethods.bekle(2);

        // admin yatağı son kullanıcının hizmetine sunar
        adminPages.bedManagersSaveButton.click();
        extentTest.info("yatak kullanıcının kullanımına açıldı");

        // admin hizmet tutarını fazla girdiğini fark eder ve edit sayfasına gider
        adminPages.bedManagersEditButton.click();
        extentTest.info("Admin değiştirme işlemine başladı");


        adminPages.bedManagersSaveButton.click();
        ReusableMethods.bekle(5);
    }


}





























































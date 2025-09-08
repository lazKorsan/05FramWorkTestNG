package User_Test;

import Pages.AdminPages;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_037 {
    AdminPages adminPages = new AdminPages();
    //Bir yönetici olarak,
    // sol açılır menüdeki Ads Section ve alt menülerine erişebilmeli,
    // mevcut reklam listesini görüntüleyebilmeli ve
    // bu reklamlar üzerinde görüntüleme, arama, düzenleme ve
    // silme işlemleri yapabilmeliyim.

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        AdminPages adminPages = new AdminPages() ;
        adminPages.signInButton.click();

        adminPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        adminPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminPages.loginPageSignInButton.click();
        ReusableMethods.bekle(2);


    }
    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }

    @Test
    public void TC_01() {
        // before method ile admin girişi yapılmıştır
        // driver açıkta ve bekliyor.
        // consruct class seviyesinde verildi
        // admin giriş yolu dbpages ile destekleniyor

        // 1 Kullanıcı ana sayfa accountButtona tıklar
        adminPages.accountButton.click();

        // Admin dashBoard Pages açar
        adminPages.dashBoard.click();

        // menu seçeneklerinden Pet AdSense seçeneğini tıklar
        adminPages.petsAdsenseButton.click();

        // açılır menüden PetAdSense seçeneğine tıklar
        adminPages.subPetAdsenseButton.click();

        // açılan menude product size almak için
        ReusableMethods.printProductsInCategory(Driver.getDriver(),
                "https://qa.loyalfriendcare.com/en/Dashboard/AdSense",
                "//td[@class='v-align-middle semi-bold sorting_1']");
        // adminPage de Reklamı düzenlemek için
        adminPages.editButton.click();


        ReusableMethods.bekle(12);

    }
    @Test
    public void TC_02(){
        // 1 kullanıcı methodla giriş yapmıştır.

        // 2 admim accountButtona tıklar ve adminPage ulaşır
        adminPages.accountButton.click();

        // 3 dashboard menüsünden adSense alt menuden adsense seçeneğini tıklar

        adminPages.dashBoard.click();


    }
}

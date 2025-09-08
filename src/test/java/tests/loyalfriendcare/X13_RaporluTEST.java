package tests.loyalfriendcare;

import Pages.AdminPages;
import Pages.HeaderPages;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRaporInLine; // Yeni base class'ımızı import ediyoruz

public class X13_RaporluTEST extends TestBaseRaporInLine {
    HeaderPages headerPages = new HeaderPages();
    AdminPages adminPages = new AdminPages();

    @Test(priority = 1)
    public void TC_01_AnaSayfaYukleme() {
        extentTest = extentReports.createTest("TC_01 - Ana Sayfa Yükleme Testi",
                "Loyal Friend Care ana sayfasının başarılı şekilde yüklenmesi kontrol edilir.");

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        ReusableMethods.bekle(5);

        // Ana sayfanın yüklendiğini doğrula
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Loyal Friend Care") ||
                Driver.getDriver().getCurrentUrl().contains("lfc"));
        extentTest.pass("Ana sayfa başarılı şekilde yüklendi: " + Driver.getDriver().getCurrentUrl());
    }

    @Test(priority = 2)
    public void TC_02_SignInButonaTiklama() {
        extentTest = extentReports.createTest("TC_02 - Sign In Butonuna Tıklama",
                "Sign In butonunun görünür olması ve tıklanabilir olması kontrol edilir.");

        Assert.assertTrue(headerPages.signInButton.isDisplayed(), "Sign In butonu görünür değil");
        Assert.assertTrue(headerPages.signInButton.isEnabled(), "Sign In butonu tıklanabilir değil");

        headerPages.signInButton.click();
        ReusableMethods.bekle(5);

        extentTest.pass("Sign In butonuna başarılı şekilde tıklandı");
    }

    @Test(priority = 3)
    public void TC_03_EmailGirisi() {
        extentTest = extentReports.createTest("TC_03 - Email Girişi",
                "Email alanına geçerli email adresinin girilmesi kontrol edilir.");

        Assert.assertTrue(adminPages.mailBox.isDisplayed(), "Email kutusu görünür değil");
        Assert.assertTrue(adminPages.mailBox.isEnabled(), "Email kutusu etkin değil");

        String userMail = ConfigReader.getProperty("userMail");
        adminPages.mailBox.sendKeys(userMail);
        ReusableMethods.bekle(5);

        Assert.assertEquals(adminPages.mailBox.getAttribute("value"), userMail, "Email doğru girilemedi");
        extentTest.pass("Email başarılı şekilde girildi: " + userMail);
    }

    @Test(priority = 4)
    public void TC_04_PasswordGirisi() {
        extentTest = extentReports.createTest("TC_04 - Password Girişi",
                "Password alanına geçerli şifrenin girilmesi kontrol edilir.");

        Assert.assertTrue(adminPages.passwordBox.isDisplayed(), "Password kutusu görünür değil");
        Assert.assertTrue(adminPages.passwordBox.isEnabled(), "Password kutusu etkin değil");

        String userPassword = ConfigReader.getProperty("userPassword");
        adminPages.passwordBox.sendKeys(userPassword);
        ReusableMethods.bekle(5);

        Assert.assertFalse(adminPages.passwordBox.getAttribute("value").isEmpty(), "Password girilemedi");
        extentTest.pass("Password başarılı şekilde girildi");
    }

    @Test(priority = 5)
    public void TC_05_RememberMeSecimi() {
        extentTest = extentReports.createTest("TC_05 - Remember Me Seçimi",
                "Remember Me checkbox'ının seçilmesi kontrol edilir.");

        Assert.assertTrue(adminPages.rememberMeButton.isDisplayed(), "Remember Me butonu görünür değil");
        Assert.assertTrue(adminPages.rememberMeButton.isEnabled(), "Remember Me butonu etkin değil");

        boolean initialState = adminPages.rememberMeButton.isSelected();
        adminPages.rememberMeButton.click();
        ReusableMethods.bekle(5);

        Assert.assertNotEquals(adminPages.rememberMeButton.isSelected(), initialState,
                "Remember Me durumu değişmedi");
        extentTest.pass("Remember Me butonu başarılı şekilde " +
                (adminPages.rememberMeButton.isSelected() ? "seçildi" : "kaldırıldı"));
    }

    @Test(priority = 6)
    public void TC_06_LoginButonaTiklama() {
        extentTest = extentReports.createTest("TC_06 - Login Butonuna Tıklama",
                "Login butonuna tıklanarak giriş işleminin tamamlanması kontrol edilir.");

        Assert.assertTrue(adminPages.loginPageSignInButton.isDisplayed(), "Login butonu görünür değil");
        Assert.assertTrue(adminPages.loginPageSignInButton.isEnabled(), "Login butonu tıklanabilir değil");

        adminPages.loginPageSignInButton.click();
        ReusableMethods.bekle(5);

        extentTest.pass("Login butonuna başarılı şekilde tıklandı");
    }

    @Test(priority = 7)
    public void TC_07_MedicinesSayfasinaGitme() {
        extentTest = extentReports.createTest("TC_07 - Medicines Sayfasına Gitme",
                "Giriş sonrası Medicines sayfasına yönlendirme kontrol edilir.");

        Assert.assertTrue(headerPages.medicinesButton.isDisplayed(), "Medicines butonu görünür değil");
        Assert.assertTrue(headerPages.medicinesButton.isEnabled(), "Medicines butonu tıklanabilir değil");

        headerPages.medicinesButton.click();
        ReusableMethods.bekle(3);

        extentTest.pass("Medicines sayfasına başarılı şekilde gidildi");
    }
}
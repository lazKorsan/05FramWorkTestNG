package uaYeni_28_08_25_tarihindeAcildi;

import Pages.AdminPages;
import Pages.HeaderPages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class regresyonTesti extends TestBaseRaporInLine { // REGRESYON TESTİ admin page searchBox arama testi
    // testin hikayesi : Developer a admim sayfasında ki bölümlere girildiğinde
    // searchBox ta arama yapılamadığı bildirildi.
    // Devoleper bunu BUG olarak aldı
    // Hatanın giderildiği test edilir
    // %%%qr %%red %%%border

    AdminPages adminPages = new AdminPages();
    HeaderPages headerPages = new HeaderPages();
    Actions actions = new Actions(Driver.getDriver());
    @BeforeClass
    public void setUp(){

        // KK =  KAYITLI KULLANICI

        extentTest = extentReports.createTest("Kullanıcı Admin Girişi",
                "KK Admin ayarlarını setUp eder");

        // KK admin ayarları bölümü

        // 1 Driver setUp edilir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("KK ana sayfayı açar ");
        ReusableMethods.bekle(1);

        displayProgressBanner( // banner ekranda 5 saniye kalır .Bekleten sonrasındaki "bekle" %%%banner
                Driver.getDriver(),
                "1 SERACHBOX ARAMA TESTİ BAŞLIYOR ",
        "TC_01",
        "Login Sayfasına yönlendirilme "
        );
        ReusableMethods.bekle(6);

        // 2 KK  login sayfasına gider

        adminPages.signInButton.click();
        extentTest.info("KK login sayfasina gitti");
        ReusableMethods.bekle(1);

        // BANNER BANNER 2
        displayProgressBanner(
                Driver.getDriver(),
                "2 KULLANICI OTURUMU AÇIILIYOR   ",
                " TC_01 ",
                "Sayfaya başarılı bir şekilde giriş yapabilme "
        );ReusableMethods.bekle(6);

        // 3 KK geçerli mail adresini girer
        adminPages.mailBox.sendKeys(ConfigReader.getProperty("adm"));
        ReusableMethods.bekle(1);
        extentTest.info("KK geçerli mail adresini girdi");

        // 4 KK geçeli şifreyi girer
        adminPages.passwordBox.sendKeys(ConfigReader.getProperty("adp"));
        ReusableMethods.bekle(1);
        extentTest.info("KK geçerli şifreyi girdi");

        // KK sisteme giriş yapar
        adminPages.loginPageSignInButton.click();
        extentTest.info("KK kimlik bilgileri girildi");

        extentTest.pass("KK kullanıcı başarılı bir şekilde giriş yaptı ");

    }

    @Test

    public void TC_01(){
        extentTest = extentReports.createTest("SEARCHBOX ARAMA TESTİ ",
                "KK Control paneline gidiş yapabilmeli  ");

        // Kullanıcı ana sayfada

        ReusableMethods.bekle(1);



        // 1 Admin sayfasına gider
        adminPages.accountButton.click();
        extentTest.info("KK admin sayfasına gitti");
        ReusableMethods.bekle(3);

        // BANNER BANNER
        displayProgressBanner(
                Driver.getDriver(),
                "3 ADMİN SAYFASINDAYIZ   ",
                " TC_01 ",
                "Admin sayfasına başarılı bir şekilde giriş yapabilme  "
        );ReusableMethods.bekle(6);

        // Yönetim konsolunu açar
        actions.moveToElement(headerPages.dashBoard).perform();
        extentTest.info("KK yönetim konsolunu açar") ;

        displayProgressBanner(
                Driver.getDriver(),
                "KONTROL PANELİNDEN BEDMANAGERS SAYFASINA GİDİYORUZ",
                " TC_01 ",
                "Kontrol panelinden BedManagera geçmek  "
        );ReusableMethods.bekle(6);

        // BedManagers bölümünün seçer
        adminPages.bedManagersButton.click();
        extentTest.info("BedMangers bölümünü seçti") ;

        // dropDown menüden BedManagers linkini seçer
        adminPages.subBedManagersButton.click();
        extentTest.info("BedManagers sayfasına gitti");

        // BANNER BANNNER
        displayProgressBanner(
                Driver.getDriver(),
                "4 ARAMA TESTİ BAŞLIYOR   ",
                " TC_01 ",
                "BedManagers bölümünde yatak listesini görebilmek "
        );ReusableMethods.bekle(6);

         // aranacak kelime girilir
        adminPages.bedManagersSearchBox.sendKeys("Vaccinations");
        ReusableMethods.bekle(6);
        extentTest.info("aranacak urun girildi");

        // ARAMA SONUÇLARINI ALMAK İÇİN List<WebElement> ProductListCount Locate edildi
        // bu locate urun title na karşılık gelir
        System.out.println("WebTablo List<WebElements> locate ");
        List<WebElement> ProductListCount =
                Driver.getDriver().
                        findElements(By.xpath("//tr[@role='row' and contains(@class, 'odd')]/td[2]"));


        // arama sonucu bulunan urunların listesi consala yazdırılır
        System.out.println(ProductListCount );
        extentTest.info("Kullanıcı arama sonucunu kayt etti ");

        // aranan urun sayısına ProductSize atanır
        int urunSayisi = ProductListCount.size();
        extentTest.info("arama sonucu urun sayısı kayt edildi ");

        // doğrulama için consola yazdırılır
        System.out.println(urunSayisi );

        // eger arama sonucu urun sayısı birden buyukse
        // urunun imajı, title  ve departments bölümlerinin
        // screenshot alınır

        if(urunSayisi>0){
            // bu method görevi %%%qr kod ile screen shot almaktır
            MultiFunctionalScreenShoots.capturePageWithAnnotations(
                    Driver.getDriver(),
                    ConfigReader.getProperty("lfc"),
                    new Object[][]{
                            {adminPages.urunImage, "Aranan Urun"},
                            {adminPages.urunTitle, "Urun Arama Sonucu"},
                            {adminPages.departmentsTitle, "hangi departmana ait"},
                            {adminPages.bedManagersSearchBox, "aranan urun"}
                    },
                    new Object[][]{ // istenirse new obje ile altı yeşil çizili element eklenebilir
                                    // formülü red kısmında olduğu gibi
                                   // hatta else bloğunun içinde kullanılabilir
                           // {},
                           // {},
                           // {},
                    }

            );


        }else System.out.println("arama sonucu urun bulunamadı");

        extentTest.info("urun arama sonucu başarılı ");


        // BANNER BANNNER
        displayProgressBanner(
                Driver.getDriver(),
                "           5 URUN ARAMA TESTİ BAŞARILI                  ",
                " TC_01 ",
                "BedManagers bölümünde yatak listesini görebilmek "
        );ReusableMethods.bekle(6);

        // admin sayfası profile menusunden logout yapar ana sayfaya yönlenir
        adminPages.profileButton.click();
        adminPages.logOutButton.click();

        // signOut tuşuna basarak sistemden güvenli bir şekilde çıkar

         // BANNER BANNER
        displayProgressBanner(
                Driver.getDriver(),
                "           7     OTURUM SONLANDIRILIYOR                   ",
                " TC_01 ",
                "BedManagers bölümünde yatak listesini görebilmek "
        );ReusableMethods.bekle(6);

        // signOut tuşuna basarak sistemden güvenli bir şekilde çıkar

        adminPages.signOutButton.click();

        displayProgressBanner(
                Driver.getDriver(),
                "          TEŞEKKÜR EDERİZ                    ",
                " TC_01 ",
                "BedManagers bölümünde yatak listesini görebilmek "
        );

        extentTest.pass("Urun arama testi sonucu başarılı");

        // arama sonucu başarılı
        ReusableMethods.bekle(5);

    }

    //


    //WebElement StockInfoRow = Driver.getDriver().findElement(By.xpath("//tr[@class='odd']"));

    //WebElement urunImage = Driver.getDriver().findElement(By.xpath("(//td[@class='v-align-middle semi-bold sorting_1'])[1]"));
    //WebElement urunTitle = Driver.getDriver().findElement(By.xpath("//td[@class='v-align-middle semi-bold']"));
    //WebElement departmentsTitle = Driver.getDriver().findElement(By.xpath("(//td[@class='v-align-middle'])"));



































































    //<--===========================================-->
    public static void displayDynamicBanner(WebDriver driver, String bannerType,
                                            String mainTitle, String testName,
                                            String testDescription, int duration) {
        displayConsoleBanner(bannerType, mainTitle, testName, testDescription);
        displayBrowserBanner(driver, bannerType, mainTitle, testName, testDescription, duration);
    }

    /**
     * 🎯 Hızlı kullanım için overload method
     */
    public static void displayAdminTestBanner(WebDriver driver, String testName, String testDescription) {
        displayDynamicBanner(driver, "start", "ADMIN TESTİ BAŞLIYOR", testName, testDescription, 5000);
    }

    /**
     * 🎯 Test ilerleyişi için banner
     */
    public static void displayProgressBanner(WebDriver driver, String progressTitle, String testName, String stepDescription) {
        displayDynamicBanner(driver, "progress", progressTitle, testName, stepDescription, 5000); // EKRANDA NE KADAR KALACAĞINI AYARLA
    }

    /**
     * 🎯 Başarı banner'ı
     */
    public static void displaySuccessBanner(WebDriver driver, String successTitle, String testName) {
        displayDynamicBanner(driver, "success", successTitle, testName, "Test başarıyla tamamlandı", 4000);
    }

    /**
     * 🎯 Konsol banner'ı
     */
    private static void displayConsoleBanner(String bannerType, String mainTitle, String testName, String testDescription) {
        String icon = getBannerIcon(bannerType);
        String colorCode = getBannerColorCode(bannerType);

        String banner =
                "\n" + colorCode +
                        "==================================================\n" +
                        "               " + icon + " " + mainTitle + " \n" +
                        "==================================================\n" +
                        "⏰ Zaman: " + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date()) + "\n" +
                        "🎯 Test: " + testName + "\n" +
                        "📝 Durum: " + testDescription + "\n" +
                        "🌐 URL: " + ConfigReader.getProperty("lfc") + "\n" +
                        "==================================================\n" +
                        "\u001B[0m"; // Reset color

        System.out.println(banner);
    }

    /**
     * 🎯 Tarayıcı banner'ı
     */
    private static void displayBrowserBanner(WebDriver driver, String bannerType,
                                             String mainTitle, String testName,
                                             String testDescription, int duration) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            String[] colors = getBannerColors(bannerType);
            String icon = getBannerIcon(bannerType);

            String script =
                    "// Önceki banner'ı temizle\n" +
                            "var oldBanner = document.getElementById('dynamicTestBanner');\n" +
                            "if (oldBanner) { oldBanner.remove(); }\n" +
                            "\n" +
                            "// Yeni banner oluştur\n" +
                            "var banner = document.createElement('div');\n" +
                            "banner.id = 'dynamicTestBanner';\n" +
                            "banner.style.position = 'fixed';\n" +
                            "banner.style.left = '50%';\n" +
                            "banner.style.top = '50%';\n" +
                            "banner.style.transform = 'translate(-50%, -50%)';\n" +
                            "banner.style.background = 'linear-gradient(135deg, ' + arguments[0] + ')';\n" +
                            "banner.style.color = 'white';\n" +
                            "banner.style.padding = '20px';\n" +
                            "banner.style.borderRadius = '15px';\n" +
                            "banner.style.zIndex = '9999';\n" +
                            "banner.style.boxShadow = '0 10px 30px rgba(0,0,0,0.3)';\n" +
                            "banner.style.fontFamily = 'Arial, sans-serif';\n" +
                            "banner.style.textAlign = 'center';\n" +
                            "banner.style.minWidth = '350px';\n" +
                            "banner.style.border = '3px solid ' + arguments[1];\n" +
                            "banner.style.animation = 'fadeIn 0.5s ease-in';\n" +
                            "\n" +
                            "// İçerik\n" +
                            "banner.innerHTML = '' +\n" +
                            "    '<div style=\"font-size: 28px; margin-bottom: 10px;\">' + arguments[2] + '</div>' +\n" +
                            "    '<h3 style=\"margin: 0 0 15px 0; font-size: 20px; font-weight: bold;\">' + arguments[3] + '</h3>' +\n" +
                            "    '<div style=\"font-size: 14px; margin-bottom: 8px; background: rgba(255,255,255,0.1); padding: 5px; border-radius: 5px;\"><strong>Test:</strong> ' + arguments[4] + '</div>' +\n" +
                            "    '<div style=\"font-size: 14px; margin-bottom: 8px;\"><strong>Açıklama:</strong> ' + arguments[5] + '</div>' +\n" +
                            "    '<div style=\"font-size: 11px; opacity: 0.8; margin-top: 15px; border-top: 1px solid rgba(255,255,255,0.2); padding-top: 10px;\">' + new Date().toLocaleString() + '</div>' +\n" +
                            "    '<div style=\"font-size: 10px; opacity: 0.6; margin-top: 5px;\">' + arguments[6] + ' ms sonra kapanacak...</div>';\n" +
                            "\n" +
                            "// CSS animation ekle\n" +
                            "var style = document.createElement('style');\n" +
                            "style.innerHTML = '@keyframes fadeIn { from { opacity: 0; transform: translate(-50%, -60%); } to { opacity: 1; transform: translate(-50%, -50%); } }';\n" +
                            "document.head.appendChild(style);\n" +
                            "\n" +
                            "// Sayfaya ekle\n" +
                            "document.body.appendChild(banner);\n" +
                            "\n" +
                            "// Belirtilen süre sonra kaldır\n" +
                            "setTimeout(function() {\n" +
                            "    banner.style.animation = 'fadeOut 0.5s ease-out';\n" +
                            "    setTimeout(function() { \n" +
                            "        if (banner.parentNode) { \n" +
                            "            banner.parentNode.removeChild(banner); \n" +
                            "        }\n" +
                            "    }, 500);\n" +
                            "}, arguments[6]);\n" +
                            "\n" +
                            "// Fade out animation için CSS\n" +
                            "var fadeOutStyle = document.createElement('style');\n" +
                            "fadeOutStyle.innerHTML = '@keyframes fadeOut { from { opacity: 1; transform: translate(-50%, -50%); } to { opacity: 0; transform: translate(-50%, -60%); } }';\n" +
                            "document.head.appendChild(fadeOutStyle);";

            js.executeScript(script, colors[0], colors[1], icon, mainTitle, testName, testDescription, duration);

        } catch (Exception e) {
            System.out.println("⚠️ Browser banner gösterilemedi: " + e.getMessage());
        }
    }

    /**
     * 🎯 Banner tipine göre icon belirle
     */
    private static String getBannerIcon(String bannerType) {
        switch (bannerType.toLowerCase()) {
            case "start": return "🚀";
            case "progress": return "⏳";
            case "success": return "✅";
            case "warning": return "⚠️";
            case "error": return "❌";
            default: return "🎯";
        }
    }

    /**
     * 🎯 Banner tipine göre renk belirle
     */
    private static String[] getBannerColors(String bannerType) {
        switch (bannerType.toLowerCase()) {
            case "start": return new String[]{"#667eea 0%, #764ba2 100%", "#ff6b6b"};
            case "progress": return new String[]{"#f093fb 0%, #f5576c 100%", "#ffd93d"};
            case "success": return new String[]{"#4facfe 0%, #00f2fe 100%", "#00b894"};
            case "warning": return new String[]{"#ff9a9e 0%, #fad0c4 100%", "#fdcb6e"};
            case "error": return new String[]{"#ff5858 0%, #f09819 100%", "#d63031"};
            default: return new String[]{"#667eea 0%, #764ba2 100%", "#ff6b6b"};
        }
    }

    /**
     * 🎯 Konsol renk kodu
     */
    private static String getBannerColorCode(String bannerType) {
        switch (bannerType.toLowerCase()) {
            case "start": return "\u001B[35m"; // Purple
            case "progress": return "\u001B[33m"; // Yellow
            case "success": return "\u001B[32m"; // Green
            case "warning": return "\u001B[33m"; // Yellow
            case "error": return "\u001B[31m"; // Red
            default: return "\u001B[36m"; // Cyan
        }
    }


}

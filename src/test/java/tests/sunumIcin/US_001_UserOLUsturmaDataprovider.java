package tests.sunumIcin;

import Pages.AdminPages;
import Pages.HeaderPages;
import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.*;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class US_001_UserOLUsturmaDataprovider extends TestBaseRaporInLine {
    AdminPages adminPages = new AdminPages();
    HeaderPages headerPages = new HeaderPages();
    private static String generatedName;
    private static String generatedMail;
    private static String generatedPassword;
    private static String generatedComfirmPassword;
    private int testCount = 1;


    @DataProvider
    public static Object[][] KullaniciProvider() {
        Faker faker = new Faker();
        // 2 defa kullanılacak hesap bilgileri create edilir
        String generatedName = faker.lorem().characters(12);
        String generatedMail = generatedName + "@gmail.com";
        String generatedPassword = faker.lorem().characters(12) + "1Zz.";
        String generatedComfirmPassword = generatedPassword;
        // data provider içine Faker calss implament edilir

        String name = faker.lorem().characters(12);
        String mail = name + "@gmail.com";
        String password = faker.lorem().characters(12) + "1Zz.";
        String comfirmPassword = password;
        return new Object[][]{
                //1nci otorum
                {faker.lorem().characters(12),
                        faker.lorem().characters(12) + "@gmail.com",
                        password,
                        comfirmPassword,
                        "1nci Oturum Başladı"
                },
                //2nci otorum
                {
                        generatedName, generatedMail, generatedPassword, generatedComfirmPassword, "2. nci oturumBaşladı"
                },
                // 3ncü oturum
                {
                        faker.lorem().characters(11),
                        faker.lorem().characters(12) + "@gmail",
                        password,
                        comfirmPassword,
                        "3ncü Oturum Başladı"
                },
                // 4ncü otorum
                {
                        generatedName, generatedMail, generatedPassword, generatedComfirmPassword, "4ncü Oturum Başladı"
                },

        };
    }


    @Test(dataProvider = "KullaniciProvider")
    public void TC_01(String userName, String mail, String passWord, String comfirmPassword ,String TestName) {

        // rapor oluşturuldu
        extentTest = extentReports.createTest("Kullanıcı" + userName + " Oluşturma Testi",
                "Kullanici AnaSayfa Header Bölümünde Bulunan Logoya bastığında Url Değişmemeli");

        // ANA SAYFA AÇILIR
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("anasayfa açıldı");

        // BANNER BANNER1
        ReusableMethods.bekle(2);
        displayProgressBanner(
                Driver.getDriver(),
                TestName + "OTURUM BAŞLIYOR",
                "Test Koşuluyor",
                "Kullanıcı adı ve şifre giriliyor"
        ); ReusableMethods.bekle(6);



        // kULLANICI LOGİN SAYFASINA YÖNLENİR
        adminPages.signUpButton.click();
        ReusableMethods.bekle(7);
        extentTest.info("kULLANICI LOGİN SAYFASINDA");


        //BANNER BANNER 2
        ReusableMethods.bekle(2);
        displayProgressBanner(
                Driver.getDriver(),
                "2 KULLANICI BİLGİLERİ GİRİLİYOR",
                TestName,
                "Kullanıcı adı ve şifre giriliyor"
        ); ReusableMethods.bekle(6);



        // Kullanıcı adı girilir
        adminPages.userNameBox.sendKeys(userName);
        ReusableMethods.bekle(2);
        extentTest.info("Kullanıcı adını girdi");

        // mail adresi girilir
        adminPages.mailBox.sendKeys(mail);
        ReusableMethods.bekle(2);
        extentTest.info("Kullanıcı mail adresini girdi");

        // şifre girilir
        adminPages.passwordBox.sendKeys(passWord);
        ReusableMethods.bekle(2);
        extentTest.info("kullanıcı şifresini girdi");

        // şifre doğrulaması yapılır
        adminPages.confirmPasswordBox.sendKeys(comfirmPassword);
        ReusableMethods.bekle(2);
        extentTest.info("kullanıcı şifre doğrulaması yaptı");


        //BANNER BANNER 3
        ReusableMethods.bekle(2);
        displayProgressBanner(
                Driver.getDriver(),
                "3 KULLANICI SİSTEME GİRİŞ YAPIYOR",
                TestName,
                "Kullanıcı adı ve şifre giriliyor"
        );ReusableMethods.bekle(6);


        // kayıt tuşuna basılır
        adminPages.registerButton.click();

        // < -- ================================================================== -- >

        if (adminPages.accountButton.isDisplayed()) {


        //BANNER BANNER 4
        ReusableMethods.bekle(2);
        displayProgressBanner(
                Driver.getDriver(),
                "4 KAYIT BAŞARILI İSİM KARŞILAŞTIRMASI YAPILIYOR ",
                TestName,
                "isim  karşılaştırması yapılıyor"
        );ReusableMethods.bekle(6);


        extentTest.info("Kullanıcı kayıt tuşuna bastı");
        extentTest.pass("BAŞARI İLE YENİ KULLANICI OLUŞTURULDU");

        // doğru isim karşılaştırması yapılır
        String expectedUserName = userName; // buradaki userName testteki isimden geliyor
        // satır 84

        Assert.assertTrue(adminPages.accountButton.getText().equals(userName),
                "Kullanıcı oluşturma hatası ");
        extentTest.info("kullanıcı kayıtta girdiği isimle sistem ismini eşleitridi");

        //BANNER BANNER 5
        ReusableMethods.bekle(2);
        displayProgressBanner(
                Driver.getDriver(),
                "5 KULLANICI ÇIKIŞ YAPIYOR  ",
                TestName,
                "Çıkış işlemlerini yapabilme "
        );
        ReusableMethods.bekle(6);

        // Kullanıcı başarılı bir şekilde çıkış yapar
        adminPages.signOutButton.click();
        extentTest.info("Kullanıcı başarılı bir şekilde sayfadan ayrıldı");
        ReusableMethods.bekle(2);
        displayProgressBanner(
                Driver.getDriver(),
                "OTURUM SONLANDI",
                userName + " OTURUM BAŞARILI",
                "durumu aktif"
        );ReusableMethods.bekle(6);

    } else{

            ReusableMethods.bekle(2);
            displayProgressBanner(
                    Driver.getDriver(),
                    "AYNI BİLGİLERLE KULLANACI OLUŞTURULAMADI",
                    userName + " OTURUM BAŞARILI",
                    "durumu aktif"
            );ReusableMethods.bekle(6);

            Driver.quitDriver();











        }



        ExcelWriter.writeTestData(
                testCount++, // Sınıf değişkeni: private int testCount = 1;
                userName,
                mail,
                passWord,
                comfirmPassword
        );




    }




    public class ExcelWriter {
        private static int rowNum = 0;
        private static final String FILE_PATH = "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\userList.xlsx";

        public static void writeTestData(int testNo, String userName,
                                         String mail, String password,
                                         String confirmPassword) {
            try {
                // Klasör kontrolü ve oluşturma
                File directory = new File(FILE_PATH).getParentFile();
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                Workbook workbook;
                Sheet sheet;
                File file = new File(FILE_PATH);

                if (file.exists()) {
                    workbook = WorkbookFactory.create(file);
                    sheet = workbook.getSheet("TestData");
                    rowNum = sheet.getLastRowNum() + 1;
                } else {
                    workbook = new XSSFWorkbook();
                    sheet = workbook.createSheet("TestData");
                    createHeaderRow(sheet);
                }

                // Veri satırı oluşturma
                Row dataRow = sheet.createRow(rowNum++);
                dataRow.createCell(0).setCellValue(testNo);
                dataRow.createCell(1).setCellValue(userName);
                dataRow.createCell(2).setCellValue(mail);
                dataRow.createCell(3).setCellValue(password);
                dataRow.createCell(4).setCellValue(confirmPassword);

                // Dosyaya yazma
                try (FileOutputStream outputStream = new FileOutputStream(file)) {
                    workbook.write(outputStream);
                }
                workbook.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static void createHeaderRow(Sheet sheet) {
            Row headerRow = sheet.createRow(rowNum++);
            headerRow.createCell(0).setCellValue("TestNo");
            headerRow.createCell(1).setCellValue("userName");
            headerRow.createCell(2).setCellValue("MailADresi");
            headerRow.createCell(3).setCellValue("password");
            headerRow.createCell(4).setCellValue("comfirmPassword");
        }
    }


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
        displayDynamicBanner(driver, "progress", progressTitle, testName, stepDescription, 3000);
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

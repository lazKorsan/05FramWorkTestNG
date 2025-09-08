package tests.ZZZHokeers;

import Pages.AdminPages;
import Pages.HeaderPages;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


public class totalHookers extends TestBaseRapor {
    HeaderPages headerPages = new HeaderPages();
    HeaderPages loyalfriendcarePages = new HeaderPages();

    @Test
    public void hooker() { // US_004 hookers
        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/Medicines/tobramycin-ophthalmic");


        WebElement aramaSonucElementYazisi = Driver.getDriver().findElement(By.xpath("//h1[i[@class='fas fa-capsules']]"));
        // en sağlam xpath   ****** //h1[i[@class='fas fa-capsules']]
        // //h1[contains(@class,'product-title')]

        // css selector   section#description h1    *****Sağlam
        // xpath   //div[@class='detail_title_1']/preceding-sibling::h1
        // css  figure + h1   *****SAĞLAM ALIYOR
        // ikon kombinasyonu   //h1[i[@class='fas fa-capsules']]

        // Dinamik Metinlerde: //h1[contains(@class,'product-title')] -----başarısız
        // Relational Locators:  //div[contains(@class,'margin_60_35')]//h1
        XPathGenerator.printXpathFormulas(aramaSonucElementYazisi);

        System.out.println(aramaSonucElementYazisi.getText());


        ReusableMethods.bekle(5);
        Driver.quitDriver();


    }

    @Test
    public void hookerx5() { //X5hookers
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        HeaderPages loyalfriendcarePages = new HeaderPages();

        loyalfriendcarePages.bodyvaccinationsButton.click();

        WebElement bedDepartments = Driver.getDriver().findElement(By.xpath("//*[@id=\"page\"]/main/div[2]/div[3]/div/a/figure/img"));
        XPathGenerator.printXpathFormulas(bedDepartments);
        bedDepartments.click();
        Driver.getDriver().navigate().back();

        Driver.quitDriver();
    }

    @Test
    public void hookerx8() {
        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/about");


        WebElement budgetVetCareBtn = Driver.getDriver().findElement(By.xpath("//*[@class='fas fa-money-check-alt']"));
        budgetVetCareBtn.click();
        ReusableMethods.takeFullPageScreenshot("4");
        Driver.getDriver().navigate().back();

        // <--
        WebElement petShelterButton = Driver.getDriver().findElement(By.xpath("//*[@class='fas fa-dog']"));
        ReusableMethods.getWebElementScreenshot(
                petShelterButton, "petShelterButton"
                        + LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        petShelterButton.click();
        Driver.getDriver().navigate().back();

        // <--

        WebElement certifiedVetButton = Driver.getDriver().findElement(By.xpath("//*[@class='fas fa-certificate']"));
        ReusableMethods.getWebElementScreenshot(
                certifiedVetButton,
                "certifiedVetButton"
                        + LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        certifiedVetButton.click();
        Driver.getDriver().navigate().back();

        // <--    One-Stop Nutrition Shop

        WebElement nutritionShop = Driver.getDriver().findElement(By.xpath("//*[@class='fas fa-paw']"));
        ReusableMethods.getWebElementScreenshot(
                nutritionShop,
                "nutritionShop" + LocalDate.now().format(DateTimeFormatter.ISO_DATE)
        );
        nutritionShop.click();
        Driver.getDriver().navigate().back();


//Driver.quitDriver();
    }

    @Test
    public void hookerx9() {
        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/Contact");


        WebElement dateButton = Driver.getDriver().findElement(By.xpath("//*[@id='Date']"));
        //XPathGenerator.printXpathFormulas(dateButton);

        WebElement phone = Driver.getDriver().findElement(By.xpath("//*[@placeholder='Phone Number']"));
        //XPathGenerator.printXpathFormulas(phone);

        WebElement departmentButton = Driver.getDriver().findElement(By.xpath("//*[@name='category_id']"));
        //XPathGenerator.printXpathFormulas(departmentButton);

        WebElement doctorsButton = Driver.getDriver().findElement(By.xpath("//*[@class='nice-select wide']"));
        //XPathGenerator.printXpathFormulas(doctorsButton);

        WebElement messageBox = Driver.getDriver().findElement(By.xpath("//*[@placeholder='Create Message']"));
        //XPathGenerator.printXpathFormulas(messageBox);

        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//*[@value='Submit']"));
        XPathGenerator.printXpathFormulas(submitButton);


        Driver.quitDriver();
    }

    @Test
    public void hookersus03() {
        ExtentTest extentTest = extentReports.createTest("Header Butonlarının Tıklama ve Başlık Testleri",
                "Kullanici AnaSayfa Header Bölümünde Bulunan Butonlara Basa bilmeli ve ilgili sayfaya gidebilmeli ");
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        HeaderPages loyalfriendcarePages = new HeaderPages();
        loyalfriendcarePages.doctorsButton.click();
        //System.out.println(loyalfriendcarePages.titleContainer.getText().trim()) ;
        String expectedTitle = "Doctors";
        String actualTitle = loyalfriendcarePages.titleContainer.getText().trim();
        softAssert.assertEquals(actualTitle, expectedTitle, "drgeasfa");
        extentTest.pass("sgsrgsrgtvsrbvsvergeaagaer");


        softAssert.assertAll();

    }

    @Test
    public void hookerUs_0002_c() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        HeaderPages loyalfriendcarePages = new HeaderPages();
        loyalfriendcarePages.signInButton.click();
    }

    @Test
    public void hookerUS_002_F() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        HeaderPages loyalfriendcarePages = new HeaderPages();
        XPathGenerator.printXpathFormulas(loyalfriendcarePages.signUpButton);

    }

    @Test
    public void hookers08() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        HeaderPages loyalfriendcarePages = new HeaderPages();
        loyalfriendcarePages.signInButton.click();
        loyalfriendcarePages.mailBox.sendKeys("user.ahmet@loyalfriendcare.com");
        loyalfriendcarePages.passwordBox.sendKeys("LFCare.0201");
        ReusableMethods.bekle(4);
        loyalfriendcarePages.loginPageSigInButton.click();
    }

    @Test
    public void configliGiris() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        HeaderPages loyalfriendcarePages = new HeaderPages();
        loyalfriendcarePages.signInButton.click();
        loyalfriendcarePages.mailBox.sendKeys(ConfigReader.getProperty("userMail"));
        loyalfriendcarePages.passwordBox.sendKeys("userPassword");
        ReusableMethods.bekle(4);
        loyalfriendcarePages.loginPageSigInButton.click();

    }

    @Test
    public void loginPageLocaters() {

        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/login");

        WebElement rememberMeButtons = Driver.getDriver().findElement(By.xpath("(//div[@class='checkbox'])"));
        //XPathGenerator.printXpathFormulas(rememberMeButtons);
        rememberMeButtons.click();

        ReusableMethods.bekle(5);

    }

    @Test
    public void loginPageLocaters2() {
        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/login");
        ReusableMethods.bekle(2);
        WebElement forgotPasswordButton = Driver.getDriver().findElement(By.xpath("//*[@class='text-info small']"));
        forgotPasswordButton.click();
    }

    @Test
    public void passwordReserPageLocaters() { // pswrdReset
        Driver.getDriver().get(ConfigReader.getProperty("pswrdReset"));
        // WebElement passwordResetPageLoginButton = Driver.getDriver().findElement(By.xpath("(//*[@class='nav-link'])[1]")) ;
        // passwordResetPageLoginButton.click();
        //  ReusableMethods.bekle(3);
        //  Driver.getDriver().navigate().back();
        //   ReusableMethods.bekle(2);

        //   WebElement passwordResetPageRegisterButton = Driver.getDriver().findElement(By.xpath("(//*[@class='nav-link'])[2]")) ;
        //    passwordResetPageRegisterButton.click();
        //    Driver.getDriver().navigate().back();

        loyalfriendcarePages.mailBox.sendKeys("sdfgg@honoluluexpresi.com");

        WebElement sendPassWordLinkButton = Driver.getDriver().findElement(By.xpath("//*[@type='submit']"));
        sendPassWordLinkButton.click();


    }

    @Test
    public void forgotpasswordPageslogoButtonTesti() {
        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/password/reset");
    }

    @Test
    public void searchBoxTest() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        HeaderPages headerPages = new HeaderPages();
        headerPages.searchBox.sendKeys("vaccination");
    }

    @Test
    public void buttonkookers() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        HeaderPages headerPages = new HeaderPages();
        TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(headerPages.logoButton, "logobutton");


    }

    @Test
    public void homebuttonerhookers() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        HeaderPages headerPages = new HeaderPages();
        WebElement homeButton = Driver.getDriver().findElement(By.xpath("//a[text()='Home']"));
        XPathGenerator.printXpathFormulas(homeButton);
        TakeScreenShotsWithRedSquare.captureScreenshotWithRedBorder(homeButton, "HOMEBUTTON");


    }

    @Test
    public void logovehomebuttonlar() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        XPathGenerator.printXpathFormulas(headerPages.aboutUsButton);

        headerPages.aboutUsButton.click();

    }

    @Test
    public void signOutButton() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        WebElement siGNoUTnbUTTON = Driver.getDriver().findElement(By.xpath("(//a[@class='btn_add'])[2]"));
        siGNoUTnbUTTON.click();

        Driver.getDriver().navigate().back();
        headerPages.signUpButton.click();
    }

    @Test
    public void loginSayfasi() {


        Driver.getDriver().get("https://qa.loyalfriendcare.com");


        // Highlight edilecek elementlerin map'i
        Map<String, By> elementsToHighlight = new HashMap<>();
        elementsToHighlight.put("logoButton", By.xpath("//*[@class='logo_normal']"));
        elementsToHighlight.put("homeButton", By.xpath("(//a[@href='https://qa.loyalfriendcare.com'])[5]"));
        elementsToHighlight.put("aboutUsButton", By.xpath("(//a[@href='https://qa.loyalfriendcare.com/about'])[2]"));
        elementsToHighlight.put("departmentsButton", By.xpath("(//a[@href='https://qa.loyalfriendcare.com/Departments'])[3]"));
        elementsToHighlight.put("doctorsButton", By.xpath("(//a[@href='https://qa.loyalfriendcare.com/Doctors'])[3]"));
        elementsToHighlight.put("medicinesButton", By.xpath("(//a[@href='https://qa.loyalfriendcare.com/Medicines'])[2]"));
        elementsToHighlight.put("vaccinationsButton", By.xpath("(//a[@href='https://qa.loyalfriendcare.com/Pets'])[3]"));
        elementsToHighlight.put("signUpButton", By.xpath("(//a[@class='btn_add'])[1]"));
        elementsToHighlight.put("signInButton", By.xpath("(//a[@class='btn_add'])[2]"));
        // Tüm elementleri highlight et ve screenshot al
        PageElementHighlighter.highlightAndCaptureElements(
                Driver.getDriver(),
                elementsToHighlight,
                "homepage_elements"
        );

        // Normal test işlemlerine devam et...
    }

    @Test
    public void log() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        headerPages.signInButton.click();


        // Highlight edilecek elementlerin map'i
        Map<String, By> elementsToHighlight = new HashMap<>();
        // elementsToHighlight.put("emailBox", By.xpath("//*[@id=\"email\"]"));
        // elementsToHighlight.put("passwordBox", By.xpath("//*[@id=\"password\"]"));
        //  elementsToHighlight.put("submitButton", By.xpath("/html/body/div/div[2]/div/form/button"));
        elementsToHighlight.put("rememberMeButton", By.xpath("(//div[@class='checkbox'])"));
        elementsToHighlight.put("forgotPasswordButton", By.xpath("//*[@class='text-info small']"));

        // Tüm elementleri highlight et ve screenshot al
        PageElementHighlighter.highlightAndCaptureElements(
                Driver.getDriver(),
                elementsToHighlight,
                "homepage_elements"
        );

        // Normal test işlemlerine devam et...
    }

    @Test
    public void register() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        headerPages.signUpButton.click();

        Map<String, By> elementsToHighlight = new HashMap<>();
        //elementsToHighlight.put("userNameBox", By.xpath("//*[@id=\"name\"]"));
        //  elementsToHighlight.put("emailBox", By.xpath("//*[@id=\"email\"]"));
        //   elementsToHighlight.put("passwordBox", By.xpath("//*[@id=\"password\"]"));
        //   elementsToHighlight.put("confirmPasswordBox", By.xpath("//*[@id=\"password-confirm\"]"));
        elementsToHighlight.put("submitButton", By.xpath("/html/body/div/div[2]/div/form/button"));

        PageElementHighlighter.highlightAndCaptureElements(
                Driver.getDriver(),
                elementsToHighlight,
                "homepage_elements"
        );


    }

    @Test
    public void serchBoxTesti() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        Map<String, By> elementsToHighlight = new HashMap<>();
        elementsToHighlight.put("searchBox", By.xpath("//input[@type='text']"));
        elementsToHighlight.put("searchButton", By.xpath("//input[@value='Search']"));

        PageElementHighlighter.highlightAndCaptureElements(
                Driver.getDriver(),
                elementsToHighlight,
                "homepage_elements"
        );


    }

    @Test
    public void accountButton() {

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        headerPages.signInButton.click();
        headerPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        headerPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        headerPages.registerButton.click();

        Map<String, By> elementsToHighlight = new HashMap<>();
        elementsToHighlight.put("accountButton", By.xpath("(//a[@class='btn_add'])[1]"));
        elementsToHighlight.put("signOutButton", By.xpath("(//a[@class='btn_add'])[2]"));

        PageElementHighlighter.highlightAndCaptureElements(
                Driver.getDriver(),
                elementsToHighlight,
                "homepage_elements_account"
        );


    }

    @Test
    public void popUpGecme() {

        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/password/reset");


        headerPages.mailBox.sendKeys("user.ahmet@loyalfriendcare.com");

        headerPages.sendPassWordLinkButton.click();


        ReusableMethods.bekle(2);


        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = Driver.getDriver().switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert metni: " + alertText);
            alert.accept(); // veya alert.dismiss();
        } catch (Exception e) {
            System.out.println("Alert bulunamadı: " + e.getMessage());
        }

        String expectedAlertText = "Password reset link has been sent to your email";

    }

    @Test
    public void popUpIyilestirme() {  // şifre sıfırlanamadığını test etmek-FAİLED

        extentTest = extentReports.createTest("Şifre Sıfırlama Testi",
                "Kullanıcı Şifresini sıfırlayabilmeli ");


        // 1 şifre sıfırlama sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        headerPages.signInButton.click();
        headerPages.forgotPasswordButton.click();
        extentTest.info("Kullanıcı şifre sıfırlama sayfasına gider");

        // 2 Geçerli mail adresi için Şifre Sıfırlama linkini test edin
        headerPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        extentTest.info("Kullanıcı geçerli mail adresi girer ");
        headerPages.sendPassWordLinkButton.click();

        String expectedAlertText = "Password reset link has been sent to your email";

        // çıkan PopUp Menüden text alma adımları
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(1));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = Driver.getDriver().switchTo().alert();
        String actualAlertText = alert.getText();
        System.out.println("Alert metni: " + actualAlertText);
        alert.accept(); // veya alert.dismiss();

        Assert.assertTrue(actualAlertText.equals(expectedAlertText), "şifre sıfırlama maili gönderilmedi ");
        extentTest.pass("Şifre sıfırlama linki ile şifrenin sıfırlandığını test eder");

    }

    @Test
    public void popUpIyilestirme2() {
        extentTest = extentReports.createTest("Şifre Sıfırlama Testi",
                "Kullanıcı Şifresini sıfırlayamadığını doğrular - Beklenen: FAIL");

        try {
            // 1 şifre sıfırlama sayfasına gidin
            Driver.getDriver().get(ConfigReader.getProperty("lfc"));
            headerPages.signInButton.click();
            headerPages.forgotPasswordButton.click();
            extentTest.info("Kullanıcı şifre sıfırlama sayfasına gider");

            // 2 Geçerli mail adresi için Şifre Sıfırlama linkini test edin
            headerPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
            extentTest.info("Kullanıcı geçerli mail adresi girer ");
            headerPages.sendPassWordLinkButton.click();

            String expectedAlertText = "Password reset link has been sent to your email";

            // Bekleme süresini artır ve alert kontrolü
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = Driver.getDriver().switchTo().alert();
            String actualAlertText = alert.getText();
            System.out.println("Alert metni: " + actualAlertText);

            // Testin FAIL olması bekleniyor, bu yüzden assertFalse kullan
            Assert.assertFalse(actualAlertText.equals(expectedAlertText),
                    "Şifre sıfırlama maili gönderildi, ancak beklenen FAIL'di");

            alert.accept();
            extentTest.fail("Test başarısız oldu - Beklenen davranış: Şifre sıfırlanamadı");

        } catch (TimeoutException e) {
            // Alert gelmezse bu da bir başarısızlık durumu
            extentTest.fail("Alert zaman aşımına uğradı - Şifre sıfırlama işlemi çalışmıyor");
            Assert.fail("Alert görüntülenmedi - TimeoutException");
        } catch (Exception e) {
            extentTest.fail("Beklenmeyen hata: " + e.getMessage());
            Assert.fail("Test exception aldı: " + e.getMessage());
        }
    }

    @Test
    public void popUpIyilestirme3() {
        extentTest = extentReports.createTest("Şifre Sıfırlama Testi",
                "Kullanıcı Şifresini sıfırlayamadığını doğrular");

        try {
            // Sayfa yükleme
            Driver.getDriver().get(ConfigReader.getProperty("lfc"));
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

            // Elementlerin tıklanabilir olmasını bekle
            wait.until(ExpectedConditions.elementToBeClickable(headerPages.signInButton)).click();
            wait.until(ExpectedConditions.elementToBeClickable(headerPages.forgotPasswordButton)).click();

            extentTest.info("Şifre sıfırlama sayfasına yönlendirildi");

            // Mail gönderme işlemi
            wait.until(ExpectedConditions.visibilityOf(headerPages.mailBox))
                    .sendKeys(ConfigReader.getProperty("adminMail"));
            extentTest.info("Geçerli mail adresi girildi");

            headerPages.sendPassWordLinkButton.click();

            // Alert kontrolü - 5 saniye bekle
            try {
                wait.until(ExpectedConditions.alertIsPresent());
                Alert alert = Driver.getDriver().switchTo().alert();
                String actualAlertText = alert.getText();

                // Test FAIL olması gerektiği için başarılı olmamalı
                Assert.assertNotEquals("Password reset link has been sent to your email",
                        actualAlertText, "Şifre sıfırlama beklenmedik şekilde çalıştı");

                alert.accept();
                extentTest.fail("Şifre sıfırlama işlemi çalıştı - Beklenen: FAIL");

            } catch (TimeoutException e) {
                extentTest.pass("Şifre sıfırlama işlemi çalışmadı - Beklenen davranış");
                // Burada test başarılı olmalı çünkü beklenen FAIL
            }

        } catch (Exception e) {
            extentTest.fail("Test hatası: " + e.getMessage());
            Assert.fail("Test exception aldı: " + e.getMessage());
        }
    }

    @Test
    public void sifreSifirlamaTesti() {
        extentTest = extentReports.createTest("Şifre Sıfırlama Testi",
                "Kullanıcı şifre sıfırlama işleminin başarısız olması test edilir - Beklenen: FAIL");

        SoftAssert softAssert = new SoftAssert();


        // 1. Ana sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        extentTest.info("Ana sayfa başarıyla yüklendi");

        // 2. Sign In butonuna tıkla
        headerPages.signInButton.click();
        extentTest.info("Sign In butonuna tıklandı");

        // 3. Forgot Password butonuna tıkla
        headerPages.forgotPasswordButton.click();
        extentTest.info("Forgot Password butonuna tıklandı");

        // 4. Sayfanın şifre sıfırlama sayfasına yönlendirildiğini doğrula
        String currentUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("reset"),
                "Şifre sıfırlama sayfasına yönlendirilemedi. Mevcut URL: " + currentUrl);
        extentTest.pass("Şifre sıfırlama sayfasına yönlendirildi: " + currentUrl);

        // 5. Mail adresini girin
        headerPages.mailBox.sendKeys(ConfigReader.getProperty("userMail"));
        extentTest.info("Geçerli mail adresi girildi: " + ConfigReader.getProperty("userMail"));

        // 6. Send Link butonuna tıklayın
        headerPages.sendPassWordLinkButton.click();
        extentTest.info("Send Link butonuna tıklandı");

        // 7. Alert yazısının içeriğini test edin
        String expectedAlertText = "Password reset link has been sent to your email"; // çıkan PopUp Menüden text alma adımları
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(1));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = Driver.getDriver().switchTo().alert();
        String actualAlertText = alert.getText();
        System.out.println("Alert metni: " + actualAlertText);
        alert.accept();

        Assert.assertTrue(actualAlertText.equals(expectedAlertText), "şifre sıfırlama maili gönderilmedi ");
        extentTest.pass("Şifre sıfırlama linki ile şifrenin sıfırlandığını test eder");

    }

    @Test
    public void sifresifirlamagecer() {
        extentTest = extentReports.createTest("Şifre Sıfırlama Testi",
                "Kullanıcı Şifresini sıfırlayamadığını doğrular");


        // 1 Kayıtlı Kullanıcı ana Sayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        extentTest.info("Anasayfa Başarı ile yüklendi ");

        // 2 Kullanıcı Login Sayfasına gider
        wait.until(ExpectedConditions.elementToBeClickable(headerPages.signInButton)).click();
        extentTest.info("Kullanıcı Login Sayfasına yönlendirildi ");

        // 3 Kullanıcı Şifre sıfırlama sayfasına yönlendirilir
        wait.until(ExpectedConditions.elementToBeClickable(headerPages.forgotPasswordButton)).click();
        extentTest.info("Kullanıcı Şifre sıfırlama sayfasına yönlendirildi");

        // 4 Kullanıcı Mail Adresini gönderir
        wait.until(ExpectedConditions.visibilityOf(headerPages.mailBox))
                .sendKeys(ConfigReader.getProperty("userMail"));
        extentTest.info("Geçerli mail adresi girildi");

        // 5 Şifre sıfırlama linkine tıklar
        headerPages.sendPassWordLinkButton.click();
        extentTest.info("şifre sıfırlama Linkine tılandı");


        // 6 Kullanıcı alert yazısının çıkmasını bekler
        wait.until(ExpectedConditions.alertIsPresent());
        extentTest.info("Kullanıcı alert yazısının çıkmasını bekledi ");

        // 7 Kullanıcı alert yazısını kaydeder
        Alert alert = Driver.getDriver().switchTo().alert();
        extentTest.info("Kullanıcı alert yazısını kaydetti");
        String actualAlertText = alert.getText();
        String expectedAlertText = "Password reset link has been sent to your email";


        // 8 Kullanıcı çıkan alert yazısı ile beklenen alert yazısını karşılaştırır
        Assert.assertNotEquals(actualAlertText,
                expectedAlertText, "Şifre sıfırlama beklenmedik şekilde çalıştı");
        extentTest.pass("Şifre sıfırlama linki gönderilemedi");
        alert.accept();
        extentTest.fail("Şifre sıfırlama işlemi çalıştı - Beklenen: FAIL");


    }

    @Test
    public void ekranGoruntusuAlma(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        headerPages.signInButton.click();
        ReusableMethods.bekle(1);

        // box lar kırmızı çizgi buttonlar yeşil çizgi
        MultiScreenShootsMethods.getWebelementWithRedBorderAndGreenLine(
                Driver.getDriver(),
                ConfigReader.getProperty("loginPage"),
                new WebElement[]{
                        headerPages.mailBox,
                        headerPages.passwordBox,
                } ,
                new WebElement[]{
                        headerPages.rememberMeButton,
                        headerPages.forgotPasswordButton,
                        headerPages.loginPageSigInButton
                }

        );

        headerPages.mailBox.sendKeys(ConfigReader.getProperty("adminMail"));
        headerPages.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        headerPages.loginPageSigInButton.click();

        MultiScreenShootsMethods.getWebelementWithRedBorder(
                Driver.getDriver(),
                ConfigReader.getProperty("lfc"),
                headerPages.accountButton

        );

        headerPages.accountButton.click();
        ReusableMethods.bekle(2);

        headerPages.profileButton.click();
        headerPages.editProfileButton.click();

        MultiScreenShootsMethods.getWebelementWithRedBorder(
                Driver.getDriver(),
                ConfigReader.getProperty("editPage"),
                headerPages.errorContainerWebelement

        );
    }


    @Test
    public void cerceveveaciklamali() {
        AdminPages adminPages  = new AdminPages();

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        MultiFunctionalScreenShoots.capturePageWithAnnotations(
                Driver.getDriver(),
                ConfigReader.getProperty("lfc"),
                new Object[][]{
                        {loyalfriendcarePages.logoButton, "logoButton"},
                        {loyalfriendcarePages.signInButton, "signInButton"}
                },
                new Object[][]{
                        {loyalfriendcarePages.signUpButton, "signUpButton"},
                        {loyalfriendcarePages.aboutUsButton, "aboutUsButton"}
                }
        );
    }






}












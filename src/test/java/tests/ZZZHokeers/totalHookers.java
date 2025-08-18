package tests.ZZZHokeers;

import Pages.LFCPages;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.XPathGenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static utilities.TestBaseRapor.extentReports;


public class totalHookers {
    LFCPages loyalfriendcarePages = new LFCPages() ;
    @Test
    public void hooker(){ // US_004 hookers
        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/Medicines/tobramycin-ophthalmic");



        WebElement aramaSonucElementYazisi = Driver.getDriver().findElement(By.xpath("//h1[i[@class='fas fa-capsules']]")) ;
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
    public void hookerx5(){ //X5hookers
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages loyalfriendcarePages = new LFCPages() ;

        loyalfriendcarePages.bodyvaccinationsButton.click();

        WebElement bedDepartments = Driver.getDriver().findElement(By.xpath("//*[@id=\"page\"]/main/div[2]/div[3]/div/a/figure/img"));
        XPathGenerator.printXpathFormulas(bedDepartments);
        bedDepartments.click();
        Driver.getDriver().navigate().back();

        Driver.quitDriver();
    }
    @Test
    public void hookerx8(){
        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/about");



        WebElement budgetVetCareBtn = Driver.getDriver().findElement(By.xpath("//*[@class='fas fa-money-check-alt']"));
        budgetVetCareBtn.click();
        ReusableMethods.takeFullPageScreenshot("4");
        Driver.getDriver().navigate().back();

        // <--
        WebElement petShelterButton = Driver.getDriver().findElement(By.xpath("//*[@class='fas fa-dog']"));
        ReusableMethods.getWebElementScreenshot(
                petShelterButton,"petShelterButton"
                        + LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        petShelterButton.click();
        Driver.getDriver().navigate().back();

        // <--

        WebElement certifiedVetButton = Driver.getDriver().findElement(By.xpath("//*[@class='fas fa-certificate']"));
        ReusableMethods.getWebElementScreenshot(
                certifiedVetButton,
                "certifiedVetButton"
                        +LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        certifiedVetButton.click();
        Driver.getDriver().navigate().back();

        // <--    One-Stop Nutrition Shop

        WebElement nutritionShop =Driver.getDriver().findElement(By.xpath("//*[@class='fas fa-paw']")) ;
        ReusableMethods.getWebElementScreenshot(
                nutritionShop,
                "nutritionShop"+LocalDate.now().format(DateTimeFormatter.ISO_DATE)
        );
        nutritionShop.click();
        Driver.getDriver().navigate().back();


//Driver.quitDriver();
    }
    @Test
    public void hookerx9(){
        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/Contact");



        WebElement dateButton = Driver.getDriver().findElement(By.xpath("//*[@id='Date']")) ;
        //XPathGenerator.printXpathFormulas(dateButton);

        WebElement phone = Driver.getDriver().findElement(By.xpath("//*[@placeholder='Phone Number']"));
        //XPathGenerator.printXpathFormulas(phone);

        WebElement departmentButton = Driver.getDriver().findElement(By.xpath("//*[@name='category_id']"));
        //XPathGenerator.printXpathFormulas(departmentButton);

        WebElement doctorsButton = Driver.getDriver().findElement(By.xpath("//*[@class='nice-select wide']"))    ;
        //XPathGenerator.printXpathFormulas(doctorsButton);

        WebElement messageBox = Driver.getDriver().findElement(By.xpath("//*[@placeholder='Create Message']"));
        //XPathGenerator.printXpathFormulas(messageBox);

        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//*[@value='Submit']")) ;
        XPathGenerator.printXpathFormulas(submitButton);




        Driver.quitDriver();
    }
    @Test
    public void hookersus03(){
        ExtentTest extentTest = extentReports.createTest("Header Butonlarının Tıklama ve Başlık Testleri",
                "Kullanici AnaSayfa Header Bölümünde Bulunan Butonlara Basa bilmeli ve ilgili sayfaya gidebilmeli ");
        SoftAssert softAssert = new SoftAssert();
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages loyalfriendcarePages = new LFCPages() ;
        loyalfriendcarePages.doctorsButton.click();
        //System.out.println(loyalfriendcarePages.titleContainer.getText().trim()) ;
        String expectedTitle = "Doctors" ;
        String actualTitle = loyalfriendcarePages.titleContainer.getText().trim() ;
        softAssert.assertEquals(actualTitle,expectedTitle,"drgeasfa");
        extentTest.pass("sgsrgsrgtvsrbvsvergeaagaer") ;




        softAssert.assertAll();

    }
    @Test
    public void hookerUs_0002_c() {
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages loyalfriendcarePages = new LFCPages();
        loyalfriendcarePages.signInButton.click();
    }
    @Test
    public void hookerUS_002_F(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages loyalfriendcarePages = new LFCPages() ;
        XPathGenerator.printXpathFormulas(loyalfriendcarePages.signUpButton);

    }
    @Test
    public void hookers08(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages loyalfriendcarePages = new LFCPages() ;
        loyalfriendcarePages.signInButton.click();
        loyalfriendcarePages.mailBox.sendKeys("user.ahmet@loyalfriendcare.com");
        loyalfriendcarePages.passwordBox.sendKeys("LFCare.0201");
        ReusableMethods.bekle(4);
        loyalfriendcarePages.loginPageSigInButton.click();
    }
    @Test
    public void configliGiris(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        LFCPages loyalfriendcarePages = new LFCPages() ;
        loyalfriendcarePages.signInButton.click();
        loyalfriendcarePages.mailBox.sendKeys(ConfigReader.getProperty("userMail"));
        loyalfriendcarePages.passwordBox.sendKeys("userPassword");
        ReusableMethods.bekle(4);
        loyalfriendcarePages.loginPageSigInButton.click();

    }

    @Test
    public void loginPageLocaters(){

    Driver.getDriver().get("https://qa.loyalfriendcare.com/en/login");

    WebElement rememberMeButtons = Driver.getDriver().findElement(By.xpath("(//div[@class='checkbox'])")) ;
    //XPathGenerator.printXpathFormulas(rememberMeButtons);
        rememberMeButtons.click();

        ReusableMethods.bekle(5);

    }
    @Test
    public void loginPageLocaters2(){
        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/login");
        ReusableMethods.bekle(2);
        WebElement forgotPasswordButton = Driver.getDriver().findElement(By.xpath("//*[@class='text-info small']")) ;
        forgotPasswordButton.click();
    }
    @Test
    public void passwordReserPageLocaters(){ // pswrdReset
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

        WebElement sendPassWordLinkButton = Driver.getDriver().findElement(By.xpath("//*[@type='submit']")) ;
        sendPassWordLinkButton.click();



    }

    @Test
    public void forgotpasswordPageslogoButtonTesti(){
        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/password/reset");
    }
}

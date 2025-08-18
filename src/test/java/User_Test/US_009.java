package User_Test;

import Pages.LFCPages;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_009 extends TestBaseRapor {
    LFCPages lfcPages = new LFCPages() ;


    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }


    @Test
    public void TC_01(){
        //1-)The user navigates to the page with the relevant URL.
        //2) Confirms that it is on the homepage
        //3-)Displays the 'Sign In' button in the header section
        //4-)User clicks on the 'Sign In' button
        //5)Confirms that you are redirected to the login page
        //6-)Closes the page

        extentTest = extentReports.createTest("Header Bölümünde SignInButonu Testi",
                "Kullanici AnaSayfa Header Bölümünde Bulunan Butonlara Basa bilmeli ve ilgili sayfaya gidebilmeli ");
        SoftAssert softAssert = new SoftAssert();

        // 1 loyalfriendcare.com ana sayfasına gidip Url i doğrulayın
        String expectedUrl = "https://qa.loyalfriendcare.com/en" ;
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.equals(expectedUrl),"kullanıcı istenilen sayfada değil");
        extentTest.info("Kullanıcı anaSayfada olduğunu doğrular") ;

        // 2 header bölümünde SignInButton görünür olduğunu test edin
        softAssert.assertTrue(lfcPages.signInButton.isDisplayed(),
                "sıgnInButton görünür değil");
        extentTest.info("Kullanıcı header bölümünde signInButton'un görünürdüğünü doğrular");

        // 3 Kullanıcı SıgnInbutton a tıklar
        lfcPages.signInButton.click();
        extentTest.info("Kullanıcı SıgnInbutton a tıklar") ;

        // 4 Kullanıcı login sayfasına yönlendirildiğini test eder
        String expectedUrlIcerik = "loginPage";
        String axtualUrlIcerik = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(axtualUrlIcerik.contains(expectedUrlIcerik),
                "sayfa uzantısı bekleneni karşılamıyor");
        extentTest.pass("Kullanıcı login sayfasına yönlendirildiğini doğrular") ;

        // 5 Kullanıcı Sayfay kapatır
        extentTest.info("kullanıcı sayfayı kapatır")  ;
        softAssert.assertAll();
    }
    @Test
    public void TC_02(){
        //1-)The user navigates to the page with the relevant URL.
        //2) Confirms that it is on the homepage
        //3-)Displays the 'Sign In' button in the header section
        //4-)User clicks on the 'Sign In' button
        //5)Confirms that the user is on the login page
        //6-)'Forgot Password' link
        //7-)Closes the page

        // < -- ============================
        SoftAssert softAssert = new SoftAssert();

        // 1 Kullanıcı sıgnInUpButton a tıklar
        lfcPages.signInButton.click();

        // 2 Login Sayfasında olduğunu doğrular

        // 3 ForgotPassword Butona Tıklar
        lfcPages.forgotPasswordButton.click();



    }
    @Test
    public void TC_03(){
        SoftAssert softAssert = new SoftAssert();
        //1-)The user navigates to the page with the relevant URL.
        //2) Confirms that it is on the homepage
        //3-)Displays the 'Sign In' button in the header section
        //4-)User clicks on the 'Sign In' button
        //5)Confirms that the user is on the login page
        //6-)'Forgot Password' link
        //7-) Clicks on the 'Forgot Password' link
        //8-)Confirms that you have been redirected to the 'Reset Password' page
        //9-)User closes the page
        lfcPages.signInButton.click();
        lfcPages.forgotPasswordButton.click();
        String expectedUrlIcerik = "reset/password" ;
        String actualUrlIcerik = Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));
        softAssert.assertAll();

    }
    @Test
    public void TC_04(){
        lfcPages.signInButton.click();
        lfcPages.forgotPasswordButton.click();
        lfcPages.logoButton.click();

    }


}

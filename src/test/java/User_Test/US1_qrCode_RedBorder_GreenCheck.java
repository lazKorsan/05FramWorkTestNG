package User_Test;

import Pages.AdminPages;
import Pages.HeaderPages;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import tests.ZZZHokeers.VisualValidationUtils;
import utilities.*;

public class US1_qrCode_RedBorder_GreenCheck {
    HeaderPages headerPages = new HeaderPages();

    //  %%%QR,RED,GREEN



    @Test
    public void multiScreenShotsMetodlarininCagirilmasi() {

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        // cağırılan elementlerin kırmızı cizgiye alınması
        MultiScreenShootsMethods.getWebelementWithRedBorder( // Kırmızı cerceve
                Driver.getDriver(),
                ConfigReader.getProperty("lfc"),
                headerPages.logoButton,
                headerPages.signInButton,
                headerPages.signUpButton
        );

        // cağırılan elementlerin altına yeşil chick işareti koyar
        MultiScreenShootsMethods.getWebelementWithGreenLine(
                Driver.getDriver(),
                ConfigReader.getProperty("lfc"),
                headerPages.homeButton,
                headerPages.aboutUsButton,
                headerPages.doctorsButton,
                headerPages.doctorsButton
        );

        // hem kırmızı hem yeşil birlikte

        MultiScreenShootsMethods.getWebelementWithRedBorderAndGreenLine(
                Driver.getDriver(),
                ConfigReader.getProperty("lfc"),
                new WebElement[]{
                        headerPages.logoButton,
                        headerPages.signInButton,
                        headerPages.signUpButton,
                },
                new WebElement[]{
                        headerPages.homeButton,
                        headerPages.aboutUsButton,
                        headerPages.doctorsButton,
                        headerPages.departmentsButton,
                        headerPages.medicinesButton
                }
                // ELİNDE BUNA UYGUN BİR METHOD VAR MI.
                // BİRDE SAYFAYA QR CODE KOYACAK

        );

    }


    @Test
    public void t(){

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));


        MultiScreenShootsMethods.getWebelementWithRedBorderAndGreenLine(
                Driver.getDriver(),
                ConfigReader.getProperty("lfc"),
                new WebElement[]{
                        headerPages.logoButton,
                        headerPages.signInButton,
                        headerPages.signUpButton,
                },
                new WebElement[]{
                        headerPages.homeButton,
                        headerPages.aboutUsButton,
                        headerPages.doctorsButton,
                        headerPages.departmentsButton,
                        headerPages.medicinesButton,
                }
        );

    }

    @Test
    public void t2(){
        AdminPages adminPages = new AdminPages() ;

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));

        String screenshot = VisualValidationUtils.highlightElementsAndTakeScreenshot(
                Driver.getDriver(),
                new Object[][]{
                        {headerPages.logoButton, "Ana Logo"},
                        {headerPages.searchButton, "Arama Butonu"}
                },
                new Object[][]{
                        {headerPages.signInButton, "İletişim Linki"}
                }
        );




    }

    @Test
    public void screenShots(){

        AdminPages adminPages = new AdminPages() ;

        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        headerPages.aboutUsButton.click();

        // şimdi cucumber için yeni framework kuruyorum
        // ortalık biraz karıştı gibi istediğim dosyayı bulamıyorum

        // aşağıdaki gibi çağırabileceğim methodu bulamıyorum
        // 1 ve istenirse 1 den fazla elementi kırmızı çerçeveye alıp
        // altına buton adını yazıyor
        //  ve istenen butonları yeşil çerçeve içine alıp
        // altına buton ismi yazıyor
        // sayfanın Url ini alıp sağ ortaya yazdırıyor .
        // qr code üstünde url uzantısı olacak şekilde



    }
}


















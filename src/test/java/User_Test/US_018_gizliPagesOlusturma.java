package User_Test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

// Constructar deneme sayfası gerçekten çok önemlidirmiştirmiştir.

public class US_018_gizliPagesOlusturma {
    DenemePages denemePages = new DenemePages();

    @Test
    public void TC_01(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        denemePages.signInButton.click(); // Artık erişilebilir olacak
    }

    // < -- ======= Constructor Taşıma Sayfası ===== -- >
    // < -- vvvvvvvvvvvv Constructor Region vvvvvvvvvv -- >
    public static class DenemePages {                                         // s1

        // < -- ======= Start Locater Area ===== -- >
        @FindBy(xpath = "(//a[@class='btn_add'])[1]")                  //s2
        public WebElement signInButton;                                //s3

        // < -- ===== End Lacater Area ===== -- >

        // < -- ===== Begin Definition Constructor  ===== -->
        public DenemePages() {                                         //s4
            PageFactory.initElements(Driver.getDriver(), this);  //s5
        }                                                              // s6
        // < -- ===== End Definitions Constructor  ===== -- >
    }                                                                  //s7
    // < -- ^^^^^^ Constructor Definition Area ^^^^^^ -- >

}

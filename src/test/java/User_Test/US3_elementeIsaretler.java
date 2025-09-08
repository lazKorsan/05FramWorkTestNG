package User_Test;

import Pages.HeaderPages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.PageElementHighlighter;

import java.util.HashMap;
import java.util.Map;

public class US3_elementeIsaretler {
    // çağırılan sınıf  PageElementHighlighter
    HeaderPages headerPages = new HeaderPages() ;

    @Test
    public void loginSayfasi(){


        Driver.getDriver().get("https://qa.loyalfriendcare.com");


        // Highlight edilecek elementlerin map'i
        Map<String, By> elementsToHighlight = new HashMap<>();
        elementsToHighlight.put("logoButton", By.xpath("//*[@class='logo_normal']"));
        elementsToHighlight.put("homeButton", By.xpath("(//a[@href='https://qa.loyalfriendcare.com'])[5]"));
        //elementsToHighlight.put("aboutUsButton", By.xpath("(//a[@href='https://qa.loyalfriendcare.com/about'])[2]"));
        elementsToHighlight.put("departmentsButton", By.xpath("(//a[@href='https://qa.loyalfriendcare.com/Departments'])[3]"));
        //elementsToHighlight.put("doctorsButton", By.xpath("(//a[@href='https://qa.loyalfriendcare.com/Doctors'])[3]"));
        elementsToHighlight.put("medicinesButton", By.xpath("(//a[@href='https://qa.loyalfriendcare.com/Medicines'])[2]"));
       // elementsToHighlight.put("vaccinationsButton", By.xpath("(//a[@href='https://qa.loyalfriendcare.com/Pets'])[3]"));
        elementsToHighlight.put("signInButton", By.xpath("(//a[@class='btn_add'])[1]"));
       // elementsToHighlight.put("signUpButton", By.xpath("(//a[@class='btn_add'])[2]"));
        // Tüm elementleri highlight et ve screenshot al
        PageElementHighlighter.highlightAndCaptureElements(
                Driver.getDriver(),
                elementsToHighlight,
                "homepage_elements"
        );

        // Normal test işlemlerine devam et...
    }
    @Test
    public void loginPage(){
        Driver.getDriver().get(ConfigReader.getProperty("lfc"));
        headerPages.signInButton.click();

        // Highlight edilecek elementlerin map'i
        Map<String, By> elementsToHighlight = new HashMap<>();
        elementsToHighlight.put("emailBox", By.xpath("//*[@class='logo_normal']"));
        elementsToHighlight.put("homeButton", By.xpath("(//a[@href='https://qa.loyalfriendcare.com'])[5]"));
        //elementsToHighlight.put("aboutUsButton", By.xpath("(//a[@href='https://qa.loyalfriendcare.com/about'])[2]"));
        elementsToHighlight.put("departmentsButton", By.xpath("(//a[@href='https://qa.loyalfriendcare.com/Departments'])[3]"));
        //elementsToHighlight.put("doctorsButton", By.xpath("(//a[@href='https://qa.loyalfriendcare.com/Doctors'])[3]"));
        elementsToHighlight.put("medicinesButton", By.xpath("(//a[@href='https://qa.loyalfriendcare.com/Medicines'])[2]"));
        // elementsToHighlight.put("vaccinationsButton", By.xpath("(//a[@href='https://qa.loyalfriendcare.com/Pets'])[3]"));
        elementsToHighlight.put("signInButton", By.xpath("(//a[@class='btn_add'])[1]"));
        // elementsToHighlight.put("signUpButton", By.xpath("(//a[@class='btn_add'])[2]"));
        // Tüm elementleri highlight et ve screenshot al
        PageElementHighlighter.highlightAndCaptureElements(
                Driver.getDriver(),
                elementsToHighlight,
                "homepage_elements"
        );

        // ZAMAN OLARAK SIKIŞIK DURUMDAYIM.
        // BANA ŞÖYLE BİR METHOD GEREKİYOR



    }
}

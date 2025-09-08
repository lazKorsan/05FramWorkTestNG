package User_Test;

import Pages.AdminPages;
import Pages.HeaderPages;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.XPathGenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class US_018_Takvimvefakerclass {
    // faker clas
    // takvim formatlayıcı kullanıldı
    // dropDown Menu seçici
HeaderPages headerPages = new HeaderPages();
AdminPages adminPages = new AdminPages() ;
Faker faker = new Faker() ;




    @Test
    public void takvimVeFakerClassKullanimi(){

        // RANDEVU SAYFASINA GİT
        Driver.getDriver().get("https://qa.loyalfriendcare.com/en/Medicines/suretin-mipen");

        // RANDEVU DEFTERİNDE 3 GÜN SONRASINI YAZDIRACAK KOD BLOĞU
        LocalDate futureDate = LocalDate.now().plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String targetDate = futureDate.format(formatter);

        Actions actions = new Actions(Driver.getDriver());
        headerPages.dateButton.click();
        actions.sendKeys(targetDate)
                        .sendKeys(Keys.TAB)
                                .sendKeys(Keys.TAB)
                                        .sendKeys(faker.phoneNumber().cellPhone())
                .perform();

        headerPages.messageBox.sendKeys(faker.lorem().characters(25));

        headerPages.appoinmentBookingButton.click();
        ReusableMethods.bekle(20);

        System.out.println(headerPages.alertSuccesText.getText());


        //  WebElement ddElement = Driver.getDriver().findElement(By.xpath("(//div[@class='nice-select wide'])")) ;
       // Select select = new Select(ddElement);
       // select.selectByValue("2");
       // select.selectByIndex(1);
       // select.selectByVisibleText("Option 1");



        // Method2 - select.selectByVisibleText("Görünen Metin");
        // Method3 - select.selectByValue("optionValue");  value değeri ile almak



        //WebElement dropdown = Driver.getDriver().findElement(By.id("dropdownID"));
        //Select select = new Select(dropdown);
        //
        //// Metin ile seçim
        //select.selectByVisibleText("Görünen Metin");
        //
        //// Value değeri ile seçim
        //select.selectByValue("optionValue");
        //
        //// Index ile seçim
        //select.selectByIndex(2);

    }

}

package uaYeni_28_08_25_tarihindeAcildi;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class YoutubeExcellKullanimiTest {

    youtubeexcellDersi youtubeexcellDersi = new youtubeexcellDersi();

    @DataProvider(name="viaExcellSource")
    public Object[][] getSourceOfExcell(){
        String filePath = "C:\\Users\\Hp\\OneDrive\\Desktop\\loyalfriendcare\\urunler.xlsx";
        return youtubeexcellDersi.getExcellData(filePath, "sayfa1", 3);
    }

    @Test(dataProvider = "viaExcellSource")
    public void excellCagirma(String deger1, String deger2, String deger3){
        System.out.printf("Değer 1: %s%n", deger1);
        System.out.printf("Değer 2: %s%n", deger2);
        System.out.printf("Değer 3: %s%n", deger3);
        System.out.println("-----------------------");
    }
}
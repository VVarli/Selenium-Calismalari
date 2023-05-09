package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P02 {
    public static void main(String[] args) {
        /*
     . .Exercise2...
        1-Driver oluşturalim
        2-Java class'imiza chnomedriver. exetyi tanitalim
        3-Driver'in tum ekranı kaplamasini sagu ayalim
        4-Driverla sayfanın yuklenmesini 10.809 milisaniye (10 saniye) boyunca beklesini söyleyelim. Egen oncesinde sqyfq Yüklenirse, beklemeyi bıraksın.
        5-"https://www.otta.de" adresine gidelim
        6-BU web adresinin sayfa basligini (title) ve adres (url)ini alalim
        7-Title ve url inin "0TT0" kelimesinin içerip icermedigini kontrol edelim
        8-Ardindan "https://wisequarter.com/" adresine gidip
        9-BU adresin basligini alalim ve "Quarter" kelimesini icenip icermedigini kontrol edelim
        10-Bir onceki web sayfamiza geri donelim
        11-Sayfayı yenileyelim
        12-Daha sonra web sgyfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
        13- En son adim olarak butun sayfalarimizi kapatmis olalim
             */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //5-"https://www.otta.de" adresine gidelim
        driver.get("https://www.otta.de");

        //6-BU web adresinin sayfa basligini (title) ve adres (url)ini alalim
        String ottoTitle = driver.getTitle();
        String ottoUrl = driver.getCurrentUrl();

        //7-Title ve url inin "0TT0" kelimesinin içerip icermedigini kontrol edelim
        String expectedTitleAndUrl = "OTTO";

        if (ottoTitle.contains(expectedTitleAndUrl) && ottoUrl.contains(expectedTitleAndUrl)) {
            System.out.println("TEST PASS");
        } else System.out.println("TEST FAILD");

        //8-Ardindan "https://wisequarter.com/" adresine gidip
        driver.navigate().to("https://wisequarter.com/");

        //9-BU adresin basligini alalim ve "Quarter" kelimesini icenip icermedigini kontrol edelim
        String expectedTitle = "Quarter";
        String quarterTitle = driver.getTitle();

        if (quarterTitle.contains(expectedTitle)) System.out.println("Quarter TEST PASS");
        else System.out.println("Quarter TEST FAILD");

        //10-Bir onceki web sayfamiza geri donelim
        driver.navigate().back();

        //11-Sayfayı yenileyelim
        driver.navigate().refresh();

        //12-Daha sonra web sgyfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
        driver.navigate().back();
        driver.close();

        //13- En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();


    }
}
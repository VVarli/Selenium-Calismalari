package day02_DriverGetMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_ilkTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // 3. Amazon sayfasina gidelim
        driver.get("https://www.amazon.com/");

        // 4. Sayfa basligini tittle yazdirin
        System.out.println("Sayfa Basligi: "+driver.getTitle());

        // 5. Sayfa basliginin Amazon icerdigini test edin
        String expectedTitle = "Amazon";
        String actualTitle= driver.getTitle();
        if(actualTitle.contains(expectedTitle)) System.out.println("TEST PASS");
        else System.out.println("TEST FAILED");

        // 6. sayfa url'sini yazdirin
        System.out.println(driver.getCurrentUrl());

        // 7. sayfa url'sinin amazon icerdigini yazdirin
        String expectedUrl = "amazon";
        String actualUrl= driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl)) System.out.println("TEST PASS");
        else System.out.println("TEST FAILED");

        // 8. sayfa handle degerini yazdirin
        System.out.println("Sayfanin handle degeri: "+driver.getWindowHandle());

        // 9. sayfa HTML kodlarinda alisveris kelimesi gectigini test edin
        String expectedIcerik = "alisveris";
        String actualPageSource= driver.getPageSource();
        if(actualPageSource.contains(expectedIcerik)) System.out.println(" sayfa kaynak kodlari alisveris iceriyor TEST PASS");
        else System.out.println("sayfa kaynak kodlari alisveris icermiyor TEST FAILED");

        // 10. sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }
}

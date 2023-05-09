package day05_relativeLocators_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_GoogleNutella {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       // 1- C01_TekrarTesti isimli bir class olusturun
       // 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

       // 3- cookies uyarisini kabul ederek kapatin

       // 4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTitile = "Google";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitile)) System.out.println("TEST PASS");
        else System.out.println("TEST FAILD");

       // 5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaCubugu = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        aramaCubugu.sendKeys("Nutella"+ Keys.ENTER);

       // 6- Bulunan sonuc sayisini yazdirin
        WebElement sonuc = driver.findElement(By.id("result-stats"));
        System.out.println(sonuc.getText());

        // 7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String aramaSonucu =sonuc.getText();
        String [] sonucAramaArr = aramaSonucu.split(" ");
        String sonucSayiKismi = sonucAramaArr[1];
        sonucSayiKismi = sonucSayiKismi.replaceAll("\\D","");
        int intAramaSaonucu = Integer.parseInt(sonucSayiKismi);
        System.out.println(intAramaSaonucu);

        if (intAramaSaonucu>10000000) System.out.println("Sonuc 10 milyondan fazla TEST PASS");
        else System.out.println("Sonuc 10 milyondan az TEST FAILD");

       // 8- Sayfayi kapatin

        driver.close();
    }
}

package day04_locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_cssSelector {
    public static void main(String[] args) throws InterruptedException {

        //1- bir class olusturun
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //3- Browseri tam sayfa yapin


        //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String expectedTitle = "Spend less";
        String actualTitlr = driver.getTitle();

        if (actualTitlr.contains(expectedTitle)) System.out.println("Title test PASS");
        else System.out.println("Title test FAILD");

        //6- Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[text()='Gift Cards']")).click();

        //7- Birthday butonuna basin
        driver.findElement(By.xpath("//*[@alt='Birthday']")).click();

        //8- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).click();

        //9- Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("(//button[@id='gc-mini-picker-amount-1'])[1]")).click();
        Thread.sleep(2000);

        //10-Urun ucretinin 25$ oldugunu test edin
        WebElement urunUcreti = driver.findElement(By.xpath("//span[@class='gc-live-preview-amount']"));
        String expectedUrunUcreti = "$25";

        if (urunUcreti.getText().contains(expectedUrunUcreti)) System.out.println("Urun ücreti TEST PASS");
        else System.out.println("Urun ucreti TEST FAILD");

        //11-Sayfayi kapatin

        driver.close();


    }
}

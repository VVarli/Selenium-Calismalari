package team08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P01 {
    public static void main(String[] args) throws InterruptedException {
        /* Automation Exercise Category Testi
        1- Bir test class’i olusturun ilgili ayarlari yapin
        2- https://www.automationexercise.com/ adresine gidin
        3- Category bolumundeki elementleri locate edin
        4- Category bolumunde 3 element oldugunu test edin
        5- Category isimlerini yazdirin
        6- Sayfayi kapatin */
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.automationexercise.com/");
        List<WebElement> kategoriElementleri =driver.findElements(By.className("panel-title"));
        int elementSayisi =3;
        int actualElelmantSayisi=kategoriElementleri.size();
        if(elementSayisi==actualElelmantSayisi)  System.out.println("TEST PASS");
        else  System.out.println("TEST FAILD");
        for (WebElement each:kategoriElementleri) {
            System.out.println(each.getText());
        }
        Thread.sleep(2000);
        driver.close();


    }
}

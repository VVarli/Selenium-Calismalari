package day03_lacators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_findElements {
    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3- Category bolumundeki elementleri locate edin
        List<WebElement> categoryElementList =driver.findElements(By.className("panel-title"));

        //4- Category bolumunde 3 element oldugunu test edin
        int expectedSize=3;
        int actualSize=categoryElementList.size();

        if (expectedSize==actualSize) System.out.println("Category element testi PASS");
        else System.out.println("Category element tsti FAILD");

        //5- Category isimlerini yazdirin
        for (WebElement each:categoryElementList) {
            System.out.println(each.getText()+ " ");
        }
        //6-sayfayı kapatin
        Thread.sleep(10);
        driver.close();

    }
}

package day03_lacators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_AutomationExercise {
    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


       //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

       //3- Sayfada 147 adet link bulundugunu test edin.
        int expectedLink = 147;
        List<WebElement> linkList=driver.findElements(By.tagName("a"));
        int actualLink = linkList.size();

        if(expectedLink==actualLink) System.out.println("Link sayisi 147 test PASS");
        else System.out.println("Link Test FAILD");

       //4- Products linkine tiklayin
        WebElement products =driver.findElement(By.partialLinkText("Products"));
        products.click();

        //5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferElementi = driver.findElement(By.id("sale_image"));
        if(specialOfferElementi.isDisplayed()) System.out.println("Test PASS");
        else System.out.println("TEST FAILD");
       //6- Sayfayi kapatin

        Thread.sleep(1000);
        driver.close();


    }
}

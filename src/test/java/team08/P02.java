package team08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class P02 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html  adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        //2 ) Berlin’i  3 farkli relative locator ile locate edin

        WebElement boston = driver.findElement(By.xpath("//*[@id='pid6_thumb']"));
        WebElement berlin1 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(boston));

        WebElement NYC = driver.findElement(By.id("pid3_thumb"));
        WebElement berlin2 = driver.findElement(RelativeLocator.with(By.tagName("img")).below(NYC));

        WebElement bayArea = driver.findElement(By.id("pid8_thumb"));
        WebElement berlin3 = driver.findElement(RelativeLocator.with(By.tagName("img")).toLeftOf(bayArea));


        //3 ) Relative locator’larin dogru calistigini test edin


        if (berlin1.getAttribute("id").equals("pid7_thumb")) {
            System.out.println("Berlin 1 ==> TEST PASS");
        }else System.out.println("Berlin 1 ==> TEST FAILD");

        if (berlin2.getAttribute("id").equals("pid7_thumb")) {
            System.out.println("Berlin 2 ==> TEST PASS");
        }else System.out.println("Berlin 2 ==> TEST FAILD");

        if (berlin3.getAttribute("id").equals("pid7_thumb")) {
            System.out.println("Berlin 3 ==> TEST PASS");
        }else System.out.println("Berlin 3 ==> TEST FAILD");




    }
}

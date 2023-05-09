package day05_relativeLocators_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        //2 ) Berlin’i 3 farkli relative locator ile locate edin

             // 1-Tag'ı img NYC'nin altinda
        WebElement nyc = driver.findElement(By.id("pid3_thumb"));
        WebElement berlin1 = driver.findElement(RelativeLocator.with(By.tagName("img")).below(nyc));

        //TEst edelim
        if (berlin1.getAttribute("id").equals("pid7_thumb")) System.out.println("Berlin1 locate testi PASS");
        else System.out.println("Berlin1 locate testi FAILD");;

             // 2-Tag'ı img Boston'in saginda
        WebElement boston = driver.findElement(By.id("pid6_thumb"));
        WebElement berlin2 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(boston));

        //TEst edelim
        if (berlin2.getAttribute("id").equals("pid7_thumb")) System.out.println("Berlin2 locate testi PASS");
        else System.out.println("Berlin1 locate testi FAILD");

             // 3-Tag'ı img Sailor'in altinda
        WebElement sailor = driver.findElement(By.id("pid11_thumb"));
        WebElement berlin3 = driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailor));

        //TEst edelim
        if (berlin3.getAttribute("id").equals("pid7_thumb")) System.out.println("Berlin3 locate testi PASS");
        else System.out.println("Berlin1 locate testi FAILD");;

        //3 ) Relative locator’larin dogru calistigini test edin

        Thread.sleep(2000);
        driver.close();
    }
}

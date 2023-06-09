package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class P07 {
    public static void main(String[] args) {



        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1 ) http://babayigit.net/relativelocators/relative.html adresine gidin
        driver.get("http://babayigit.net/relativelocators/relative.html");

        //2 ) Nurse  3 farkli relative locator ile locate edin
        WebElement doctor = driver.findElement(By.id("dr_thumb"));
        WebElement nurse = driver.findElement(RelativeLocator.with(By.tagName("img")).below(doctor));

        //3 ) Relative locator'larin dogru calistigini test edin
        if (nurse.getAttribute("id").equals("nurs_thumb")) System.out.println("test pass");
        else System.out.println("test faild");






    }
}

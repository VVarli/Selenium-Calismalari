package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P03 {
    public static void main(String[] args) {
               /* ...Exercise3...
            Navigate to  https://testpages.herokuapp.com/styled/index.html
            Click on  Calculater under Micro Apps
            Type any number in the first input
            Type any number in the second input
            Click on Calculate
            Get the result
            Print the result
             */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testpages.herokuapp.com/styled/index.html");



        driver.findElement(By.id("calculatetest")).click();

        //WebElement calculator1 = driver.findElement(By.id("number1"));
        //calculator1.sendKeys("48");
        driver.findElement(By.id("number1")).sendKeys("48");

        //WebElement calculator2 = driver.findElement(By.id("number2"));
        //calculator2.sendKeys("5");
        driver.findElement(By.id("number2")).sendKeys("5");

        //WebElement calculatorA = driver.findElement(By.id("calculate"));
        //calculatorA.submit();
        driver.findElement(By.id("calculate")).submit();

        WebElement calculatorAnswer = driver.findElement(By.id("answer"));
        System.out.println("Answer: "+ calculatorAnswer.getText());


    }
}

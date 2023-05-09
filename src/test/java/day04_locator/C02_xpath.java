package day04_locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_xpath {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Add Element butonuna basin
         driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

         Thread.sleep(1000);

        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu = driver.findElement(By.xpath("//button[@class='added-manually']"));
        if (deleteButonu.isDisplayed()) System.out.println("TEst PASS");
        else System.out.println("Test FAILD");

        //4- Delete tusuna basin
        deleteButonu.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addElementElementi = driver.findElement(By.xpath("//h3"));
        if (addElementElementi.isDisplayed()) System.out.println("Add-Remove elementi tesit PASS");
        else System.out.println("Add-Remove elementi tesit PASS");

        Thread.sleep(3000);
        driver.close();
    }
}

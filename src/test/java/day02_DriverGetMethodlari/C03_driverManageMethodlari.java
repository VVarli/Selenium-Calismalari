package day02_DriverGetMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_driverManageMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.drive","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");

        System.out.println("Baslangic konum "+driver.manage().window().getPosition());
        System.out.println("Baslangic boyut"+driver.manage().window().getSize());

        Thread.sleep(1000);
        driver.manage().window().maximize();
        System.out.println("Maximize konum "+driver.manage().window().getPosition());
        System.out.println("Maximize boyut"+driver.manage().window().getSize());

        Thread.sleep(1000);
        driver.manage().window().fullscreen();
        System.out.println("Fullscreen konum "+driver.manage().window().getPosition());
        System.out.println("Fullscreen boyut"+driver.manage().window().getSize());

        Thread.sleep(1000);
        driver.manage().window().minimize();
        System.out.println("Minimize konum "+driver.manage().window().getPosition());
        System.out.println("Minimize boyut"+driver.manage().window().getSize());

        driver.manage().window().setPosition(new Point(50,50));
        driver.manage().window().setSize(new Dimension(500,500));




        Thread.sleep(3000);
        driver.close();

    }
}

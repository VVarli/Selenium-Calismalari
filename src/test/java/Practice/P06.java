package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P06 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String ht = "https://";
        driver.get(ht+"www.google.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.navigate().to(ht+"www.amazon.com");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        System.out.println(driver.getWindowHandle());
        Thread.sleep(2000);
        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        String handle = driver.getWindowHandle();
        System.out.println(driver.getWindowHandle());
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(ht+"www.wisequarter.com");
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());
        driver.switchTo().window(handle);
        driver.close(); // son browser kapanır
        driver.quit(); // birden fazla acilan sekmelerin tamami kapanir




    }
}

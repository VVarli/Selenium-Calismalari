package day02_DriverGetMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverGetMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com.tr/");  // www yazmazsak calisir ama https yazmazsak calismaz
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        System.out.println(driver.getPageSource());

        System.out.println(driver.getWindowHandle());
        // acilan her bir pencereye verilen unique hash code degerini veririr

        System.out.println(driver.getWindowHandles());
        //birden fazla pencere aciliyorsa acilan tum pencereleri unique hash code'lerini bir set olarak dondurur




        Thread.sleep(5000); // milisaniye olarak yazdigimiz sayi süresince bekeler
        driver.close(); // acilan browseri kapatir



    }
}

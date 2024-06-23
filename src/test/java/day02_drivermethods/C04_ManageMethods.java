package day02_drivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_ManageMethods {
    public static void main(String[] args) throws InterruptedException {




        //TechPro sayfasina gidelim. https://www.techproeducation.com/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techproeducation.com/");

        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanın olculeri = " + driver.manage().window().getSize());

        //Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //Sayfanin boyutlarini maximize durumunda yazdirin
        System.out.println("Sayfanın olculeri = " + driver.manage().window().getSize());
        Thread.sleep(3000);

        //Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();
        Thread.sleep(3000);

        //Sayfanin boyutlarini fullscreen durumunda yazdirin
        System.out.println("Sayfanın olculeri = " + driver.manage().window().getSize());

        //Sayfayi kapatin
        driver.quit();

    }
}

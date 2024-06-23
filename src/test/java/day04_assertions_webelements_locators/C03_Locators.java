package day04_assertions_webelements_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Locators {

    //Go to Amazon page
    //Locate the search box and print and search for iPhone
    //close the page

    //test01 oluştur, https://amazon.com sayfasına git

    @Test
    void test01() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");

        /* <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
        placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0"
        aria-label="Search Amazon" spellcheck="false">
        NOT : Eger bir arama kutusunu locate edip bir text gonderirsek 2 sekilde enter tusuna basabiliriz
        1) submit ();
        2) Keys.ENTER*/

        //Arama kutusunu id ile locate ediniz ve iphone yazdırıp aratınız
        // 1. YOL
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone");
        searchBox.submit();

        //Arama kutusunu id ile locate ediniz ve iphone yazdırıp aratınız
        //2. YOL
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        Thread.sleep(5000);

        //Arama kutusunu name ile locate ediniz ve iphone yazdırıp aratınız
        //3.YOL name Attribute
        driver.findElement(By.name("field-keywords")).sendKeys("iphone",Keys.ENTER);

        //sayfayı kapatınız
        driver.quit();


    }
}

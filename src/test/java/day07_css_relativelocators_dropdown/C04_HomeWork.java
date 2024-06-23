package day07_css_relativelocators_dropdown;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C04_HomeWork {

        @Test
        void test01() {

        //Amaç: Google'da bir arama yaparak sonuçları kontrol etmek.   Adımlar:
        //Selenium WebDriver'ı kullanarak bir tarayıcıyı açın (Google Chrome, Firefox, vb.).
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Google ana sayfasını açın.
        driver.get("https://google.com");

        //Bir arama yapın (örneğin, "Selenium").
        WebElement searchBox = driver.findElement(By.cssSelector(".gLFyf"));
        searchBox.sendKeys("selenium", Keys.ENTER);

        //Sonuçların sayfa başlığını kontrol edin ve doğru sonuçları aldığınızı doğrulayın.
        Assertions.assertTrue(driver.getTitle().contains("selenium"));

        //İlk sayfadaki ilk üç sonucu alın ve bunları konsola yazdırın.

    }

        @Test
        void test02() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.google.com/ adresine gidin
        driver.get("https://google.com");
        Thread.sleep(2000);

        //cookies uyarisi cikarsa kabul ederek kapatin
        //Sayfa basliginin "Google" ifadesi icerdigini test edin
        Assertions.assertTrue(driver.getTitle().contains("Google"));

        //Arama cubuguna "Selenium" yazip aratin
        WebElement searchBox = driver.findElement(By.cssSelector(".gLFyf"));
        searchBox.sendKeys("selenium", Keys.ENTER);

        // Bulunan sonuc sayisini yazdirin
        WebElement resultNumber = driver.findElement(By.id("result-stats"));
        System.out.println("Bulunan sonuc sayisi = " + resultNumber.getText());  //Yaklaşık 269.000.000 sonuç bulundu (0,23 saniye)

        // sonuc sayisinin 10 milyon'dan fazla oldugunu test edin

        String stringNumber = resultNumber.getText().split(" ")[1];
        System.out.println("number = " + stringNumber);

        int intNumber = Integer.parseInt(stringNumber.replaceAll("[.]",""));
        System.out.println("intNumber = " + intNumber);

        Assertions.assertTrue(intNumber>10000000);

        // Sayfayi kapatin
        driver.quit();
    }
}

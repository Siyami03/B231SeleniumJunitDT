package day05_webelements_locators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_WebelementsLocators {// Go to Google page
        // Find the search box according to the "name" attribute and type "selenium"
        // Make the call
        //Test that the header contains selenium
        //Print how many links are on the page to the console
        //If the links on the page have text, print them to the console
        //close the page

    //test01 oluştur,obje oluştur, sayfayı maximize yap, 15 sn wait yap

    @Test
    void test01() {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.google.com sayfasına git.
        driver.get("https://www.google.com");

        // Arama kutusunu "name" attribute e göre bularak "selenium" yaz
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("selenium");

        // Aramayı yap
        searchBox.submit();

        //Başlığın selenium içerdiğini test et
        Assertions.assertTrue(driver.getTitle().contains("selenium")) ;

        //Sayfada kaç tane link olduğunu yazdır
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin Sayisi = " + links.size());

        /* Eğer birden fazla webelement locate etmek istiyorsak findEelements methodu kullanırız ve bu method bize
         elemanları webelement olan bir list return eder.
         Bir webelemente ait yazıyı alabilmek için getText() methodunu kullanırız */

        //Sayfadaki linklerin metinleri varsa konsola yazdır
        for (WebElement w : links) {
            if (!w.getText().isEmpty()){
                System.out.println(w.getText());
            }
        }

        //sayfayı kapat
        driver.quit();
    }
}
package day14_exceptions_takescreenshot;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementException extends TestBase {

        /*StaleElementException nasil alinir?
        ==> Bir sayfadaki bir webelementi locate ettikten ve bunu bir webelement seklinde sakladiktan sonra o sayfada
        yenileme yapan herhangi bir islem(navigate.refresh(), back(), forward()...) yapildiginda locateini aldigimiz
        webelementi tekrar kullanmak istersek bu exceptionu aliriz

        Bu hatayi nasil handle ederiz?
        ==> navigate.refresh(), back(), forward() ...methodlari kullanildiginda webelementi tekrar locate etmeliyiz   */

        @Test
        void test01() {
        //test01 oluştur
        //https://techproeducation.com sitesine git
        driver.get("https://techproeducation.com");

        //Arama kutusunu locate et
        WebElement searchBox = driver.findElement(By.id("searchHeaderInput"));

        //arama kutusuna "CAYLAR TAZE" yazdır
        searchBox.sendKeys("CAYLAR TAZE");

        //sayfayı yinele
        driver.navigate().refresh();

        //arama kutusuna "CAYLAR TAZE" yazdır
        searchBox.sendKeys("CAYLAR TAZE");

        //Exception cözumu icin yeniden locate al
        searchBox = driver.findElement(By.id("searchHeaderInput"));

        //arama kutusuna "CAYLAR TAZE" yazdır
        searchBox.sendKeys("CAYLAR TAZE");
    }

        /*
        ==> ElementClickInterceptedException : Bir webelementin baska bir webelement(pop-up, reklam, cookies)
        tarafindan engellenmesi sonucunda bu hatayi aliriz

        ==> WebDriverException : Webdriver ile ilgili internet, kurulum yada versiyon uyumsuzluklari nedeniyle alinir

        ==> InvalidArgumentException : Eger bir methoda gecersiz bir arguman gönderirsek bu hatayi aliriz      */

        @Test
        void invalidArgumentExceptionTest() {
            driver.get("123");
    }
}

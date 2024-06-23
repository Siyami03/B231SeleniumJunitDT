package day14_exceptions_takescreenshot;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

        /*Eger sayfadaki bir webelementi locate ettikten sonra NoSuchElementExcepiton aliyorsak;
        1) Locate i tekrar kontrol etmek
        2) Wait / Syncronization problemi olabilir; implictly wait suresini artirabiliriz
        3) Webelementin iframe icinde olup olmadigini kontrol ederiz
        4) Driver webelementi göremiyordur, dolayisiyla actions class yardimiyla scroll yaparak webelementin gorunur
           olmasini saglariz
        5) Bir linke tiklandiginda yeni bir sayfa ya da sekme aciliyorysa ve driveri bu yeni acilan sayfaya gecirmeden
          o sayfadaki bir webelementi locate edersek bu hatayi aliriz                                */

        @Test
        void test01() {

        /*Bilincli olarak yanlis locate aldik ve NoSuchElementExcepiton aldik      */
        //https://techproeducation.com adresine git
        driver.get("https://techproeducation.com");

        //Aramu kutusunun locateni al
        WebElement searchBox = driver.findElement(By.id(" searchHeaderInput"));

        //Arama kutusuna "Batch231" yazdir
        searchBox.sendKeys("Batch231");
    }
}

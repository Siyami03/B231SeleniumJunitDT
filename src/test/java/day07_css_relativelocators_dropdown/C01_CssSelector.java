package day07_css_relativelocators_dropdown;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_CssSelector {

        /*SYNTAX
        1) tagName [ attributeName = 'attributeValue' ]
        2) Eger id ile css locate almak istersek #idAttributeDegeri
        3) Eger class ile css locate almak istersek .classAttributeDegeri

        XPath ile Css Selector arasindaki fark:
        1) cssSelector Xpath'e gore daha hizli calisir
        2) Xpath ile bir webelement icin birden fazla sonuc verirse index ile bunu tek'e dusurebiliriz
            Fakat cssSelector ile index kullanamayiz
        3) Xpath ile bir webelementi sadece text'i ile locate edebiliriz
            Fakat css ile bunu yapamayiz
         */

        //Go to https://the-internet.herokuapp.com/add_remove_elements/
        //Press the Add Element button
        //Test that the delete button is visible
        //press the delete key
        //Test that the "Add/Remove Elements" text is visible
        //close the page

        @Test
        void test01() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(2000);

        //Add Element butonuna basin
        driver.findElement(By.cssSelector("button[ onclick= 'addElement()' ]")).click();

        //Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.cssSelector("button[ class= 'added-manually' ]"));
        Assertions.assertTrue(deleteButton.isDisplayed());
        Thread.sleep(2000);

        //Delete tusuna basin
        deleteButton.click();

        //"Add/Remove Elements" yazisinin gorunur oldugunu test edin
        WebElement addRemoveElement = driver.findElement(By.cssSelector("h3"));
        Assertions.assertTrue(addRemoveElement.isDisplayed());
        Thread.sleep(2000);

        //sayfayı kapatınız
        driver.quit();
    }
}

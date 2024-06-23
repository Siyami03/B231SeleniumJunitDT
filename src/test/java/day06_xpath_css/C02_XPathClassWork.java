package day06_xpath_css;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_XPathClassWork {

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

        //Add Element butonuna basin
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();

        //Delete butonu'nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));
        Assertions.assertTrue(deleteButton.isDisplayed());
        Thread.sleep(2000);
        //Delete tusuna basin
        deleteButton.click();
        Thread.sleep(2000);
        //"Add/Remove Elements" yazisinin gorunur oldugunu test edin
       WebElement addRemoveElement = driver.findElement(By.xpath("//h3"));
       Assertions.assertTrue(addRemoveElement.isDisplayed());

        //sayfayı kapatınız
        driver.quit();


    }

}

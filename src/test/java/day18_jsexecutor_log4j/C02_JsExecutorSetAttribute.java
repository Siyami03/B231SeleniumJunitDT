package day18_jsexecutor_log4j;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JsExecutorSetAttribute extends TestBase {

    @Test
    void test01() {

        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(3);

        /*
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
        placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0"
        aria-label="Search Amazon" spellcheck="false">
         */

        //jsexecutor ile arama kutusuna selenium yazdiralim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='selenium'",searchBox);

    }


    @Test
    void test02() {
        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(3);

        //jsexecutor ile arama kutusuna selenium yazdiralim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        jsSendKeys(searchBox,"selenium");
    }

    @Test
    void test03() {
        //amazona gidelim
        driver.get("https://amazon.com");
        waitForSecond(3);

        //jsexecutor ile arama kutusunun id degerini ismimiz ile degistirelim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        /*
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
        placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0"
        aria-label="Search Amazon" spellcheck="false">
         */

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('id','mehmet')",searchBox);

        //Degistirmis oldugumuz id ile arama kutusunu locate edelim
        driver.findElement(By.id("mehmet")).sendKeys("selenium");

    }


}

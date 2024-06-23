package day17_excel_jsexecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_JSExecutorClick extends TestBase {

        @Test
        void test01() {
        //amazon sayfasina gidelim
        driver.get("https://amazon.com");
        waitForSecond(3);

        //sell webelementine tikalayalim
        WebElement sell = driver.findElement(By.xpath("//*[.='Sell']"));
        sell.click();
        //sell linkinin önü kapandigi ici ElementClickInterceptedException aldik
    }

        @Test
        void test02() {
        //amazon sayfasina gidelim
        driver.get("https://amazon.com");
        waitForSecond(3);

        //sell webelementine tikalayalim
        WebElement sell = driver.findElement(By.xpath("//*[.='Sell']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",sell);

    }

        @Test
        void test03() {
        //amazon sayfasina gidelim
        driver.get("https://amazon.com");
        waitForSecond(3);

        //sell webelementine tikalayalim
        WebElement sell = driver.findElement(By.xpath("//*[.='Sell']"));
        jsClick(sell);

    }
}

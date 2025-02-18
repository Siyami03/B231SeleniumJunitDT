package day14_exceptions_takescreenshot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {

        //Bu exception alidiginda ExplicitWait akla gelmeli ve ;
        //1) ExplicitWait süresi artirilmalidir.
        //2) Explicit wait ile aldigimiz locate i kontrol etmeliyiz
        //3) Explicit wait ile locate ettigimiz webelement iframe icinde olabilir dolayisiyla iframe e gecis yapmamiz gerekir

        //NOT ==> Eger implicitlywait te sure yeterli olmazsa NoSuchElementException aliriz

        @Test
        void test01() {

        //test01 oluştur
        //https://the-internet.herokuapp.com/dynamic_loading/1 adresine git
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.tagName("button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement helloWorld = driver.findElement(By.xpath("//*[.='Hello World!']"));
        wait.until(ExpectedConditions.visibilityOf(helloWorld));
        Assertions.assertEquals("Hello World!",helloWorld.getText());
    }
}

package day09_iframe_windowhandles_basicauthentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {

        /*
        Bir HTML dökümani icinde yerlestirilmis olan baska bir HTML dökümanina Inline Frame (iframe) denir. Sayfadaki bir
        webelementi locate ettigimizde NoSuchElement Exception aliyorsak locate'i kontrol ederiz ve yine ayni hatayi
        aliyorsak ulasmak istedgimiz webelement iframe icinde olabilir. Dolayisiyla iframe icindeki bir webelemente ulasmak
        icin driverimizi iframe'e gecirmemiz gerekir

        Bunu 3 sekilde yapabiliriz :
        1)  driver.switchTo().frame( sayfadaki iframe in index ini verebiliriz  ) index 0 dan baslar
        2)  driver.switchTo().frame( <iframe> id / name attribute degeri   )
        3)  driver.switchTo().frame( iframe webelementi  )

        Tekrar ana sayfaya gecmek istersek defaultContent() methodu ile gecebiliriz.
        Eger ic ice iframelere gecis yaptiysak ve bir üst frame'e tekrar driver'i tasimak istersek parentFrame()
        methodu ile bir üst frame e gecis yapabiliriz.     */

        //https://testcenter.techproeducation.com/index.php?page=iframe
        //Test that the text 'An iframe with a thin black border:' on the home page contains 'black border'
        //Also test that the text 'Applications lists' is on the page
        //Test that there is an iframe text in the page

        @Test
        void test01() {

        //test01 oluştur
        //https://testcenter.techproeducation.com/index.php?page=iframe sitesine git
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin oldugunu test edin
        String actualText = driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']")).getText();
        Assertions.assertTrue(actualText.contains("black border"));

        //Ayrica 'Applications lists' yazisinin sayfada oldugunu test edin
        driver.switchTo().frame(0);
        WebElement aplicationsListWE = driver.findElement(By.xpath("//h1"));
        Assertions.assertTrue(aplicationsListWE.getText().contains("Applications lists"));

        //sayfada iframe yazısının olduğunu test edin
        driver.switchTo().defaultContent();
        WebElement iframeText = driver.findElement(By.xpath("//h3"));
        Assertions.assertTrue(iframeText.getText().contains("iframe"));
    }
}

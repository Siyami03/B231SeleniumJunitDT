package day15_screenshots_extentreport;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_WebElementScreenShot extends TestBase {

        //go to the Amazon page
        //search for laptop in the search box
        //take the screenshot
        //get the image of the result text webelement

        @Test
        void test01() throws IOException {

        //https://amazon.com sayfasına gidelim
        driver.get("https://amazon.com");
        waitForSecond(3);

        //Arama kutusunda laptop aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop", Keys.ENTER);

        //ekran resmini alalım
        screenShot();

        //sonuc yazısı webelementinin resmini alalım
        WebElement resultText = driver.findElement(By.xpath("//*[  contains(  text() , 'results for'   )  ]"));

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path ="src\\test\\java\\screenshots\\resultTextWebElement"+date+".png";
        Files.write(Paths.get(path),  resultText.getScreenshotAs(OutputType.BYTES));
    }

        @Test
        void test02() throws IOException {

        //https://amazon.com sayfasına gidelim
        driver.get("https://amazon.com");
        waitForSecond(3);

        //Arama kutusunda laptop aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop", Keys.ENTER);

        //ekran resmini alalım
        screenShot();

        //sonuc yazısı webelementinin resmini alalım
        WebElement resultText = driver.findElement(By.xpath("//*[ contains( text() , 'results for')]"));
        sceenShotOfWebElement(resultText);
    }
}

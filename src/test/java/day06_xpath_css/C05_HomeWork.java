package day06_xpath_css;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_HomeWork {


        @Test
        void test01() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //   ChromeDriver kullanarak, facebook sayfasina gidin
        driver.get("https://facebook.com");

        //   sayfa basliginin (title) "Facebook"icerdigini dogrulayin,
        String title = driver.getTitle();
        Assertions.assertTrue(title.contains("Facebook"));

        //   Sayfa URL'inin "facebook"kelimesi icerdigini dogrulayin,
        String url = driver.getCurrentUrl();
        Assertions.assertTrue(url.contains("facebook"));

        //https://testcenter.techproeducation.com/ sayfasina gidin.
        driver.get("https://testcenter.techproeducation.com/");

        //   Sayfa basliginin "Automation Engineer"icerdigini dogrulayin.
        String titleexpectedData = "Automation Engineer";
        String titleactualData = driver.getTitle();
        Assertions.assertTrue(titleactualData.contains(titleexpectedData));

        //   Sayfa URL'inin "techproeducation"kelimesi icerdigini dogrulayin,
        String UrlExpectedData = "techproeducation";
        String UrlActualData = driver.getCurrentUrl();
        Assertions.assertTrue(UrlActualData.contains(UrlExpectedData));

        //   "Back to TechProEducation.com" butonunun görüntülendigini doğrulayin
        WebElement backToEducationButton = driver.findElement(By.cssSelector("a[target='_blank']"));
        Assertions.assertTrue(backToEducationButton.isDisplayed());

        //   "Back to TechProEducation.com" butonunun üzerindeki yazinin TechProEducation icerdigini doğrulayin
        Assertions.assertTrue(backToEducationButton.getText().contains("TechProEducation"));

        //   Tekrar "facebook"sayfasina donun
        driver.navigate().back();

        //   Geri döndüğünüzü doğrulayin.
        String expectedTitle = "Facebook";
        String actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitle));

        //   Sayfayi kapatin
        driver.quit();
    }
}

package day03_implicitlywait_junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C02_JunitFirstTest {

    /* test01 adında bir test methodu oluştur, Chrome driver objesi oluştur, sayfayı maximize yap, 15 sn wait yap,
    techppro sitesine git, sayfayı kapat */

    @Test
    public void test01(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://techproeducation.com");
        driver.close();
    }

    /* test02 adında bir test methodunu kısa yoldan oluştur, Edge driver objesi oluştur, sayfayı maximize yap, 15 sn
    wait yap, facebook sitesine git, sayfayı kapat */

    @Test
    void test02() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://facebbok.com");
        driver.close();
    }

    /* test03 adında bir test methodunu kısa yoldan oluştur,FireFox driver objesi oluştur, sayfayı maximize yap, 15 sn
    wait yap, google sitesine git, sayfayı kapat */

    @Test
    void test03() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://google.com");
        driver.close();
    }

}

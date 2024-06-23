package day03_implicitlywait_junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C04_ClassWork {

    /* C02'yi kopyala, beforeEach methodu oluştur, ilgili kodları buraya kes/yapıştır */

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
        driver.get("https://techproeducation.com");
    }

    @Test
    void test02() {
        driver.get("https://facebook.com");
    }

    @Test
    void test03() {
        driver.get("https://google.com");
    }

    /* afterEach methodu oluştur, ilgili kodları buraya yaz */

    @AfterEach
    void tearDown() {
        driver.close();
    }
}
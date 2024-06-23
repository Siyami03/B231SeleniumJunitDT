package day05_webelements_locators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_HomeWork {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    void test01() throws InterruptedException {

        //1-Web sayfasına gidin. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);

        //2-Search(ara) "city bike"
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("city bike", Keys.ENTER);

        //3-Cikan sonuc yazisini yazdirin
        WebElement resultText = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println("Arama sonucu = " + resultText.getText());

        //4-Ilk urunun locate ini alin
        WebElement ilkUrun = driver.findElement(By.xpath("//*[.='6KU Fixie Urban Track Bike']"));

        //5-Ilk urunun gorunur olup olmadıgını true veya false seklinde yazdirin
        if (ilkUrun.isDisplayed()){
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
        //6-Ilk urunun erisilebilir olup olmadigini true veya false seklinde yazdirin
        if (ilkUrun.isEnabled()){
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }

        //7-Ilk urunun secilabilir olup olmadigini true veya false seklinde yazdirin
        if (ilkUrun.isSelected()){
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
        Thread.sleep(3000);

        //8-Ilk urune tiklayin
        ilkUrun.click();

        //9-Sayfayı kapatın
        driver.quit();

    }
}

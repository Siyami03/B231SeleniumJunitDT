package day01_firstdriversetting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Driver {
    public static void main(String[] args) {

        /* ChromeDriver, Seleniumdan gelen komutlari alir ve bunlari Chrome'un anlayabileceği sekilde cevirir
        Bunun icin java dan  System.setProperty() methodu ile Selenium'a ChromeDriver'in konumunu bildirerek
        ChromeBrowserin doğru bir sekilde baslatilmasini saglar    */

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();  //bos bir chrome acar
        driver.get("https://google.com");       //get() methodu ile String olarak belirttigimiz url'e gideriz
        driver.quit();                          //oturumu sonlandırır.

    }
}

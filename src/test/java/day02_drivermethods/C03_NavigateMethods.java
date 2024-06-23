package day02_drivermethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_NavigateMethods {
    public static void main(String[] args) throws InterruptedException {

        // go to techproeducation homepage https://www.techproeducation.com/
        //Go to Amazon page. https://www.amazon.com/
        //Go back to techproeducation page
        //Go to Amazon page again
        //Refresh the page
        //Close all pages

        // techproeducation ana sayfasina gidelim . https://www.techproeducation.com/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.techproeducation.com/");
        Thread.sleep(3000);

        //Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(3000);

        //Tekrar techproeducation sayfasina donelim
        driver.navigate().back();
        Thread.sleep(3000);

        //Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();
        Thread.sleep(3000);

        //Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();
        Thread.sleep(3000);

        //Tum sayfalari kapatalim
        driver.quit();

        /*Java'da Thread.sleep(3000); kodu mevcut is parcacigini (thread) belirtilen sure kadar duraklatir.
        Bu kod hard wait olarak ta adlandirilir yani ne olursa olsun 3 saniye bekleyecek demektir.
        Test uzmanlari bu waiti kullanmaktan kacinmaladir, cunku gereksiz beklemelere neden olur.
        Gelecek derslerde seleniumdan gelen dynamic wait leri ogreneceğiz    */


    }
}

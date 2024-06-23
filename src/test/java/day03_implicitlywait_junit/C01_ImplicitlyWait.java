package day03_implicitlywait_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ImplicitlyWait {
    public static void main(String[] args) {

        /*Bir sayfaya gittigimizde internetten kaynakli ya da sayfaya ayni anda cok fazla giris yapilmasindan kaynakli
        webelementler hemen yüklenmeyebilir.Dolayisiyla islem yapilmak istenen webelement henuz yuklenmemisse kodlarimiz
        bu elemenit bulamaz ve hata aliriz. İste bu nedenle implicitlyWait methodu ile bekleme yaparak bu sayfanin
        yuklenmesini belirteceğimiz maximum icin bekletme saglariz.İmplicitly wait ile isimizin cogunu hallederiz geriye
        kalan detaylar icin ilerleyen dersimizde explicitwait ögreneceğiz  */

        //Go to TechProEducation page
        //test that the page title contains TechPro Education
        //go to facebook page
        //test that the page url contains facebook
        //go back to techpro page
        //Test that you are back
        //close the page

        /* chrome driver oluştur, obje oluştur, sayfayı maximize yap, sayafyı 15 sn beklet */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();      //driver'imiza tüm web elementleri rahatlıkla gösterebilmek icin yaptik
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //techpro sayfasına gidiniz
        driver.get("https://www.techproeducation.com");

        //sayfa başlığının TechPro Education içerdiğini test ediniz
        String expectedData = "TechPro Education";
        String actualData = driver.getTitle();
        if (actualData.contains(expectedData)){     System.out.println("TEST PASSED");        }
        else {   System.out.println("TEST FAIL");        }

        //facebook sayfasına gidiniz
        driver.get("https://facebook.com");

        //sayfa url'inin facebook içerdiğini test ediniz
        if (driver.getCurrentUrl().contains("facebook")) { System.out.println("TEST PASSED"); }
        else { System.out.println("TEST FAIL"); }

        //techpro sayfasına geri dönününüz
        driver.navigate().back();

        //Geri döndüğünüzü test ediniz
        //1.yol
        System.out.println("driver.getTitle() = " + driver.getTitle());
        if (driver.getTitle().equals("TechPro Education IT Programs")){ System.out.println("TEST PASSED"); }
        else { System.out.println("TEST FAIL"); }

        //2.yol
        if(driver.getCurrentUrl().equals("https://techproeducation.com/")){ System.out.println("TEST PASSED"); }
        else { System.out.println("TEST FAILED");  }

        //sayfayı kapatınız
        driver.quit();

    }
}

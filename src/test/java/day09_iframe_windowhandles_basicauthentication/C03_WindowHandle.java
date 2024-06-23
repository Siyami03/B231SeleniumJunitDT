package day09_iframe_windowhandles_basicauthentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {

        //On Windows 1, go to https://www.techproeducation.com
        //Verify that the title contains "TechPro Education"
        //Open https://www.youtube.com in Windows 2 (in a new window)
        //In Windows 3 (in a new window), open https://www.linkedin.com:
        //Go to the techproeducation page,
        //go to youtube page,
        //Go to LinkedIn page

        @Test
        void test01() {

        //test01 oluştur
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindowHandle = driver.getWindowHandle();

        //Başlığın "TechPro Education" icerdigini doğrulayın
        Assertions.assertTrue(driver.getTitle().contains("TechPro Education"));

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.WINDOW); // yeni bir pncere acar ve driveri buraya gecis yaptirir.
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle =driver.getWindowHandle();
        waitForSecond(2);

        //techproeducation sayfasına geçiniz
        driver.switchTo().window(techproWindowHandle);
        waitForSecond(2);

        //youtube sayfasına geçiniz
        driver.switchTo().window(youtubeWindowHandle);
        waitForSecond(2);

        //linkedIn sayfasına geçiniz
        driver.switchTo().window(linkedinWindowHandle);
    }

        @Test
        void test02() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindowHandle = driver.getWindowHandle();

        //Başlığın "TechPro Education" icerdigini doğrulayın
        Assertions.assertTrue(driver.getTitle().contains("TechPro Education"));

        //Window 2'de (yeni bir sekmede) https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB); // yeni bir sekme acar ve driveri buraya gecis yaptirir.
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();

        //Window 3'te (yeni bir sekmede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle =driver.getWindowHandle();
        waitForSecond(2);

        //techproeducation sayfasına geçiniz
        driver.switchTo().window(techproWindowHandle);
        waitForSecond(2);

        //youtube sayfasına geçiniz
        driver.switchTo().window(youtubeWindowHandle);
        waitForSecond(2);

        //linkedIn sayfasına geçiniz
        driver.switchTo().window(linkedinWindowHandle);
    }
}

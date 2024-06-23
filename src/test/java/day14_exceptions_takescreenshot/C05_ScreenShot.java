package day14_exceptions_takescreenshot;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_ScreenShot extends TestBase {

        /*Bir sayfanin ekran görüntüsünü almak istersek;
        1) ekran gorunutusunu kaydetmek istedigimiz dosya yolunu belirleriz
        2) TakeScreenShot tipinde bir object declare edip driveri bu objectye assign edeceğiz
            ==> TakeScreenShot ts = driver;
        3) Files classinda write() methodunu kullanarak icine parametre olarak aldigimiz ekran goruntusunu
        nereye kaydedeceğimizi beliritir, getScreenShotAs() methodu ile almis oldugumuz ekran görüntüsün bu
        path e kaydederiz     */

        @Test
        void test01() throws IOException {

        //test01 oluştur
        //https://techproeducation.com sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Ekran görüntüsünü alalim
        String path = "src\\test\\java\\screenshots\\techpro.png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        ts.getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get(path), ts.getScreenshotAs(OutputType.BYTES));
    }

        @Test
        void test02() throws IOException {
        //test02 oluştur
        //https://google.com sayfasina gidelim
        driver.get("https://google.com");

        //Ekran görüntüsünü alalim
        String path = "src\\test\\java\\screenshots\\google.jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        ts.getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get(path), ts.getScreenshotAs(OutputType.BYTES));
    }
}

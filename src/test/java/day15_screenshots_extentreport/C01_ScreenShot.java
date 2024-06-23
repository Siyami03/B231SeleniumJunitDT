package day15_screenshots_extentreport;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C01_ScreenShot extends TestBase {

        @Test
        void test01() throws IOException {

        //facebook sayfasina gidelim
        driver.get("https://facebook.com");

        //Dinamic kayıt oluştur
        //DateTimeFormatter ile anlik zamani alarak istedigimiz formata dynamic olarak dönüstürdük
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());

        //Ekran görüntüsü kayıt yolunu belirle
        String path = "src/test/java/screenshots/facebook"+date+".png";

        //Screenshot objesi olustur
        TakesScreenshot ts = (TakesScreenshot) driver;

        //Ekran goruntusu al
        ts.getScreenshotAs(OutputType.BYTES);

        //Ekran goruntusunu kaydet
        Files.write(Paths.get(path),ts.getScreenshotAs(OutputType.BYTES));
    }

        @Test
        void test02() {

        //TestBase daki methodu kullanarak ekran goruntusu al
        //facebook sayfasina gidelim
        driver.get("https://facebook.com");

        //Ekran goruntusu al
        screenShot();
    }
}

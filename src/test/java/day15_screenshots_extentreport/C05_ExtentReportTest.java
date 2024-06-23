package day15_screenshots_extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C05_ExtentReportTest extends TestBase {

        ExtentReports extentReports;
        ExtentHtmlReporter extentHtmlReporter;
        ExtentTest extentTest;

        @Test
        void test01() {

        //Bu objecti raporlari olusturmak ve yönetmek icin kullanacağız
        extentReports = new ExtentReports();

        /*
        Oncelikle olusturmak istedigimz html reportu project imizde nerede saklamak istiyorsak bir dosya yolu
        olusturmaliyiz, cunku bu path i kullanarak bir tane html report olusturacağız
        bunun icin ExtentHtmlReporter classindan object olusturmaliyiz
         */
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path ="target/extentReport/"+date+"htmlReport.html";
        extentHtmlReporter=new ExtentHtmlReporter(path);

        //ExtentReports' a HTML raporlayiciyi ekler, Bu raporun html formatinda olusturulmasini saglar.
        extentReports.attachReporter(extentHtmlReporter);

        //HTML reportun title kısmını ayarlar, browser sekmesinde görüntülenir
        extentHtmlReporter.config().setDocumentTitle("Batch 231 Test Report");

        //Raporun adini ayarlar, bu raporda görüntülenecek olan genel basliktir
        extentHtmlReporter.config().setReportName("My Extent Report");

        //Bu html reportunda görmek isteyebileceğimiz diger bilgileri asagidaki sekilde key valua olarak girebiliriz
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Test Automation Engineer","Ali Can");

        //Amazon Test adinda yeni bir test olusturur ve bu teste Test Steps alt basligini aciklama olarak ekler
        extentTest=extentReports.createTest("Techproeducation","Test Steps");

        //TechproEducation sayfasina gidelim
        driver.get("https://techproeducation.com/");
        extentTest.info("Kullanici Techpro sayfasina gider");

        //TechproEducation ana sayfada oldugunuzu dogrulayin
        Assertions.assertEquals("https://techproeducation.com/",driver.getCurrentUrl());
        extentTest.info("Kullanici anasayfada oldugunu doğrulamak icin test yapar");
        extentTest.pass("Ana sayfa url testi basarili");

        //Ana Sayfada sosyal medya iconlarinin goruntulendigini dogrulayin
        WebElement icons = driver.findElement(By.xpath("//div[@class='toolbar-sl-share']"));
        Assertions.assertTrue(icons.isDisplayed());
        extentTest.info("Kullanici sosyal medya iconlarini kontrol eder");
        extentTest.pass("Kullanici iconlarin görüntülendigini doğrular");

        extentReports.flush();

    }
}
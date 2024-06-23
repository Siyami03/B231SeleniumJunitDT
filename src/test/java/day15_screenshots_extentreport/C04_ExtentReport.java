package day15_screenshots_extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_ExtentReport {

        /*ExtentReport kullanabilmek icin 3 class a ihtiyac vardir.
        1) ExtentReports classindan raporlamayi baslatmak icin bir object olusturmamiz gerekir
        2) ExtentHtmlReporter classindan raporlari html formatinda olusturmasi icin object olusturmamiz gerekir
        3) ExtentTest classindan test adimlarina bilgi ekleyebilmek icin bir object olusturmamiz gerekir     */

        ExtentReports extentReports;
        ExtentHtmlReporter extentHtmlReporter;
        ExtentTest extentTest;

        @Test
        void extentReportTemplate() {
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
        extentTest=extentReports.createTest("Amazon Test","Test Steps");

        /*========buraya kadar sablon ayarlamalir tamamlandi========================== */

        //Testin basarili oldugunu belirtir ve rapora PASS notunu ekler
        extentTest.pass("PASS");

        //Testle ilgili bilgilndirici not ekler
        extentTest.info("BILGILENDIRME NOTU");

        //Testin basarisiz oldugunu belirtir ve  rapora FAIL MESAJI notunu ekler
        extentTest.fail("FAIL MESAJI");

        //Testle ilgili UYARI MESAJI notunu ekler
        extentTest.warning("UYARI MESAJI");

        //Testin atlandigini belirtilen mesaj ile rapora ekler
        extentTest.skip("ATLATMA MESAJI");

        //Tum test verilerini kaydeder ve HTML raporu olusturur
        extentReports.flush();
    }
}

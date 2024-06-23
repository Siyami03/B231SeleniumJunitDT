package day16_extentreport_webtables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_ExtentReport extends TestBase {

        //Go to Amazon page
        //Search selenium in the search box
        //Verify that the page title contains selenium

        @Test
        void test01() {

        createExtentReport("Amazon Title Test");

        //https://amazon.com sayfasına gidelim
        driver.get("https://amazon.com");
        extentTest.info("Kullanici amazon sayfasina gider");
        waitForSecond(3);
        addscreenShotToReport();

        //Arama kutusunda selenium aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium");
        addScreenShotOfWebElementToReport(searchBox);
        searchBox.submit();
        waitForSecond(1);
        extentTest.info("Arama kutusuna selenium yazilarak aratildi");

        //Sayfa basliginin selenium icerdigini doğrulayalim
        Assertions.assertTrue(driver.getTitle().contains("selenium"));
        extentTest.pass("Sayfa basliginin selenium icerdigini doğrulayandi");
        addscreenShotToReport();

        extentReports.flush();

        //Ekran goruntulerini raporda goruntulemek icin;
        //Target'daki rapor uzerinde sag tik => Open in => explorer => acilan tabloda rapor uzerinde cift tikla
    }
}

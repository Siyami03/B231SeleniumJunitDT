package day08_testbase_alert;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class C04_HomeWork extends TestBase {

    //=====================================================Homework 1===================================================

    @Test
    void test01() throws InterruptedException {

        //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        driver.findElement(By.cssSelector("button[onclick='alertbox()']")).click();
        waitForSecond(2);

        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        String clickTheButton = driver.switchTo().alert().getText();
        System.out.println("clickTheButton = " + clickTheButton);
        driver.switchTo().alert().accept();
        waitForSecond(2);

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna
        // basınız
        driver.findElement(By.xpath("(//a[@class=\"analystic\"])[2]")).click();
        waitForSecond(2);
        driver.findElement(By.xpath("//button[@onclick=\"confirmbox()\"]")).click();
        waitForSecond(2);

        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();
        waitForSecond(2);

        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna
        // basınız
        driver.findElement(By.xpath("(//a[@class=\"analystic\"])[3]")).click();
        waitForSecond(2);
        driver.findElement(By.xpath("//button[@onclick=\"promptbox()\"]")).click();
        waitForSecond(2);

        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("Siyami");
        waitForSecond(2);
        driver.switchTo().alert().accept();
        waitForSecond(2);

        //-Çıkan mesajı konsola yazdırınız
        String massage = driver.findElement(By.id("demo1")).getText();
        System.out.println("massage = " + massage);
        waitForSecond(2);

        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        Assertions.assertEquals("Hello Siyami How are you today", driver.findElement(By.id("demo1")).
                getText());
    }

    //=================================================Homework 2===================================================

    @Test
    void test02() {


        //https://the-internet.herokuapp.com/dropdown adresine gidin
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.SelectByIndexTest methodunu oluşturun ve indeksi kullanarak Seçenek 1'i seçin
        WebElement box1 = driver.findElement(By.id("dropdown"));
        selectIndex(box1, 1);
        waitForSecond(2);

        //2.SelectByValueTest methodunu oluşturun ve  value ile Seçenek 2'yi seçin

        //3.SelectByVisibleTextTest methodunu olusturun ve görünür metinle Seçenek 1 değerini seç
        //4.printAllTest methodunu olusturun ve tüm seceneklerin metinlerini konsol a yazdirin, secenekler arasinda
        // "Option 2" oldugunu test edin
        //5.yeni bir method olusturun ve default olarak secili olan secenegin "Please select an option" oldugunu test edin
        //6.sizeTest adinda yeni bir method olusturun ve dropdown menudeki secenek sayisinin 3 oldugunu test edin,
    }

    //=================================================Homework 3===================================================


    @Test
    void test03() throws InterruptedException {

        //- ebay sayfasına gidiniz
        driver.get("https://ebay.com");

        //- electronics bölümüne tıklayınız
        driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[2]/a")).click();
        waitForSecond(3);

        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        List<WebElement> picture = driver.findElements(By.partialLinkText("presentation"));
        for (WebElement w : picture) {
            w.click();
            Thread.sleep(2000);
            System.out.println("Sayfa baslıgı = " + w.getText());
        }
        //- Her sayfanın sayfa başlığını yazdıralım
    }

    //==========Homework 4===========================

    @Test
    void test04() {

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna basin 100 kez basınız
        WebElement addElementButton = driver.findElement(By.xpath("//*[.='Add Element']"));

        for (int i = 0; i < 100; i++) {
            addElementButton.click();
        }
        driver.navigate().refresh();

        //Delete butonuna 90 kez basınız
        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        int counter = 0;
        for (int i = 0; i < 90; i++) {
            addElementButton = driver.findElement(By.xpath("//*[.='Add Element']"));
            addElementButton.click();
            WebElement deleteButton = driver.findElement(By.xpath("//*[.='Delete']"));
            deleteButton.click();
            counter = counter + 1;
        }
        System.out.println("Delete basma sayisi = " + counter);

        //Ve 90 kez basıldığını doğrulayınız
        Assertions.assertEquals(90,counter);
    }
}



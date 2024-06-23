package practices.practice01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class P02 extends TestBase {

        // Go to https://testpages.herokuapp.com/styled/calculator
        // Test the application for mathematical operations by creating four different test methods.

        // https://testpages.herokuapp.com/styled/calculator adresine gidin
        // Dört farkli test metdhodu olusturarak matematiksel işlem icin uygulamayi test edin.


        @Test
        void plus() {
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        //Birinci kutuya sayi gönderilir
        String firstNumber="12";
        driver.findElement(By.id("number1")).sendKeys(firstNumber);

        //Dropdowna kısayoldan secim yaptik
        driver.findElement(By.id("function")).sendKeys("plus");

        //ikinci kutuya sayi gönderilir
        String secondNumber="3";
        driver.findElement(By.id("number2")).sendKeys(secondNumber);

        //Calculate butonuna tikladik
        driver.findElement(By.cssSelector("#calculate")).click();

        //Application uzerinden sonuc yazisini aldki
        String result = driver.findElement(By.cssSelector("#answer")).getText();
        System.out.println("result = " + result);

        //Toplama islemini yapabilmek icin string olan datalari integer a cevirdik
        //actual ve expected resultlari design ettik
        Integer expectedResult = Integer.valueOf(firstNumber) +  Integer.valueOf(secondNumber);
        Integer actualResult = Integer.valueOf(result);
        waitForSecond(3);
        //Assertion yaptik
        assertEquals(expectedResult,actualResult,"Toplama islemi hatali");
        }

        @Test
        void minus() {
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        //Birinci kutuya sayi gönderilir
        String firstNumber="12";
        driver.findElement(By.id("number1")).sendKeys(firstNumber);

        //Dropdowndan reusable method ile secim yaptik
        WebElement ddm = driver.findElement(By.id("function"));
        selectVisible(ddm,"minus");

        //ikinci kutuya sayi gönderilir
        String secondNumber="3";
        driver.findElement(By.id("number2")).sendKeys(secondNumber);

        //Calculate butonuna tikladik
        driver.findElement(By.cssSelector("#calculate")).click();

        //Application uzerinden sonuc yazisini aldki
        String result = driver.findElement(By.cssSelector("#answer")).getText();
        System.out.println("result = " + result);

        //Toplama islemini yapabilmek icin string olan datalari integer a cevirdik
        //actual ve expected resultlari design ettik
        Integer expectedResult = Integer.valueOf(firstNumber) - Integer.valueOf(secondNumber);
        Integer actualResult = Integer.valueOf(result);
        waitForSecond(3);
        //Assertion yaptik
        assertEquals(10,actualResult,"Cıkarma islemi hatali");
        }

        @Test
        void times() {
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        //Birinci kutuya sayi gönderilir
        String firstNumber="12";
        driver.findElement(By.id("number1")).sendKeys(firstNumber);

        //Dropdowna kısayoldan secim yaptik
        driver.findElement(By.id("function")).sendKeys("times");

        //ikinci kutuya sayi gönderilir
        String secondNumber="3";
        driver.findElement(By.id("number2")).sendKeys(secondNumber);

        //Calculate butonuna tikladik
        driver.findElement(By.cssSelector("#calculate")).click();

        //Application uzerinden sonuc yazisini aldki
        String result = driver.findElement(By.cssSelector("#answer")).getText();
        System.out.println("result = " + result);

        //Toplama islemini yapabilmek icin string olan datalari integer a cevirdik
        //actual ve expected resultlari design ettik
        Integer expectedResult = Integer.valueOf(firstNumber) *  Integer.valueOf(secondNumber);
        Integer actualResult = Integer.valueOf(result);
        waitForSecond(3);
        //Assertion yaptik
        assertEquals(expectedResult,actualResult,"Carpma islemi hatali");
        }

        @Test
        void divide() {
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        //Birinci kutuya sayi gönderilir
        String firstNumber="12";
        driver.findElement(By.id("number1")).sendKeys(firstNumber);

        //Dropdowna kısayoldan secim yaptik
        driver.findElement(By.id("function")).sendKeys("divide");

        //ikinci kutuya sayi gönderilir
        String secondNumber="3";
        driver.findElement(By.id("number2")).sendKeys(secondNumber);

        //Calculate butonuna tikladik
        driver.findElement(By.cssSelector("#calculate")).click();

        //Application uzerinden sonuc yazisini aldki
        String result = driver.findElement(By.cssSelector("#answer")).getText();
        System.out.println("result = " + result);

        //Toplama islemini yapabilmek icin string olan datalari integer a cevirdik
        //actual ve expected resultlari design ettik
        Integer expectedResult = Integer.valueOf(firstNumber) /  Integer.valueOf(secondNumber);
        Integer actualResult = Integer.valueOf(result);
        waitForSecond(3);
        //Assertion yaptik
        assertEquals(expectedResult,actualResult,"Bolme islemi hatali");
        }

        //Merve Y.Tekinin uygulaması
        //"https://www.instagram.com/" adresine gidin
        // Kullanıcı adı ve şifrenizi kullanarak oturum açın.
        //Ara butonuna tıkla.
        //Arama kutusuna mesaj atacağın kişinin ismini gir.
        //Doğru kişinin üzerine tıkla ve profiline gir.
        //Kişiyi takip et
        //Mesaj gönder butonuna tıkla.
        //Uyarı mesajını geç
        //Mesajını yaz ve gönder
        //Sayfayı kapat  :)
    }

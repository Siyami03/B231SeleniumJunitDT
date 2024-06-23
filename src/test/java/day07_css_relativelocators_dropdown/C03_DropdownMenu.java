package day07_css_relativelocators_dropdown;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropdownMenu {

        /*
        Dropdown u automate etmek icin
        1- Dropdown menuyu ilk olarak locate ederiz
        2- Select objecti olusturulur
        3- Select objecti uzerinden istedigimiz method ile secim yapariz
           SYNTAX
           Select options = new Select(Webelement dropdown);
           a-selectByVisibleText()->Kullanici tarafindan görünür metin ile secim yapmak icin kullanilir
           b-selectByIndex()->Index ile secim yapmak icin kullanilir ( index 0 dan baslar)
           c-selectByValue()->value atribute degeri ile secim yapmak icin kullanilir
        4- getOptions() -> Locate ettigimiz dropdown menu deki tum secenekleri bize verir
        5- getFirstSelectedOption() -> Dropdown menudeki secili olan seceneği bize verir
           NOT: Cogu zaman dropdown webelementine sendKeys() methodu ile alt seceneklerden bir secenegi göndererek te
           secim yapabiliriz */

        // Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        // 3 farklı test methodu oluşturalım

        WebDriver driver;

        @BeforeEach
        void setUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

        @Test
        void test01() {
        // 1.Method:
        // a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));

        // b. Select objesi olustur
        Select selectYear = new Select(year);
        Select selectMonth = new Select(month);
        Select selectDay = new Select(day);

        // c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        selectYear.selectByIndex(0);//index 0 dan baslar
        selectMonth.selectByValue("7");//<option value="7">August</option> value degerine göre secer
        selectDay.selectByVisibleText("13");//ekranda gorulen deger gore secer
    }

        @Test
        void test02() {
        // 2.Method:
        // a. Tüm eyalet isimlerini yazdıralım
        WebElement states =  driver.findElement(By.id("state"));
        Select select = new Select(states);
        List<WebElement> statesList = select.getOptions();
        //1 yol
        /* for( WebElement  w : statesList){
           System.out.println(w.getText());      }       */

        //2 yol
        statesList.forEach(t-> System.out.println(t.getText()));       }

        @Test
        void test02a() {
        List<WebElement> statesList = driver.findElements(By.xpath("//select[@id='state']/option"));
        statesList.forEach(t-> System.out.println(t.getText()));         }

        @Test
        void test03() {

        // 1.Method:
        // a.Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));

        year.sendKeys("2021");
        month.sendKeys("May");
        day.sendKeys("19");
    }

        @Test
        void test04() {
        // 3.Method:
        // a.State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement states = driver.findElement(By.cssSelector("#state"));
        Select select = new Select(states);

        String actualOption = select.getFirstSelectedOption().getText();
        String expectedOption ="Select a State";
        Assertions.assertEquals(expectedOption,actualOption);
    }

        @AfterEach
        void tearDown() {
            driver.quit();
        }
}

package day14_exceptions_takescreenshot;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;

public class C03_NullPointerException {

    /*NullPointerException
    Eger bir object yada variable olusturup bu olusturdugumuz objeye assignment yapmadan kullanmak istersek bu hatayi
    aliriz, Cünkü javada degeri null olan bir object ile etkilesim yapilmasina izin vermez     */

    //test01 oluştur, test01 dışında driver variableni oluştur, "https://google.com" adresine git, driver objesini
    //assignment yap

    //test02 oluştur, test01 dışında faker variableni oluştur, fake isim oluştur, faker objesini
    //assignment yap

    //test03 oluştur, test01 dışında action variableni oluştur, action.perform() yap, action objesini
    //assignment YAPMA !!
    WebDriver driver;
    Faker faker;
    Action action;

    @Test
    void test01() {
        driver = new ChromeDriver();
        driver.get("https://google.com");
    }

    @Test
    void test02() {
        faker=new Faker();
        System.out.println(faker.name().fullName());
    }

    @Test
    void test03() {
        action.perform();
    }
}

package day12_faker_files;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.security.Key;

public class C06_HomeWork extends TestBase {
    @Test
    void test01() {

        //HOMEWORK
        //1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");

        //2. "create new account" butonuna basin
        //driver.findElement(By.xpath("//*[.='Yeni hesap oluştur']")).click();
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        waitForSecond(2);

        //3. "firstName" giris kutusuna bir isim yazin
        //4. "surname" giris kutusuna bir soyisim yazin
        Faker faker =new Faker();
        WebElement nameBox = driver.findElement(By.name("firstname"));
        nameBox.sendKeys(faker.name().firstName(), Keys.TAB,
                faker.name().lastName());

        //5. "email" giris kutusuna bir email yazin
        String email = faker.internet().emailAddress();
        WebElement emailBox1 = driver.findElement(By.name("reg_email__"));
        emailBox1.sendKeys(email,Keys.TAB);

        //6. "email" onay kutusuna emaili tekrar yazin
        WebElement emailBox2 = driver.findElement(By.name("reg_email_confirmation__"));
        emailBox2.sendKeys(email);
        
        //7. Bir sifre girin
        //8. Tarih icin gun secin
        //9. Tarih icin ay secin
        //10. Tarih icin yil secin
        //11. Cinsiyeti secin
        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test
        //edin.
        //13. Sayfayi kapatin


    }


}

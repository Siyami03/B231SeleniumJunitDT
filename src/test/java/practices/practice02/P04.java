package practices.practice02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P04 extends TestBase {

        //Go to http://zero.webappsecurity.com
        //Click the Signin button
        //Write "username" in the login field
        //Write "password" in the password field
        //Click the Sign in button
        //Go to the Pay Bills page under Online Banking
        //Write any amount you want to deposit in the amount section
        //write "2020-09-10" in the date field
        //Click the Share button
        //"The payment was successfully submitted." Check if the message appears
        //close the page


        @Test
        void test01() {

        //http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

        //Login alanine  "username" yazdirin
        //Password alanine "password" yazdirin
        //Sign in buttonuna tiklayin
        WebElement login = driver.findElement(By.cssSelector("#user_login"));
        login.sendKeys("username", Keys.TAB,"password",Keys.ENTER);

        driver.navigate().back();//sayfadaki olusan güvenlik uyarisini asmak icin yaptik

        //Online Banking altındaki Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu")).click();
        waitForSecond(2);

        driver.findElement(By.id("pay_bills_link")).click();

        //amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //tarih kismina "2020-09-10" yazdirin
        WebElement amount = driver.findElement(By.id("sp_amount"));
        amount.sendKeys("5000", Keys.TAB, "2020-09-10");

        //Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        //"The payment was successfully submitted." mesajinin ciktigini control edin
        String actualSuccesMessage =  driver.findElement(By.xpath("//*[.='The payment was successfully submitted.']")).getText();
        String expectedSuccesMessage="The payment was successfully submitted.";
        Assertions.assertEquals(expectedSuccesMessage,actualSuccesMessage);

    }
}

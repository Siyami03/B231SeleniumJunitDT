package day10_windowhandles_basicauthentication_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {

        //1-Go to Amazon homepage
        //2-print all cookies in the console with a loop
        //3-Test that the number of cookies on the page is greater than 5
        //4-Test that the value of the cookie named i18n-prefs is USD
        //5-Create a cookie with the name "my favorite cookie" and the value "chocolate" and add it to the page
        //6-Test that the cookie you added has been added to the page
        //7-delete the cookie named skin and test whether it is deleted
        //8-delete all cookies and test if they are deleted

        /*Cookie denildiginde aklima manage() methodu gelmeli. Cookie ler ile ilgili tum islemleri manage() methodu
          sayesinde yapariz      */

        @Test
        void test01() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");
        waitForSecond(3);                                        //captche yi manual olarak gecmek icin hard wait koyduk

        //2-tum cookie’leri consolda bir loop ile yazdirin
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int counter=1;
        for (Cookie  w : cookieSet){
            System.out.println( counter+" . cookie ==>  "+ w);
            System.out.println( counter+" . cookie Name ==>  "+ w.getName());
            System.out.println( counter+" . cookie Value ==>  "+ w.getValue());
            System.out.println("==========================================");
            counter++;
        }

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int actualSize = cookieSet.size();
        Assertions.assertTrue(actualSize>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assertions.assertEquals("USD",actualCookieValue);

        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);//=>cookie yi ekledik
        cookieSet = driver.manage().getCookies();

        int counter2=1;
        for (Cookie  w : cookieSet){
            System.out.println( counter2+" . cookie ==>  "+ w);
            System.out.println( counter2+" . cookie Name ==>  "+ w.getName());
            System.out.println( counter2+" . cookie Value ==>  "+ w.getValue());
            System.out.println("==========================================");
            counter2++;
        }

        //6-eklediginiz cookie’nin sayfaya eklendigini test
        Assertions.assertTrue(cookieSet.contains(cookie));

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assertions.assertNull(driver.manage().getCookieNamed("skin"));

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();//tum cookie leri sildik
        cookieSet=driver.manage().getCookies();//cookieSeti tekrar güncelledik
        Assertions.assertTrue( cookieSet.isEmpty());//isEmpty() methodu ile cookiesetin icinin bos oldugunu doğrladik
    }
}

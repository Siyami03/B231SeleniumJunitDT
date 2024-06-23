package day04_assertions_webelements_locators;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class C01_Assertions {

    //Junit 5'te assertion yapmak için Assertions class'i kullanilir
    //Junit 4'tw Assert classi kullanılır

    //test01 oluştur, iki değerin eşit olduğunu test et
    @Test
    void test01() {
        Assertions.assertEquals(3,3);
    }

    //test02 oluştur, iki değer ile yapılan bir işlemin true olup olmadığını test et
    @Test
    void test02() {
        Assertions.assertTrue(2<5);
    }

    //test03 oluştur, iki değer ile yapılan bir işlemin false olup olmadığını test et
    @Test
    void test03() {
        Assertions.assertFalse("selenium".contains("junit"));
    }

    //test04 oluştur, iki değerin eşit olmadığını test et
    @Test
    void test04() {
        Assertions.assertNotEquals("selenium","junit");
    }

    //test05 oluştur, iki değeri karşılaştır ve eşit olup olmadığını test et
    //Not : İki array'in birbirine esit olabilmesi icin ayni indexte ayni elemanlarin olmasi gerekir
    @Test
    void test05() {
        char [] expectedArray ={'j','u','n','i','t'};
        char [] actualArray ={'j','u','n','t','i'};
        Assertions.assertArrayEquals(expectedArray,actualArray);
    }

    //test06 oluştur, verilen deger null ise test gecer degilse kalir oluştur
    @Test
    void test06() {
        String str = null;
        Assertions.assertNull(str); //Eğer verilen deger null ise test gecer degilse kalir
    }

    //test07 oluştur, Verilen deger null degil ise tetst gecer null ise kalir oluştur
    @Test
    void test07() {
        String str = "selenium";
        Assertions.assertNotNull(str); //Verilen deger null degil ise tetst gecer null ise kalir
    }
}

package day08_testbase_alert;

import org.junit.jupiter.api.Test;
import utilities.TestBase;

public class C01_TestBaseClassWork extends TestBase {


    //utilities package oluştur ve bu package içinde TestBase class oluştur
    //test01 oluştur
    //https://google.com adresine git

    @Test
    void test01() {
        driver.get("https://google.com");
    }
}

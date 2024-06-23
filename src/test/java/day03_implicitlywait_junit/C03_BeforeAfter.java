package day03_implicitlywait_junit;

import org.junit.jupiter.api.*;

public class C03_BeforeAfter {

    /* Kısa yoldan beforeAll methodu oluştur ve yazdır */

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll notasyonuna sahip olan bir method class taki tum test methodlarindan önce 1 kez calistirilir.");
    }

    /* Kısa yoldan beforeEach methodu oluştur ve yazdır */

    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach notasyonuna sahip olan bir method her bir test methodundan önce 1 kez calistirilir.");
    }

    /* Kısa yoldan test01 methodu oluştur ve yazdır */

    @Test
    void test01() {
        System.out.println("test01 calisti");
    }

    /* Kısa yoldan test02 methodu oluştur ve yazdır */

    @Test
    void test02() {
        System.out.println("test02 calisti");
    }

    /* Kısa yoldan test03 methodu oluştur ve yazdır, daha sonraki çalıştırma için bu testi atla */

    @Test @Disabled
    void test03() {
        System.out.println("test03 calisti");
    }

    /* Kısa yoldan afterEach methodu oluştur ve yazdır */

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach notasyonuna sahip olan bir method her bir test methodundan sonra 1 kez calistirilir.");
    }

    /* Kısa yoldan afterAll methodu oluştur ve yazdır */

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll notasyonuna sahip olan bir method class taki tum test methodlarindan sonra 1 kez calistirilir.");

    }
}

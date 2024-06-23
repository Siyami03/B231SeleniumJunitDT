package day12_faker_files;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class C01_Faker {

            @Test
            void fakerClassWork() {
            Faker faker = new Faker();
            //faker objesi ile fake bir isim yazdırınız
            System.out.println("first name  = " + faker.name().firstName());

            //faker objesi ile fake bir soyisim yazdırınız
            System.out.println("lastName = " + faker.name().lastName());

            //faker objesi ile fake bir adress yazdırınız
            System.out.println("fullAddress = " + faker.address().fullAddress());

            //faker objesi ile fake bir telefon No yazdırınız
            System.out.println("phoneNumber = " + faker.phoneNumber().phoneNumber());

            //faker objesi ile fake bir email yazdırınız
            System.out.println("emailAddress = " + faker.internet().emailAddress());

            //faker objesi ile fake bir rastgele 15 haneli bir sayi yazdırınız
            String number = faker.number().digits(15);
            System.out.println("number = " + number);

            //faker objesi ile fake bir isimsoyisim yazdırınız
            System.out.println("fullName = " + faker.name().fullName());
            }

            @Test
            void test01() {

            Faker faker = new Faker(new Locale("TR"));
            System.out.println("fullName = " + faker.name().fullName());
            System.out.println("fullAddress = " + faker.address().fullAddress());
            }
}

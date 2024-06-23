package day12_faker_files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    void test01() {

   /*System.getProperty("user.dir") komutu javada programin suanda calisan dizini verir (current working directory)   */

   System.out.println(System.getProperty("user.dir"));                //C:\Users\siyam\Desktop\B231SeleniumJunitDT
   System.out.println(System.getProperty("user.home"));               //C:\Users\siyam

   /*Bilgisayarimşzda bulunan herhangi bir dosyanin avrligini test edebilmemiz icin; öncelikle varligini test etmek
   istedigimiz dosyanin yolunu almaliyiz. Sonra ise Files.exists() methodu ile test gerceklestrecegiz                 */

   //"C:\Users\siyam\OneDrive\Masaüstü\Batch231.txt"
   String ortakYol="\\OneDrive\\Masaüstü\\Batch231.txt";
   String dynamicPath = System.getProperty("user.home") + ortakYol;
   /*Files.exists(Paths.get(dynamicPath) methodunu kullanarak belirtmis oldugumuz path objectinin dosya sistemimizde var
   olup olmadigini kontrol ettik               */

   Assertions.assertTrue(Files.exists(Paths.get(dynamicPath)));
    }
}


package day17_excel_jsexecutor;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

        @Test
        void test01() throws IOException {
        //1)Oncelikle excel dosyasinin bulundugu path ayarlanir
        String path ="src/test/java/resources/Capitals.xlsx";

        //2) Belirtilen path te bulunan excel dosyasindan java classimiza data akisi olusturur
        FileInputStream fis = new FileInputStream(path);

        //3) java ortaminda bir excel dosyasi actik
        Workbook workbook = WorkbookFactory.create(fis);

        //4) Bir excel dosyasinda birden fazla sayfa bulunabilir
        //Sheet1 adli calisma sayfasini acmak ve buradaki datalara erismek icin kullanilir
        Sheet sheet = workbook.getSheet("Sheet1");

        //5)Bir excel sayfasindan belirtilen indexteki satira erismek icin kullanilir
        Row row = sheet.getRow(0);//index 0 dan baslar

        //6)Bir rowda birden fazla cell vardir, belirtilen indexteki celle erismek icin kullanilir
        Cell cell = row.getCell(0);

        System.out.println(cell);
    }

        @Test
        void test02() throws IOException {

        //1)Oncelikle excel dosyasinin bulundugu path ayarlanir
        String path ="src/test/java/resources/Capitals.xlsx";

        //2) Belirtilen path te bulunan excel dosyasindan java classimiza data akisi olusturur
        FileInputStream fis = new FileInputStream(path);

        //3) java ortaminda bir excel dosyasi actik
        Workbook workbook = WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0));


    }
}

package day17_excel_jsexecutor;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcel {

        @Test
        void test01() throws IOException {

        //classwork
        //mysmoketestdata.xlsx dosyasina STATUS adinda ucuncu bir sutun olusturunuz,
        // Bu sutun altinda satirlara sirasiyla valid valid ve invalid degerlerini yaziniz

        FileInputStream fis = new FileInputStream("src/test/java/resources/mysmoketestdata.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sheet1 = workbook.getSheet("customer_info");

        Row row =sheet1.getRow(0);

        //ucuncu celli olustur
        Cell cell3= row.createCell(2);

        // ucuncu cell in value sunu STATUS olarak ayarladi
        cell3.setCellValue("STATUS");

        //ikinci satirin ucuncu hucresini olusturacağız ve bu hücrenin degerini valid olarak ayarlayacağız
        sheet1.getRow(1).createCell(2).setCellValue("valid");

        //ücün satirin ucuncu hucresini olusturacağız ve bu hücrenin degerini valid olarak ayarlayacağız
        sheet1.getRow(2).createCell(2).setCellValue("valid");

        //dördüncü satirin ucuncu hucresini olusturacağız ve bu hücrenin degerini valid olarak ayarlayacağız
        sheet1.getRow(3).createCell(2).setCellValue("invalid");

        FileOutputStream fos = new FileOutputStream("src/test/java/resources/mysmoketestdata.xlsx");
        workbook.write(fos);

        fis.close();
        fos.close();

        }
}

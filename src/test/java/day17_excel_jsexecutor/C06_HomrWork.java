package day17_excel_jsexecutor;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C06_HomrWork extends TestBase {

    //HOMEWORK
        /*Bir "Name" sütunu oluşturup isimlerini excel doyasına yazınız:
         ("ayhan","beyhan","ceyhan","ali","veli","ahmet","can","sam","kate","raj","pam")  */

    @Test
    void test01() throws IOException {

        String path = "src/test/java/resources/mysmoketestdata.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("customer_info");
        Row row = sheet.getRow(0);
        Cell cell3 = row.createCell(2);
        cell3.setCellValue("Name");

        sheet.getRow(1).createCell(2).setCellValue("ayhan");
        sheet.getRow(2).createCell(2).setCellValue("beyhan");
        sheet.getRow(3).createCell(2).setCellValue("ceyhan");
        sheet.getRow(4).createCell(2).setCellValue("ali");
        sheet.getRow(5).createCell(2).setCellValue("veli");
        sheet.getRow(6).createCell(2).setCellValue("ahmet");
        sheet.getRow(7).createCell(2).setCellValue("can");
        sheet.getRow(8).createCell(2).setCellValue("sam");
        sheet.getRow(9).createCell(2).setCellValue("kate");
        sheet.getRow(10).createCell(2).setCellValue("raj");
        sheet.getRow(11).createCell(2).setCellValue("pam");

        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);

        fis.close();
        fos.close();

    }
}

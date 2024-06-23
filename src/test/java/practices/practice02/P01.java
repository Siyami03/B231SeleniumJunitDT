package practices.practice02;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class P01 extends TestBase {

        //https://demo.guru99.com/test/radio.html
        //select Option2 from the radio button
        //select if checkbox1 and checkbox3 are not selected
        //Test that Option2 is selected from the radio button
        //Test that Option 3 is not selected in the radio button
        //test that checkbox1 and checkbox3 are selected
        //test if checkbox2 element is not selected



        @Test
        void test01() {
        // https://demo.guru99.com/test/radio.html
        driver.get("https://demo.guru99.com/test/radio.html");

        // radio button dan Option2 yi seçin
        WebElement option1=driver.findElement(By.id("vfb-7-1"));
        WebElement option2=driver.findElement(By.id("vfb-7-2"));
        WebElement option3=driver.findElement(By.id("vfb-7-3"));

        option2.click();


        // checkbox1 ve checkbox3 seçili değilse seçin
        WebElement checkBox1= driver.findElement(By.id("vfb-6-0"));
        WebElement checkBox2= driver.findElement(By.id("vfb-6-1"));
        WebElement checkBox3= driver.findElement(By.id("vfb-6-2"));

        if(!checkBox1.isSelected()){
            checkBox1.click();
        }

        if(!checkBox3.isSelected()){
            checkBox3.click();
        }

        // radio button dan Option2 seçili oldugunu test edin
        assertTrue(option2.isSelected(),"option 2 secili degil");

        // radio button da Option 3 ün secili olmadigini test edin
        assertFalse(option3.isSelected(), "option 3 secili");

        // checkbox1 ve checkbox3 seçili olduğunu test edein
        assertTrue(checkBox1.isSelected());
        assertTrue(checkBox3.isSelected());

        // checkbox2 elementinin seçili olmadığını test edin
        assertFalse(checkBox2.isSelected());

    }
}


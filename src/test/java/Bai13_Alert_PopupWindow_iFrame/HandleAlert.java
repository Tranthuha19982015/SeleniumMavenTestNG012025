package Bai13_Alert_PopupWindow_iFrame;

import common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HandleAlert extends BaseTest {
    @Test
    public void demoHandleAlertAccept() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
        Thread.sleep(1000);

        //Click vào nút "Click Me" thứ nhất
        driver.findElement(By.xpath("//p[text()='JavaScript Alerts']/button[text()='Click Me']")).click();
        Thread.sleep(1000);

        //Khởi tạo class Alert
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());

        //Dùng hàm accept() để xác nhận Alert (tương ứng click vào nút OK)
        alert.accept();
        Thread.sleep(1000);
    }

    @Test
    public void demoHandleAlertDismiss() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
        Thread.sleep(1000);

        //Click vào nút "Click Me" thứ hai
        driver.findElement(By.xpath("//p[text()='Confirm box:']/button[text()='Click Me']")).click();
        Thread.sleep(1000);

        //Khởi tạo class Alert
        Alert alert = driver.switchTo().alert();
        //Dùng hàm dismiss() để từ chối Alert (tương ứng click vào nút Cancel)
        alert.dismiss();
        Thread.sleep(1000);
        //Kiểm tra Alert đã được từ chối thành công hay chưa
        List<WebElement> confirmDemo = driver.findElements(By.xpath("//p[text()='You pressed Cancel!']"));
        Assert.assertTrue(confirmDemo.size() > 0, "Nhấn Cancel không thành công!");

//        String expectedMessage = "You pressed Cancel!";
//        String actualMessage = driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText();
//        Assert.assertEquals(actualMessage, expectedMessage, "Nhấn Cancel không thành công");
        Thread.sleep(1000);
    }

    @Test
    public void demoHandleAlertInputTextOther() throws InterruptedException {
        String textInput = "Hatest alert input text";
        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
        Thread.sleep(1000);

        //Click vào nút "Click Me" thứ nhất
        driver.findElement(By.xpath("//p[text()='Prompt box:']/button[text()='Click Me']")).click();
        Thread.sleep(1000);

        //Khởi tạo class Alert
        Alert alert = driver.switchTo().alert();
        //Dùng hàm sendKeys() để nhập dữ liệu vào Alert
        alert.sendKeys(textInput);
        Thread.sleep(1000);
        //Nhấn Ok button
        alert.accept();
        Thread.sleep(1000);
        //Kiểm tra Alert đã được xác nhận thành công hay chưa
        String resultInput = driver.findElement(By.xpath("//p[@id='prompt-demo']")).getText();
        Assert.assertTrue(resultInput.contains(textInput), "Nhập dữ liệu vào Alert không thành công");
        Thread.sleep(1000);
    }
}

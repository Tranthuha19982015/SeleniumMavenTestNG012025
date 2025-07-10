package Bai11_Assert;

import Bai10_Annotations.testcases.LocatorsCRM;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestHardAssert extends BaseTest {
    @Test(priority = 1)
    public void testHardAssert() {

        driver.get("https://anhtester.com");

        String expectedTitle = "Anh Tester Automation Testing 123";
        String actualTitle = driver.getTitle();

        System.out.println("*** Checking For The Title ***");

        Assert.assertEquals(actualTitle, expectedTitle, "Tiêu đề trang không khớp với mong đợi");
    }

    @Test(priority = 2)
    public void testLoginCRMSuccess() throws InterruptedException {
        System.out.println("testLoginSuccess");
        // truy cập link web CRM
        driver.get(LocatorsCRM.url);
        Thread.sleep(1000);

        // Login CRM
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
        Thread.sleep(1000);

        // verify login success

//        code sai - Java sẽ hiện lỗi, không hiển thị lỗi chủ động từ Assert do tester set
//        boolean checkMenuDashboard = driver.findElement(By.xpath(LocatorsCRM.linkMenuDashboard)).isDisplayed();  // do check bằng isDisplayed()
//        Assert.assertTrue(checkMenuDashboard, "Menu Dashboard không hiển thị, đăng nhập thất bại");

//        code đúng - để hiển thị lỗi chủ động từ Assert do tester set
        List<WebElement> checkDashboard = driver.findElements(By.xpath(LocatorsCRM.linkMenuDashboard));
        System.out.println("checkDashboard = " + checkDashboard.size());

        Assert.assertTrue(checkDashboard.size() > 0, "Menu Dashboard không hiển thị, đăng nhập thất bại");

        System.out.println("Đăng nhập thành công vào CRM");
    }
}

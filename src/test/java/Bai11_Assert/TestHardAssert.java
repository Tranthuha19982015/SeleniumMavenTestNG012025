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

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 2)
    public void testLoginCRMSuccess() {
        System.out.println("Đăng nhập thành công vào CRM");
        // truy cập link web CRM
        driver.get(LocatorsCRM.url);

        // Login CRM
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

//        boolean checkLoginSuccess = driver.findElement(By.xpath(LocatorsCRM.linkMenuCustomer)).isDisplayed();

        List<WebElement> checkDashboard = driver.findElements(By.xpath(LocatorsCRM.linkMenuDashboard));
        System.out.println("checkDashboard = " + checkDashboard.size());

        Assert.assertTrue(checkDashboard.size() > 0, "Menu Dashboard không hiển thị, đăng nhập thất bại");
    }
}

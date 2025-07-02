package Bai10_Annotations.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    @Test(priority = 1)
    public void loginCRM() {
        System.out.println("Đăng nhập thành công vào CRM");
        // truy cập link web CRM
        driver.get(LocatorsCRM.url);

        // Login CRM
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
    }

    @Test(priority = 2)
    public void loginEmailInvalid() {
        System.out.println("Đăng nhập vào CRM không thành công do email không hợp lệ");
        // truy cập link web CRM
        driver.get(LocatorsCRM.url);

        // Login CRM
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin123@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
    }
}

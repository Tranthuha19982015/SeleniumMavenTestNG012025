package Bai9_TestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;

public class RunTestNG {
    WebDriver driver;

    //    Khoi tao trinh duyet Chrome
    @BeforeMethod
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    //    Thuc thi cac test case (chay test 2 lan)
    @Test
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//h2[@class='card__title mt-0']//a[contains(text(),'Sử dụng Chat AI để generate code Test Automation')]"));
        Assert.assertEquals(element.getText(), "Sử dụng Chat AI để generate code Test Automation", "Title does not match!");
    }

    @Test
    public void testCRM() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//h1[normalize-space()='Login']"));
        Assert.assertEquals(element.getText(), "Login", "Title does not match!");
    }

    //    Dong trinh duyet sau khi test xong
    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}

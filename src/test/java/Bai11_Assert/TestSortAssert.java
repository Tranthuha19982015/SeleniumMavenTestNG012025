package Bai11_Assert;

import common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSortAssert extends BaseTest {
    @Test(priority = 1)
    public void testSoftAssert() throws InterruptedException {

        driver.get("https://anhtester.com");

        SoftAssert softassert = new SoftAssert();

        String expectedTitle = "Anh Tester Automation Testing";
        String actualTitle = driver.getTitle();

        System.out.println("*** Checking For The First Title ***");
        softassert.assertEquals(actualTitle, expectedTitle);

        driver.findElement(By.xpath("//a[@id='btn-login']")).click();
        Thread.sleep(2000);
        System.out.println("*** Checking For The Second Title ***");

        String actualLoginPageTitle = driver.getTitle();
        softassert.assertEquals(actualLoginPageTitle, "Login");

        softassert.assertAll(); // Bắt buộc phải gọi assertAll() để kiểm tra tất cả các assert đã được thực hiện
    }
}

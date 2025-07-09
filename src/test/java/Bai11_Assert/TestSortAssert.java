package Bai11_Assert;

import common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSortAssert extends BaseTest {
    @Test(priority = 1)
    public void testSoftAssert() {

        driver.get("https://anhtester.com");

        SoftAssert softassert = new SoftAssert();

        String expectedTitle = "Anh Tester";
        String actualTitle = driver.getTitle();

        System.out.println("*** Checking For The First Title ***");

        softassert.assertEquals(actualTitle, expectedTitle);

        driver.findElement(By.xpath("//a[@id='btn-login']")).click();

        System.out.println("*** Checking For The Second Title ***");

        String actualLoginPageTitle = driver.getTitle();

        softassert.assertEquals(actualLoginPageTitle, "Login");

        softassert.assertAll(); // Kết thúc quá trình kiểm tra Soft Assert, nếu có lỗi sẽ hiển thị tất cả các lỗi đã gặp trong quá trình kiểm tra
    }
}

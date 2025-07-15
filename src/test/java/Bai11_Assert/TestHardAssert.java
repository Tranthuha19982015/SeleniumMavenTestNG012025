package Bai11_Assert;

import Bai10_Annotations.testcases.LocatorsCRM;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin1@example.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
        Thread.sleep(1000);

        // verify login success

//        code sai - Java sẽ hiện lỗi, không hiển thị lỗi chủ động từ Assert do tester set
        // không tìm thấy phần tử Selenium sẽ ném ra lỗi NoSuchElementException ⇒ test dừng tại đó, không tới dòng Assert.assertTrue.
//        boolean checkMenuDashboard = driver.findElement(By.xpath(LocatorsCRM.linkMenuDashboard)).isDisplayed();
//        Assert.assertTrue(checkMenuDashboard, "Menu Dashboard không hiển thị, đăng nhập thất bại");

//        code đúng - để hiển thị lỗi chủ động từ Assert do tester set
//        Selenium sẽ không ném ra lỗi NoSuchElementException nếu không tìm thấy phần tử, chỉ trả về list = 0 phần tử
        List<WebElement> checkMenuDashboard = driver.findElements(By.xpath(LocatorsCRM.linkMenuDashboard));
        System.out.println("checkMenuDashboard = " + checkMenuDashboard.size());
        Assert.assertTrue(checkMenuDashboard.size() > 0, "Menu Dashboard không hiển thị, đăng nhập thất bại");
        System.out.println("Đăng nhập thành công vào CRM");
    }

    @Test(priority = 3)
    public void testAddNewCustomer() throws InterruptedException {
        String customerName = "Hatest Company" + System.currentTimeMillis();

        // truy cập link web CRM
        driver.get(LocatorsCRM.url);
//        Thread.sleep(1000);

        // Login CRM
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
//        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
//        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
        Thread.sleep(1000);

        //Verify login success
        List<WebElement> checkMenuDashboard = driver.findElements(By.xpath(LocatorsCRM.linkMenuDashboard));
        System.out.println("checkMenuDashboard = " + checkMenuDashboard.size());
        Assert.assertTrue(checkMenuDashboard.size() > 0, "Menu Dashboard không hiển thị, đăng nhập thất bại");

        // Click vào menu Customers
        driver.findElement(By.xpath(LocatorsCRM.linkMenuCustomer)).click();

        // Verify menu Customers hiển thị
        List<WebElement> checkMenuCustomer = driver.findElements(By.xpath("//span[normalize-space()='Customers Summary']"));
        System.out.println("checkMenuCustomer = " + checkMenuCustomer.size());
        Assert.assertTrue(checkMenuCustomer.size() > 0, "Menu Customer không hiển thị");
        // Verify tiêu đề Customers Summary hiển thị
        String headerCustomerText = driver.findElement(By.xpath("//span[normalize-space()='Customers Summary']")).getText();
        Assert.assertEquals(headerCustomerText, "Customers Summary", "Tiêu đề không khớp với mong đợi");

        driver.findElement(By.xpath(LocatorsCRM.buttonNewCustomer)).click();

        driver.findElement(By.xpath(LocatorsCRM.inputCompany)).sendKeys(customerName);
        driver.findElement(By.xpath(LocatorsCRM.inputVatNumber)).sendKeys("10");
        driver.findElement(By.xpath(LocatorsCRM.inputPhone)).sendKeys("0965868594");
        driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).sendKeys("https://www.hatestcompany.com");
//        dropdown group
        driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchGroups)).sendKeys("VIP", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();
        Thread.sleep(1000);
//        default currency
        driver.findElement(By.xpath(LocatorsCRM.dropdownCurrency)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCurrency)).sendKeys("USD", Keys.ENTER);
        Thread.sleep(1000);
//        language default
        driver.findElement(By.xpath(LocatorsCRM.dropdownDefaultLanguage)).click();
        Thread.sleep(1000);
//        C1:
        String xpathLanguage = String.format(LocatorsCRM.optionDefaultLanguage, "Vietnamese");
        driver.findElement(By.xpath(xpathLanguage)).click();
        Thread.sleep(1000);
//        C2:
//        driver.findElement(By.xpath(LocatorsCRM.selectXPathLanguage("Vietnamese"))).click();

        driver.findElement(By.xpath(LocatorsCRM.inputAddress)).sendKeys("123 Street, City, Country");
        driver.findElement(By.xpath(LocatorsCRM.inputCity)).sendKeys("Hanoi");
        driver.findElement(By.xpath(LocatorsCRM.inputState)).sendKeys("Hanoi");
        driver.findElement(By.xpath(LocatorsCRM.inputZipCode)).sendKeys("100000");
//          country
        driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry)).sendKeys("Vietnam", Keys.ENTER);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.buttonSave)).click();
        Thread.sleep(2000);
    }
}

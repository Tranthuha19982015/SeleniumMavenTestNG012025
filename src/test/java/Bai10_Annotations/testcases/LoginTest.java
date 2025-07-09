package Bai10_Annotations.testcases;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    @Test(priority = 1)
    public void testLoginSuccess() throws InterruptedException {

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

        //verify login success

        System.out.println("Đăng nhập thành công vào CRM");
    }

    @Test(priority = 2)
    public void testLoginFailWithEmailInvalid() throws InterruptedException {
        System.out.println("testLoginFailWithEmailInvalid");
        // truy cập link web CRM
        driver.get(LocatorsCRM.url);
        Thread.sleep(1000);

        // Login CRM
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin123@example.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
        Thread.sleep(1000);

        System.out.println("Đăng nhập vào CRM không thành công do email không hợp lệ");
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

        // Click vào menu Customers
        driver.findElement(By.xpath(LocatorsCRM.linkMenuCustomer)).click();
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

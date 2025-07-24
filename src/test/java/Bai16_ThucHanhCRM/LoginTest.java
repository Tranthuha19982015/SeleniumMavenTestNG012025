package Bai16_ThucHanhCRM;

import Bai10_Annotations.testcases.LocatorsCRM;
import common.BaseTest;
import keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class LoginTest extends BaseTest {
    @Test
    public void testLoginSuccess() {
        driver.get(LocatorsCRM.url);
        WebUI.setText(driver, By.xpath(LocatorsCRM.inputEmail), "admin@example.com");
        WebUI.setText(driver, By.xpath(LocatorsCRM.inputPassword), "123456");
        WebUI.clickElement(driver, By.xpath(LocatorsCRM.buttonLogin));

        boolean dashboardElements = driver.findElements(By.xpath(LocatorsCRM.linkMenuDashboard)).size() > 0;
        Assert.assertTrue(dashboardElements, "Login failed or Dashboard not display.");

//        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.linkMenuDashboard)).isDisplayed());
    }

    @Test
    public void testLoginFailureWithEmailInvalid() {
        driver.get(LocatorsCRM.url);
        WebUI.setText(driver, By.xpath(LocatorsCRM.inputEmail), "12admin@example.com");
        WebUI.setText(driver, By.xpath(LocatorsCRM.inputPassword), "123456");
        WebUI.clickElement(driver, By.xpath(LocatorsCRM.buttonLogin));

        // Wait for the error message to be visible
        boolean isElementsErrorMessage = driver.findElements(By.xpath("//div[@id='alerts']/div[contains(text(),'Invalid email or password')]")).size() > 0;

        System.out.println("Element Error Message: " + "//div[@id='alerts']/div[contains(text(),'Invalid email or password')]");

        Assert.assertTrue(isElementsErrorMessage, "The error message for invalid email not display.");
    }

    @Test
    public void testLoginFailureWithPasswordInvalid() {
        driver.get(LocatorsCRM.url);
        WebUI.setText(driver, By.xpath(LocatorsCRM.inputEmail), "admin@example.com");
        WebUI.setText(driver, By.xpath(LocatorsCRM.inputPassword), "12345678");
        WebUI.clickElement(driver, By.xpath(LocatorsCRM.buttonLogin));

        // Wait for the error message to be visible
        boolean isElementsErrorMessage = driver.findElements(By.xpath("//div[@id='alerts']/div[contains(text(),'Invalid email or password')]")).size() > 0;

        System.out.println("Element Error Message: " + "//div[@id='alerts']/div[contains(text(),'Invalid email or password')]");

        Assert.assertTrue(isElementsErrorMessage, "The error message for invalid email not display.");
    }

    @Test
    public void testLoginFailureWithEmailNull() {
        driver.get(LocatorsCRM.url);
        WebUI.setText(driver, By.xpath(LocatorsCRM.inputEmail), "");
        WebUI.setText(driver, By.xpath(LocatorsCRM.inputPassword), "12345678");
        WebUI.clickElement(driver, By.xpath(LocatorsCRM.buttonLogin));

        // Wait for the error message to be visible
        boolean isElementsErrorMessage = driver.findElements(By.xpath("//div[text()='The Email Address field is required.']")).size() > 0;

        System.out.println("Element Error Message: " + "//div[text()='The Email Address field is required.']");

        Assert.assertTrue(isElementsErrorMessage, "The error message for Email required not display.");
    }

    @Test
    public void testLoginFailureWithPasswordNull() {
        driver.get(LocatorsCRM.url);
        WebUI.setText(driver, By.xpath(LocatorsCRM.inputEmail), "admin@example.com");
        WebUI.setText(driver, By.xpath(LocatorsCRM.inputPassword), "");
        WebUI.clickElement(driver, By.xpath(LocatorsCRM.buttonLogin));

        // Wait for the error message to be visible
        boolean isElementsErrorMessage = driver.findElements(By.xpath("//div[text()='The Password field is required.']")).size() > 0;

        System.out.println("Element Error Message: " + "//div[text()='The Password field is required.']");

        Assert.assertTrue(isElementsErrorMessage, "The error message for Password required not display.");
    }
}

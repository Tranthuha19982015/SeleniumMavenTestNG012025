package Bai17_PageObjectModel.pages;

import Bai10_Annotations.testcases.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    //Khai báo driver trong từng trang
    private WebDriver driver;

    //Khai bao URL của trang Login
    private String urlLogin = "https://crm.anhtester.com/admin/authentication";

    //Khai bao doi tuong wait cho trang Login
    private WebDriverWait wait;

    //Khai báo hàm xây dựng cho từng trang
    public LoginPage(WebDriver driver) {
        this.driver = driver; //Từ khóa this phân biệt 2 biến cùng tên trong cùng 1 hàm
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //Khai báo các đối tượng element thuộc về trang Login
    private By headerLogin = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By checkboxRememberMe = By.xpath("//input[@id='remember']");
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");
    private By errorMessageInvalid = By.xpath("//div[@id='alerts']");
    private By errorMessageRequiredEmail = By.xpath("//div[normalize-space()='The Email Address field is required.']");
    private By errorMessageRequiredPassword = By.xpath("//div[normalize-space()='The Password field is required.']");

    //Khai báo các hàm xử lý nội bộ trên trang Login
    private void setEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
        driver.findElement(inputEmail).sendKeys(email);
    }

    private void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        driver.findElement(inputPassword).sendKeys(password);
    }

    private void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonLogin));
        driver.findElement(buttonLogin).click();
    }

    public void loginCRM(String email, String password) {
        driver.get(urlLogin);
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    public void verifyLoginSuccess() {
        boolean dashboardElements = driver.findElements(By.xpath("//span[normalize-space()='Dashboard']")).size() > 0;
        Assert.assertTrue(dashboardElements, "Login failed or Dashboard not display.");
    }
}

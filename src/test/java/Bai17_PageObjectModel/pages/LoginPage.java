package Bai17_PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    //Khai báo driver trong từng trang
    private WebDriver driver;

    //Khai báo URL của trang Login
    private String urlLoginAdmin = "https://crm.anhtester.com/admin/authentication";

    //Khai báo hàm xây dựng cho từng trang
    public LoginPage(WebDriver driver) {
        this.driver = driver; //Từ khóa this phân biệt 2 biến cùng tên trong và ngoài
    }

    //Khai báo các đối tượng element thuộc về trang Login (khai báo những element cần thiết cho TCs sau này)
    private By headerLoginPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By checkboxRememberMe = By.xpath("//input[@id='remember']");
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");
    private By errorMessageInvalid = By.xpath("//div[@id='alerts']/div[contains(text(),'Invalid email or password')]");
    private By errorMessageRequiredEmail = By.xpath("//div[normalize-space()='The Email Address field is required.']");
    private By errorMessageRequiredPassword = By.xpath("//div[normalize-space()='The Password field is required.']");

    //Khai báo các hàm xử lý nội bộ trong nội bộ trang Login

    public void verifyLoginPageDisplay() {
        boolean isElementPresent = driver.findElements(headerLoginPage).size() > 0;
        Assert.assertTrue(isElementPresent, "Login page is not displayed.");
    }

    public void navigateToLoginAdminCRM() {
        driver.get(urlLoginAdmin);
    }

    private void setEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    private void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    private void clickLoginButton() {
        driver.findElement(buttonLogin).click();
    }

    public void loginCRM(String email, String password) {
        navigateToLoginAdminCRM();
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    public void verifyLoginSuccess() {
        boolean isElementPresent = driver.findElements(By.xpath("//span[normalize-space()='Dashboard']")).size() > 0;
        Assert.assertTrue(isElementPresent, "Login failed or Dashboard not displayed.");
    }

    public void verifyLoginFailureWithInvalidEmailOrPassword() {
        boolean isElementErrorMessage = driver.findElements(errorMessageInvalid).size() > 0;
        Assert.assertTrue(isElementErrorMessage, "Error message for invalid email not displayed.");
    }

    public void verifyLoginFailureWithEmailNull() {
        boolean isElementErrorMessage = driver.findElements(errorMessageRequiredEmail).size() > 0;
        Assert.assertTrue(isElementErrorMessage, "Error message for required email not displayed.");
    }

    public void verifyLoginFailureWithPasswordNull() {
        boolean isElementErrorMessage = driver.findElements(errorMessageRequiredPassword).size() > 0;
        Assert.assertTrue(isElementErrorMessage, "Error message for required password not displayed.");
    }
}

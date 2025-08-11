package Bai20_21_Practise_POM_CRM.pages;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {

    //Khai báo driver trong từng trang
    private WebDriver driver;

    //Khai báo URL của trang Login
    private String urlLoginAdmin = "https://crm.anhtester.com/admin/authentication";

    //Khai báo hàm xây dựng cho từng trang
    public LoginPage(WebDriver driver) {
        super(driver);
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
        Assert.assertTrue(WebUI.waitForElementVisible(driver,headerLoginPage), "Login page is not displayed.");
    }

    public void navigateToLoginAdminCRM() {
        driver.get(urlLoginAdmin);
    }

    private void enterEmail(String email) {
        WebUI.setText(driver, inputEmail, email);
    }

    private void enterPassword(String password) {
        WebUI.setText(driver, inputPassword, password);
    }

    private void clickLoginButton() {
        WebUI.clickElement(driver, buttonLogin);
    }

    public void loginCRM(String email, String password) { //Chỉ dùng nội bộ trang Login
        navigateToLoginAdminCRM();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public DashboardPage loginCRM() { //Dùng để liên kết trang
        navigateToLoginAdminCRM();
        enterEmail("admin@example.com");
        enterPassword("123456");
        clickLoginButton();
        verifyLoginSuccess();

        return new DashboardPage(driver); //Trả về đối tượng DashboardPage sau khi đăng nhập thành công
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(WebUI.waitForElementVisible(driver,menuDashboard), "Login failed or Dashboard not displayed.");
    }

    public void verifyLoginFailureWithInvalidEmailOrPassword() {
        Assert.assertTrue(WebUI.waitForElementVisible(driver,errorMessageInvalid), "Error message for invalid email not displayed.");
    }

    public void verifyLoginFailureWithEmailNull() {
        Assert.assertTrue(WebUI.waitForElementVisible(driver,errorMessageRequiredEmail), "Error message for required email not displayed.");
    }

    public void verifyLoginFailureWithPasswordNull() {
        Assert.assertTrue(WebUI.waitForElementVisible(driver,errorMessageRequiredPassword), "Error message for required password not displayed.");
    }
}

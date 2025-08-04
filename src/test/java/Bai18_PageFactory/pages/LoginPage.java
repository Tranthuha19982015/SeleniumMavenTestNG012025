package Bai18_PageFactory.pages;

import keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
        PageFactory.initElements(driver, this); //Từ khóa this: tại class này
    }

    //Khai báo các đối tượng element thuộc về trang Login (khai báo những element cần thiết cho TCs sau này)
    @FindBy(xpath = "//h1[normalize-space()='Login']")
    private WebElement headerLoginPage;
    @FindAll({
            @FindBy(id = "email"),
            @FindBy(xpath = "//input[@id='email']")
    })

    private WebElement inputEmail;
    @FindBy(id = "password")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement buttonLogin;
    @FindBy(xpath = "//input[@id='remember']")
    private WebElement checkboxRememberMe;
    @FindBy(xpath = "//a[normalize-space()='Forgot Password?']")
    private WebElement linkForgotPassword;
    @FindBy(xpath = "//div[@id='alerts']/div[contains(text(),'Invalid email or password')]")
    private WebElement errorMessageInvalid;
    @FindBy(xpath = "//div[normalize-space()='The Email Address field is required.']")
    private WebElement errorMessageRequiredEmail;
    @FindBy(xpath = "//div[normalize-space()='The Password field is required.']")
    private WebElement errorMessageRequiredPassword;

    //Khai báo các hàm xử lý nội bộ trong nội bộ trang Login

    public void verifyLoginPageDisplay() {
        boolean isElementPresent = false;
        try {
            isElementPresent = headerLoginPage.isDisplayed(); //nếu đúng trả về True, nếu False trả về catch bên dưới
        } catch (Exception e) {
            isElementPresent = false;
        }
        Assert.assertTrue(isElementPresent, "Login page is not displayed.");

    }

    public void navigateToLoginAdminCRM() {
        driver.get(urlLoginAdmin);
    }

    // dùng 3 hàm dưới để có thể custom thêm cho hàm như Wait,...
    private void enterEmail(String email) {
        WebUI.setText(driver, inputEmail, email);
    }

    private void enterPassword(String password) {
        WebUI.setText(driver, inputPassword, password);
    }

    private void clickLoginButton() {
        WebUI.clickElement(driver, buttonLogin);
    }

    //
    public void loginCRM(String email, String password) {
        navigateToLoginAdminCRM();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public void verifyLoginSuccess() {
        boolean isElementPresent = false;
        try {
            isElementPresent = menuDashboard.isDisplayed();
        } catch (Exception e) {
            isElementPresent = false;
        }
        Assert.assertTrue(isElementPresent, "Login failed or Dashboard not displayed.");
    }

    public void verifyLoginFailureWithInvalidEmailOrPassword() {
        boolean isElementErrorMessage = false;
        try {
            isElementErrorMessage = errorMessageInvalid.isDisplayed();
        } catch (Exception e) {
            isElementErrorMessage = false;
        }
        Assert.assertTrue(isElementErrorMessage, "Error message for invalid email not displayed.");
    }

    public void verifyLoginFailureWithEmailNull() {
        boolean isElementErrorMessage = false;
        try {
            isElementErrorMessage = errorMessageRequiredEmail.isDisplayed();
        } catch (Exception e) {
            isElementErrorMessage = false;
        }
        Assert.assertTrue(isElementErrorMessage, "Error message for required email not displayed.");
    }

    public void verifyLoginFailureWithPasswordNull() {
        boolean isElementErrorMessage = false;
        try {
            isElementErrorMessage = errorMessageRequiredPassword.isDisplayed();
        } catch (Exception e) {
            isElementErrorMessage = false;
        }
        Assert.assertTrue(isElementErrorMessage, "Error message for required password not displayed.");
    }
}

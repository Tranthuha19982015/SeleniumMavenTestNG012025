package Bai18_PageFatory.testcases;

import Bai18_PageFatory.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @Test(priority = 1)
    public void testLoginSuccess() {
        loginPage = new LoginPage(driver); //Khởi tạo đối tượng LoginPage với driver lấy từ BaseTest
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2)
    public void testLoginFailureWithEmailInvalid() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("12admin@example.com", "123456");
        loginPage.verifyLoginFailureWithInvalidEmailOrPassword();
    }

    @Test(priority = 3)
    public void testLoginFailureWithPasswordInvalid() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "12345678");
        loginPage.verifyLoginFailureWithInvalidEmailOrPassword();
    }

    @Test(priority = 4)
    public void testLoginFailureWithEmailNull() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("", "123456");
        loginPage.verifyLoginFailureWithEmailNull();
    }

    @Test(priority = 5)
    public void testLoginFailureWithPasswordNull() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "");
        loginPage.verifyLoginFailureWithPasswordNull();
    }
}

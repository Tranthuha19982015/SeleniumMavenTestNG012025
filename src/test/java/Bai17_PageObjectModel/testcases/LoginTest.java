package Bai17_PageObjectModel.testcases;

import Bai17_PageObjectModel.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @Test
    public void testLoginSuccess() {
        loginPage = new LoginPage(driver); //Khởi tạo đối tượng LoginPage với driver lấy từ BaseTest

        loginPage.loginCRM("admin@example.com","123456");
        loginPage.verifyLoginSuccess();
    }
}

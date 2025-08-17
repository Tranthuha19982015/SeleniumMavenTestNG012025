package Bai22_23_WebUI.testcases;

import Bai22_23_WebUI.pages.CustomersPage;
import Bai22_23_WebUI.pages.DashboardPage;
import Bai22_23_WebUI.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class CustomersTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;

    @Test
    public void testAddNewCustomer() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        customersPage = dashboardPage.clickMenuCustomers();

        String customerName = "Company HTest " + System.currentTimeMillis();

        customersPage.verifyNavigateToCustomerPage();
        customersPage.clickButtonNewCustomer();
        customersPage.fillDataForAddNewCustomer(customerName);
        customersPage.clickSaveButton();
        customersPage.verifyNavigateToCustomerDetailPage();
        customersPage.verifyAddNewCustomerSuccess(customerName);
    }
}

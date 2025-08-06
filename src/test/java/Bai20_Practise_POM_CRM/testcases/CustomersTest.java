package Bai20_Practise_POM_CRM.testcases;

import Bai20_Practise_POM_CRM.pages.CustomersPage;
import Bai20_Practise_POM_CRM.pages.DashboardPage;
import Bai20_Practise_POM_CRM.pages.LoginPage;
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
        customersPage.submitDataForAddNewCustomer(customerName);
        customersPage.verifyNavigateToCustomerDetailPage();
        customersPage.verifyAddNewCustomerSuccess(customerName);
    }
}

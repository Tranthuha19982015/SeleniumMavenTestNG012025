package Bai20_21_Practise_POM_CRM.testcases;

import Bai20_21_Practise_POM_CRM.pages.CustomersPage;
import Bai20_21_Practise_POM_CRM.pages.DashboardPage;
import Bai20_21_Practise_POM_CRM.pages.LoginPage;
import Bai20_21_Practise_POM_CRM.pages.ProjectsPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class ProjectsTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CustomersPage customersPage;
    private ProjectsPage projectsPage;

    @Test
    public void testAddNewProject() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();

        customersPage = dashboardPage.clickMenuCustomers();
        String customerName = "Company HTest " + System.currentTimeMillis();
        customersPage.clickButtonNewCustomer();
        customersPage.fillDataForAddNewCustomer(customerName);
        customersPage.clickSaveButton();

        projectsPage = dashboardPage.clickMenuProjects();
        String projectName = "Project Htest " + System.currentTimeMillis();
        projectsPage.verifyProjectsPageDisplay();
        projectsPage.clickAddNewProjectButton();
        projectsPage.fillDataNewProject(projectName,customerName,"Fixed Rate");
        projectsPage.clickSaveButton();
//        projectsPage.verifyAlertMessageSuccessDisplayed();

    }
}

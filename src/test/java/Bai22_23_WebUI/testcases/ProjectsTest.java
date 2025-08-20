package Bai22_23_WebUI.testcases;

import Bai22_23_WebUI.pages.CustomersPage;
import Bai22_23_WebUI.pages.DashboardPage;
import Bai22_23_WebUI.pages.LoginPage;
import Bai22_23_WebUI.pages.ProjectsPage;
import common.BaseTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        String customerName = "Company HTest " + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        customersPage.clickButtonNewCustomer();
        customersPage.fillDataForAddNewCustomer(customerName);
        customersPage.clickSaveButton();

        projectsPage = dashboardPage.clickMenuProjects();
        String projectName = "Project Htest " + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        projectsPage.verifyProjectsPageDisplay();
        projectsPage.clickAddNewProjectButton();
        projectsPage.fillDataNewProject(projectName,customerName,"Fixed Rate");
        projectsPage.clickSaveButton();
//        projectsPage.verifyAlertMessageSuccessDisplayed();

    }
}

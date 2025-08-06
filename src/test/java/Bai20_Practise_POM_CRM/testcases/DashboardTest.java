package Bai20_Practise_POM_CRM.testcases;

import Bai20_Practise_POM_CRM.pages.DashboardPage;
import Bai20_Practise_POM_CRM.pages.LoginPage;
import Bai20_Practise_POM_CRM.pages.ProjectsPage;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ProjectsPage projectsPage;

    @Test
    public void testLabelProjectsInProgressOnDashboard() {
        loginPage = new LoginPage(driver);
//        loginPage.loginCRM("admin@example.com", "123456");
//        loginPage.verifyLoginSuccess();
//
//        dashboardPage = new DashboardPage(driver);

        dashboardPage = loginPage.loginCRM(); // login và trả về đối tượng DashboardPage: new DashboardPage(driver);

        dashboardPage.verifyDashboardPageDisplay();

        String totalProjectsInProgressOnDashboard = dashboardPage.getTotalProjectsInProgress();
        System.out.println("Total Projects In Progress: " + totalProjectsInProgressOnDashboard);

//        dashboardPage.clickMenuProjects(); // Chuyển sang trang Projects

        projectsPage = dashboardPage.clickMenuProjects();

        Assert.assertEquals(totalProjectsInProgressOnDashboard, projectsPage.getTotalInProgress() + " / " + projectsPage.getTotalProjects(),
                "Total Projects In Progress on Dashboard does not match with Projects Page");
//        dashboardPage.verifyTotalProjectsInprogress(); //cách 2
    }
}

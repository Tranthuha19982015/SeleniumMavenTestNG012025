package Bai18_PageFatory.testcases;


import Bai18_PageFatory.pages.DashboardPage;
import Bai18_PageFatory.pages.LoginPage;
import Bai18_PageFatory.pages.ProjectsPage;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ProjectsPage projectsPage;

    @Test
    public void testCheckListMenuDisplay() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboardPageDisplay();

        dashboardPage.checkListMenuDisplay();
    }

    @Test
    public void testLabelProjectsInProgressOnDashboard() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboardPageDisplay();

        String totalProjectsInProgressOnDashboard = dashboardPage.getTotalProjectsInProgress();
        System.out.println("Total Projects In Progress: " + totalProjectsInProgressOnDashboard);
        dashboardPage.clickMenuProjects();

        projectsPage = new ProjectsPage(driver);

        Assert.assertEquals(totalProjectsInProgressOnDashboard, projectsPage.getTotalInProgress() + " / " + projectsPage.getTotalProjects(),
                "Total Projects In Progress on Dashboard does not match with Projects Page");
//        dashboardPage.verifyTotalProjectsInprogress(); //cách 2
    }
}

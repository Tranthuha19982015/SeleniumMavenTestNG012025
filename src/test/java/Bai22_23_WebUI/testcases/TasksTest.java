package Bai22_23_WebUI.testcases;

import Bai22_23_WebUI.pages.DashboardPage;
import Bai22_23_WebUI.pages.LeadsPage;
import Bai22_23_WebUI.pages.LoginPage;
import Bai22_23_WebUI.pages.TasksPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class TasksTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadsPage leadsPage;
    private TasksPage tasksPage;

    @Test
    public void testAddNewTask() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLeads();

        String leadsName = "Leads Htest " + System.currentTimeMillis();
        leadsPage.clickButtonNewLead();
        leadsPage.fillDataAddNewLead(leadsName);
        leadsPage.clickSaveButton();
        leadsPage.clickButtonCloseAfterAdd();

        tasksPage = leadsPage.clickMenuTasks();

        String subject = "Tasks Htest " + System.currentTimeMillis();
        tasksPage.verifyTasksPageDisplay();
        tasksPage.clickButtonNewTask();
        tasksPage.verifyAddNewTaskPageDisplay();
        tasksPage.fillDataAddNewTask(subject,leadsName);
        tasksPage.clickButtonSave();
        tasksPage.verifyAddNewTaskSuccess();
    }
}

package Bai20_21_Practise_POM_CRM.testcases;

import Bai20_21_Practise_POM_CRM.pages.DashboardPage;
import Bai20_21_Practise_POM_CRM.pages.LeadsPage;
import Bai20_21_Practise_POM_CRM.pages.LoginPage;
import Bai20_21_Practise_POM_CRM.pages.TasksPage;
import common.BaseTest;
import keywords.WebUI;
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

package Bai20_21_Practise_POM_CRM.testcases;

import Bai20_21_Practise_POM_CRM.pages.DashboardPage;
import Bai20_21_Practise_POM_CRM.pages.LoginPage;
import Bai20_21_Practise_POM_CRM.pages.TasksPage;
import common.BaseTest;
import keywords.WebUI;
import org.testng.annotations.Test;

public class TasksTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    TasksPage tasksPage;

    @Test
    public void testAddNewTask() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        tasksPage = dashboardPage.clickMenuTasks();

        String subject = "Tasks Htest " + System.currentTimeMillis();
        tasksPage.verifyTasksPageDisplay();
        tasksPage.clickButtonNewTask();
        tasksPage.verifyAddNewTaskPageDisplay();
        tasksPage.fillDataAddNewTask(subject);
        tasksPage.clickButtonSave();
        WebUI.sleep(2);
    }
}

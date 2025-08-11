package Bai20_Practise_POM_CRM.testcases;

import Bai20_Practise_POM_CRM.pages.DashboardPage;
import Bai20_Practise_POM_CRM.pages.LoginPage;
import Bai20_Practise_POM_CRM.pages.TasksPage;
import common.BaseTest;
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
        tasksPage.clickButtonNewTask();
        tasksPage.submitDataAddNewTask(subject);
    }
}

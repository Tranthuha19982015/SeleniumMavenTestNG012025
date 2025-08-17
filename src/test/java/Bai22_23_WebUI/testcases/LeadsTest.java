package Bai22_23_WebUI.testcases;

import Bai22_23_WebUI.pages.DashboardPage;
import Bai22_23_WebUI.pages.LeadsPage;
import Bai22_23_WebUI.pages.LoginPage;
import Bai22_23_WebUI.pages.TasksPage;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeadsTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadsPage leadsPage;
    private TasksPage tasksPage;

    @Test
    public void testAddNewLead() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLeads();

        String leadsName = "Leads Htest " + System.currentTimeMillis();
        leadsPage.verifyNavigateToLeadPage();
        leadsPage.clickButtonNewLead();
        leadsPage.verifyOpenWindowAddNewLead();
        leadsPage.fillDataAddNewLead(leadsName);
        leadsPage.clickSaveButton();
        leadsPage.clickButtonCloseAfterAdd();
        leadsPage.searchAndCheckLeadInTable(leadsName);
    }

    @Test
    public void testStatusOnTableWithLeadsSummaryAfterAddSuccess() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLeads();

        String leadsName = "Leads Htest " + System.currentTimeMillis();

        leadsPage.verifyNavigateToLeadPage();

        //get total lead status in leads summary
        leadsPage.clickIconLeadsSummary();
        String beforeTotalActive = leadsPage.getTotalStatusActiveLeads();
        leadsPage.clickIconLeadsSummary();
        String beforeTotalCustomer = leadsPage.getTotalStatusCustomerLeads();

        //Add new lead
        leadsPage.clickButtonNewLead();
        leadsPage.verifyOpenWindowAddNewLead();
        //fill data
        leadsPage.fillDataAddNewLead(leadsName);
        leadsPage.clickSaveButton();

        //dong pop-up
        leadsPage.clickButtonCloseAfterAdd();
        //verify add lead success
        leadsPage.searchAndCheckLeadInTable(leadsName);
        String statusOfFisrtRowItem = leadsPage.getFirstRowItemLeadStatus();

        leadsPage.clickMenuLeads();
        leadsPage.clickIconLeadsSummary();

        //get total lead status in leads summary
        String afterTotalActive = leadsPage.getTotalStatusActiveLeads();
        String afterTotalCustomer = leadsPage.getTotalStatusCustomerLeads();

        leadsPage.verifyAfterAddingNewLead(Integer.parseInt(beforeTotalActive), Integer.parseInt(beforeTotalCustomer),
                Integer.parseInt(afterTotalActive), Integer.parseInt(afterTotalCustomer), statusOfFisrtRowItem);
    }

    @Test
    public void testTotalStatusOnTableWithLeadsSummary() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLeads();

        leadsPage.verifyNavigateToLeadPage();

        //get total lead status in leads summary
        leadsPage.clickIconLeadsSummary();
        int totalActiveOnLeadsSummary = Integer.parseInt(leadsPage.getTotalStatusActiveLeads());
        int totalActiveOnTable = leadsPage.countActiveStatusOnTable();
        Assert.assertEquals(totalActiveOnTable, totalActiveOnLeadsSummary,
                "Total active status leads on summary does not match with total active status leads on table.");

        leadsPage.clickIconLeadsSummary();
        int totalCustomerOnLeadsSummary = Integer.parseInt(leadsPage.getTotalStatusCustomerLeads());
        int totalCustomerOnTable = leadsPage.countCustomerStatusOnTable();
        Assert.assertEquals(totalCustomerOnTable, totalCustomerOnLeadsSummary,
                "Total customer status leads on summary does not match with total customer status leads on table.");
    }

    @Test
    public void testLeadValueInTaskAfterAddingSuccessfully() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLeads();

        String leadsName = "Leads Htest " + System.currentTimeMillis();

        leadsPage.verifyNavigateToLeadPage();
        //Add new lead
        leadsPage.clickButtonNewLead();
        leadsPage.verifyOpenWindowAddNewLead();
        //fill data
        leadsPage.fillDataAddNewLead(leadsName);
        leadsPage.clickSaveButton();
        //dong pop-up
        leadsPage.clickButtonCloseAfterAdd();
        //verify add lead success
        leadsPage.searchAndCheckLeadInTable(leadsName);
        //get Lead Name, Lead Email
        String email = leadsPage.getFirstRowItemLeadEmail();

        //Navigate to Tasks page
        tasksPage = leadsPage.clickMenuTasks();
        //Verify that the tasks page is displayed
        tasksPage.verifyTasksPageDisplay();
        //Verify that the add new task page is displayed
        tasksPage.clickButtonNewTask();
        tasksPage.verifyAddNewTaskPageDisplay();
        //Verify lead after successful addition is displayed on the new task screen
        tasksPage.chooseLeadFollowingRelatedTo(leadsName);
        String valueLeadDisplayOnTask = tasksPage.getValueLeadInTask();
        System.out.println("Lead value is displayed on the Add New Task form: " + valueLeadDisplayOnTask);

        //Assert that the lead name and email are displayed correctly in the task creation form
        Assert.assertEquals(valueLeadDisplayOnTask, leadsName + " - " + email, "Lead value on the New Task does not match.");
    }
}

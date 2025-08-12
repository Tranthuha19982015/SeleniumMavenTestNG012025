package Bai20_21_Practise_POM_CRM.testcases;

import Bai20_21_Practise_POM_CRM.pages.DashboardPage;
import Bai20_21_Practise_POM_CRM.pages.LeadsPage;
import Bai20_21_Practise_POM_CRM.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class LeadsTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private LeadsPage leadsPage;

    @Test
    public void testAddNewLead() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLeads();

        String name = "Leads Htest " + System.currentTimeMillis();
        leadsPage.verifyNavigateToLeadPage();
        leadsPage.clickButtonNewLead();
        leadsPage.verifyOpenWindowAddNewLead();
        leadsPage.fillDataAddNewLead(name);
        leadsPage.clickSaveButton();
        leadsPage.clickButtonCloseAfterAdd();
        leadsPage.verifyAddNewLeadSuccess(name);
    }

    @Test
    public void testStatusOnTableWithLeadsSummaryAfterAddSuccess(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLeads();

        String name = "Leads Htest " + System.currentTimeMillis();
        leadsPage.verifyNavigateToLeadPage();
        leadsPage.verifyAfterAddingNewLead(name);
    }
}

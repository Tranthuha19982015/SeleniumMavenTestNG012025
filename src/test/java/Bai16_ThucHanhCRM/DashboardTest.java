package Bai16_ThucHanhCRM;

import Bai10_Annotations.testcases.LocatorsCRM;
import common.BaseTest;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DashboardTest extends BaseTest {
    @Test
    public void testDashboard_CheckQuickStatisticsTotal() {
        driver.get(LocatorsCRM.url);
        WebUI.setText(driver, By.xpath(LocatorsCRM.inputEmail), "admin@example.com");
        WebUI.setText(driver, By.xpath(LocatorsCRM.inputPassword), "123456");
        WebUI.clickElement(driver, By.xpath(LocatorsCRM.buttonLogin));

        boolean dashboardElements = driver.findElements(By.xpath(LocatorsCRM.linkMenuDashboard)).size() > 0;
        Assert.assertTrue(dashboardElements, "Login failed or Dashboard not display.");

        //get Lable so luong ngoai Dashboard
        String totalProjectsInProgressOnDashboard = driver.findElement(By.xpath("(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span")).getText();
        System.out.println("Total Projects In Progress: " + totalProjectsInProgressOnDashboard);

        WebUI.clickElement(driver, By.xpath("//span[normalize-space()='Projects']/parent::a"));

        //get so luong ngoai trang Projects
        String totalProjectsNotStartedOnProjects = driver.findElement(By.xpath("//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='Not Started']/preceding-sibling::span")).getText();
        System.out.println("Total Projects Not Started on Projects Page: " + totalProjectsNotStartedOnProjects);

        String totalProjectsInProgressOnProjects = driver.findElement(By.xpath("//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='In Progress']/preceding-sibling::span")).getText();
        System.out.println("Total Projects In Progress on Projects Page: " + totalProjectsInProgressOnProjects);

        String totalProjectsOnHoldOnProjects = driver.findElement(By.xpath("//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='On Hold']/preceding-sibling::span")).getText();
        System.out.println("Total Projects On Hold on Projects Page: " + totalProjectsOnHoldOnProjects);

        String totalProjectsCancelledOnProjects = driver.findElement(By.xpath("//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='Cancelled']/preceding-sibling::span")).getText();
        System.out.println("Total Projects Cancelled on Projects Page: " + totalProjectsCancelledOnProjects);

        String totalProjectsFinishedOnProjects = driver.findElement(By.xpath("//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='Finished']/preceding-sibling::span")).getText();
        System.out.println("Total Projects Finished on Projects Page: " + totalProjectsFinishedOnProjects);

        int totalProjects = Integer.parseInt(totalProjectsNotStartedOnProjects) +
                Integer.parseInt(totalProjectsInProgressOnProjects) +
                Integer.parseInt(totalProjectsOnHoldOnProjects) +
                Integer.parseInt(totalProjectsCancelledOnProjects) +
                Integer.parseInt(totalProjectsFinishedOnProjects);

        System.out.println("Total Projects on Projects Page: " + totalProjects);

        //Kiem tra so luong du lieu trong Dashboard va trang Projects co khop nhau hay khong
        Assert.assertEquals(totalProjectsInProgressOnDashboard, totalProjectsInProgressOnProjects + " / " + totalProjects, "Total Projects In Progress on Dashboard does not match with Projects Page.");
    }
}

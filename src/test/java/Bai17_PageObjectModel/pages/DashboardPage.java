package Bai17_PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends BasePage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By buttonDashboardOptions = By.xpath("//div[@class='screen-options-btn']");
    private By labelTotalProjectsInprogress = By.xpath("(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span");

    public void verifyDashboardPageDisplay() {
        boolean isDashboardDisplayed = driver.findElements(buttonDashboardOptions).size() > 0;
        Assert.assertTrue(isDashboardDisplayed, "Dashboard page is not displayed");
    }

    public String getTotalProjectsInProgress() {
        return driver.findElement(labelTotalProjectsInprogress).getText();
    }

//    public void verifyTotalProjectsInprogress() {
//        String totalProjectsInProgressOnDashboard = driver.findElement(labelTotalProjectsInprogress).getText();
//        System.out.println("Total Projects In Progress: " + totalProjectsInProgressOnDashboard);
//
//        clickMenuProjects();
//
//        ProjectsPage projectsPage = new ProjectsPage(driver);
//
//        Assert.assertEquals(totalProjectsInProgressOnDashboard, projectsPage.getTotalInProgress() + " / " + projectsPage.getTotalProjects(),
//                "Total Projects In Progress on Dashboard does not match with Projects Page");
//    }

}

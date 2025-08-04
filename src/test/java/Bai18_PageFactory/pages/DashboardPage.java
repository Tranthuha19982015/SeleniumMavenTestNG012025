package Bai18_PageFactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DashboardPage extends BasePage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBys(@FindBy(xpath = "//ul[@id='side-menu']/li[contains(@class,'menu-item')]"))
    private List<WebElement> listMenu;
    @FindBy(xpath = "//div[@class='screen-options-btn']")
    private WebElement buttonDashboardOptions;
    @FindBy(xpath = "(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span")
    private WebElement labelTotalProjectsInprogress;

    public void checkListMenuDisplay() {
        boolean isDashboardDisplayed = false;
        try {
            isDashboardDisplayed = listMenu.size() > 0;
        } catch (Exception e) {
            isDashboardDisplayed = false;
        }
        Assert.assertTrue(isDashboardDisplayed, "List menu is not displayed");

        System.out.println("List menu is displayed with " + listMenu.size() + " item.");

        System.out.println("List of menu item: ");
        for (WebElement menu : listMenu) {
            System.out.println(menu.getText());
        }
    }

    public void verifyDashboardPageDisplay() {
        boolean isDashboardDisplayed = false;
        try {
            isDashboardDisplayed = buttonDashboardOptions.isDisplayed();
        } catch (Exception e) {
            isDashboardDisplayed = false;
        }
        Assert.assertTrue(isDashboardDisplayed, "Dashboard page is not displayed");
    }
    public void verifyDashboardPageDisplay2() {
        boolean isDashboardDisplayed = false;
        try {
            isDashboardDisplayed = buttonDashboardOptions.isDisplayed();
        } catch (Exception e) {
            isDashboardDisplayed = false;
        }
        Assert.assertTrue(isDashboardDisplayed, "Dashboard page is not displayed");
    }

    //Cách 1
    public String getTotalProjectsInProgress() {
        return labelTotalProjectsInprogress.getText();
    }

    //Cách 2
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

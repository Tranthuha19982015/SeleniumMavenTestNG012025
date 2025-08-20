package Bai22_23_WebUI.pages;

import keywords.WebUI;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
    }

    //Element chung cho cac trang
    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard' and @class='menu-text']");
    public By menuCustomers = By.xpath("//span[normalize-space()='Customers' and @class='menu-text']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects' and @class='menu-text']");
    public By menuLeads = By.xpath("//span[normalize-space()='Leads' and @class='menu-text']");
    public By menuTasks = By.xpath("//span[normalize-space()='Tasks' and @class='menu-text']");
    public By iconProfile = By.xpath("//li[@class='icon header-user-profile']");
    public By optionLogout = By.xpath("//a[text()='Logout']");
    public By alertMessage = By.xpath("//div[@id='alert_float_1']/span[@class='alert-title']");

    public void logoutSystem() {
        WebUI.clickElement(iconProfile);
        WebUI.clickElement(optionLogout);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageDisplay();
    }

    //Cac phuong thuc chung cho cac trang
    public void clickMenuDashboard() {
        WebUI.clickElement(menuDashboard);
    }

    public CustomersPage clickMenuCustomers() {
        WebUI.clickElement(menuCustomers);
        return new CustomersPage(driver);
    }

    public ProjectsPage clickMenuProjects() {
        WebUI.clickElement(menuProjects);
        return new ProjectsPage(driver); // Trả về đối tượng ProjectsPage sau khi click vào menu Projects
    }

    public LeadsPage clickMenuLeads() {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuLeads);
        return new LeadsPage(driver);
    }

    public TasksPage clickMenuTasks() {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuTasks);
        return new TasksPage(driver);
    }
}

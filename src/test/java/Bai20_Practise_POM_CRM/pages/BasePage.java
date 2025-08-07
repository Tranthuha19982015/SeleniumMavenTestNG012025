package Bai20_Practise_POM_CRM.pages;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //Element chung cho cac trang
    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard' and @class='menu-text']");
    public By menuCustomers = By.xpath("//span[normalize-space()='Customers' and @class='menu-text']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects' and @class='menu-text']");
    public By menuLeads = By.xpath("//span[normalize-space()='Leads' and @class='menu-text']");

    public By iconProfile = By.xpath("//li[@class='icon header-user-profile']");
    public By optionLogout = By.xpath("//a[text()='Logout']");

    public void logoutSystem() {
        WebUI.clickElement(driver, iconProfile);
        WebUI.clickElement(driver, optionLogout);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageDisplay();
    }

    //Cac phuong thuc chung cho cac trang
    public void clickMenuDashboard() {
        WebUI.clickElement(driver, menuDashboard);
    }

    public CustomersPage clickMenuCustomers() {
        WebUI.clickElement(driver, menuCustomers);
        return new CustomersPage(driver);
    }

    public ProjectsPage clickMenuProjects() {
        WebUI.clickElement(driver, menuProjects);
        return new ProjectsPage(driver); // Trả về đối tượng ProjectsPage sau khi click vào menu Projects
    }

    public LeadsPage clickMenuLeads() {
        WebUI.clickElement(driver, menuLeads);
        return new LeadsPage(driver);
    }
}

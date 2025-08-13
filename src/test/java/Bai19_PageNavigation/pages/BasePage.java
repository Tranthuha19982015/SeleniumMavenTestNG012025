package Bai19_PageNavigation.pages;

import keywords.WebUI_Old;
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

    public By iconProfile = By.xpath("//li[@class='icon header-user-profile']");
    public By optionLogout = By.xpath("//a[text()='Logout']");

    public void logoutSystem() {
        WebUI_Old.clickElement(driver, iconProfile);
        WebUI_Old.clickElement(driver, optionLogout);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageDisplay();
    }

    //Cac phuong thuc chung cho cac trang
    public void clickMenuDashboard() {
        WebUI_Old.clickElement(driver, menuDashboard);
    }

    public void clickMenuCustomers() {
        WebUI_Old.clickElement(driver, menuCustomers);
    }

    public ProjectsPage clickMenuProjects() {
        WebUI_Old.clickElement(driver, menuProjects);
        return new ProjectsPage(driver); // Trả về đối tượng ProjectsPage sau khi click vào menu Projects
    }
}

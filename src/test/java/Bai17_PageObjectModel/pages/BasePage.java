package Bai17_PageObjectModel.pages;

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

    public By iconProfile = By.xpath("//li[@class='icon header-user-profile']");
    public By optionLogout = By.xpath("//a[text()='Logout']");

    public void logoutSystem() {
        WebUI.clickElement(driver, iconProfile);
        WebUI.clickElement(driver, By.xpath("//a[normalize-space()='Logout']"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageDisplay();
    }
    //Cac phuong thuc chung cho cac trang
    public void clickMenuDashboard() {
        WebUI.clickElement(driver, menuDashboard);
    }

    public void clickMenuCustomers() {
        WebUI.clickElement(driver, menuCustomers);
    }

    public void clickMenuProjects() {
        WebUI.clickElement(driver, menuProjects);
    }
}

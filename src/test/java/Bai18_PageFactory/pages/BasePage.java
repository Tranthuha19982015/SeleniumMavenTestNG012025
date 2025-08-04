package Bai18_PageFactory.pages;

import keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Element chung cho cac trang
    @FindBy(xpath = "//span[normalize-space()='Dashboard' and @class='menu-text']")
    public WebElement menuDashboard;

    @FindBy(xpath = "//span[normalize-space()='Customers' and @class='menu-text']")
    public WebElement menuCustomers;

    @FindBy(xpath = "//span[normalize-space()='Projects' and @class='menu-text']")
    public WebElement menuProjects;

    @FindBy(xpath = "//li[@class='icon header-user-profile']")
    public WebElement iconProfile;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement optionLogout;

    public void logoutSystem() {
        WebUI.clickElement(driver,iconProfile);
        WebUI.clickElement(driver,optionLogout);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageDisplay();
    }

    //Cac phuong thuc chung cho cac trang
    public void clickMenuDashboard() {
        WebUI.clickElement(driver, menuDashboard);
    }

    public void clickMenuCustomers() {
        WebUI.clickElement(driver,menuCustomers);
    }

    public void clickMenuProjects() {
//        menuProjects.click();
        WebUI.clickElement(driver,menuProjects);
    }
}

package Bai20_21_Practise_POM_CRM.pages;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectsPage extends BasePage {
    private WebDriver driver;

    public ProjectsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By labelTotalNotStarted = By.xpath("//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='Not Started']/preceding-sibling::span");
    private By labelTotalInProgress = By.xpath("//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='In Progress']/preceding-sibling::span");
    private By labelTotalOnHold = By.xpath("//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='On Hold']/preceding-sibling::span");
    private By labelTotalCancelled = By.xpath("//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='Cancelled']/preceding-sibling::span");
    private By labelTotalFinished = By.xpath("//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='Finished']/preceding-sibling::span");

    //Khai bao cac ham su dung noi bo trong trang Projects
    public String getTotalNotStarted() {
        return driver.findElement(labelTotalNotStarted).getText();
    }

    public String getTotalInProgress() {
        return driver.findElement(labelTotalInProgress).getText();
    }

    public String getTotalOnHold() {
        return driver.findElement(labelTotalOnHold).getText();
    }

    public String getTotalCancelled() {
        return driver.findElement(labelTotalCancelled).getText();
    }

    public String getTotalFinished() {
        return driver.findElement(labelTotalFinished).getText();
    }

    //Ham tinh toan tong so du lieu trong trang Projects
    public int getTotalProjects() {
        int totalProjects = Integer.parseInt(getTotalNotStarted()) +
                Integer.parseInt(getTotalInProgress()) +
                Integer.parseInt(getTotalOnHold()) +
                Integer.parseInt(getTotalCancelled()) +
                Integer.parseInt(getTotalFinished());
        return totalProjects;
    }

}

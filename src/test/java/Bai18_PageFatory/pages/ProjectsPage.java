package Bai18_PageFatory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectsPage extends BasePage {
    private WebDriver driver;

    public ProjectsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='Not Started']/preceding-sibling::span")
    private WebElement labelTotalNotStarted;
    @FindBy(xpath = "//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='In Progress']/preceding-sibling::span")
    private WebElement labelTotalInProgress;
    @FindBy(xpath = "//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='On Hold']/preceding-sibling::span")
    private WebElement labelTotalOnHold;
    @FindBy(xpath = "//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='Cancelled']/preceding-sibling::span")
    private WebElement labelTotalCancelled;
    @FindBy(xpath = "//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='Finished']/preceding-sibling::span")
    private WebElement labelTotalFinished;

    //Khai bao cac ham su dung noi bo trong trang Projects
    public String getTotalNotStarted() {
        return labelTotalNotStarted.getText();
    }

    public String getTotalInProgress() {
        return labelTotalInProgress.getText();
    }

    public String getTotalOnHold() {
        return labelTotalOnHold.getText();
    }

    public String getTotalCancelled() {
        return labelTotalCancelled.getText();
    }

    public String getTotalFinished() {
        return labelTotalFinished.getText();
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

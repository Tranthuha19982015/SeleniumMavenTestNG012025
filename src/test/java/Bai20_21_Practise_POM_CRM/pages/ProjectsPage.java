package Bai20_21_Practise_POM_CRM.pages;

import keywords.WebUI_Old;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProjectsPage extends BasePage {
    private WebDriver driver;

    public ProjectsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //Locator list projects page
    private By buttonNewProject = By.xpath("//div[@id='vueApp']/descendant::a[normalize-space()='New Project']");
    private By headerProjectsPage = By.xpath("//span[normalize-space()='Projects Summary']");
    private By labelTotalNotStarted = By.xpath("//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='Not Started']/preceding-sibling::span");
    private By labelTotalInProgress = By.xpath("//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='In Progress']/preceding-sibling::span");
    private By labelTotalOnHold = By.xpath("//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='On Hold']/preceding-sibling::span");
    private By labelTotalCancelled = By.xpath("//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='Cancelled']/preceding-sibling::span");
    private By labelTotalFinished = By.xpath("//div[@class='_filters _hidden_inputs']/descendant::span[normalize-space()='Finished']/preceding-sibling::span");
    private By inputSearchProject = By.xpath("//div[@id='projects_filter']/descendant::input[@type='search']");
    private By firstRowItemProjectName = By.xpath("//table[@id='projects']//tbody/tr[1]/td[2]");

    //Locator add new project page
    private By inputProjectName = By.xpath("//input[@id='name']");
    private By dropdownCustomer = By.xpath("//button[@data-id='clientid']");
    private By inputSearchCustomer = By.xpath("//button[@data-id='clientid']/following-sibling::div/descendant::input[@type='search']");

    private By valueCustomer(String value) {
        String xpathCustomer = "//button[@data-id='clientid']/following-sibling::div/descendant::span[normalize-space()='" + value + "']";
        return By.xpath(xpathCustomer);
    }

    private By checkboxCalculateProgressThroughTasks = By.xpath("//label[normalize-space()='Calculate progress through tasks']");
    private By dropdownBillingType = By.xpath("//button[@data-id='billing_type']");

    private By valueBillingType(String value) {
        String xpathBillingType = "//button[@data-id='billing_type']/following-sibling::div/descendant::span[normalize-space()='" + value + "']";
        return By.xpath(xpathBillingType);
    }

    private By dropdownStatus = By.xpath(" //button[@data-id='status']");

    private By valueStatus(String value) {
        String xpathStatus = "//button[@data-id='status']/following-sibling::div/descendant::span[normalize-space()='" + value + "']";
        return By.xpath(xpathStatus);
    }

    private By inputTotalRate = By.xpath("//input[@id='project_cost']");
    private By inputRatePerHour = By.xpath("//input[@id='project_rate_per_hour']");
    private By inputEstimatedHours = By.xpath("//input[@id='estimated_hours']");
    private By dropdownMembers = By.xpath("//button[@data-id='project_members[]']");
    private By inputSearchMembers = By.xpath("//button[@data-id='project_members[]']/following-sibling::div/descendant::input[@type='search']");
    private By inputStartDate = By.xpath("//input[@id='start_date']");
    private By inputDeadline = By.xpath("//input[@id='deadline']");
    private By inputTags = By.xpath("//label[normalize-space()='Tags']/following-sibling::ul/descendant::input");
    private By iFrameDescription = By.xpath("//iframe[@id='description_ifr']");
    private By inputDescription = By.xpath("//body[@id='tinymce']//p");
    private By checkboxSendProjectCreatedEmail = By.xpath("//label[normalize-space()='Send project created email']");
    private By buttonSave = By.xpath("//div[contains(@class,'panel-footer')]//button[normalize-space()='Save']");

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

    public void verifyProjectsPageDisplay() {
        WebUI_Old.highlightElement(driver, driver.findElement(headerProjectsPage));
        boolean isDisplayed = true;
        try {
            isDisplayed = driver.findElement(headerProjectsPage).isDisplayed();
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        System.out.println("Is Projects Page displayed? " + isDisplayed);

        Assert.assertTrue(isDisplayed, "Projects Page is not displayed!");
    }

    public void clickAddNewProjectButton() {
        WebUI_Old.clickElement(driver, buttonNewProject);
    }

    public void fillInputBasedOnBillingType(String billingType) {
        if (billingType.equals("Fixed Rate")) {
            WebUI_Old.setText(driver, inputTotalRate, "1000");
        } else if (billingType.equals("Project Hours")) {
            WebUI_Old.setText(driver, inputRatePerHour, "100");
        } else if (billingType.equals("Task Hours")) {
            System.out.println(billingType + " Based on task hourly rate");
        } else {
            System.out.println("Invalid billing type: " + billingType);
        }
    }

    public void fillDataNewProject(String projectName, String customerName, String billingType) {
        Actions actions = new Actions(driver);
        WebUI_Old.setText(driver, inputProjectName, projectName);

        // Select customer from dropdown
        WebUI_Old.clickElement(driver, dropdownCustomer);
        WebUI_Old.setText(driver, inputSearchCustomer, customerName);
        WebUI_Old.sleep(1);
        actions.moveToElement(driver.findElement(valueCustomer(customerName))).click().keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).sendKeys(" ").build().perform();
        WebUI_Old.waitForResultVisible(driver, valueCustomer(customerName));
        WebUI_Old.clickElement(driver, valueCustomer(customerName));
        WebUI_Old.clickElement(driver, checkboxCalculateProgressThroughTasks);

        // Select billing type
        WebUI_Old.clickElement(driver, dropdownBillingType);
        WebUI_Old.clickElement(driver, valueBillingType(billingType));
        fillInputBasedOnBillingType(billingType);

        // Select status
        WebUI_Old.clickElement(driver, dropdownStatus);
        WebUI_Old.clickElement(driver, valueStatus("On Hold"));

        //fill Estimated Hours
        WebUI_Old.setText(driver, inputEstimatedHours, "10");

        // Select members from dropdown
        WebUI_Old.clickElement(driver, dropdownMembers);
        WebUI_Old.setText(driver, inputSearchMembers, "Anh Tester");
        WebUI_Old.setKey(driver, inputSearchMembers, Keys.ENTER);
        WebUI_Old.clickElement(driver, dropdownMembers);

        // Fill start date, deadline, tags
        WebUI_Old.clearTextElement(driver, inputStartDate);
        WebUI_Old.setText(driver, inputStartDate, "10/08/2025");
        WebUI_Old.setText(driver, inputDeadline, "01/12/2025");
        WebUI_Old.setText(driver, inputTags, "htest13825");

        // Switch to iframe for description input
        WebUI_Old.switchToFrameWhenAvailable(driver, iFrameDescription);
        WebUI_Old.setText(driver, inputDescription, "Here is the description of the iframe test project.");
        WebUI_Old.switchToDefaultContent(driver);
        WebUI_Old.clickElement(driver, checkboxSendProjectCreatedEmail);
    }

    public void clickSaveButton() {
        WebUI_Old.clickElement(driver, buttonSave);
    }

    public void verifyAlertMessageSuccessDisplayed() {
        boolean isDisplayed = true;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(alertMessage));
            isDisplayed = driver.findElement(alertMessage).isDisplayed();
            WebUI_Old.highlightElement(driver, driver.findElement(alertMessage));
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        System.out.println("Is alert message displayed? " + isDisplayed);
        Assert.assertTrue(isDisplayed, "Alert message success is not displayed!");

        String actualMessage = driver.findElement(alertMessage).getText();
        System.out.println("Actual alert message: " + actualMessage);
        Assert.assertEquals(actualMessage, "Project added successfully.", "Alert message does not match expected message!");
    }
    public void verifyProjectDetail(){

    }

    public void verifyAddNewProjectSuccess(String projectName) {

    }
}

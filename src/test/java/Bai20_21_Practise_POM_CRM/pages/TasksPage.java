package Bai20_21_Practise_POM_CRM.pages;

import keywords.WebUI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TasksPage extends BasePage {
    private WebDriver driver;
    private CustomersPage customersPage;
    private ProjectsPage projectsPage;
    private LeadsPage leadsPage;

    public TasksPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By buttonNewTask = By.xpath("//a[normalize-space()='New Task']");
    private By headerTasksPage = By.xpath("//span[normalize-space()='Tasks Summary']");
    private By labelNotStarted = By.xpath("//span[normalize-space()='Not Started']/preceding-sibling::span");
    private By labelInProgress = By.xpath("//span[normalize-space()='In Progress']/preceding-sibling::span");
    private By labelTesting = By.xpath("//span[normalize-space()='Testing']/preceding-sibling::span");
    private By labelAwaitingFeedback = By.xpath("//span[normalize-space()='Awaiting Feedback']/preceding-sibling::span");
    private By labelComplete = By.xpath("//span[normalize-space()='Complete']/preceding-sibling::span");
    private By inputSearchTasks = By.xpath("//div[@id='tasks_filter']/descendant::input[@type='search']");
    private By firstRowItemTasksName = By.xpath("//table[@id='tasks']//tbody/tr[1]/td[3]");

    private By headerAddNewTask = By.xpath("//h4[@id='myModalLabel']");
    private By checkboxPublic = By.xpath("//label[normalize-space()='Public']");
    private By checkboxBillable = By.xpath("//label[@for='task_is_billable']");
    //    private By textLinkAttachFiles = By.xpath("//a[normalize-space()='Attach Files']");
//    private By inputChooseFileAttachment = By.xpath("//div[@id='new-task-attachments']/descendant::input[@type='file']");
//    private By iconAddMoreFileAttachment = By.xpath("//div[@id='new-task-attachments']/descendant::button[contains(@class,'add_more_attachments')]");
//    private By iconDeleteFileAttachment = By.xpath("//div[@id='new-task-attachments']/descendant::button[contains(@class,'remove_attachment')]");
    private By inputSubject = By.xpath("//input[@id='name']");
    private By inputHourlyRate = By.xpath("//input[@id='hourly_rate']");
    private By datepickerStartDate = By.xpath("//input[@id='startdate']");
    private By datepickerDueDate = By.xpath("//input[@id='duedate']");
    private By dropdownPriority = By.xpath("//button[@data-id='priority']");

    private By selectPriority(String priority) {
        String xpathPriority = "//button[@data-id='priority']/following-sibling::div/descendant::span[normalize-space()='" + priority + "']";
        return By.xpath(xpathPriority);
    }

    private By dropdownRepeatEvery = By.xpath("//button[@data-id='repeat_every']");

    private By selectRepeatEvery(String repeatEvery) {
        String xpathRepeatEvery = "//button[@data-id='repeat_every']/following-sibling::div/descendant::span[normalize-space()='" + repeatEvery + "']";
        return By.xpath(xpathRepeatEvery);
    }

    private By listRepeatEvery = By.xpath("//button[@data-id='repeat_every']/following-sibling::div/descendant::ul/li");
    private By checkboxInfinity = By.xpath("//label[normalize-space()='Infinity']");
    private By inputTotalCycles = By.xpath("//input[@id='cycles']");
    private By inputNumberCustomRepeatEvery = By.xpath("//input[@id='repeat_every_custom']");
    private By dropdownTypeCustomRepeatEvery = By.xpath("//button[@data-id='repeat_type_custom']");

    private By selectTypeCustomRepeatEvery(String type) {
        String xpathType = "//button[@data-id='repeat_type_custom']/following-sibling::div/descendant::span[contains(normalize-space(),'" + type + "')]";
        return By.xpath(xpathType);
    }

    private By dropdownRelatedTo = By.xpath("//button[@data-id='rel_type']");

    private By selectRelatedTo(String relatedTo) {
        String xpathRelatedTo = "//button[@data-id='rel_type']/following-sibling::div/descendant::span[normalize-space()='" + relatedTo + "']";
        return By.xpath(xpathRelatedTo);
    }

    private By dropdownTypeRelatedTo = By.xpath("//button[@data-id='rel_id']");
    private By inputSearchTypeRelatedTo = By.xpath("//button[@data-id='rel_id']/following-sibling::div/descendant::input[@type='search']");

    private By selectValueSearchTypeRelatedTo(String value) {
        String valueSearch = "(//button[@data-id='rel_id']/following-sibling::div)/descendant::span[contains(normalize-space(),'" + value + "')]";
        return By.xpath(valueSearch);
    }

    private By dropdownAssignees = By.xpath("//button[@data-id='assignees']");
    private By inputSearchAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div/descendant::input[@type='search']");
    private By dropdownFollowers = By.xpath("//button[@data-id='followers[]']");
    private By inputSearchFollowers = By.xpath("//button[@data-id='followers[]']/following-sibling::div/descendant::input[@type='search']");
    private By labelTags = By.xpath("//label[normalize-space()='Tags']");
    private By inputTags = By.xpath("//div[@id='inputTagsWrapper']/descendant::li[@class='tagit-new']/input");
    private By inputTaskDescription = By.xpath("//textarea[@id='description']");
    private By iframeTaskDescription = By.xpath("//iframe[@id='description_ifr']");
    private By inputOnFrame = By.xpath("//body[@id='tinymce']/descendant::p");
    private By buttonClose = By.xpath("//button[normalize-space()='Close']");
    private By buttonSave = By.xpath("//button[normalize-space()='Save']");

    private boolean checkExist(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void verifyTasksPageDisplay() {
        Assert.assertTrue(checkExist(headerTasksPage), "The tasks header page not display.");
        Assert.assertEquals(WebUI.getTextElement(driver, headerTasksPage), "Tasks Summary", "The Tasks header not match.");
    }

    public void clickButtonNewTask() {
        WebUI.clickElement(driver, buttonNewTask);
    }

    public void verifyAddNewTaskPageDisplay() {
        Assert.assertTrue(checkExist(headerAddNewTask), "The Add new task header page not display.");
        Assert.assertEquals(WebUI.getTextElement(driver, headerAddNewTask), "Add new task", "The Add new task header not match.");
    }

    public void chooseOptionRepeatEvery(String typeRepeat) {
        if (!typeRepeat.equals("") && !typeRepeat.equals("Custom")) {
            WebUI.clickElement(driver, checkboxInfinity);
            WebUI.clearTextElement(driver, inputTotalCycles);
            WebUI.setText(driver, inputTotalCycles, "8");
        } else if (typeRepeat.equals("Custom")) {
            WebUI.clearTextElement(driver, inputNumberCustomRepeatEvery);
            WebUI.setText(driver, inputNumberCustomRepeatEvery, "3");
            WebUI.clickElement(driver, dropdownTypeCustomRepeatEvery);
            WebUI.clickElement(driver, selectTypeCustomRepeatEvery("Week"));
        }
    }

    public void fillDataAddNewTask(String subject, String valueRelatedTo) {
        Actions actions = new Actions(driver);
        WebUI.clickElement(driver, checkboxPublic);
        WebUI.setText(driver, inputSubject, subject);
        WebUI.clearTextElement(driver, inputHourlyRate);
        WebUI.setText(driver, inputHourlyRate, "3");

        //select Start Date
        WebUI.clearTextElement(driver, datepickerStartDate);
        WebUI.setText(driver, datepickerStartDate, "11-08-2025");
        WebUI.clickElement(driver, datepickerStartDate);

        //select Due Date
        WebUI.clearTextElement(driver, datepickerDueDate);
        WebUI.setText(driver, datepickerDueDate, "12-08-2025");
        WebUI.clickElement(driver, datepickerDueDate);

        //select Priority
        WebUI.clickElement(driver, dropdownPriority);
        WebUI.clickElement(driver, selectPriority("High"));

        //select Repeat Every
        WebUI.clickElement(driver, dropdownRepeatEvery);
        String typeRepeatEvery = "Custom";
        WebUI.clickElement(driver, selectRepeatEvery(typeRepeatEvery));
        chooseOptionRepeatEvery(typeRepeatEvery);

        //select Related To
        WebUI.clickElement(driver, dropdownRelatedTo);
        String optionRelatedTo = "Lead";
        WebUI.clickElement(driver, selectRelatedTo(optionRelatedTo));
        WebUI.clickElement(driver, dropdownTypeRelatedTo);
        WebUI.setText(driver, inputSearchTypeRelatedTo, valueRelatedTo);
        WebUI.sleep(1);
        actions.moveToElement(driver.findElement(inputSearchTypeRelatedTo)).click().keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).sendKeys(" ").build().perform();
        WebUI.waitForResultVisible(driver, selectValueSearchTypeRelatedTo(valueRelatedTo));
        WebUI.clickElement(driver, selectValueSearchTypeRelatedTo(valueRelatedTo));

        //select Assignees
        WebUI.clickElement(driver, dropdownAssignees);
        WebUI.setText(driver, inputSearchAssignees, "Anh Tester");
        WebUI.setKey(driver, inputSearchAssignees, Keys.ENTER);
        WebUI.clickElement(driver, dropdownAssignees);

        //select Followers
        WebUI.clickElement(driver, dropdownFollowers);
        WebUI.setText(driver, inputSearchFollowers, "Anh Tester");
        WebUI.setKey(driver, inputSearchFollowers, Keys.ENTER);
        WebUI.clickElement(driver, dropdownFollowers);

        //fill Tags
        WebUI.setText(driver, inputTags, "htest");
        WebUI.setKey(driver, inputTags, Keys.ENTER);
        WebUI.clickElement(driver, labelTags);

        //fill iFrame Description
        WebUI.clickElement(driver, inputTaskDescription);
        WebUI.switchToFrameWhenAvailable(driver, iframeTaskDescription);
        WebUI.setText(driver, inputOnFrame, "htest iframe");
        WebUI.switchToDefaultContent(driver);
    }

    public void clickButtonSave() {
        WebUI.clickElement(driver, buttonSave);
    }

    public void verifyAddNewTaskSuccess() {
        Assert.assertTrue(checkExist(alertMessage), "The alert message not display.");
        String actualMessage = WebUI.getTextElement(driver, alertMessage);
        Assert.assertEquals(actualMessage, "Task added successfully.", "The alert message add new tasks not match.");
    }
}

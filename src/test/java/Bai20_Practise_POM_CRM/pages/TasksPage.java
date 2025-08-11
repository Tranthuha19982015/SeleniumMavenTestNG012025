package Bai20_Practise_POM_CRM.pages;

import keywords.WebUI;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class TasksPage extends BasePage {
    private WebDriver driver;

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

    private By dropdownAssignees = By.xpath("//button[@data-id='assignees']");
    private By inputSearchAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div/descendant::input[@type='search']");
    private By dropdownFollowers = By.xpath("//button[@data-id='followers[]']");
    private By inputSearchFollowers = By.xpath("//button[@data-id='followers[]']/following-sibling::div/descendant::input[@type='search']");
    private By labelTags = By.xpath("//label[normalize-space()='Tags']");
    private By inputTags = By.xpath("//div[@id='inputTagsWrapper']/descendant::li[@class='tagit-new']/input");
    private By inputTaskDescription = By.xpath("//textarea[@id='description']");
    private By iframeTaskDescription = By.xpath("//iframe[@id='description_ifr']");
    private By inputOnFrame = By.xpath("//body[@id='tinymce']/descendant::p");
    private By buttonClose = By.xpath("//div[@id='_task_modal']//div[@class='modal-footer']/button[normalize-space()='Close']");
    private By buttonSave = By.xpath("//div[@id='_task_modal']//div[@class='modal-footer']/button[normalize-space()='Save']");

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

    public void checkChooseRepeatEvery() {
        for (int i = 0; i < WebUI.getListElement(driver, listRepeatEvery).size(); i++)
            if (WebUI.getListElement(driver, listRepeatEvery).get(i).equals("") && WebUI.getListElement(driver, listRepeatEvery).get(i).equals("Custom")) {
                WebUI.clickElement(driver, checkboxInfinity);
                WebUI.clearTextElement(driver, inputTotalCycles);
                WebUI.setText(driver, inputTotalCycles, "8");
                break;
            } else if (WebUI.getListElement(driver, listRepeatEvery).get(i).equals("Custom")) {
                WebUI.clearTextElement(driver, inputNumberCustomRepeatEvery);
                WebUI.setText(driver, inputNumberCustomRepeatEvery, "3");
                WebUI.clickElement(driver, dropdownTypeCustomRepeatEvery);
                WebUI.clickElement(driver, selectTypeCustomRepeatEvery("Week"));
                break;
            }
    }

    public void submitDataAddNewTask(String subject) {
        WebUI.clickElement(driver, checkboxPublic);
        WebUI.setText(driver, inputSubject, subject);
        WebUI.clearTextElement(driver, inputHourlyRate);
        WebUI.setText(driver, inputHourlyRate, "3");
        WebUI.setText(driver, datepickerStartDate, "10-08-2025");
        WebUI.clickElement(driver, datepickerStartDate);
        WebUI.setText(driver, datepickerDueDate, "12-08-2025");
        WebUI.clickElement(driver, datepickerDueDate);
        WebUI.clickElement(driver, dropdownPriority);
        WebUI.clickElement(driver, selectPriority("High"));
        WebUI.clickElement(driver, dropdownRepeatEvery);
        WebUI.clickElement(driver, selectRepeatEvery("6 Months"));
        checkChooseRepeatEvery();

        WebUI.clickElement(driver, dropdownRelatedTo);
        WebUI.clickElement(driver, selectRelatedTo("Lead"));

        WebUI.clickElement(driver, dropdownAssignees);
        WebUI.setText(driver, inputSearchAssignees, "Anh Tester");
        WebUI.setKey(driver, inputSearchAssignees, Keys.ENTER);
        WebUI.clickElement(driver, dropdownAssignees);

        WebUI.clickElement(driver, dropdownFollowers);
        WebUI.setText(driver, inputSearchFollowers, "Anh Tester");
        WebUI.setKey(driver, inputSearchFollowers, Keys.ENTER);
        WebUI.clickElement(driver, dropdownFollowers);
        WebUI.setText(driver, inputTags, "htest");
        WebUI.setKey(driver, inputTags, Keys.ENTER);
        WebUI.clickElement(driver, labelTags);
        WebUI.clickElement(driver, inputTaskDescription);
        WebUI.switchToFrameWhenAvailable(driver, iframeTaskDescription);
        WebUI.setText(driver, inputOnFrame, "htest iframe");
        WebUI.switchToDefaultContent(driver);
        WebUI.clickElement(driver, buttonSave);
    }

    public void verifyAddNewTaskSuccess() {

    }
}

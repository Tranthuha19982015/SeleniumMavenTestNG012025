package Bai20_Practise_POM_CRM.pages;

import keywords.WebUI;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LeadsPage extends BasePage {
    public WebDriver driver;

    public LeadsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By buttonNewLead = By.xpath("//a[normalize-space()='New Lead']");
    private By iconLeadsSummary = By.xpath("//a[contains(@class,'btn-with-tooltip') and @data-title='Leads Summary']");
    private By labelActive = By.xpath("//h4[normalize-space()='Leads Summary']/following-sibling::div/descendant::span[normalize-space()='Active']/preceding-sibling::span");
    private By labelCustomer = By.xpath("//h4[normalize-space()='Leads Summary']/following-sibling::div/descendant::span[normalize-space()='Customer']/preceding-sibling::span");
    private By headerLeadsPage = By.xpath("//h4[normalize-space()='Leads Summary']");
    private By inputSearchLead = By.xpath("//div[@id='leads_filter']/descendant::input[@type='search']");
    private By firstRowItemLead = By.xpath("//table[@id='leads']//tbody/tr[1]/td[3]/a");

    private By headerAddNewLeadWindow = By.xpath("//h4[normalize-space()='Add new lead']");
    private By dropdownStatus = By.xpath("//button[@data-id='status']");
    private By inputSearchStatus = By.xpath("//button[@data-id='status']/following-sibling::div/descendant::input[@type='search']");
    private By iconAddStatus = By.xpath("//label[@for='new_status_name']/following-sibling::div/descendant::a/parent::div");
    private By inputAddNewStatus = By.xpath("//input[@id='new_status_name']");
    private By dropdownSource = By.xpath("//button[@data-id='source']");
    private By inputSearchSource = By.xpath("//button[@data-id='source']/following-sibling::div/descendant::input[@type='search']");
    private By iconAddSource = By.xpath("//label[@for='new_source_name']/following-sibling::div/descendant::a/parent::div");
    private By inputAddNewSource = By.xpath("//input[@id='new_source_name']");
    private By dropdownAssigned = By.xpath("//button[@data-id='assigned']");
    private By inputSearchAssigned = By.xpath("//button[@data-id='assigned']/following-sibling::div/descendant::input[@type='search']");
    private By inputTags = By.xpath("//div[@id='inputTagsWrapper']//li[@class='tagit-new']/input");
    private By inputName = By.xpath("//label[text()='Name']/following-sibling::input[@id='name']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputPosition = By.xpath("//input[@id='title']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputEmailAddress = By.xpath("//input[@id='email']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By dropdownCountry = By.xpath("//button[@data-id='country']");
    private By inputSearchCountry = By.xpath("//button[@data-id='country']/following-sibling::div/descendant::input[@type='search']");
    private By inputPhone = By.xpath("//input[@id='phonenumber']");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By inputLeadValue = By.xpath("//input[@name='lead_value']");
    private By dropdownDefaultLanguage = By.xpath("//button[@data-id='default_language']");
    private By inputSearchDefaultLanguage = By.xpath("//button[@data-id='default_language']/following-sibling::div/descendant::input[@type='search']");
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputDescription = By.xpath("//textarea[@id='description']");
    private By checkboxPublic = By.xpath("//label[@for='lead_public']");
    private By checkboxContactedToday = By.xpath("//label[normalize-space()='Contacted Today']");

    private By buttonClose = By.xpath("//div[@id='tab_lead_profile']/descendant::button[normalize-space()='Close']");
    private By buttonSave = By.xpath("//div[@id='tab_lead_profile']/descendant::button[normalize-space()='Save']");

    private By buttonCloseWindowAfterAdd = By.xpath("//div[@class='modal-content data']//button[@aria-label='Close']");

    public boolean checkExist(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickIconLeadsSummary() {
        WebUI.clickElement(driver, iconLeadsSummary);
    }

    public void verifyNavigateToLeadPage() {
        clickIconLeadsSummary();
        Assert.assertTrue(checkExist(headerLeadsPage), "The lead header page not display.");
        Assert.assertEquals(WebUI.getTextElement(driver, headerLeadsPage), "Leads Summary", "The lead header page not match.");
    }

    public void clickButtonNewLead() {
        WebUI.clickElement(driver, buttonNewLead);
    }

    public void verifyOpenWindowAddNewLead() {
        Assert.assertTrue(checkExist(headerAddNewLeadWindow), "The new lead window not display.");
        Assert.assertEquals(WebUI.getTextElement(driver, headerAddNewLeadWindow), "Add new lead", "The lead summary window not match.");
    }

    public void submitDataAddNewLead(String name) {
        WebUI.clickElement(driver, dropdownStatus);
        WebUI.setText(driver, inputSearchStatus, "Active");
        WebUI.setKey(driver, inputSearchStatus, Keys.ENTER);

        WebUI.clickElement(driver, dropdownSource);
        WebUI.setText(driver, inputSearchSource, "Google");
        WebUI.setKey(driver, inputSearchSource, Keys.ENTER);

        WebUI.clickElement(driver, inputTags);
        WebUI.setText(driver, inputTags, "HTest");
        WebUI.setKey(driver, inputTags, Keys.ENTER);

        WebUI.setText(driver, inputName, name);
        WebUI.setText(driver, inputAddress, "Minh Khai");
        WebUI.setText(driver, inputPosition, "Bắc Từ Liêm");
        WebUI.setText(driver, inputCity, "Hà Nội");
        WebUI.setText(driver, inputEmailAddress, "htest" + System.currentTimeMillis() + "@gmail.com");
        WebUI.setText(driver, inputState, "htest state");
        WebUI.setText(driver, inputWebsite, "htest.com.vn");

        WebUI.clickElement(driver, dropdownCountry);
        WebUI.setText(driver, inputSearchCountry, "Vietnam");
        WebUI.setKey(driver, inputSearchCountry, Keys.ENTER);

        WebUI.setText(driver, inputPhone, "0965896589");
        WebUI.setText(driver, inputZipCode, "0235565");
        WebUI.setText(driver, inputLeadValue, "10");

        WebUI.clickElement(driver, dropdownDefaultLanguage);
        WebUI.setText(driver, inputSearchDefaultLanguage, "Vietnamese");
        WebUI.setKey(driver, inputSearchDefaultLanguage, Keys.ENTER);

        WebUI.setText(driver, inputCompany, "NDJSC");
        WebUI.setText(driver, inputDescription, "Test add lead");
        WebUI.clickElement(driver, checkboxPublic);

        WebUI.clickElement(driver, buttonSave);
    }

    public void clickButtonCloseAfterAdd() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", (driver.findElement(buttonCloseWindowAfterAdd)));
        WebUI.sleep(1);
        WebUI.clickElement(driver, buttonCloseWindowAfterAdd);
    }

    public void verifyAddNewLeadSuccess(String name) {
        WebUI.clickElement(driver, inputSearchLead);
        WebUI.setText(driver, inputSearchLead, name);
        WebUI.setKey(driver, inputSearchLead, Keys.ENTER);
        WebUI.sleep(1);
        Assert.assertEquals(WebUI.getTextElement(driver, firstRowItemLead), name, "Không đúng Lead đã thêm mới.");
    }

    public String getTotalStatusActiveLeads() {
        String totalActiveLeads = WebUI.getTextElement(driver, labelActive);
        return totalActiveLeads;
    }

    public String getTotalStatusCustomerLeads() {
        String totalCustomerLeads = WebUI.getTextElement(driver, labelCustomer);
        return totalCustomerLeads;
    }

    public int getTotalLeads() {
        int totalLeads = Integer.parseInt(getTotalStatusActiveLeads()) + Integer.parseInt(getTotalStatusCustomerLeads());
        return totalLeads;
    }
}

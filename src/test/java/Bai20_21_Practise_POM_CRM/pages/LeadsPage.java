package Bai20_21_Practise_POM_CRM.pages;

import keywords.WebUI_Old;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LeadsPage extends BasePage {
    private WebDriver driver;

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
    private By firstRowItemLeadName = By.xpath("//table[@id='leads']//tbody/tr[1]/td[3]/a");
    private By firstRowItemLeadStatus = By.xpath("//table[@id='leads']//tbody/tr[1]//td/span[contains(@class,'lead-status')]");
    private By totalStatusActiveLeads = By.xpath("//table[@id='leads']//tbody//td/span[contains(@class,'lead-status') and text()='Active']");
    private By totalStatusCustomerLeads = By.xpath("//table[@id='leads']//tbody//td/span[contains(@class,'lead-status') and text()='Customer']");

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
        WebUI_Old.clickElement(driver, iconLeadsSummary);
    }

    public void verifyNavigateToLeadPage() {
        clickIconLeadsSummary();
        Assert.assertTrue(checkExist(headerLeadsPage), "The lead header page not display.");
        Assert.assertEquals(WebUI_Old.getTextElement(driver, headerLeadsPage), "Leads Summary", "The lead header page not match.");
    }

    public void clickButtonNewLead() {
        WebUI_Old.clickElement(driver, buttonNewLead);
    }

    public void verifyOpenWindowAddNewLead() {
        Assert.assertTrue(checkExist(headerAddNewLeadWindow), "The new lead window not display.");
        Assert.assertEquals(WebUI_Old.getTextElement(driver, headerAddNewLeadWindow), "Add new lead", "The lead summary window not match.");
    }

    public void fillDataAddNewLead(String name) {
        WebUI_Old.clickElement(driver, dropdownStatus);
        WebUI_Old.setText(driver, inputSearchStatus, "Active");
        WebUI_Old.setKey(driver, inputSearchStatus, Keys.ENTER);

        WebUI_Old.clickElement(driver, dropdownSource);
        WebUI_Old.setText(driver, inputSearchSource, "Google");
        WebUI_Old.setKey(driver, inputSearchSource, Keys.ENTER);

        WebUI_Old.clickElement(driver, inputTags);
        WebUI_Old.setText(driver, inputTags, "HTest");
        WebUI_Old.setKey(driver, inputTags, Keys.ENTER);

        WebUI_Old.setText(driver, inputName, name);
//        WebUI.setText(driver, inputAddress, "Minh Khai");
        WebUI_Old.setText(driver, inputPosition, "Bắc Từ Liêm");
        WebUI_Old.setText(driver, inputCity, "Hà Nội");
        WebUI_Old.setText(driver, inputEmailAddress, "htest" + System.currentTimeMillis() + "@gmail.com");
        WebUI_Old.setText(driver, inputState, "htest state");
        WebUI_Old.setText(driver, inputWebsite, "htest.com.vn");

        WebUI_Old.clickElement(driver, dropdownCountry);
        WebUI_Old.setText(driver, inputSearchCountry, "Vietnam");
        WebUI_Old.setKey(driver, inputSearchCountry, Keys.ENTER);

        WebUI_Old.setText(driver, inputPhone, "0965896589");
        WebUI_Old.setText(driver, inputZipCode, "0235565");
        WebUI_Old.setText(driver, inputLeadValue, "10");

        WebUI_Old.clickElement(driver, dropdownDefaultLanguage);
        WebUI_Old.setText(driver, inputSearchDefaultLanguage, "Vietnamese");
        WebUI_Old.setKey(driver, inputSearchDefaultLanguage, Keys.ENTER);

        WebUI_Old.setText(driver, inputCompany, "NDJSC");
        WebUI_Old.setText(driver, inputDescription, "Test add lead");
        WebUI_Old.clickElement(driver, checkboxPublic);
    }

    public void clickSaveButton() {
        WebUI_Old.clickElement(driver, buttonSave);
    }

    public void clickButtonCloseAfterAdd() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", (driver.findElement(buttonCloseWindowAfterAdd)));
        WebUI_Old.sleep(1);
        WebUI_Old.clickElement(driver, buttonCloseWindowAfterAdd);
    }

    public void verifyAddNewLeadSuccess(String name) {
        WebUI_Old.waitForElementInVisible(driver, buttonCloseWindowAfterAdd);
        WebUI_Old.clickElement(driver, inputSearchLead);
        WebUI_Old.setText(driver, inputSearchLead, name);
        WebUI_Old.setKey(driver, inputSearchLead, Keys.ENTER);
        WebUI_Old.sleep(1);
        Assert.assertEquals(WebUI_Old.getTextElement(driver, firstRowItemLeadName), name, "Không đúng Lead đã thêm mới.");
    }

    public String getTotalStatusActiveLeads() {
        return WebUI_Old.getTextElement(driver, labelActive);
    }

    public String getTotalStatusCustomerLeads() {
        return WebUI_Old.getTextElement(driver, labelCustomer);
    }

    public int getTotalLeads() {
        int totalLead = Integer.parseInt(getTotalStatusActiveLeads()) + Integer.parseInt(getTotalStatusCustomerLeads());
        return totalLead;
    }

    public int countActiveStatusOnTable() {
        return driver.findElements(totalStatusActiveLeads).size();
    }

    public int countCustomerStatusOnTable() {
        return driver.findElements(totalStatusCustomerLeads).size();
    }

    public void verifyTotalStatusOnTableWithLeadsSummary() {
        clickIconLeadsSummary();
        System.out.println("Số lượng Status Active = " + getTotalStatusActiveLeads());
        int totalActive = Integer.parseInt(getTotalStatusActiveLeads());
        int countActive = countActiveStatusOnTable();
        Assert.assertEquals(totalActive, countActive, "Số lượng Status Active dưới Table không bằng trên Lead Summary");

        clickIconLeadsSummary();
        System.out.println("Số lượng Status Customer = " + getTotalStatusCustomerLeads());
        int totalCustomer = Integer.parseInt(getTotalStatusCustomerLeads());
        int countCustomer = countCustomerStatusOnTable();
        Assert.assertEquals(totalCustomer, countCustomer, "Số lượng Status Customer dưới Table không bằng trên Lead Summary");
    }

    public void verifyAfterAddingNewLead(String name) {
        clickIconLeadsSummary();
        String beforeActiveStatus = getTotalStatusActiveLeads();
        String beforeCustomerStatus = getTotalStatusCustomerLeads();

        clickButtonNewLead();
        fillDataAddNewLead(name);
        clickSaveButton();
        clickButtonCloseAfterAdd();
        verifyAddNewLeadSuccess(name);
        String statusOfRowAddNew = WebUI_Old.getTextElement(driver, firstRowItemLeadStatus);

        driver.navigate().refresh();
        WebUI_Old.waitForPageLoaded(driver);

        clickIconLeadsSummary();
        String afterActiveStatus = getTotalStatusActiveLeads();
        String afterCustomerStatus = getTotalStatusCustomerLeads();

        if (statusOfRowAddNew.equals("Active")) {
            Assert.assertEquals(Integer.parseInt(afterActiveStatus), Integer.parseInt(beforeActiveStatus) + 1, "Số lượng status Active trên Lead Summary không tăng đúng");
        } else if (statusOfRowAddNew.equals("Customer")) {
            Assert.assertEquals(Integer.parseInt(afterCustomerStatus), Integer.parseInt(beforeCustomerStatus) + 1, "Số lượng status Customer trên Lead Summary không tăng đúng");
        } else {
            System.out.println("Bản ghi mới thêm thành công thêm Status mới");
        }
//        verifyTotalStatusOnTableWithLeadsSummary();
    }
}

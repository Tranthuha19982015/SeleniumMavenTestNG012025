package Bai22_23_WebUI.pages;

import keywords.WebUI;
import org.openqa.selenium.*;
import org.testng.Assert;

public class LeadsPage extends BasePage {
    private WebDriver driver;

    public LeadsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

    // Locators for elements on the Leads page
    private By buttonNewLead = By.xpath("//a[normalize-space()='New Lead']");
    private By iconLeadsSummary = By.xpath("//a[contains(@class,'btn-with-tooltip') and @data-title='Leads Summary']");
    private By labelActive = By.xpath("//span[normalize-space()='Active']/preceding-sibling::span");
    private By labelCustomer = By.xpath("//span[normalize-space()='Customer']/preceding-sibling::span");
    private By headerLeadsPage = By.xpath("//h4[normalize-space()='Leads Summary']");
    private By inputSearchLead = By.xpath("//div[@id='leads_filter']/descendant::input[@type='search']");

    // The first row item in the leads table
    private By firstRowItemLeadName = By.xpath("//table[@id='leads']//tbody/tr[1]/td[3]/a");
    private By firstRowItemLeadEmail = By.xpath("//table[@id='leads']//tbody/tr[1]/td[5]/a");
    private By firstRowItemLeadStatus = By.xpath("//table[@id='leads']//tbody/tr[1]//td/span[contains(@class,'lead-status')]");

    // The total number of leads with specific statuses in the leads table
    private By totalStatusActiveLeads = By.xpath("//table[@id='leads']//tbody//td/span[contains(@class,'lead-status') and text()='Active']");
    private By totalStatusCustomerLeads = By.xpath("//table[@id='leads']//tbody//td/span[contains(@class,'lead-status') and text()='Customer']");

    // Elements in the Add New Lead window
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
    private By popupProfileLead = By.xpath("//div[@id='lead-modal']//div[@class='modal-content data']");

    public void clickIconLeadsSummary() {
        WebUI.clickElement(iconLeadsSummary);
        WebUI.waitForPageLoaded();
    }

    public void verifyNavigateToLeadPage() {
        boolean isDisplayed = WebUI.checkElementExist(headerLeadsPage);
        Assert.assertTrue(isDisplayed, "The lead header page not display.");
    }

    public void clickButtonNewLead() {
        WebUI.clickElement(buttonNewLead);
        WebUI.waitForPageLoaded();
    }

    public void verifyOpenWindowAddNewLead() {
        boolean isDisplayed = WebUI.checkElementExist(headerAddNewLeadWindow);
        Assert.assertTrue(isDisplayed, "The new lead window not display.");
    }

    public void fillDataAddNewLead(String name) {
        WebUI.clickElement(dropdownStatus);
        WebUI.setTextAndKey(inputSearchStatus, "Customer", Keys.ENTER);

        WebUI.clickElement(dropdownSource);
        WebUI.setTextAndKey(inputSearchSource, "Google", Keys.ENTER);

        WebUI.clickElement(dropdownAssigned);
        WebUI.setTextAndKey(inputSearchAssigned, "Anh Tester", Keys.ENTER);

        WebUI.setText(inputTags, "htest" + System.currentTimeMillis());

        WebUI.setText(inputName, name);
//        WebUI.setText(driver, inputAddress, "Minh Khai");
        WebUI.setText(inputPosition, "Bắc Từ Liêm");
        WebUI.setText(inputCity, "Hà Nội");
        WebUI.setText(inputEmailAddress, "htest" + System.currentTimeMillis() + "@gmail.com");
        WebUI.setText(inputState, "htest state");
        WebUI.setText(inputWebsite, "htest.com.vn");

        WebUI.clickElement(dropdownCountry);
        WebUI.setTextAndKey(inputSearchCountry, "Vietnam", Keys.ENTER);

        WebUI.setText(inputPhone, "0965896589");
        WebUI.setText(inputZipCode, "0235565");
        WebUI.setText(inputLeadValue, "10");

        WebUI.clickElement(dropdownDefaultLanguage);
        WebUI.setTextAndKey(inputSearchDefaultLanguage, "Vietnamese", Keys.ENTER);

        WebUI.setText(inputCompany, "NDJSC");
        WebUI.setText(inputDescription, "Test add lead");
        WebUI.clickElement(checkboxPublic);
    }

    public void clickSaveButton() {
        WebUI.clickElement(buttonSave);
        WebUI.waitForPageLoaded();
    }

    public void clickButtonCloseAfterAdd() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", (WebUI.getWebElement(buttonCloseWindowAfterAdd)));
        WebUI.sleep(1);
        WebUI.clickElement(buttonCloseWindowAfterAdd);
        WebUI.waitForPageLoaded();
    }

    public String getFirstRowItemLeadName() {
        return WebUI.getElementText(firstRowItemLeadName);
    }

    public String getFirstRowItemLeadEmail() {
        return WebUI.getElementText(firstRowItemLeadEmail);
    }

    public String getFirstRowItemLeadStatus() {
        return WebUI.getElementText(firstRowItemLeadStatus);
    }

    public void searchAndCheckLeadInTable(String name) {
        WebUI.waitForElementNotVisible(popupProfileLead);
        WebUI.clickElement(inputSearchLead);
        WebUI.setTextAndKey(inputSearchLead, name, Keys.ENTER);
        WebUI.waitForPageLoaded();
        WebUI.sleep(1);
        Assert.assertEquals(getFirstRowItemLeadName(), name, "Không đúng Lead đã thêm mới.");
    }

    public String getTotalStatusActiveLeads() {
        return WebUI.getElementText(labelActive);
    }

    public String getTotalStatusCustomerLeads() {
        return WebUI.getElementText(labelCustomer);
    }

    public int getTotalLeads() {
        int totalLead = Integer.parseInt(getTotalStatusActiveLeads()) + Integer.parseInt(getTotalStatusCustomerLeads());
        return totalLead;
    }

    public void verifyAfterAddingNewLead(int beforeActiveStatus, int beforeCustomerStatus,
                                         int afterActiveStatus, int afterCustomerStatus, String statusOfFirstRowItem) {
        if (statusOfFirstRowItem.equals("Active")) {
            Assert.assertEquals(afterActiveStatus, beforeActiveStatus + 1, "The number of Active Statuses after adding new ones does not match.");
            Assert.assertEquals(afterCustomerStatus, beforeCustomerStatus, "The number of Customer Statuses after adding new ones does not match.");
            System.out.println("The number of Status Active after successfully adding new ones is: " + afterActiveStatus);
            System.out.println("The number of Customer Statuses that remain unchanged after successful addition is: " + afterCustomerStatus);
        } else if (statusOfFirstRowItem.equals("Customer")) {
            Assert.assertEquals(afterCustomerStatus, beforeCustomerStatus + 1, "The number of Customer Statuses after adding new ones does not match.");
            Assert.assertEquals(afterActiveStatus, beforeActiveStatus, "The number of Active Statuses after adding new ones does not match.");
            System.out.println("The number of Status Active that remains unchanged after a successful addition is: " + afterActiveStatus);
            System.out.println("The number of Customer Statuses after successfully adding new ones is: " + afterCustomerStatus);
        } else {
            System.out.println("The newly added record has a Status other than Active and Customer: " + statusOfFirstRowItem);
        }
    }

    public int countActiveStatusOnTable() {
        return WebUI.getWebElements(totalStatusActiveLeads).size();
    }

    public int countCustomerStatusOnTable() {
        return WebUI.getWebElements(totalStatusCustomerLeads).size();

    }
}

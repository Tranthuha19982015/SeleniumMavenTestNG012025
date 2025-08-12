package Bai20_21_Practise_POM_CRM.pages;

import keywords.WebUI;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CustomersPage extends BasePage {
    private WebDriver driver;

    public CustomersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //Locator for Customer List
    private By buttonNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By headerCustomerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By inputSearchCustomer = By.xpath("//div[@id='clients_filter']//input[@type='search']");
    private By firstRowItemCustomer = By.xpath("//table[@id='clients']//tbody/tr[1]/td[3]/a");
    private By labelTotalCustomers = By.xpath("//span[normalize-space()='Total Customers']/preceding-sibling::span");

    //Locator for Add New Customer
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputVatNumber = By.xpath("//input[@id='vat']");
    private By inputPhone = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By dropdownGroups = By.xpath("//button[contains(@data-id,'groups_in')]");
    private By inputSearchGroups = By.xpath("//button[contains(@data-id,'groups_in')]/following-sibling::div//input[@type='search']");
    private By dropdownCurrency = By.xpath("//button[contains(@data-id,'default_currency')]");
    private By inputSearchCurrency = By.xpath("//button[contains(@data-id,'default_currency')]/following-sibling::div//input[@type='search']");
    private By dropdownDefaultLanguage = By.xpath("//button[contains(@data-id,'default_language')]");

    public By selectXpathLanguage(String language) {
        String xpathLanguage = "//span[normalize-space()='" + language + "']";
        System.out.println("Select language: " + language);
        return By.xpath(xpathLanguage);
    }

    //    private By optionLanguageVietnamese = By.xpath("//span[normalize-space()='Vietnamese']");
//    private String optionLanguageDynamic = "(//span[normalize-space()='%s'])[%d]";
    private By dropdownCountry = By.xpath("//button[contains(@data-id,'country')]");
    private By inputSearchCountry = By.xpath("//button[contains(@data-id,'country')]/following-sibling::div//input[@type='search']");
    private By buttonSave = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");
    private By headerCustomerDetailPage = By.xpath("//h4[normalize-space()='Profile']");

    //Hàm xử lý cho trang Customer
    private boolean checkElementExist(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void verifyNavigateToCustomerPage() {
        Assert.assertTrue(checkElementExist(headerCustomerPage), "The customer header page not display.");
        Assert.assertEquals(WebUI.getTextElement(driver, headerCustomerPage), "Customers Summary", "The customer header page not match.");
    }

    public void clickButtonNewCustomer() {
        WebUI.clickElement(driver, buttonNewCustomer);
    }

    public void fillDataForAddNewCustomer(String customerName) {
        WebUI.setText(driver, inputCompany, customerName);
        WebUI.setText(driver, inputVatNumber, "10");
        WebUI.setText(driver, inputPhone, "0965898635");
        WebUI.setText(driver, inputWebsite, "htest.com.vn");

        // select Groups
        WebUI.clickElement(driver, dropdownGroups);
        WebUI.setText(driver, inputSearchGroups, "hatran");
        WebUI.setKey(driver, inputSearchGroups, Keys.ENTER);
        WebUI.clickElement(driver, dropdownGroups);

        //select Currency
        WebUI.clickElement(driver, dropdownCurrency);
        WebUI.setText(driver, inputSearchCurrency, "USD");
        WebUI.setKey(driver, inputSearchCurrency, Keys.ENTER);

        //select Default Language
        WebUI.clickElement(driver, dropdownDefaultLanguage);
        WebUI.clickElement(driver, selectXpathLanguage("Vietnamese"));

        WebUI.setText(driver, inputAddress, "Minh Khai, Bắc Từ Liêm");
        WebUI.setText(driver, inputCity, "Hà Nội");
        WebUI.setText(driver, inputState, "123545");
        WebUI.setText(driver, inputZipCode, "0001212");

        //select Country
        WebUI.clickElement(driver, dropdownCountry);
        WebUI.setText(driver, inputSearchCountry, "Vietnam");
        WebUI.setKey(driver, inputSearchCountry, Keys.ENTER);
    }

    public void clickSaveButton() {
        WebUI.clickElement(driver, buttonSave);
    }

    public void verifyNavigateToCustomerDetailPage() {
        Assert.assertTrue(checkElementExist(headerCustomerDetailPage), "The customer detail header page not display.");
        Assert.assertEquals(WebUI.getTextElement(driver, headerCustomerDetailPage), "Profile", "The customer detail header page not match.");
    }

    public void verifyAddNewCustomerSuccess(String customerName) {
        //navigation to customer detail
        verifyNavigateToCustomerDetailPage();

        //Verify data in customer detail
        Assert.assertEquals(WebUI.getAttributeElement(driver, inputCompany, "value"), customerName, "The Company name not match.");
        Assert.assertEquals(WebUI.getAttributeElement(driver, inputVatNumber, "value"), "10", "The VAT value not match.");
        Assert.assertEquals(WebUI.getAttributeElement(driver, inputPhone, "value"), "0965898635", "The Phone number value not match.");
        Assert.assertEquals(WebUI.getAttributeElement(driver, inputWebsite, "value"), "htest.com.vn", "The Website value not match.");
        Assert.assertEquals(WebUI.getAttributeElement(driver, dropdownGroups, "title"), "hatran", "The Groups value not match.");
        Assert.assertEquals(WebUI.getAttributeElement(driver, dropdownCurrency, "title"), "USD", "The Currency value not match.");
        Assert.assertEquals(WebUI.getAttributeElement(driver, dropdownDefaultLanguage, "title"), "Vietnamese", "The Default Language value not match.");
        Assert.assertEquals(WebUI.getAttributeElement(driver, inputAddress, "value"), "Minh Khai, Bắc Từ Liêm", "The Address value not match.");
        Assert.assertEquals(WebUI.getAttributeElement(driver, inputCity, "value"), "Hà Nội", "The City value not match.");
        Assert.assertEquals(WebUI.getAttributeElement(driver, inputState, "value"), "123545", "The State value not match.");
        Assert.assertEquals(WebUI.getAttributeElement(driver, inputZipCode, "value"), "0001212", "The Zip Code value not match.");
        Assert.assertEquals(WebUI.getAttributeElement(driver, dropdownCountry, "title"), "Vietnam", "The Country value not match.");
    }

    public void searchAndCheckCustomerInTable() {

    }

    public void verifyCustomerDetail() {

    }
}


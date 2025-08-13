package Bai14_JavascriptExecutor;

import common.BaseTest;
import keywords.WebUI_Old;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoJavascriptExecutor extends BaseTest {
    @Test
    public void testClickElementWithJavaScriptExecutor() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(1000);

        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));

        // sendKeys text on input
        js.executeScript("arguments[0].setAttribute('value','admin@example.com');", inputEmail);
        js.executeScript("arguments[0].setAttribute('value','123456');", inputPassword);

        WebElement buttonLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        js.executeScript("arguments[0].click()", buttonLogin);
        Thread.sleep(2000);
    }

    @Test
    public void testClickElementWithJavaScriptExecutor_CMS() throws InterruptedException {
        // Creating the JavascriptExecutor interface object
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://cms.anhtester.com");
        Thread.sleep(1000);

        // Click on "Website Testing" module using JavascriptExecutor
        WebElement menuBlog = driver.findElement(By.xpath("//a[normalize-space()='Blogs']"));
        js.executeScript("arguments[0].click();", menuBlog);
//        menuBlog.click();
        Thread.sleep(1000);
    }

    @Test
    public void testScrollToElement() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'Kiến thức Automation Testing')]"));

        //Scroll to element
        //Giá trị true là nằm phía trên
        //Giá trị false là nằm phía dưới
        js.executeScript("arguments[0].scrollIntoView(true);", element);

//        js.executeScript("arguments[0].scrollIntoView(false);", element);

        Thread.sleep(2000);
    }

    @Test
    public void demoHighlightElement() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
//        js.executeScript("arguments[0].style.border='3px solid red';", inputEmail);
        WebUI_Old.highlightElement(driver, inputEmail, "red");
        js.executeScript("arguments[0].setAttribute('value','admin@example.com');", inputEmail);
        Thread.sleep(1000);

        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
//        js.executeScript("arguments[0].style.border='3px solid purple';", inputPassword);
        WebUI_Old.highlightElement(driver, inputPassword, "green");
        js.executeScript("arguments[0].setAttribute('value','123456');", inputPassword);
        Thread.sleep(1000);

        WebElement buttonLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        js.executeScript("arguments[0].click();", buttonLogin);
        Thread.sleep(2000);
    }

    @Test
    public void jsExecutorDemo01() throws InterruptedException {
        // Creating the JavascriptExecutor interface object
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        // Click on "Website Testing" module using JavascriptExecutor
        WebElement button = driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']"));
        js.executeScript("arguments[0].click();", button);
        Thread.sleep(1000);

        // Get page title and Domain using JavascriptExecutor
        String titleText = js.executeScript("return document.title;").toString();
        System.out.println("Page Title is: " + titleText);

        String domainName = js.executeScript("return document.domain;").toString();
        System.out.println("Domain is: " + domainName);

        // Add Alert window using JavascriptExecutor
        js.executeScript("alert('Successfully Logged In');");

        Thread.sleep(2000);
    }

    @Test
    public void localStorage() throws InterruptedException {
        String localGetVar = "";

        driver.navigate().to("https://anhtester.com");
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Set giá trị
        js.executeScript("window.localStorage.setItem(arguments[0],arguments[1])", "age", "30");

        Thread.sleep(1000);

        //Get giá trị
        localGetVar = (String) js.executeScript("return window.localStorage.getItem(arguments[0])", "age");

        System.out.println(localGetVar);

        Thread.sleep(1000);
    }
}

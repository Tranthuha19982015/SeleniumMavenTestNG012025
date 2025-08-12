package keywords;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebUI {
    public static int WAIT_TIMEOUT = 10;

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void highlightElement(WebDriver driver, WebElement element) {
        // Highlight the element using JavaScriptExecutor
        String script = "arguments[0].style.border='3px solid red';";
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    public static void highlightElement(WebDriver driver, WebElement element, String color) {
        // Highlight the element using JavaScriptExecutor
        String script = "arguments[0].style.border='3px solid " + color + "';";
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    public static void clickElement(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
//        highlightElement(driver, element);
        element.click();
        System.out.println("Click to element: " + by);
    }

    public static void clickElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        highlightElement(driver, element);
        element.click();
    }

    public static void clickElement(WebDriver driver, By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        System.out.println("Click to element: " + by);
    }

    public static void setText(WebDriver driver, By by, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.sendKeys(text);
        System.out.println("Set text for element: " + by);
    }

    public static void setText(WebDriver driver, WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
        highlightElement(driver, element);
        element.sendKeys(text);
    }

    public static void setKey(WebDriver driver, By by, Keys key) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.sendKeys(key);
    }

    public static String getTextElement(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        System.out.println("Get text of element: " + by);
        String textElement = element.getText();
        System.out.println("===> Text: " + textElement);
        return textElement;
    }

    public static String getAttributeElement(WebDriver driver, By by, String attribute) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        System.out.println("Get attribute of element" + by);
        String attributeElement = element.getAttribute(attribute);
        System.out.println("===> Attribute: " + attributeElement);
        return attributeElement;
    }

    public static List<WebElement> getListElement(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        return elements;
    }

    public static boolean waitForElementVisible(WebDriver driver, By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element not visible: " + by);
            return false;
        }
    }

    public static void waitForResultVisible(WebDriver driver, By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            System.out.println("Element not visible: " + by);
        }
    }

    public static void switchToFrameWhenAvailable(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
            System.out.println("Switched to iframe: " + by);
        } catch (TimeoutException e) {
            throw new RuntimeException("Iframe không xuất hiện sau: " + WAIT_TIMEOUT + " giây");
        }
    }

    public static void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
        System.out.println("Switched back to default content");
    }

    public static void clearTextElement(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.clear();
        System.out.println("Clear text default of element: " + by);
    }

}

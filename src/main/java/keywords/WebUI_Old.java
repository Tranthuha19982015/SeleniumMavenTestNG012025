package keywords;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebUI_Old {
    public static int WAIT_TIMEOUT = 10;
    private static int PAGE_LOAD_TIMEOUT = 20;

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
        System.out.println("Set text \"" + text + "\" for element: " + by);
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
        String textActual = "";
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            textActual = element.getText();
            System.out.println("Get text of element: " + by);
            System.out.println("===> Text: " + textActual);
        } catch (TimeoutException e) {
            System.out.println("Element not found or not visible: " + by);
        }
        return textActual;
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

    //Chờ đợi trang load xong mới thao tác
    public static void waitForPageLoaded(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            //System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }

    public static void waitForElementInVisible(WebDriver driver, By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (TimeoutException e) {
            System.out.println("Element still visible: " + by);
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

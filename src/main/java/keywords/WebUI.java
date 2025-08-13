package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WebUI {

    private static int WAIT_TIMEOUT = 10;
    private static double STEP_TIME = 0.5;
    private static int PAGE_LOAD_TIMEOUT = 20;
    private static WebDriver driver; //driver = null

    public WebUI(WebDriver driver) {
        this.driver = driver;
    }

    public static void logConsole(Object message) {
        System.out.println(message);
    }

    public static void highlightElement(By by) {
        // Highlight the element using JavaScript
        String script = "arguments[0].style.border='3px solid red';";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, driver.findElement(by));
    }

    public static void highlightElement(By by, String color) {
        // Highlight the element using JavaScript
        String script = "arguments[0].style.border='3px solid " + color + "';";
        ((JavascriptExecutor) driver).executeScript(script, driver.findElement(by));
    }

    //Wait for Element
    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebElement waitForElementVisible(By by) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            highlightElement(by);
        } catch (Throwable error) {
            logConsole("Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
        }
        return element;
    }

    public static WebElement waitForElementVisible(By by, int timeOut) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            highlightElement(by);
        } catch (Throwable error) {
            logConsole("Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
        }
        return element;
    }

    public static void clickElement(By by) {
        WebElement element = waitForElementVisible(by);
        element.click();
    }

    public static void clickElement(By by, int seconds) {
        WebElement element = waitForElementVisible(by, seconds);
        element.click();
    }

    public static void setText(By by, String text) {
        waitForElementVisible(by).sendKeys(text);
    }

}


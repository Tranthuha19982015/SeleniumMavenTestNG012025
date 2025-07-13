package Bai12_ActionsClass_RobotClass;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestActionsClass extends BaseTest {
    @Test
    public void testSendKeys() throws InterruptedException {
        driver.get("https://cms.anhtester.com/");

        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Ok. I Understood']")).click();

        //Input search
        WebElement element = driver.findElement(By.xpath("//input[@id='search']"));

        //Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        //Dùng action để gọi hàm sendKeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Giày nữ").perform();
        Thread.sleep(2000);
    }

    @Test
    public void testPressEnterKey() throws InterruptedException {
        driver.get("https://cms.anhtester.com/");

        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Ok. I Understood']")).click();

        //Input search
        WebElement element = driver.findElement(By.xpath("//input[@id='search']"));

        //Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        //Dùng action để gọi hàm sendKeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Giày nữ").perform();
        Thread.sleep(2000);

        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
    }

    @Test
    public void testClick() throws InterruptedException {
        driver.get("https://cms.anhtester.com/");

        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Ok. I Understood']")).click();

        //Input search
        WebElement element = driver.findElement(By.xpath("//input[@id='search']"));

        //Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        //Dùng action để gọi hàm sendKeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Giày nữ").perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
        action.click(driver.findElement(By.xpath("(//a[contains(text(),'Giày nữ')])[1]"))).perform();

        Thread.sleep(2000);
    }

    @Test
    public void doubleClick() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("(//h2[@class='section__title'])[1]"));

        Actions action = new Actions(driver);

        action.doubleClick(element).perform();
        Thread.sleep(2000);
    }

    @Test
    public void contextClick() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("(//h2[@class='section__title'])[1]"));

        Actions action = new Actions(driver);

        action.contextClick(element).perform();
        Thread.sleep(2000);
    }
}

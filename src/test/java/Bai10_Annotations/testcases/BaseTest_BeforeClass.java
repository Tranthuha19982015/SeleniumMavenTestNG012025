package Bai10_Annotations.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest_BeforeClass {
    public WebDriver driver;


    @BeforeClass
    public void createDriver() {
        System.out.println("Khởi tạo trình duyệt Chrome");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            System.out.println("Đóng trình duyệt");
        }
    }
}

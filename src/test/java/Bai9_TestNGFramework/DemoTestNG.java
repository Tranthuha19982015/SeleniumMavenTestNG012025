package Bai9_TestNGFramework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DemoTestNG {

    @Test
    public void testMethod1() {
        System.out.println("This is Test Method 1");
    }

    @Test
    public void testMethod2() {
        System.out.println("This is Test Method 2");
    }
}

package Bai10_Annotations;

import org.testng.annotations.*;

public class DemoAnnotations_2 {
//    @BeforeSuite
//    public void beforeSuite() {
//        System.out.println("@BeforeSuite 2 Chạy trước toàn bộ suite");
//    }
//
//    @AfterSuite
//    public void afterSuite() {
//        System.out.println("@AfterSuite 2 Chạy sau toàn bộ suite");
//    }

//    @BeforeTest
//    public void beforeTest() {
//        System.out.println("@BeforeTest 2 Chạy trước tất cả các test trong một thẻ <test>");
//    }
//
//    @AfterTest
//    public void afterTest() {
//        System.out.println("@AfterTest 2 Chạy sau tất cả các test trong một thẻ <test>");
//    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Call API lấy dữ liệu trước khi chạy test");
        System.out.println("@BeforeClass 2 Chạy trước tất cả các test trong class này");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass 2 Chạy sau tất cả các test trong class này");
    }

    @Test
    public void testLoginSuccess() {
        System.out.println("This is Test Login Success");
    }

    @Test
    public void testLoginFail() {
        System.out.println("This is Test Login Fail");
    }
}

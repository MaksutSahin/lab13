package students.Maksut;

import utils.BrowserUtils;
import utils.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class lab08 {
    //    Step 1)Launch the web browser and open the site http://demo.guru99.com/test/delete_customer.php
//    Step 2)Enter Any Customer id.
//    Step 3)After entering the customer ID, Click on the “Submit” button.
//    Step 4)Reject/accept the alert.
    WebDriver driver;

    @BeforeGroups
    void bGroup() {
    }

    @BeforeSuite
    void bSuite() {
    }

    @BeforeTest
    void bTest() {
        System.out.println("Pre-test phase. Testing process begins...");
        driver = WebDriverUtil.getDriver("chrome");
        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/delete_customer.php");
    }

    @BeforeClass
    void bClass() {
    }

    @BeforeMethod
    void bMethod() {
    }


    @Test
    void test1() {
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).click();
    }

    @Test
    void test2() {
        test1();
        Random random = new Random(9999999999L);
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("" + random.nextLong());
    }

    @Test
    void test3AcceptScenario() {
        test2();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().accept();
        BrowserUtils.wait(2);
        driver.quit();
    }

    @Test
    void test3DismissScenario() {
        bTest();
        test2();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().dismiss();
        BrowserUtils.wait(2);

    }


    @AfterMethod
    void aMethod() {
    }

    @AfterClass
    void aClass() {
        BrowserUtils.wait(1);
        driver.quit();
    }

    @AfterTest
    void aTest() {
        System.out.println("After-Test phase. Testing process is completed...");
    }

    @AfterSuite
    void aSuite() {
    }

    @AfterGroups
    void aGroup() {
    }
}

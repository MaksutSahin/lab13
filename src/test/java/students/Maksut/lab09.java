package students.Maksut;

import utils.BrowserUtils;
import utils.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class lab09 {
    WebDriver driver;

    @BeforeGroups
    void bGroup() {
    }

    @BeforeSuite
    void bSuite() {
    }

    @BeforeTest
    void bTest() {
    }

    @BeforeClass
    void bClass() {
        System.out.println("Pre-test phase. Testing process begins...");
        System.out.println("===============================================");
    }

    @BeforeMethod
    void bMethod() {
//        System.out.println("\n"+"•••○○○New test is starting○○○•••"+"\n");
    }

    @Test
    void test1() {
        driver = WebDriverUtil.getDriver("chrome");
        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");
        BrowserUtils.wait(1);
    }

    @Test
    void test2() {
        System.out.println("The current window’s handle = " + driver.getWindowHandle());
        BrowserUtils.wait(1);
    }

    @Test
    void test3() {
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.linkText("Visit W3Schools.com!")).click();
        BrowserUtils.wait(1);
    }

    @Test
    public ArrayList<String> test4() {
        return new ArrayList<>(driver.getWindowHandles());
    }

    @Test
    void test5() {
        System.out.println("Total window handle number = " + test4().size());
    }

    @Test
    void test6() {
        driver.switchTo().window(test4().get(1));
    }

    @Test
    void test7() {
        System.out.println("The current window’s handle = " + driver.getWindowHandle());
    }

    @Test
    void test8() {
        if (driver.findElement(By.xpath("/html/body/div[3]/a[1]/i")).isDisplayed()) {
            System.out.println("-The upper left side logo is displayed as expected and logo verification has passed.");
        } else {
            System.out.println("-The upper left side logo is not displayed as expected and logo verification has failed.");
        }
    }

    @Test
    void test9() {
        driver.switchTo().window(test4().get(0));
    }

    @Test
    void test10() {
        System.out.println("The current window’s handle = " + driver.getWindowHandle());
    }

    @Test
    void test11() {
        String currentButtonText = driver.findElement(By.xpath("/html/body/div[2]/div/button")).getText();
        if (currentButtonText.contains("Run ❯")) {
            System.out.println("-Run button text contains \"Run ❯\" and button text verification has passed.");
        } else {
            System.out.println("-Run button text does not contain \"Run ❯\" and button text verification has failed");
        }
    }

    @AfterMethod
    void aMethod() {
//        System.out.println("\n" + "○○○•••End of current test•••○○○"+"\n");
    }

    @AfterClass
    void aClass() {
    }

    @AfterTest
    void aTest() {
    }

    @AfterSuite
    void aSuite() {
        System.out.println("===============================================");
        System.out.println("After-Test phase. Testing process is completed...");
        driver.quit();
    }

    @AfterGroups
    void aGroup() {
    }

}

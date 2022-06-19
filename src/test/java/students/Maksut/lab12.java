package students.Maksut;

import utils.BrowserUtils;
import utils.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class lab12 {
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
    }

    @Test
    void test1() {
        driver = WebDriverUtil.getDriver("chrome");
        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
    }

    @Test
    void test2() {
        driver.switchTo().frame("iframeResult").findElement(By.xpath("/html/body/button")).click();
        BrowserUtils.wait(1);
    }

    @Test
    void test3() {
        driver.switchTo().alert().sendKeys("Maksut");
        driver.switchTo().alert().accept();
        BrowserUtils.wait(1);
    }

    @Test
    void test4() {
        String expectedName = "Maksut";
        String currentText = driver.findElement(By.xpath("/html/body/p")).getText();
        if (currentText.contains(expectedName)) {
            System.out.println("•PASSED• Your name \"" + expectedName + "\" is shown on the page.");
        } else {
            System.out.println("•FAILED• Your name \"" + expectedName + "\" is not shown on the page.");
        }
        BrowserUtils.wait(1);
    }

    @Test
    void test5() {
        driver.switchTo().window(driver.getWindowHandle());
        driver.findElement(By.xpath("/html/body/div[2]/div/a[1]")).click();
        BrowserUtils.wait(1);
    }

    @Test
    void test6() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        BrowserUtils.wait(1);
    }

    @Test
    void test7() {
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/a")).click();
        BrowserUtils.wait(1);
    }

    @Test
    void test8() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div[1]/div/div[2]/form/div[1]/div[2]/input")).sendKeys("abcde");
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div[1]/div/div[2]/form/div[2]/div[2]/input")).sendKeys("123asdzxc,./");
        BrowserUtils.wait(1);
    }

    @Test
    void test9() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div[1]/div/div[2]/form/div[2]/div[1]/span")).click();
        BrowserUtils.wait(1);
    }

    @Test
    void test91() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        BrowserUtils.wait(2);
        Assert.assertEquals(("Tryit Editor v3.7"), driver.getTitle());
    }

    @AfterMethod
    void aMethod() {
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


package students.Maksut;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class lab13 {
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
        driver.get("http://demo.guru99.com/V4/");
    }

    @Test
    void test2() {

    }

    @Test
    void test3() {
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).click();
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys("mngr415262");
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).click();
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("dyqAryd");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")));
    }


    @Test
    void test4() {
        String currentText = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
        String expectedText = "Manger Id: mngr368294";
        if (currentText.contains(expectedText)){
            System.out.println("•Passed• Home page contains text as \""+expectedText+"\".");
        }
        else{
            System.out.println("•Failed• Home page does not contain text as \""+expectedText+"\".");
        }
    }

    @Test
    void test5() {
    }

    @Test
    void test6() {
    }

    @Test
    void test7() {
    }

    @Test
    void test8() {
    }

    @Test
    void test9() {
    }

    @Test
    void test91() {
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
//        driver.quit();
    }

    @AfterGroups
    void aGroup() {
    }
}

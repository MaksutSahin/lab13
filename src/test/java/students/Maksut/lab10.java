package students.Maksut;

import utils.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
public class lab10 {
    WebDriver driver;

    @BeforeGroups
    void bGroup() {
    }

    @BeforeSuite
    void bSuite() {
        System.out.println("Pre-test phase. Testing process begins...");
    }

    @BeforeTest
    void bTest() {
    }

    @BeforeClass
    void bClass() {
    }

    @BeforeMethod
    void bMethod() {
    }


    @Test
    void test1() {
        driver = WebDriverUtil.getDriver("chrome");
        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
    }

    @Test
    void test2() {
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).click();
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys("mngr415262");
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).click();
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("dyqAryd");
    }

    @Test
    void test3() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")));
    }

    @Test
    void test4(){
        ((JavascriptExecutor) driver).executeScript("alert('Welcome to Guru99');");
    }

    @AfterMethod
    void aMethod() {
//       driver.close();
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

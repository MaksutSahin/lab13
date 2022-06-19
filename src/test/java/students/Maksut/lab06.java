package students.Maksut;

import utils.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

//go to: http://demo.guru99.com/test/newtours/register.php
// click on country dropdown and select Barbados with Select Method
//Use 3 different Select Method (visible text,index,value)
//and switch to another countries as you wish
public class lab06 {
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
    }

    @BeforeClass
    void bClass() {
    }

    @BeforeMethod
    void bMethod() {
        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/newtours/register.php");
    }

    @Test
    void test1() throws InterruptedException {
//        driver.findElement(By.name("country")).click();
        WebElement DropDownBox = driver.findElement(By.name("country"));
        Select dropdown = new Select(DropDownBox);
        Thread.sleep(1700);
        dropdown.selectByVisibleText("BARBADOS");
        Thread.sleep(1700);
        dropdown.selectByValue("TURKEY");
        Thread.sleep(1700);
        dropdown.selectByIndex(41);
        Thread.sleep(1800);
    }

//    @Test
//    void test1Alternative() {
//        driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[11]/td[2]/select/option[20]")).click();
//    }

    @AfterMethod
    void aMethod() {
        driver.close();
    }

    @AfterClass
    void aClass() {
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

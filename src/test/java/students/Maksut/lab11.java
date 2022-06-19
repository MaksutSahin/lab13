package students.Maksut;

import utils.BrowserUtils;
import utils.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class lab11 {
    WebDriver driver;
    /////////////////////  task1

    @BeforeTest
    void bTest2(){
        System.out.println("Pre-test phase. Testing process begins...");
        driver = WebDriverUtil.getDriver("chrome");
        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/delete_customer.php");
    }
    @Test
    void secondTest1(){
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).click();
    }
    @Test
    void secondTest2() {
        secondTest1();
        Random random = new Random(9999999999L);
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("" + random.nextLong());
    }

    @Test
    void secondTest3AcceptScenario() {
        secondTest2();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().accept();
        BrowserUtils.wait(2);
        driver.quit();
    }

    @Test
    void secondTest3DismissScenario() {
        bTest2();
        secondTest2();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().dismiss();
        BrowserUtils.wait(2);
        driver.quit();
    }
    @AfterTest
    void aTest2(){
        BrowserUtils.wait(1);
    }
    ///////////////////// task2-
    @BeforeClass
    void bClass() {
        System.out.println("Pre-test phase. New testing process begins...");
        System.out.println("===============================================");
    }

    @BeforeMethod
    void bMethod() {
//        System.out.println("\n"+"•••○○○New test is starting○○○•••"+"\n");
    }

    @Test
    public void test1(){
        driver = WebDriverUtil.getDriver("chrome");
        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/hovers");
        BrowserUtils.wait(1);

    }

    @Test
    void test2() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/img"))).perform();
        BrowserUtils.wait(1);
    }

    @Test
    void test3() {
        String expectedImageText="name: user3";
//        String currentImageText=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/h5")).getText();
        if (driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/h5")).isDisplayed()){
            System.out.println("•PASSED• The text of third image \""+expectedImageText+"\" is present on the screen.");
        }
        else {
            System.out.println("•FAILED• The text of third image \""+expectedImageText+"\" is not present on the screen.");
        }
        BrowserUtils.wait(1);
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

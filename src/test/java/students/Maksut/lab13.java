package students.Maksut;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import students.Maksut.pages.lab13_Home;
import students.Maksut.pages.lab13_Login;
import students.Maksut.pages.lab13_NewCustomerEntry;
import utils.BrowserUtils;
import utils.PropertiesReadingUtil;
import utils.WebDriverUtil;

import java.time.Duration;
import java.util.ArrayList;


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
        driver = WebDriverUtil.getDriver("chrome");
        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("Pre-test phase. Testing process begins...");
        System.out.println("===============================================");
        BrowserUtils.wait(4);
    }

    @BeforeMethod
    void bMethod() {
    }

    @Test(priority = -3)
    public ArrayList<String> asd() {
        return new ArrayList<>(driver.getWindowHandles());
    }

    @Test(priority = -1)
//(properties)
    void test1() {
        driver.switchTo().window(asd().get(0));
        driver.switchTo().window(asd().get(1));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL);
        actions.keyUp(Keys.CONTROL);
        driver.get(PropertiesReadingUtil.getProperties("url"));
        BrowserUtils.wait(2);
    }

    @Test(priority = 0)
//(Login)
    void test2() throws InterruptedException {
        lab13_Login toLog = new lab13_Login(driver);
        if (toLog.checkGuru99BankText()) {
            System.out.println("•Passed• \"Guru99 Bank\" text is present in the login page.");
        }

        if (driver.findElement(By.xpath("/html/body/div[2]/h2")).isDisplayed()) {
            System.out.println("•Passed• \"Guru99 Bank\" text is present in the login page.");
        } else {
            System.out.println("•Failed• \"Guru99 Bank\" text is not displayed in the login page.");
        }
        BrowserUtils.wait(2);
    }

    @Test(priority = 1)
//(Login)-(properties)
    void test3() {
        lab13_Login toLog = new lab13_Login(driver);
        toLog.loginGuru(driver, PropertiesReadingUtil.getProperties("username"), PropertiesReadingUtil.getProperties("password"));
        BrowserUtils.wait(2);
    }


    @Test(priority = 2)
//(Home)
    void test4() {
        lab13_Home testHome = new lab13_Home(driver);
        String currentText = testHome.getMangerId();
        String expectedText = "Manger Id: mngr368294";
        if (currentText.contains(expectedText)) {
            System.out.println("•Passed• Home page contains text as \"" + expectedText + "\".");
        } else {
            System.out.println("•Failed• Home page does not contain text as \"" + expectedText + "\".");
        }
        BrowserUtils.wait(2);
    }

    @Test(priority = 3)
//(NewCustomerPage)
    void test5() {
        lab13_NewCustomerEntry NCE = new lab13_NewCustomerEntry(driver);
        NCE.newCustomerEntField.click();
        String currentTitle = driver.getTitle();
        String expectedTitle = "Guru99 Bank New Customer Entry Page";
        if (currentTitle.equals(expectedTitle)) {
            System.out.println("•Passed• User is in the New Customer Entry Page.");
        } else {
            System.out.println("•Failed• User is not in the New Customer Entry Page.");
        }
        BrowserUtils.wait(2);
    }

    @Test(priority = 4)
//(NewCustomerPage)
    void test6() {
        lab13_NewCustomerEntry NCE = new lab13_NewCustomerEntry(driver);
        NCE.setFields("Fernanda", "Female", (short) 1984, (byte) 12, (byte) 29, "4958 Golden Street", "Tucson", "Arizona", 123456, 3078459111L, "fernandaNCE0012@gmail.com", "noName.123");
        BrowserUtils.wait(2);
    }

    @Test(priority = 5)
//(NewCustomerPage)
    void test7() {
        lab13_NewCustomerEntry NCE = new lab13_NewCustomerEntry(driver);
        if (NCE.checkNewCustomer()) {
            System.out.println("•Passed• New customer is added. Verification is successful.");
        } else {
            System.out.println("•Failed• New customer is not added. Verification is not successful.");
        }
        BrowserUtils.wait(2);
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

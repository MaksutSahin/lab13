package students.Maksut;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class lab05 {
    //Go to Amazon
//enter Desk in search box
//Then search for desks
//(Use this task with TestNG framework)
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void lab05(){
        WebDriver abc=new ChromeDriver();
        abc.manage().window().maximize();
        abc.get("https://www.amazon.com");
        abc.findElement(By.id("twotabsearchtextbox")).sendKeys("Desk",Keys.ENTER);
    }
    @AfterMethod
    public void close(){
        System.out.println("This code is DONE right HEREEEE!!!");
    }
}

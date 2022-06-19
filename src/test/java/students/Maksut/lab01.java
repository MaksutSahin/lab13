package students.Maksut;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class lab01 { /*##Task 1
Go to https://www.etsy.com/
Maximize window

##Task 2
Go to https://www.amazon.com/
get title and print out*/

    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver myDriver = new FirefoxDriver();
        myDriver.get("https://www.etsy.com/");
        myDriver.manage().window().maximize();

        WebDriver myDriver2 = new FirefoxDriver();
        myDriver2.get("https://www.amazon.com/");
        System.out.println("title = " + myDriver2.getTitle());
    }
}

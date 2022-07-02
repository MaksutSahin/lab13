package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class WebDriverUtil {
    //create  a util that takes browser type and create connection between browser and selenium

    public static WebDriver getDriver(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            //chrome browser needs to be set up
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions ();
            options.addExtensions (new File("4.46.2_0.crx"));
            return new ChromeDriver(options);
        }else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else {
            System.out.println("Browser is not exist!!!!");
            System.out.println("Check the browser name");
            System.out.println("browser="+browser);
            return null;
        }

    }

}

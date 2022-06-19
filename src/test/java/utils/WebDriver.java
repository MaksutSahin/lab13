package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriver {
        //create  a util that takes browser type and create connection between browser and selenium

        public static org.openqa.selenium.WebDriver getDriver(String browser){
            if(browser.equalsIgnoreCase("chrome")){
                //chrome browser needs to be set up
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
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

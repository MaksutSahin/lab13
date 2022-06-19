package students.Maksut;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class lab02 {//TC #1: Facebook title verification
//Task - 1
//Open Chrome Browser
//Go to https://www.facebook.com
//Verify title: Expected: "Facebook - Log In or Sign Up"
//Task - 2
//Open Chrome Browser
//Go to google
//Navigate back
//Navigate forward
//Navigate to https://www.amazon.com
//Verify title contains : Smile

    //Second Task:
    // Go to https://www.etsy.com/
    // Maximize window
    // Verify title doesn't contain "Smile"
    // Verify Current Url
    // Go to https://www.amazon.com/
    // Verify title
    // Verify Current Url
    // Navigate Back
    // Refresh
    // Quit browser
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver myDriver = new ChromeDriver();
        Thread.sleep(1800);
        myDriver.get("https://www.facebook.com");
        Thread.sleep(1800);
        String expectedTitleWord = "Facebook - Log In or Sign Up";
        String actualTitle = myDriver.getTitle();
        if (actualTitle.equalsIgnoreCase(expectedTitleWord)) {
            System.out.println("-Facebook title is \"Facebook - Log In or Sign Up\" and title verification has passed");
        } else {
            System.out.println("-Facebook title is not \"Facebook - Log In or Sign Up\" and title verification has failed");
        }
        System.out.println("♦Actual title = " + actualTitle);
        myDriver.close();

        WebDriver myDriver2 = new ChromeDriver();
        myDriver2.get("https://www.google.com");
        Thread.sleep(1800);
        myDriver2.navigate().back();
        Thread.sleep(1800);
        myDriver2.navigate().forward();
        Thread.sleep(1800);
        myDriver2.navigate().to("https://www.amazon.com");
        Thread.sleep(1800);
        String expectedTitleWord2 = "Smile";
        String actualTitle2 = myDriver2.getTitle();
        if (actualTitle2.contains(expectedTitleWord2)) {
            System.out.println("-Amazon title contains Smile and title verification has passed");
        } else {
            System.out.println("-Amazon title does not contains Smile and title verification has failed");
        }
        System.out.println("♦Actual title = " + actualTitle2);
        Thread.sleep(1800);
        myDriver2.close();

        WebDriver myDriver3 = new ChromeDriver();
        myDriver3.get("https://www.etsy.com");
        myDriver3.manage().window().maximize();
        String expectedTitleWord3 = "Smile";
        String actualTitle3 = myDriver3.getTitle();
        if (actualTitle3.contains(expectedTitleWord3)) {
            System.out.println("-Etsy title contains " + expectedTitleWord3 + " and title verification has passed");
        } else {
            System.out.println("-Etsy title does not contain " + expectedTitleWord3 + " and title verification has failed");
        }
        System.out.println("♦Actual title = " + actualTitle3);
        Thread.sleep(1800);
        System.out.println("►►►►►☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼☼◄◄◄◄◄");
        myDriver3.get("https://www.amazon.com");
        System.out.println("♦Title = " + myDriver3.getTitle());
        System.out.println("♦Current URL = " + myDriver3.getCurrentUrl());
        Thread.sleep(1800);
        myDriver3.navigate().back();
        Thread.sleep(1800);
        myDriver3.navigate().refresh();
        Thread.sleep(1800);
        myDriver3.quit();
    }
}

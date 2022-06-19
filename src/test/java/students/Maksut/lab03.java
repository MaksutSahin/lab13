package students.Maksut;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class lab03 {
    //TASK: Google search
//1- Open a chrome browser
//2- Go to: https://google.com
//3- Write "apple" in search box
//4- Click google search button
//5- Verify title:
//Expected: Title should start with "apple" word
//6-navigate back
//7-write cherry in search box
//8-verify title contains cherry.

//TASK2: Google Feeling lucky button
//1- Open a chrome browser
//2- Go to: https://google.com
//3- Write "apple" in search box
//click i am feeling lucky button
//Verify title contains Apple

    //go to https://opensource-demo.orangehrmlive.com/
//locate user name and send user name, (username=Admin)
//locate user password and send password (password=admin123)
//click on the login button
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver drv = new ChromeDriver();
        drv.get("https://google.com");
        Thread.sleep(1800);
        drv.findElement(By.name("q")).sendKeys("apple");
        Thread.sleep(1800);
        drv.findElement(By.name("btnK")).click();
        Thread.sleep(1800);
        String preExpectedTitle = "apple";
        String actualTitle = drv.getTitle();
        if (actualTitle.startsWith(preExpectedTitle)) {
            System.out.println("-Title is started with " +preExpectedTitle+" and title verification has passed.");}
        else {
            System.out.println("-Title is not started with "+preExpectedTitle+" and title verification has failed");}
        drv.navigate().back();
        drv.findElement(By.name("q")).sendKeys("cherry");
        drv.findElement(By.name("q")).sendKeys(Keys.ENTER);
        String containExpectedTitle = "cherry";
        String actualTitle2 = drv.getTitle();
        if (actualTitle2.contains(containExpectedTitle)) {
            System.out.println("-Title contains " +containExpectedTitle+" and title verification has passed.");}
        else {
            System.out.println("-Title does not contain "+containExpectedTitle+" and title verification has failed");}
        drv.close();

        System.out.println("\n\n");


        WebDriver drv2 = new ChromeDriver();
        drv2.get("https://google.com");
        Thread.sleep(1800);
        drv2.findElement(By.name("q")).sendKeys("apple");
        Thread.sleep(1800);
        drv2.findElement(By.name("btnI")).click();
        Thread.sleep(1800);
        String containExpectedTitle2 = "Apple";
        String actualTitle3 = drv2.getTitle();
        if (actualTitle3.startsWith(containExpectedTitle2)) {
            System.out.println("-Title is started with " +containExpectedTitle2+" and title verification has passed.");}
        else {
            System.out.println("-Title is not started with "+containExpectedTitle2+" and title verification has failed");}
        drv2.close();

        System.out.println("\n\n");

        WebDriver drv3 = new ChromeDriver();
        drv3.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(1800);
        drv3.findElement(By.id("txtUsername")).sendKeys("Admin");
        drv3.findElement(By.id("txtPassword")).sendKeys("admin123");
        drv3.findElement(By.id("btnLogin")).click();
        Thread.sleep(1800);
        drv3.close();
    }
}

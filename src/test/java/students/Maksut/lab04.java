package students.Maksut;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
// 1. Open Chrome browser
// 2. Go to https://demo.guru99.com/test/radio.html
// 3. Verify all checkboxes are not selected (you can use findelements to store in list and use for loop to validate)
// 4. Click to checkbox3
// 5. Verify checkbox3 is selected
public class lab04 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver drv1=new ChromeDriver();
        drv1.get("https://demo.guru99.com/test/radio.html");
        List<WebElement> checkboxes=drv1.findElements(By.xpath("//input[@type='checkbox']"));
        Thread.sleep(1750);
        System.out.println("Testing if all checkboxes are non-selected:");
        for(WebElement each:checkboxes){
            if(each.isSelected()){
                System.out.println("•FAILED• "+each+" is selected.");}
            else {
                System.out.println("•PASSED• "+each+" is not selected.");}}
        WebElement checkbox3=drv1.findElement(By.id("vfb-6-2"));
        checkbox3.click();
        Thread.sleep(1750);
        System.out.println("Testing if checkbox3 is selected:");
        if (checkbox3.isSelected()){
            System.out.println("•PASSED• "+checkbox3+" is selected.");}
        else {
            System.out.println("•FAILED• "+checkbox3+" is not selected.");}
        System.out.println("♪♪♪♫♫♪♪♫♪♪♪♫♫♪♪♪♫♫♪♪♪♫♫♪♫♪♪♫♪♫♪♫♪♫♪♪♫");
    }
}

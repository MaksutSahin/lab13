package students.Maksut.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.PropertiesReadingUtil;

public class lab13_Login extends POM_Design_Base {
    @FindBy(how= How.XPATH,using = "/html/body/form/table/tbody/tr[1]/td[2]/input")
    @CacheLookup
    public WebElement usernameBox;

    @FindBy(how= How.XPATH,using ="/html/body/form/table/tbody/tr[2]/td[2]/input")
    @CacheLookup
    public WebElement passwordBox;

    @FindBy(how= How.XPATH,using ="/html/body/form/table/tbody/tr[3]/td[2]/input[1]")
    @CacheLookup
    public WebElement loginButton;

    @FindBy(how= How.XPATH,using ="/html/body/div[2]/h2")
    @CacheLookup
    public WebElement Guru99BankText;

    public lab13_Login(WebDriver a) {
        super(a);
    }


    public void loginGuru(WebDriver a,String username, String password){
        usernameBox.click();
        usernameBox.sendKeys(PropertiesReadingUtil.getProperties("username"));
        passwordBox.click();
        passwordBox.sendKeys(PropertiesReadingUtil.getProperties("password"));
        ((JavascriptExecutor) a).executeScript("arguments[0].click();", loginButton);
    }

    public boolean checkGuru99BankText(){
        return this.Guru99BankText.isDisplayed();
    }
}

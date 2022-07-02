package students.Maksut.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class lab13_NewCustomerEntry extends POM_Design_Base {
    @FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
    @CacheLookup
    public WebElement newCustomerEntField;
    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")
    @CacheLookup
    public WebElement nameField;
    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
    @CacheLookup
    public WebElement genderRadioButtonForFemale;//I'm not going to create another radio button for male since it is default.
    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input")
    @CacheLookup
    public WebElement birthdayField;
    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")
    @CacheLookup
    public WebElement addressField;
    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")
    @CacheLookup
    public WebElement cityField;
    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input")
    @CacheLookup
    public WebElement provinceField;
    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[10]/td[2]/input")
    @CacheLookup
    public WebElement PINField;
    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input")
    @CacheLookup
    public WebElement phoneField;
    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[12]/td[2]/input")
    @CacheLookup
    public WebElement emailField;
    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input")
    @CacheLookup
    public WebElement passwordField;
    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]")
    @CacheLookup
    public WebElement submitButton;
    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[1]/td")
    @CacheLookup
    public WebElement newCustomerAddedText;

    public lab13_NewCustomerEntry(WebDriver a) {
        super(a);
    }


    public void setFields(String name, String gender, short year, byte month, byte day, String streetNumberAndName, String city, String province, int PIN, long phone, String email, String password) {
        nameField.sendKeys(name);
        if (gender.startsWith("f") || gender.startsWith("F")) {
            genderRadioButtonForFemale.click();
        }
        birthdayField.sendKeys("" + year + Keys.TAB + "" + month + "" + day);
        addressField.sendKeys(streetNumberAndName);
        cityField.sendKeys(city);
        provinceField.sendKeys(province);
        PINField.sendKeys("" + PIN);
        phoneField.sendKeys("+" + phone);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public boolean checkNewCustomer() {
        return this.newCustomerAddedText.isDisplayed();
    }
}

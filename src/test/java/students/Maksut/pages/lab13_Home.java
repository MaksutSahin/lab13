package students.Maksut.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class lab13_Home extends POM_Design_Base {
    @FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")
    @CacheLookup
    public WebElement MangerIdText;

    public lab13_Home(WebDriver a) {
        super(a);
    }

    public String getMangerId(){
        return MangerIdText.getText();
    }
}

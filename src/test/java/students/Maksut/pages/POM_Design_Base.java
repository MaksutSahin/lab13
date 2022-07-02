package students.Maksut.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class POM_Design_Base {
    public POM_Design_Base(WebDriver a) {
        PageFactory.initElements(a, this);
    }
}

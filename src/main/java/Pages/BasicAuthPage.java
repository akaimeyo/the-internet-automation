package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicAuthPage extends BasePage{

    @FindBy(xpath = "//div/p")
    WebElement basicConfirmation;

    public BasicAuthPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean confirmBasicPassed() {
        try {
            return basicConfirmation.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Access not granted");
            return false;
        }
    }


}

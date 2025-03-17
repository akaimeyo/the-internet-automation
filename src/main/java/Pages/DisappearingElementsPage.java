package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class DisappearingElementsPage extends BasePage {

    @FindBy(xpath = "//ul/li")
    List<WebElement> buttons;

    public DisappearingElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean checkButtonsListLength() {

        int expectedLength = 5;
        PageFactory.initElements(driver, this);
        System.out.println("Buttons amount: " + buttons.size());
        return buttons.size() == expectedLength;
    }
}

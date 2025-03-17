package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class AddRemoveElementsPage extends BasePage {

    @FindBy(xpath = "//button[text()='Add Element']")
    public WebElement addButton;

    @FindBy(className = "added-manually")
    public List<WebElement> deleteButtons;

    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickAddElement() {
        addButton.click();
    }

    public boolean isDeleteButtonDisplayed() {
        return !deleteButtons.isEmpty();
    }

    public void clickRemoveElement() {
        if (isDeleteButtonDisplayed()) {
            deleteButtons.getFirst().click();
        }
    }
}

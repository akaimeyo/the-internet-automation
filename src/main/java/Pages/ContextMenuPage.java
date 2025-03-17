package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage extends BasePage {

    @FindBy(id = "hot-spot")
    WebElement hotSpot;

    @FindBy(id = "page-footer")
    WebElement footer;

    Actions actions = new Actions(driver);

    public ContextMenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean rightClickOnHotSpot() {
        actions.contextClick(hotSpot).build().perform();
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
            return true;
        } catch (NoAlertPresentException e) {
            System.out.println("No Alert present");
        }
        ((RemoteWebDriver) driver).resetInputState();
        return false;
    }

    public void leftClickOnHotSpot() {
        hotSpot.click();
    }

    public void rightClickOutOfHotSpot() {
        actions.contextClick(footer).build().perform();
        ((RemoteWebDriver) driver).resetInputState();
    }

    public void dismissContextMenu() {
        hotSpot.click();
    }

}

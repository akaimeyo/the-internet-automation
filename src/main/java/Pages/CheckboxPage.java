package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckboxPage extends BasePage {

    @FindBy(xpath = "//div[@class='example']//input")
    List<WebElement> checkboxes;

    public CheckboxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setCheckboxesTrue() {

        for (WebElement checkbox : checkboxes) {
            String attrValue = checkbox.getDomAttribute("checked");
            if (attrValue == null)
                checkbox.click();
        }
    }

    public boolean verifyChecked() {
        for (WebElement checkbox : checkboxes) {
            if (checkbox.getDomAttribute("checked") == null) {
                return false;
            }
        }
        return true;
    }

    public void setCheckboxFalse() {
        for (WebElement checkbox : checkboxes) {
            String attrValue = checkbox.getDomAttribute("checked");
            if (attrValue != null)
                checkbox.click();
        }
    }

    public boolean verifyNotChecked() {
        for (WebElement checkbox : checkboxes) {
            if (checkbox.getDomAttribute("checked") != null) {
                return false;
            }
        }
        return true;
    }
}

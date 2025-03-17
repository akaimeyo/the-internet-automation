package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DropdownPage extends BasePage {

    @FindBy(id = "dropdown")
    WebElement dropdownPicker;

    List<WebElement> dropdownOptions = null;

    List<WebElement> getDropdownOptions() {
        if (dropdownOptions == null)
            dropdownOptions = dropdownPicker.findElements(By.tagName("option"));

        return dropdownOptions;
    }

    public DropdownPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openDropdownList() {
        dropdownPicker.click();
    }

    public void selectOption(int option) {
        if (option < getDropdownOptions().size()) {
            getDropdownOptions().get(option).click();
        } else
            throw new IllegalArgumentException("Selected option: " + option + ", array size: " + getDropdownOptions().size());
    }

    public boolean checkSelection(int expected) {
        try {
            return getDropdownOptions().get(expected).isSelected();
        } catch (NullPointerException e) {
            System.out.println("Element not selected");
            return false;
        }
    }

    public void clickDisabledElement() {
        dropdownPicker.findElement(By.xpath("./option[@disabled]")).click();
        dropdownPicker.click();
    }

    public boolean disabledNotSelected() {
        return dropdownPicker.getText().contains("Please select an option");
    }

}

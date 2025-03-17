package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//TODO design way to check if image load was successful
public class BrokenImagesPage extends BasePage{

    @FindBy(xpath = "//div[@class='example']/img")
    List<WebElement> images;

    public BrokenImagesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void dummyname() {

    }
}

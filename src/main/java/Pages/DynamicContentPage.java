package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DynamicContentPage extends BasePage {

    @FindBy(xpath = "//div[@class='example']/div[@class='row']/div[@id='content']")
    WebElement pageContent;

    List<WebElement> textFields = null;

    List<WebElement> profilePictures = null;

    List<String> initialTexts = new ArrayList<>();
    List<String> reloadTexts = new ArrayList<>();

    List<String> initialImageLinks = new ArrayList<>();

    List<String> reloadImageLinks = new ArrayList<>();
    public DynamicContentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<String> getInitialImageLinks() {
        return initialImageLinks;
    }

    public List<String> getReloadImageLinks() {
        return reloadImageLinks;
    }

    public List<String> getInitialTexts() {
        return initialTexts;
    }

    public List<String> getReloadTexts() {
        return reloadTexts;
    }

    List<WebElement> getTextFields() {
        if (textFields == null)
            textFields = pageContent.findElements(By.xpath(".//div[@class='large-10 columns']"));

        return textFields;
    }

    List<WebElement> getProfilePictures() {
        if (profilePictures == null)
            profilePictures = pageContent.findElements(By.xpath(".//img"));

        return profilePictures;
    }

    public void getTextsBeforeReload() {
        for (WebElement element : getTextFields())
            initialTexts.add(element.getText());
    }

    public void getTextsAfterReload() {
        textFields = null;
        for (WebElement element : getTextFields())
            reloadTexts.add(element.getText());
    }

    public boolean compare(List<String> before, List<String> after) {
        return before.containsAll(after);
    }

    public void getImagesBeforeReload() {
        for (WebElement element : getProfilePictures())
            initialImageLinks.add(Objects.requireNonNull(element.getDomAttribute("src")).stripTrailing());
    }

    public void getImagesAfterReload() {
        profilePictures = null;
        for (WebElement element : getProfilePictures())
            reloadImageLinks.add(Objects.requireNonNull(element.getDomAttribute("src")).stripTrailing());
    }
}

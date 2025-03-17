package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.URI;
import java.util.Base64;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='content']//a[@href='/add_remove_elements/']")
    WebElement addRemoveElements;

    @FindBy(xpath = "//div[@id='content']//a[@href='/basic_auth']")
    WebElement basicAuth;

    @FindBy(xpath = "//div[@id='content']//a[@href='/broken_images']")
    WebElement brokenImages;

    @FindBy(xpath = "//div[@id='content']//a[@href='/checkboxes']")
    WebElement checkboxes;

    @FindBy(xpath = "//div[@id='content']//a[@href='/context_menu']")
    WebElement contextMenu;

    @FindBy(xpath = "//div[@id='content']//a[@href='/disappearing_elements']")
    WebElement disappearingElements;

    @FindBy(xpath = "//div[@id='content']//a[@href='/drag_and_drop']")
    WebElement dragAndDrop;

    @FindBy(xpath = "//div[@id='content']//a[@href='/dropdown']")
    WebElement dropdown;

    @FindBy(xpath = "//div[@id='content']//a[@href='/dynamic_content']")
    WebElement dynamicContent;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getAddRemoveElements() {
        return addRemoveElements;
    }

    public WebElement getBasicAuth() {
        return basicAuth;
    }

    public WebElement getBrokenImages() {
        return brokenImages;
    }

    public WebElement getCheckboxes() {
        return checkboxes;
    }

    public WebElement getContextMenu() {
        return contextMenu;
    }

    public WebElement getDisappearingElements() {
        return disappearingElements;
    }

    public WebElement getDragAndDrop() {
        return dragAndDrop;
    }

    public WebElement getDropdown() {
        return dropdown;
    }

    public WebElement getDynamicContent() {
        return dynamicContent;
    }

    public void open(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    public void manageBasicAuth() {
        if (isAlertPresent() && driver instanceof FirefoxDriver) {
            driver.switchTo().alert().dismiss();
            driver.navigate().back();
            driver.manage().addCookie(new Cookie("Authorization", "Basic " + cookieValue()));
            driver.navigate().refresh();
            open(basicAuth);
        } else if (isAlertPresent() && driver instanceof ChromeDriver) {
            Predicate<URI> uriPredicate = uri -> uri.toString().contains("herokuapp.com");
            Supplier<Credentials> authentication = UsernameAndPassword.of(Statics.BASIC_LOGIN, Statics.BASIC_PASSWORD);
            ((HasAuthentication) driver).register(uriPredicate, authentication);
        }
    }

    public String cookieValue() {
        String credentials = Statics.BASIC_LOGIN + ":" + Statics.BASIC_PASSWORD;
        return Base64.getEncoder().encodeToString(credentials.getBytes());
    }

    public void dismissBasicAuth() {
        driver.switchTo().alert().dismiss();
    }

}

package Pages;

import etc.ConfigFactory;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected ConfigFactory config = new ConfigFactory();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForElementToBeClickable(org.openqa.selenium.WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            System.out.println("No Alert present");
            return false;
        }
    }

    public void dismissPopup() {
        if (isAlertPresent()) driver.switchTo().alert().dismiss();
    }

    public void reloadPage() {
        driver.navigate().refresh();
    }
}

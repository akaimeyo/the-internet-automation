import etc.ConfigFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterTest;

import java.time.Duration;


public class BaseTest {

    protected static WebDriver driver;

    protected ConfigFactory config = new ConfigFactory();

    @AfterTest
    public void teardownTest() {
        driver.quit();
    }

    public void open(String url) {
        try {
            driver.get(url);
        } catch (TimeoutException e) {
            driver.quit();
            throw new TimeoutException(e);
        }
    }

    public void setupDriver() {

        FirefoxOptions options = new FirefoxOptions();
        options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        WebDriverManager.firefoxdriver().capabilities(options).setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    public void ensureOnHomePage() {
        String regex = "https:\\/\\/the-internet\\.herokuapp\\.com\\/(.*)";

        if (driver.getCurrentUrl().matches(regex))
            driver.navigate().back();
    }

    public void reload() {
        driver.navigate().refresh();
    }

}

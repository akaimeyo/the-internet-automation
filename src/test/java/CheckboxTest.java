import Pages.CheckboxPage;
import Pages.HomePage;
import etc.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {

    HomePage homePage;
    CheckboxPage checkboxPage;
    ConfigFactory config = new ConfigFactory();

    @BeforeClass
    public void setUpTest() {
        setupDriver();

        homePage = new HomePage(driver);
        checkboxPage = new CheckboxPage(driver);

        open(config.loadProperty("url"));
        homePage.open(homePage.getCheckboxes());
    }

    @Test
    public void checkboxesTrue() {
        checkboxPage.setCheckboxesTrue();
        Assert.assertTrue(checkboxPage.verifyChecked());
    }

    @Test
    public void checkboxesFalse() {
        checkboxPage.setCheckboxFalse();
        Assert.assertTrue(checkboxPage.verifyNotChecked());
    }
}

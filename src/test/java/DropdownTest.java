import Pages.DropdownPage;
import Pages.HomePage;
import etc.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {

    HomePage homePage;
    DropdownPage dropdownPage;
    ConfigFactory config = new ConfigFactory();

    @BeforeClass
    public void setupTest() {
        setupDriver();

        homePage = new HomePage(driver);
        dropdownPage = new DropdownPage(driver);

        open(config.loadProperty("url"));
        homePage.open(homePage.getDropdown());
    }

    @Test
    public void selectOption() {
        dropdownPage.openDropdownList();
        dropdownPage.selectOption(1);
        Assert.assertTrue(dropdownPage.checkSelection(1));
    }

    @Test
    public void changeSelection() {
        dropdownPage.openDropdownList();
        dropdownPage.selectOption(2);
        Assert.assertTrue(dropdownPage.checkSelection(2));
    }

    @Test
    public void attemptSelectDisabled() {
        dropdownPage.openDropdownList();
        dropdownPage.clickDisabledElement();
        Assert.assertTrue(dropdownPage.disabledNotSelected());
    }
}

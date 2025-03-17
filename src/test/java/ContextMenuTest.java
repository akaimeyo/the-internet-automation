import Pages.ContextMenuPage;
import Pages.HomePage;
import etc.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    HomePage homePage;
    ContextMenuPage contextMenuPage;
    ConfigFactory config = new ConfigFactory();

    @BeforeClass
    public void setUpTest() {

        setupDriver();

        homePage = new HomePage(driver);
        contextMenuPage = new ContextMenuPage(driver);

        open(config.loadProperty("url"));
        homePage.open(homePage.getContextMenu());
    }

    @Test
    public void rightClickOutOfHotSpot() {
        contextMenuPage.rightClickOutOfHotSpot();
        Assert.assertFalse(contextMenuPage.isAlertPresent());
        contextMenuPage.dismissPopup();
        contextMenuPage.dismissContextMenu();
    }

    @Test
    public void rightClickInHotSpot() {
        contextMenuPage.rightClickOnHotSpot();
        Assert.assertTrue(contextMenuPage.rightClickOnHotSpot());
        contextMenuPage.dismissPopup();
        contextMenuPage.dismissContextMenu();
    }

    @Test
    public void leftClickInHotSpot() {
        contextMenuPage.leftClickOnHotSpot();
        Assert.assertFalse(contextMenuPage.isAlertPresent());
        contextMenuPage.dismissPopup();
    }
}

import Pages.DisappearingElementsPage;
import Pages.HomePage;
import etc.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DisappearingElementsTest extends BaseTest {

    HomePage homePage;
    DisappearingElementsPage disappearingElementsPage;
    ConfigFactory config = new ConfigFactory();

    @BeforeClass
    public void setupTest() {
        setupDriver();

        homePage = new HomePage(driver);
        disappearingElementsPage = new DisappearingElementsPage(driver);

        open(config.loadProperty("url"));
        homePage.open(homePage.getDisappearingElements());
    }

    @Test
    public void checkCorrectAmountOfElements() {
        Assert.assertTrue(disappearingElementsPage.checkButtonsListLength());
    }

    @Test
    public void checkAmountAfterReload() {
        disappearingElementsPage.reloadPage();
        Assert.assertTrue(disappearingElementsPage.checkButtonsListLength());
    }
}

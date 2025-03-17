import Pages.AddRemoveElementsPage;
import Pages.HomePage;
import etc.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddRemoveElementsTest extends BaseTest {

    HomePage homePage;
    AddRemoveElementsPage addRemoveElementsPage;
    ConfigFactory config = new ConfigFactory();

    @BeforeClass
    public void setupTest() {
        setupDriver();

        homePage = new HomePage(driver);
        addRemoveElementsPage = new AddRemoveElementsPage(driver);

        open(config.loadProperty("url"));
    }

    @Test
    public void addElement() {
        homePage.open(homePage.getAddRemoveElements());
        addRemoveElementsPage.clickAddElement();
        Assert.assertTrue(addRemoveElementsPage.isDeleteButtonDisplayed());
    }

    @Test
    public void removeElement() {
        addRemoveElementsPage.clickRemoveElement();
        Assert.assertFalse(addRemoveElementsPage.isDeleteButtonDisplayed());
    }
}

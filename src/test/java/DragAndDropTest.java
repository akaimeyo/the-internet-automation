import Pages.DragAndDropPage;
import Pages.HomePage;
import etc.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {

    public HomePage homePage;
    public DragAndDropPage dragAndDropPage;
    ConfigFactory config = new ConfigFactory();

    @BeforeClass
    public void setupTest() {
        setupDriver();

        homePage = new HomePage(driver);
        dragAndDropPage = new DragAndDropPage(driver);

        open(config.loadProperty("url"));
        homePage.open(homePage.getDragAndDrop());
    }

    @Test
    public void dragAoverB() {
        dragAndDropPage.dragColumns("a", "b");
        Assert.assertEquals(dragAndDropPage.checkOrderOfColumns(), "desc");
    }

    @Test
    public void dragBoverA() {
        dragAndDropPage.dragColumns("b", "a");
        Assert.assertEquals(dragAndDropPage.checkOrderOfColumns(), "asc");
    }
}

import Pages.BrokenImagesPage;
import Pages.HomePage;
import etc.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrokenImagesTest extends BaseTest {
    HomePage homePage;
    BrokenImagesPage brokenImagesPage;
    ConfigFactory config = new ConfigFactory();

    @BeforeClass
    private void setUpTest() {

        homePage = new HomePage(driver);
        brokenImagesPage = new BrokenImagesPage(driver);
        open(config.loadProperty("url"));
        homePage.open(homePage.getBrokenImages());

    }

    @Test
    public void imageLoadPass() {
    }
}

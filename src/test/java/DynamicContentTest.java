import Pages.DynamicContentPage;
import Pages.HomePage;
import etc.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicContentTest extends BaseTest {

    HomePage homePage;

    DynamicContentPage dynamicContentPage;

    ConfigFactory config = new ConfigFactory();

    @BeforeClass
    public void setupTest() {
        setupDriver();

        homePage = new HomePage(driver);
        dynamicContentPage = new DynamicContentPage(driver);

        driver.get(config.loadProperty("url"));
        homePage.open(homePage.getDynamicContent());

    }

    @Test
    public void checkIfContentChangesOnReload() {
        dynamicContentPage.getTextsBeforeReload();
        reload();
        dynamicContentPage.getTextsAfterReload();
        Assert.assertFalse(dynamicContentPage.compare(dynamicContentPage.getInitialTexts(), dynamicContentPage.getReloadTexts()));
    }

    @Test
    public void checkIfImagesChangeOnReload() {
        dynamicContentPage.getImagesBeforeReload();
        reload();
        dynamicContentPage.getImagesAfterReload();
        Assert.assertFalse(dynamicContentPage.compare(dynamicContentPage.getInitialImageLinks(), dynamicContentPage.getReloadImageLinks()));
    }
}

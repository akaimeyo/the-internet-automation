import Pages.BasicAuthPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest {

    HomePage homePage;
    BasicAuthPage basicAuthPage;

    @BeforeClass
    public void setupTest() {
        setupDriver();

        homePage = new HomePage(driver);
        basicAuthPage = new BasicAuthPage(driver);

        driver.get(config.loadProperty("url"));
    }

    @Test
    public void basicAuthPositiveTest() {
        ensureOnHomePage();
        driver.manage().deleteAllCookies();
        homePage.open(homePage.getBasicAuth());
        homePage.manageBasicAuth();
        Assert.assertTrue(basicAuthPage.confirmBasicPassed());
    }

    @Test
    public void basicAuthNegativeTest() {
        ensureOnHomePage();
        driver.manage().deleteAllCookies();
        homePage.open(homePage.getBasicAuth());
        homePage.dismissBasicAuth();
        Assert.assertFalse(basicAuthPage.confirmBasicPassed());
    }

}

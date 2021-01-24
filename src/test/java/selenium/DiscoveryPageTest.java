package selenium;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import pages.DiscoveryPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class DiscoveryPageTest {

    public static DiscoveryPage discoveryPage;

    @BeforeClass
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://discover.trivago.co.uk/";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        discoveryPage = new DiscoveryPage();
        open(Configuration.baseUrl, DiscoveryPage.class);
    }

    @AfterClass
    public static void close() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        clearBrowserCache();
        closeWebDriver();
    }


    /**
     * e2e test when user searching a location in his city for 2 days
     */

    @Test
    public void selectLocationWithinCity() {
        discoveryPage.acceptCookies();
        discoveryPage.clickOnRadiusField();
        discoveryPage.selectRadius("None");
        discoveryPage.selectViewDealButton();
    }

    /**
     * e2e test when user searching a location on distance 100 miles from his city for 2 days stay
     */

    @Test
    public void selectAnotherDistance() {
        discoveryPage.acceptCookies();
        discoveryPage.clickOnRadiusField();
        discoveryPage.selectRadius("100 miles");
        discoveryPage.selectViewDealButton();
    }

    /**
     * test in process
     * e2e test when user choose another city for 2 days stay
     */

    @Test(groups = {"debug"})
    public void selectAnotherCity(){
        discoveryPage.acceptCookies();
        discoveryPage.clearLocationField();
        discoveryPage.setValueLocationField("London");
        discoveryPage.selectRadius("None");
        discoveryPage.selectViewDealButton();
    }


}
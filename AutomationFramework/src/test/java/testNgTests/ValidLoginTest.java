package testNgTests;

import lib.base.BaseTest;
import lib.util.Configuration;
import lib.util.SeleniumActions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class ValidLoginTest extends BaseTest {
    HomePage homePage;
    Configuration config;
    LoginPage loginPage;

    public ValidLoginTest() {
        super();
    }

    @BeforeMethod()
    public void setUp() {
        homePage = new HomePage(getDriver());
        config = new Configuration();
        loginPage = new LoginPage(getDriver());
    }

    @Test(priority = 0)
    public void ValidsignIn() {
        SeleniumActions.get(config.getProperty("URL"),getDriver());
        homePage.clickOnLoginButton();
        loginPage.setEmailAddress(config.getProperty("Mail"));
        loginPage.setPassword(config.getProperty("Password"));
        loginPage.clickSignIn();
    }

}

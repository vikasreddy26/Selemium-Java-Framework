package stepDefinitions;

import io.cucumber.java.en.Given;
import lib.cucumberBase.CucumberBaseTest;
import lib.util.Configuration;
import lib.util.SeleniumActions;
import pages.HomePage;

public class HomePageSteps {
    CucumberBaseTest baseTest = new CucumberBaseTest();
    @Given("User is at the Home Page")
    public void user_is_at_the_home_page() {
        Configuration config = new Configuration();
        SeleniumActions.get(config.getProperty("URL"),baseTest.getDriver());
    }

    @Given("Navigate to LogIn Page")
    public void navigate_to_log_in_page() {
        HomePage homePage = new HomePage(baseTest.getDriver());
        homePage.clickOnLoginButton();
    }

}

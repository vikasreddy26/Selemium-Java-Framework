package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lib.cucumberBase.CucumberBaseTest;
import lib.util.Configuration;
import lib.util.SeleniumActions;
import org.testng.Assert;
import pages.LoginPage;

public class LoginPageSteps {

    CucumberBaseTest baseTest = new CucumberBaseTest();

    @When("User enter UserName and Password")
    public void user_enter_user_name_and_password() {
        LoginPage loginPage = new LoginPage(baseTest.getDriver());
        Configuration config = new Configuration();
        loginPage.setEmailAddress(config.getProperty("Mail"));
        loginPage.setPassword(config.getProperty("Password"));
    }

    @When("Click on the LogIn button")
    public void click_on_the_log_in_button() {
      LoginPage loginPage = new LoginPage(baseTest.getDriver());
      loginPage.clickSignIn();
    }

    @When("User enter invalid {string} and {string}")
    public void user_enter_invalid_and(String mail, String password) {
        LoginPage loginPage = new LoginPage(baseTest.getDriver());
        loginPage.setEmailAddress(mail);
        loginPage.setPassword(password);
    }
    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {
        LoginPage loginPage = new LoginPage(baseTest.getDriver());
        boolean isDisplayed = SeleniumActions.isDisplayed(loginPage.getAuthenticationErrorElement());
        Assert.assertEquals(isDisplayed,true);
    }



}

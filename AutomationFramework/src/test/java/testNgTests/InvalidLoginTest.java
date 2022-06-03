package testNgTests;

import lib.base.BaseTest;
import lib.util.Configuration;
import lib.util.ExcelReader;
import lib.util.SeleniumActions;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest{
    Logger log = Logger.getLogger(InvalidLoginTest.class);
    HomePage homePage;
    Configuration config;
    LoginPage loginPage;
    ExcelReader ex;
    public InvalidLoginTest() {
        super();
    }

    @BeforeMethod()
    public void setUp() {
        homePage = new HomePage(getDriver());
        config = new Configuration();
        loginPage = new LoginPage(getDriver());
        ex = new ExcelReader("src\\test\\resources\\Data\\TestData.xlsx");
    }
    @Test()
    public void test1(){
        SeleniumActions actions = new SeleniumActions();
        actions.get("https://www.google.com/", getDriver());
        WebElement element = SeleniumActions.findElement(getDriver(),"xpath","//input[@name = 'q']");
        SeleniumActions.sendKeys(element,"Iphone 14");
    }

    @Test(priority = 1,enabled = false)
    public void InvalidsignIn() {
        SeleniumActions.get(config.getProperty("URL"),getDriver());
        homePage.clickOnLoginButton();
        log.info("Performing Invalid Login Test");
        int rowCount = ex.getRowCount("Sheet1");
        for(int i =1;i<=rowCount;i++){
            loginPage.setEmailAddress(ExcelReader.getdata("src\\test\\resources\\Data\\TestData.xlsx", "Sheet1", i, 0));
            loginPage.setPassword(ExcelReader.getdata("src\\test\\resources\\Data\\TestData.xlsx", "Sheet1", i, 1));
            loginPage.clickSignIn();
            boolean isDisplayed = SeleniumActions.isDisplayed(loginPage.getAuthenticationErrorElement());
            Assert.assertEquals(isDisplayed,true);
        }
    }

}

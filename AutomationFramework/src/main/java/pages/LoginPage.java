package pages;

import lib.util.SeleniumActions;
import lib.util.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Waits {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email") private WebElement emailAddress;
    @FindBy(id = "passwd") private WebElement Password;
    @FindBy(xpath = "//button[@name ='SubmitLogin']") private WebElement signinButton;
    @FindBy(xpath = "//p[text() = 'There is 1 error']")private WebElement authenticationError;

    public void setEmailAddress(String mail) {
        SeleniumActions.javascriptExecutorScrollToElement(driver, emailAddress);
        waitForElementVisible(driver,emailAddress);
        SeleniumActions.sendKeys(emailAddress, mail);
    }

    public void setPassword(String password) {
        waitForElementVisible(driver,Password);
        SeleniumActions.sendKeys(Password, password);
    }

    public void clickSignIn() {
        waitForElementClickable(driver,signinButton);
        SeleniumActions.click(signinButton);
    }

    public WebElement getAuthenticationErrorElement(){
        waitForElementVisible(driver,authenticationError);
        return authenticationError;
    }

}

package pages;

import lib.util.SeleniumActions;
import lib.util.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Waits{

    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[contains(text(),'Sign in')]") private WebElement loginbtn;

    public void clickOnLoginButton(){
        waitForElementClickable(driver,loginbtn);
        SeleniumActions.click(loginbtn);
    }

}

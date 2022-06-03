package lib.factory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManagerAbstract {
    protected WebDriver driver;

    public abstract void setDriver();

    public void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver(){
        if(driver == null){
            setDriver();
        }
        return driver;
    }

}

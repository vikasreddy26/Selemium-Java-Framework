package lib.base;

import lib.factory.DriverManagerAbstract;
import lib.factory.DriverManagerFactory;
import lib.factory.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    private  ThreadLocal<DriverManagerAbstract> driverManagerAbstract = new ThreadLocal<DriverManagerAbstract>();
    public  static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private void setDriverManager(DriverManagerAbstract driverManager){
        this.driverManagerAbstract.set(driverManager);
    }
    protected DriverManagerAbstract getDriverManager(){
        return this.driverManagerAbstract.get();
    }

    @Parameters("browser")
    @BeforeTest
    public void setDriver(@Optional String browser){
        browser = System.getProperty("browser", browser);
        setDriverManager(DriverManagerFactory.getManager(DriverType.valueOf(browser)));
        driver.set(getDriverManager().getDriver());
        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " +
                "DRIVER = " + getDriver());
    }
    public WebDriver getDriver(){
        return driver.get();
    }

}

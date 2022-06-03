package lib.cucumberBase;

import io.cucumber.java.Before;
import lib.factory.DriverManagerAbstract;
import lib.factory.DriverManagerFactory;
import lib.factory.DriverType;
import lib.util.Configuration;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class CucumberBaseTest {
    private ThreadLocal<DriverManagerAbstract> driverManagerFactory = new ThreadLocal<DriverManagerAbstract>();
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected void setDriverManager(DriverManagerAbstract driverManager) {
        this.driverManagerFactory.set(driverManager);
    }

    protected DriverManagerAbstract getDriverManager() {
        return this.driverManagerFactory.get();
    }
    @Before
    @BeforeClass
    public static void setDriver() {
        Configuration config = new Configuration();
        String browser = config.getProperty("Browser");
        CucumberBaseTest cucumberBaseTest = new CucumberBaseTest();
        cucumberBaseTest.setDriverManager(DriverManagerFactory.getManager(DriverType.valueOf(browser)));
        driver.set(cucumberBaseTest.getDriverManager().getDriver());
        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " +
                "DRIVER = " +cucumberBaseTest.getDriver());
    }

    public WebDriver getDriver() {
        return driver.get();
    }

}

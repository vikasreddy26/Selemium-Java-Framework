package lib.factory;

public class DriverManagerFactory {

    public static DriverManagerAbstract getManager(DriverType driverType) {
        switch (driverType) {
            case CHROME:
              return  new MyChromeDriver();
            case FIREFOX:
              return new MyFirefoxDriver();
            case CHROMEWITHCAPABILITIES:
                return new MyChromeDriverWithCapabilities();
            default: throw new IllegalStateException("Unexpected value: " + driverType);
        }
    }
}
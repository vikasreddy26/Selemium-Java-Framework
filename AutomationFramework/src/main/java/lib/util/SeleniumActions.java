package lib.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SeleniumActions {

    public static void clearText(WebElement element) {
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }

    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public static void navigateTo(String URL, WebDriver driver) {
        driver.navigate().to(URL);
    }

    public static void get(String url, WebDriver driver) {
        driver.get(url);
    }

    public static void sendKeys(WebElement element, String value) {
        try {
            element.clear();
            element.sendKeys(value);
        } catch (ElementNotInteractableException e) {
            e.printStackTrace();
        }
    }

    public static void click(WebElement element) {
        try {
            element.click();
        } catch (ElementNotInteractableException e) {
            e.printStackTrace();
        }
    }

    public static WebElement findElement(WebDriver driver, String locatorType, String value) {
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            switch (locatorType) {
                case "id":
                    webElement = driver.findElement(By.id(value));
                    break;
                case "xpath":
                    webElement = driver.findElement(By.xpath(value));
                    break;
                case "className":
                    webElement = driver.findElement(By.className(value));
                    break;
                case "tagName":
                    webElement = driver.findElement(By.tagName(value));
                    break;
                case "linktext":
                    webElement = driver.findElement(By.linkText(value));
                    break;
                case "name":
                    webElement = driver.findElement(By.name(value));
                    break;
            }
            return webElement;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void moveToElement(WebDriver driver, WebElement element) {
        try {
            Actions act = new Actions(driver);
            Action mouseHover = act.moveToElement(element).build();
            mouseHover.perform();
        } catch (ElementNotInteractableException e) {
            e.printStackTrace();
        }
    }

    public static void dragAndDrop(WebDriver driver, WebElement dragElement, WebElement dropElement) {
        Actions action = new Actions(driver);
        action.dragAndDrop(dragElement, dropElement).build().perform();
    }

    public static List<WebElement> getAllSelectOptions(WebElement element) {
        Select sel = new Select(element);
        return sel.getOptions();
    }

    public static List<WebElement> findElements(WebDriver driver, String locatorType, String value) {
        List<WebElement> webElements = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            switch (locatorType) {
                case "id":
                    webElements = driver.findElements(By.id(value));
                    break;
                case "xpath":
                    webElements = driver.findElements(By.xpath(value));
                    break;
                case "className":
                    webElements = driver.findElements(By.className(value));
                    break;
                case "tagName":
                    webElements = driver.findElements(By.tagName(value));
                    break;
                case "linktext":
                    webElements = driver.findElements(By.linkText(value));
                    break;
                case "name":
                    webElements = driver.findElements(By.name(value));
                    break;
            }
            return webElements;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getSelectOptionsCount(WebElement element) {
        Select sel = new Select(element);
        System.out.println(sel.getOptions().size());
        return sel.getOptions().size();
    }

    public static String getFirstSelectedOption(WebElement element) {
        Select sel = new Select(element);
        sel.getOptions().size();
        return sel.getFirstSelectedOption().getText().trim();
    }

    public static void selectByVisibleText(WebElement element, String value) {
        Select sel = new Select(element);
        sel.selectByVisibleText(value);

    }

    public static void selectbyIndex(WebElement element, int index) {
        try {
            Select sel = new Select(element);
            sel.selectByIndex(index);
        } catch (ElementNotSelectableException e2) {
            e2.printStackTrace();
        }
    }

    public static void selectByValue(WebElement element, String value) {
        Select sel = new Select(element);
        sel.selectByValue(value);
    }

    public static boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public static void acceptAlert(WebDriver driver) {
        try {
            driver.switchTo().alert().accept();

        } catch (NoAlertPresentException Ex) {
        }
    }

    public static void dismissAlert(WebDriver driver) {
        try {
            driver.switchTo().alert().dismiss();

        } catch (NoAlertPresentException Ex) {
        }
    }

    public static void sendKeysToAlert(WebDriver driver, String value) {
        try {
            driver.switchTo().alert().sendKeys(value);

        } catch (NoAlertPresentException Ex) {
        }
    }

    public static String getTextOfAlert(WebDriver driver) {
        try {
            return driver.switchTo().alert().getText();

        } catch (NoAlertPresentException Ex) {
            return "NoAlertPresent";
        }
    }

    public static void javascriptExecutorScrollToElement(WebDriver driver, WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public static void javascriptExecutorSendKeys(WebDriver driver, WebElement webElement, String value) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')",
                    webElement);
        } catch (ElementNotInteractableException e) {
            e.printStackTrace();
        }
    }

    public static void javascriptExecutorClick(WebDriver driver, WebElement webElement) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", webElement);
        } catch (ElementNotInteractableException e) {
            e.printStackTrace();
        }
    }

    public static String getAttribute(WebDriver driver, WebElement element, String value) {
        String text = "";
        try {
            text = element.getAttribute(value);

        } catch (Exception e) {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                text = (String) js.executeScript("return arguments[0].getAttribute('" + value + "');", element);

            } catch (Exception e1) {
            }
        }
        return text;
    }

    public String getWindowHandle(WebDriver driver) {
        String windoHandle = driver.getWindowHandle();
        return windoHandle;
    }

    public Set<String> getWindowHandles(WebDriver driver) {
        Set<String> windoHandles = driver.getWindowHandles();
        return windoHandles;
    }

    public static String getText(WebElement element) {
        String text = element.getText();
        return text;
    }

    public static boolean isSelected(WebDriver driver, String loctorType, String value) {
        try {
            boolean isSelected;
            WebElement element = SeleniumActions.findElement(driver, loctorType, value);
            if (element != null) {
                isSelected = element.isSelected();
            } else {
                isSelected = false;
            }
            return isSelected;
        } catch (Exception e) {
            return false;
        }
    }

    public static void switchFrame(WebDriver driver, int index) {
        try {
            driver.switchTo().frame(index);
        } catch (NoSuchFrameException e) {
            System.out.println("frame with index: " + String.valueOf(index) + " is not available");
            e.printStackTrace();
        }
    }

    public static void switchFrameByElement(WebDriver driver, WebElement frameElement) {
        try {
            driver.switchTo().frame(frameElement);
        } catch (NoSuchFrameException e) {
            System.out.println("frame :" + frameElement.toString() + " is not available");
            e.printStackTrace();
        }
    }

    public static void switchFrameByName(WebDriver driver, String frameName) {
        try {
            driver.switchTo().frame(frameName);
        } catch (NoSuchFrameException e) {
            System.out.println("frame with title: " + frameName + " is not available");
            e.printStackTrace();
        }
    }

    public static void closeCurrentWindow(WebDriver driver) {

        driver.close();
    }

    public static String takeScreenShot(WebDriver driver, String screenshotname) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir") + "\\target\\screenshots\\" + screenshotname);
        String dest = destination.getAbsolutePath();
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dest;
    }

    public static boolean isDisplayed(WebElement element) {

        return element.isDisplayed();
    }

    public static boolean isEnabled(WebElement element) {

        return element.isEnabled();
    }

    public static List<String> findBrokenLinks(WebDriver driver) {
        List<String> brokenlinks = new ArrayList<String>();
        try {
            List<WebElement> links = driver.findElements(By.tagName("a"));
            for (WebElement element : links) {
                String url = element.getAttribute("href");
                URL link = new URL(url);
                HttpURLConnection http = (HttpURLConnection) link.openConnection();
                http.connect();
                int rescode = http.getResponseCode();
                if (rescode >= 400) {
                    brokenlinks.add(url);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brokenlinks;
    }

}
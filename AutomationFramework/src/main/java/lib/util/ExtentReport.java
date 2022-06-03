package lib.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lib.base.BaseTest;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ExtentReport {

    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;

    public ExtentReport() {

    }

    public void setExtent() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\target\\Reports\\report.html");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Functional Testing");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host name", "localhost");
        extent.setSystemInfo("Environemnt", "QA");
        extent.setSystemInfo("user", "vikas reddy");
    }

    public void createTest(String testName) {
        test = extent.createTest(testName);

    }

//    public void logbrokenLinks(String pagename) {
//        if (SeleniumActions.findBrokenLinks().size() > 0) {
//            for (String url : SeleniumActions.findBrokenLinks()) {
//                logFailStatus(url + "  :: is a broken link from  "+  pagename);
//            }
//        }
//    }

    public void createNode(String nodeName) {
        test.createNode(nodeName);

    }

    public void logFailStatus(String message) {
        test.log(Status.INFO, message);

    }

    public void logPassStatus(String message) {

        test.log(Status.PASS, message);
    }

    public void attachScreenshotToReport(String name)  {
        BaseTest baseTest = new BaseTest();
        WebDriver driver = baseTest.getDriver();
        String path =  SeleniumActions.takeScreenShot(driver,name);
        try {
            test.addScreenCaptureFromPath(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void endReport() {

        extent.flush();
    }

}

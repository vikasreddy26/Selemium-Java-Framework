package lib.util;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class EventListners implements ITestListener{

    Logger log = Logger.getLogger(EventListners.class);


    @Override
    public void onTestStart(ITestResult result) {

        log.info(result.getName() + " Method Started ");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(result.getName() + " Method PASSED ");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        log.info(result.getName() + " Method FAILED ");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        log.info(result.getName() + " Method SKIPPED ");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

}

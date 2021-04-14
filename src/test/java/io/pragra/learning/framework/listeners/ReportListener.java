package io.pragra.learning.framework.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.pragra.learning.framework.reports.HTMLReport;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportListener implements ITestListener {
    ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {
         extentTest= HTMLReport.createAndGetTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test " + result.getMethod() + "passed successfully");
        HTMLReport.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, "Test " + result.getMethod() + "failed");
        HTMLReport.flush();
    }
}

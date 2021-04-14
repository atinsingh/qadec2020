package io.pragra.learning.framework.testcases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.pragra.learning.framework.reports.HTMLReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DemoTest12 {

    @Test
    public void testName() {
        ExtentTest tc1 = HTMLReport.createAndGetTest("TC1");
        tc1.log(Status.INFO, "This is start of TC");
        tc1.warning("THis is not good");
        tc1.pass("password successfully");

    }

    @Test
    public void testName2() {
        ExtentTest tc1 = HTMLReport.createAndGetTest("TC2");
        tc1.log(Status.INFO, "This is start of TC");
        tc1.warning("THis is not good");
        tc1.fail("password successfully");

    }

    @AfterMethod
    public void tearDown() {
        HTMLReport.flush();
    }
}

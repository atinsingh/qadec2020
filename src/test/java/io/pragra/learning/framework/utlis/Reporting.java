package io.pragra.learning.framework.utlis;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.utils.FileUtil;
import io.pragra.learning.framework.config.Config;
import io.pragra.learning.framework.drivermanager.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.apache.commons.io.FileUtils.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting {
    WebDriver webDriver;
    public ExtentReports reports;
    public ExtentTest test;
    public ExtentHtmlReporter reporter;
    @BeforeTest
    public void setUp(){
        String timeStamp=new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
        String repoName= timeStamp+".html";
        reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Report/myreport"+repoName);
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Functional Report");
        reporter.config().setTheme(Theme.DARK);
        reports=new ExtentReports();
      reports.attachReporter(reporter);
      reports.setSystemInfo("HostName","LocalHost");
      reports.setSystemInfo("OS","MacOS");
      reports.setSystemInfo("Tester","Agila EThiraj");
      reports.setSystemInfo("Browser","Chrome");
    }


    @AfterMethod
    public void tearDown(ITestResult result1) throws IOException {
        if(result1.getStatus()==ITestResult.SUCCESS){
            test.log(Status.PASS,"Test case is passed");

        }
        else
            if(result1.getStatus()==ITestResult.FAILURE){
                test.log(Status.FAIL,"Test is failed" + result1.getName());
                String s = Reporting.captureScreenshot(webDriver, result1.getName());
                test.addScreenCaptureFromPath(s);

            }
            else if(result1.getStatus()==ITestResult.SKIP){
                test.log(Status.SKIP,"Test case has been skipped" + result1.getName());
            }
    }
    @AfterTest
    public void endReport(){
        reports.flush();
    }
    public static String captureScreenshot(WebDriver web, String ScreenshotName) throws IOException {
        String date=new SimpleDateFormat("yyyMMddhhmmss").format(new Date());
        TakesScreenshot webDriver1 = (TakesScreenshot) web;
        File screenshotAs = webDriver1.getScreenshotAs(OutputType.FILE);
     String destination= System.getProperty("user.dir")+"/Screenshots/Screenshot"+date+".png";
     File ff=new File(destination);
        FileUtils.copyFile(screenshotAs,ff);
        return destination;
    }
   /* @AfterClass
    public void tearDown(){
        webDriver.quit();
    }*/

}

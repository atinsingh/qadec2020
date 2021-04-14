package io.pragra.learning.framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.pragra.learning.framework.utlis.Utils;

public class HTMLReport {
    private static HTMLReport report;
    private ExtentReports extentReports;
    private ExtentTest test;

    private HTMLReport() {
        String file = Utils.getReportFileName();
        extentReports  = new ExtentReports();
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(file);
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Functional Report");
        reporter.config().setTheme(Theme.DARK);
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("HostName",System.getenv("HOSTNAME"));
        extentReports.setSystemInfo("OS","MacOS");
        extentReports.setSystemInfo("Tester","Agila EThiraj");
        extentReports.setSystemInfo("Browser","Chrome");
    }

    public synchronized static ExtentTest createAndGetTest(String testName) {
        if(report==null){
            report = new HTMLReport();
        }
        return report.extentReports.createTest(testName);
    }
    public static synchronized void flush() {
        if(report!=null){
            report.extentReports.flush();
        }
    }
}

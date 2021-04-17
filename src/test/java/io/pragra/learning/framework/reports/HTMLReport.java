package io.pragra.learning.framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.pragra.learning.framework.config.Config;
import io.pragra.learning.framework.utlis.Utils;

public class HTMLReport {
    private static HTMLReport report;
    private ExtentReports extentReports;
    private ExtentTest test;

    private HTMLReport() {
        String file = Utils.getReportFileName();
        extentReports  = new ExtentReports();
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(file);
        reporter.config().setDocumentTitle(Config.getProperty("document.title"));
        reporter.config().setReportName(Config.getProperty("report.name"));
        reporter.config().setTheme(Theme.DARK);
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("HostName",Config.getProperty("HostName"));
        extentReports.setSystemInfo("OS",Config.getProperty("OS"));
        extentReports.setSystemInfo("Tester",Config.getProperty("tester"));
        extentReports.setSystemInfo("browser", Config.getProperty("browser"));
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

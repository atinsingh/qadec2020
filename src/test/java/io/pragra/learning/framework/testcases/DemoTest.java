package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.config.Config;
import io.pragra.learning.framework.drivermanager.DriverManager;
import io.pragra.learning.framework.pages.RequestADemoPage;
import io.pragra.learning.framework.pages.TopNav;
import io.pragra.learning.framework.pages.meeting.ContactSales;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.logging.Logger;

public class DemoTest {
    static Logger log = Logger.getLogger("DemoTest.class");

    WebDriver driver;
    TopNav topNav;


    @BeforeSuite
    public void setUp() {
        DOMConfigurator.configure("/Users/agilaethiraj/IdeaProjects/qadec2020/src/log4j.xml");
        log.info("Setting up the driver");
        try {
            driver = DriverManager.getDriver();
            driver.get(((String) Config.getProperty("app.url")));
        } catch (NullPointerException e) {
            System.out.println("No such key specified in the properties");
            e.printStackTrace();
        }
    }

    @Test
    public void demoTest() {
        log.info("Executing first test case");


        topNav = new TopNav(driver);
        try {
            RequestADemoPage requestADemoPage = topNav.clickRequest();


            Assert.assertEquals(requestADemoPage.getPageHeading().getText(), "Requesting a Demo");


            requestADemoPage
                    .keyInEmail("abc@gmail.com")
                    .keyInCompany("ABC CORP")
                    .keyLastName("SS")
                    .keyFirstName("AASDR");

        } catch (AssertionError e) {
            System.out.println("Mismatch of expected and actual");
        }
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {

            log.info("End of the test case");
            Thread.sleep(10000);


            driver.quit();
        }



    }



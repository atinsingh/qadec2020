package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.config.Config;
import io.pragra.learning.framework.drivermanager.DriverManager;
import io.pragra.learning.framework.pages.RequestADemoPage;
import io.pragra.learning.framework.pages.TopNav;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class DemoTest {
  Logger log= LogManager.getLogger("DemoTest.class");

    WebDriver driver;
    TopNav topNav;


    @BeforeSuite
    public void setUp() {
        log.info("Setting up the driver");
        try {
            driver = DriverManager.getDriver();
            driver.get(((String) Config.getProperty("app.url")));
        } catch (NullPointerException e) {
            log.info("No value mentioned for the app.url key in the framework.properties file");
            e.printStackTrace();

        }
    }

    @Test
    public void demoTest() {


        topNav = new TopNav(driver);
        log.debug("Comparing the page heading text value to the expected text");
        try {
            RequestADemoPage requestADemoPage = topNav.clickRequest();


            Assert.assertEquals(requestADemoPage.getPageHeading().getText(), "Requesting a Demo");
            log.info("Inputting user details");


            requestADemoPage
                    .keyInEmail("abc@gmail.com")
                    .keyInCompany("ABC CORP")
                    .keyLastName("SS")
                    .keyFirstName("AASDR");

        } catch (AssertionError e) {
            log.error("Page heading text does not match with the expected result");
            e.printStackTrace();

        }
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {

            log.info("End of the test case");
            Thread.sleep(10000);


            driver.quit();
        }



    }



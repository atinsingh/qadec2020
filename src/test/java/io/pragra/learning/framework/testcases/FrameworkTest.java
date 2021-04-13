package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.config.Config;
import io.pragra.learning.framework.drivermanager.DriverManager;
import io.pragra.learning.framework.utlis.Reporting;
import io.pragra.learning.framework.utlis.ScreenShotType;
import io.pragra.learning.framework.utlis.Utils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.apache.logging.log4j.Logger;

public class FrameworkTest extends Reporting {
    private static final Logger log=LogManager.getLogger(FrameworkTest.class);


    @Test
    public void tc() {
        test=reports.createTest("tc");
        try {
            Assert.assertEquals(Config.getProperty("browser.name"), "chrome");
        }
        catch (NullPointerException e){
            log.error("No value is presented for the key {} ",Config.getProperty("browser.name"));
            e.getMessage();
        }
    }

    @Test
    public void checkBrowserTest() throws InterruptedException {
        test=reports.createTest("checkBrowserTest");
        log.debug("Fetching the key form the [Framework.properties] file and comparing to the expected URL{}",Config.getProperty("app.url"));
        try {
            WebDriver driver = DriverManager.getDriver();
            String property = (String) Config.getProperty("app.url");
            Assert.assertEquals(property, "https://zoom.us/");
            driver.get(property);
            Thread.sleep(10000);
            Utils.captureScreenShot(driver, "checkBrowserTest", ScreenShotType.PASS);

            driver.quit();
        }

        catch (ScreenshotException e) {
            log.error("Unable to perform the screenshot operation");
            e.printStackTrace();

        }
        catch (WebDriverException e){
            log.warn("WebDriver continues to be on action, unable to close the Browser at the appropriate time");
            e.getMessage();
        }


    }
}

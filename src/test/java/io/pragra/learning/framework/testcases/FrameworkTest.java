package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.config.Config;
import io.pragra.learning.framework.drivermanager.DriverManager;
import io.pragra.learning.framework.utlis.ScreenShotType;
import io.pragra.learning.framework.utlis.Utils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class FrameworkTest {
    Logger log = Logger.getLogger(FrameworkTest.class.getName());


    @Test
    public void tc() {
        DOMConfigurator.configure("/Users/agilaethiraj/IdeaProjects/qadec2020/src/log4j.xml");
        log.info("Executing First test case, checking broswer name");
        Assert.assertEquals(Config.getProperty("browser.name"), "chrome");
    }

    @Test
    public void checkBrowserTest() throws InterruptedException {
        log.info("Performing Screenshot of a website");
        try {
            WebDriver driver = DriverManager.getDriver();
            String property = (String) Config.getProperty("app.url");
            Assert.assertEquals(property, "https://zoom.us/");
            driver.get(property);
            Thread.sleep(10_000);
            Utils.captureScreenShot(driver, "checkBrowserTest", ScreenShotType.PASS);

            driver.quit();
        }

        catch (ScreenshotException e) {
            System.out.println("The element cannot be captured");

        }


    }
}

package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.config.Config;
import io.pragra.learning.framework.drivermanager.DriverManager;
import io.pragra.learning.framework.utlis.ScreenShotType;
import io.pragra.learning.framework.utlis.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameworkTest {

    @Test
    public void tc() {
        Assert.assertEquals(Config.getProperty("browser.name"),"chrome");
    }

    @Test
    public void checkBrowserTest() throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        String property = (String) Config.getProperty("app.url");
        Assert.assertEquals(property,"https://zoom.us/");
        driver.get(property);
        Thread.sleep(10_000);
        Utils.captureScreenShot(driver,"checkBrowserTest", ScreenShotType.PASS );

        driver.quit();

    }
}

package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.config.Config;
import io.pragra.learning.framework.drivermanager.DriverManager;
import io.pragra.learning.framework.pages.ContactSales;
import io.pragra.learning.framework.pages.RequestADemoPage;
import io.pragra.learning.framework.pages.TopNav;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DemoTest {
    WebDriver driver ;
    TopNav topNav;

    @BeforeSuite
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get(((String) Config.getProperty("app.url")));
    }

    @Test
    public void demoTest() {
        topNav = new TopNav(driver);
        RequestADemoPage requestADemoPage = topNav.clickRequest();

        Assert.assertEquals(requestADemoPage.getPageHeading().getText(),"Request a Demo");

        requestADemoPage
                .keyInEmail("abc@gmail.com")
                .keyInCompany("ABC CORP")
                .keyLastName("SS")
                .keyFirstName("AASDR");
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}


package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.config.Config;
import io.pragra.learning.framework.drivermanager.DriverManager;
import io.pragra.learning.framework.pages.TopNav;
import io.pragra.learning.framework.pages.meeting.JoinAMeetingPage;
import io.pragra.learning.framework.utlis.Reporting;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class Demo4 extends Reporting {
    WebDriver webDriver;
    TopNav topNav;
    @BeforeClass
    public void set(){
        webDriver = DriverManager.getDriver();
        webDriver.get(((String) Config.getProperty("app.url")));
    }
    @Test
    public void test1() throws IOException {
        test= reports.createTest("test1");
        topNav=new TopNav(webDriver);
        JoinAMeetingPage jj=topNav.clickRequest4();
        jj.id("agila.sri21@gmail.com")
                .submitted();
        captureScreenshot(webDriver,"test1");
    }
    @AfterClass
    public void end() throws InterruptedException{
        Thread.sleep(2000);
        webDriver.quit();
    }
}

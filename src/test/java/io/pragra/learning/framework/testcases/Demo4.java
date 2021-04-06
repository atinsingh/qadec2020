package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.config.Config;
import io.pragra.learning.framework.drivermanager.DriverManager;
import io.pragra.learning.framework.pages.TopNav;
import io.pragra.learning.framework.pages.meeting.JoinAMeetingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Demo4 {
    WebDriver webDriver;
    TopNav topNav;
    @BeforeSuite
    public void set(){
        webDriver = DriverManager.getDriver();
        webDriver.get(((String) Config.getProperty("app.url")));
    }
    @Test
    public void test1(){
        topNav=new TopNav(webDriver);
        JoinAMeetingPage jj=topNav.clickRequest4();
        jj.id("agila.sri21@gmail.com")
                .submitted();
    }
    @AfterSuite
    public void end() throws InterruptedException{
        Thread.sleep(2000);
        webDriver.quit();
    }
}

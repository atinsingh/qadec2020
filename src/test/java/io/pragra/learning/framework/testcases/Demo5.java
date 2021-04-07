package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.config.Config;
import io.pragra.learning.framework.drivermanager.DriverManager;
import io.pragra.learning.framework.pages.TopNav;
import io.pragra.learning.framework.pages.meeting.Solutions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Demo5 {
    WebDriver webDriver;
    TopNav topnav;
    @BeforeSuite
    public void set(){
        webDriver=DriverManager.getDriver();
        webDriver.get(((String) Config.getProperty("app.url")));

    }
    @Test
    public void set1()throws InterruptedException{
        topnav=new TopNav(webDriver);
        Solutions sol=topnav.clickRequest5();
        sol.click1();
        Thread.sleep(2000);
        sol.click2("agila.sri21@gmail.com")
                .click3("Nisanthan")
                .click4("Naganathan")
                .click5("Google")
                .click6()
                .click7()
                .click8()
                .click9("90202")
                .click10()
                .click11();
    }
    @AfterSuite
    public void end() throws InterruptedException{
        Thread.sleep(2000);
        webDriver.quit();
    }
}

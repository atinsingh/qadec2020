package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.config.Config;
import io.pragra.learning.framework.drivermanager.DriverManager;
import io.pragra.learning.framework.pages.TopNav;
import io.pragra.learning.framework.pages.meeting.Solutions;
import io.pragra.learning.framework.utlis.Reporting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Demo5 extends Reporting {
    Logger log= LogManager.getLogger(Demo5.class);
    WebDriver webDriver;
    TopNav topnav;
    @BeforeSuite
    public void set(){
        log.info("Opening the URL specified as a key in the framework.properties");
        webDriver=DriverManager.getDriver();
        webDriver.get(((String) Config.getProperty("app.url")));

    }
    @Test
    public void set1()throws InterruptedException {
        test=reports.createTest("set1");
        try {
            topnav = new TopNav(webDriver);
            Solutions sol = topnav.clickRequest5();
            sol.click1();
            Thread.sleep(2000);
            log.info("inputting user details in the given form");
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
        catch (ElementNotSelectableException e){
            log.error("Invalid operation on the element, unable to perform click operation to the specified element");
            e.getMessage();
            log.info("Check the address of the desired element from the DOM and verify it");
        }
        catch (ElementNotInteractableException e){
            log.error("Invalid operation on the given element, unable to perform the operation.");
            e.getMessage();
            log.info("Check the address of the element from the DOM and verify it");

        }
    }
    @AfterSuite
    public void end() throws InterruptedException {
        Thread.sleep(2000);
        try {
            webDriver.quit();
        }
        catch (WebDriverException e){
            e.getMessage();
            log.info("Driver continues to be active, despite quiting.");
        }
    }
}

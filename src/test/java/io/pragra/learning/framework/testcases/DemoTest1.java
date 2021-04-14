package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.config.Config;
import io.pragra.learning.framework.drivermanager.DriverManager;
import io.pragra.learning.framework.pages.TopNav;
import io.pragra.learning.framework.pages.meeting.ContactSales;
import io.pragra.learning.framework.utlis.Reporting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class DemoTest1 extends Reporting {
    Logger log = LogManager.getLogger(DemoTest1.class);
    WebDriver driver;
    TopNav topNav;
    @BeforeClass
    public void set(){
       driver= DriverManager.getDriver();
       driver.get(((String) Config.getProperty("app.url")));
    }
    @Test
    public void test() throws IOException {
        test=reports.createTest("test");
        try {
            topNav = new TopNav(driver);
            ContactSales cc = topNav.clickRequest3();
            cc.workMail("agila.sri21@gmail.com")
                    .cN("Google")
                    .fN("Agila")
                    .lN("Ethiraj")
                    .employee("251-500")
                    .phone("6476772775")
                    .country("Canada")
                    .state("Ontario")
                    .head("M8V2J2")
                    .add("N/A")
                    .in()
                    .sub();


        }
        catch (ElementClickInterceptedException e){
            log.warn("Unable to perform the click operation on the given address of the element");
            e.getMessage();
        }
        catch (ElementNotInteractableException e){
            log.error("Actions cannot be performed, as the element cannot be Interactable");
            e.getMessage();

        }
        String title = driver.getTitle();
        System.out.println(title);
        if(driver.getTitle().equals("Contacting Sales - Zoom")){
            Assert.assertTrue(true);
        }
        else
        {
            captureScreenshot(driver,"test");
            System.out.println("Title did not match");
        }


    }
    @AfterClass
    public void close() throws InterruptedException {
        test=reports.createTest("close");
        Thread.sleep(1000);
        try {
            driver.quit();
        }
        catch (WebDriverException e){
            log.info("Browser remains active");
            e.getMessage();
        }
    }
}

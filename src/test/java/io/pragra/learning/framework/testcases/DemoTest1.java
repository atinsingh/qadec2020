package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.config.Config;
import io.pragra.learning.framework.drivermanager.DriverManager;
import io.pragra.learning.framework.pages.TopNav;
import io.pragra.learning.framework.pages.meeting.ContactSales;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DemoTest1 {
    WebDriver driver;
    TopNav topNav;
    @BeforeSuite
    public void set(){
       driver= DriverManager.getDriver();
       driver.get(((String) Config.getProperty("app.url")));
    }
    @Test
    public void test(){
        topNav =new TopNav(driver);
        ContactSales cc=topNav.clickRequest3();
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
    @AfterSuite
    public void close() throws InterruptedException{
        Thread.sleep(1000);
        driver.quit();
    }
}

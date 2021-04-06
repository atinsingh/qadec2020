package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.config.Config;
import io.pragra.learning.framework.drivermanager.DriverManager;
import io.pragra.learning.framework.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ContactSalesTest{
        WebDriver driver ;
        MainNav mainNav;
        RequestADemoPage requestADemoPage;



    @BeforeSuite
        public void setUp() {
            driver = DriverManager.getDriver();
            driver.get(((String) Config.getProperty("app.url")));
        }

        @Test
        public void contactSalesTest() throws InterruptedException {
            mainNav = new MainNav(driver);
            ContactSales contactSales = mainNav.clickRequest();

            Assert.assertEquals(contactSales.getPage_Heading().getText(),"Contact Sales");

            contactSales
                    .keyInEmail("parul@gmail.com")
                    .keyInCompany("Pragra")
                    .keyLastName("GG")
                    .keyFirstName("Parul")
                    .keyInEmpCount()
                    .keyInPhone("762625362")
                    .keyInCountry().keyInState().keyInHQZip("L3A8Q2")
                    .keyInAddInfo("Information about collaboration")
                    .keyInText("I would like to receive communications about products, offerings, and industry trends from Zoom. I understand that I can unsubscribe at any time.")
                    .selectRadio().privacy().submit();
        }

        @Test
        public void tc() throws InterruptedException {
            requestADemoPage = new RequestADemoPage(driver);
            ContactSales contactSales= mainNav.clickRequest();

            contactSales.requestDemo();
            Thread.sleep(5000);

        }



        @AfterSuite
        public void tearDown() throws InterruptedException {
            Thread.sleep(10000);
            driver.quit();
        }
    }




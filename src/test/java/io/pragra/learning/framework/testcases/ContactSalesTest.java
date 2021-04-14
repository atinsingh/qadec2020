package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.config.Config;
import io.pragra.learning.framework.drivermanager.DriverManager;
import io.pragra.learning.framework.pages.*;
import io.pragra.learning.framework.utlis.Reporting;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class ContactSalesTest extends Reporting  {
        WebDriver driver ;
        MainNav mainNav;
        RequestADemoPage requestADemoPage;
    @BeforeClass
    public void settUp() {
        driver = DriverManager.getDriver();
        driver.get(((String) Config.getProperty("app.url")));
    }


        @Test
        public void contactSalesTest() throws InterruptedException, IOException {
        test=reports.createTest("contactSalesTest");

            mainNav = new MainNav(driver);
            ContactSales contactSales = mainNav.clickRequest();


          Assert.assertEquals(contactSales.getPage_Heading().getText(),"Contact Sales");
            String title = driver.getTitle();
            if(driver.getTitle().equals("Contact Sales - Zoom")){
                Assert.assertTrue(true);
            }
            else
            {
                captureScreenshot(driver,"contactSalesTest");
                System.out.println("Title Mismatch");
            }
            System.out.println(title);

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
        test=reports.createTest("tc");

            requestADemoPage = new RequestADemoPage(driver);
            ContactSales contactSales= mainNav.clickRequest();

            contactSales.requestDemo();
            Thread.sleep(5000);

        }
          @AfterClass
    public void tearDown(){
        driver.quit();
    }




    }




package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.config.Config;
import io.pragra.learning.framework.drivermanager.DriverManager;
import io.pragra.learning.framework.pages.RequestSignUp;
import io.pragra.learning.framework.pages.Signup;
import io.pragra.learning.framework.pages.SignupFreePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.thread.IThreadWorkerFactory;

public class SignupTest {
    WebDriver driver;
    Signup signup;

    @BeforeSuite
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get(Config.getProperty("app.url"));
    }
    @Test
    public  void SignupTest() {
        signup= new Signup(driver);
        RequestSignUp requestSignUp = signup.clickSignup();
        Assert.assertEquals(requestSignUp.getPageHeading().getText(), "For verification, please confirm your date of birth.");
        requestSignUp
                .keyInDay()
                .keyInMonth()
                .keyInYear()
                .keyInContinue()
                .KeyEmail("abc@gmail.com");

    }
    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}

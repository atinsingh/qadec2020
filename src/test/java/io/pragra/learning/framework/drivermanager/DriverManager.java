package io.pragra.learning.framework.drivermanager;

import io.pragra.learning.framework.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static DriverManager driverManager;
    private WebDriver driver;

    public DriverManager() {
        init();
    }


    public void init() {

        if(((String) Config.getProperty("browser.name")).equalsIgnoreCase(BrowserType.CHROME)) {
            if (System.getProperty("webdriver.chrome.driver") == null) {
                System.setProperty("webdriver.chrome.driver", (String) Config.getProperty("chrome.driver.location"));
            }
            driver = new ChromeDriver();
        }else
        if(((String) Config.getProperty("browser.name")).equalsIgnoreCase(BrowserType.FIREFOX)) {
            if (System.getProperty("webdriver.gecko.driver") == null) {
                System.setProperty("webdriver.gecko.driver", (String) Config.getProperty("firefox.driver.location"));
            }
            driver = new FirefoxDriver();
        }else {
            if (System.getProperty("webdriver.chrome.driver") == null) {
                System.setProperty("webdriver.chrome.driver", (String) Config.getProperty("chrome.driver.location"));
            }
            driver = new ChromeDriver();
        }
    }

    public synchronized static WebDriver getDriver() {
        if(driverManager == null) {
            driverManager = new DriverManager();
        }
        return driverManager.driver;
    }

}

package io.pragra.learning.framework.drivermanager;

import io.pragra.learning.framework.config.Config;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.yaml.snakeyaml.tokens.Token.ID.Key;


public class DriverManager {
    private static final Logger log=LogManager.getLogger(DriverManager.class);
    private static DriverManager driverManager;
    private WebDriver driver;

    public DriverManager() {
        init();
    }


    public void init()  {
        log.debug("Comparing the browser name from the file framework.properties to the [{}]",BrowserType.CHROME);
        try {
            if (((String) Config.getProperty("browser.name")).equalsIgnoreCase(BrowserType.CHROME)) {
                if (System.getProperty("webdriver.chrome.driver") == null) {
                    System.setProperty("webdriver.chrome.driver", (String) Config.getProperty("chrome.driver.location"));
                }
                log.info("Opening Chrome Driver Browser Successfully");
                driver = new ChromeDriver();

            } else
                log.debug("Comparing the browser name from the file framework.properties to the [{}]", BrowserType.FIREFOX);
            {

                if (((String) Config.getProperty("browser.name")).equalsIgnoreCase(BrowserType.FIREFOX)) {
                    if (System.getProperty("webdriver.gecko.driver") == null) {
                        System.setProperty("webdriver.gecko.driver", (String) Config.getProperty("firefox.driver.location"));
                    }
                    log.info("Opening the Firefox Driver Successfully");
                    driver = new FirefoxDriver();
                } else
                    log.info("Web driver name and the location not specified");
                log.debug("Setting the default Webdriver name and the location in the framework.properties file");
                {
                    if (System.getProperty("webdriver.chrome.driver") == null) {
                        System.setProperty("webdriver.chrome.driver", (String) Config.getProperty("chrome.driver.location"));
                    }
                    log.info("Opening the default driver as a Chrome driver");
                    driver = new ChromeDriver();
                }
            }
        }
        catch (NullPointerException e){
            log.warn("The mentioned key does not posses any value in the location{}",Config.getProperty("browser.name"));
            e.getMessage();

        }
        catch (NoDataException e){
            log.error("No such Key mentioned in the framework.properties");
            e.printStackTrace();
        }
    }





    public synchronized static WebDriver getDriver() {
        if(driverManager == null) {
            driverManager = new DriverManager();
        }
        return driverManager.driver;
    }

}

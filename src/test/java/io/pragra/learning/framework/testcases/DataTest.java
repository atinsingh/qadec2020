package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.data.ContactProvider;
import io.pragra.learning.framework.data.ExcelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class DataTest {
    Logger logger = LogManager.getLogger(DataTest.class);
    @Test(dataProvider = "contact", dataProviderClass = ContactProvider.class)
    public void tc(String email, String fname, String lname, String company, String zip) {
        logger.info("Following Data Received Email: [{}] , FirstName: [{}], " +
                "LastName : [{}] , Company: [{}] , Zip: [{}]", email,fname,lname,company,zip);
    }
}

package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.dataAg.Data;
import io.pragra.learning.framework.utlis.Reporting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataTest1 {
    WebDriver webDriver;

   Logger log= LogManager.getLogger(DataTest1.class);
    @Test(dataProvider = "getData", dataProviderClass = Data.class)
    public void test(String email, String fl, String ll, String company, String zip) throws IOException {

        log.info("The Following are the details of the student,Email:[{}],FirstName:[{}],LastName:[{}],Company_Name:[{}},Zip:[{}]",email,fl,ll,company,zip);

    }
}

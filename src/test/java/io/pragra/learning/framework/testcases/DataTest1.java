package io.pragra.learning.framework.testcases;

import io.pragra.learning.framework.dataAg.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class DataTest1 {
   Logger log= LogManager.getLogger(DataTest1.class);
    @Test(dataProvider = "getData", dataProviderClass = Data.class)
    public void test(String email, String fl, String ll, String company, String zip){

        log.info("The Following are the details of the student,Email:[{}],FirstName:[{}],LastName:[{}],Company_Name:[{}},Zip:[{}]",email,fl,ll,company,zip);
    }
}

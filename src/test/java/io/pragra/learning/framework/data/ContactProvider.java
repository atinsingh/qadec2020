package io.pragra.learning.framework.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactProvider {
    private static final Logger log = LogManager.getLogger(ContactProvider.class);

    @DataProvider
    public static Iterator<Object[]> contact() {
        List<Object[]> data = new ArrayList<>();
        try {
            log.info("Fetching the data from the Excel sheet and storing the data.");

            List<List<Object>> contactData = ExcelReader.getDataFromSheet("ContactData", true);



            // contactData.forEach(list->data.add(list.toArray()));

            for (List<Object> objectData : contactData) {
                data.add(objectData.toArray());
            }


        } catch (ArrayStoreException e) {
            log.error("The type of objects from the list cannot be stored in the array of object {}",data );
            e.getMessage();
        }
        return data.iterator();
    }

    }






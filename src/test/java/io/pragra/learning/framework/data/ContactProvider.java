package io.pragra.learning.framework.data;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactProvider {

    @DataProvider
    public static Iterator<Object []> contact() {
        List<List<Object>> contactData = ExcelReader.getDataFromSheet("ContactData", true);
        List<Object []> data = new ArrayList<>();

       // contactData.forEach(list->data.add(list.toArray()));

        for (List<Object> objectData : contactData) {
            data.add(objectData.toArray());
        }
        return data.iterator();
    }
}

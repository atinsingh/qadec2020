package io.pragra.learning.framework.dataAg;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Data {
    @DataProvider
    public static Iterator<Object[]> getData(){
        //Calling the excel class by passing the sheet name from the excel file and specifying the boolean value
        List<List<Object>> data = Excel.getDetails("ContactData",true);
        //Create a list where it accepts the arrays of objects from the excel sheet
        List<Object[]> details=new ArrayList<>();
        //using foreach loop to get the data's from the excel sheet by giving a data type of list and object
        for(List<Object> Data1: data){
            //Adding the data's from the excel sheet to the list of array objects.
            details.add(Data1.toArray());
        }
        //returning the data's
       return details.iterator();

    }
}

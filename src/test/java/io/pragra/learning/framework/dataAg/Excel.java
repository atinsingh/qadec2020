package io.pragra.learning.framework.dataAg;

import io.pragra.learning.framework.config.Config;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Excel {
    private static Workbook workbook;
    //workbook is a excel file sheet, create a object for workbook
    private static Excel excel;

    private Excel() {
        //Path class used to fetch the location of the file.
        Path path = Paths.get(Config.getProperty("excel.file.location"), Config.getProperty("excel.file.name"));
        try {
            InputStream in = new FileInputStream(path.toFile());   //Inputstream is used for reading from a file
            //Adding your excel sheet to the workbook by passing the object of the local excel sheet.
            workbook=new XSSFWorkbook(in);
        }
        //Handling exception by using try and catch for, if the location or the file does not exist
        //FileNotFound Exception is thrown.
        //If file cannot be readable, writable-I/O exception is thrown.
        catch (FileNotFoundException e) {

        } catch (IOException e) {

        }


    }
    //The excel sheet data types accepts list of Objects(can be String or any date type)
    //Using Two internal and external list is predominantly for rows and columns and generics are used for data types,
    //in this case object is referred.
    public static List<List<Object>> getDetails(String sheet, boolean skipheader){
                                                                            //if the constructor, as in if there's no constructor with the workbook and the file created then create a
                                                                           //new object for the class.
        if(excel==null){
            excel=new Excel();
        }
                                                               //or if it's present then get the workbook.getsheet by passing your excel sheet name.
                                                                //The workbook sheet is ready with the exact file name and the sheet details, now it's time to iterate through
                                                              //every element.
        Sheet sheet1 = workbook.getSheet(sheet);
        //created a list of object which converts into array list for storing your entire table
        //with the details of rows and columns together.
     List<List<Object>> rowData =new ArrayList<>();
     //From the workbooksheet object get the rowiterator method to get the details of the first row.
        Iterator<Row> rowIterator = sheet1.rowIterator();
        //This boolean variable name is used to skip the header(first row) if it is true, then move to the next row
        //by using the sheet object.next method.
        if(skipheader){
            rowIterator.next();
        }
        //Once it moves to the next row(second row), check if it has elements
        while(rowIterator.hasNext()){
            //Keep iterating the next data(Enhancing the iterator) Finalizes that the row has datas.
            Row next = rowIterator.next();
            //create a list which accepts in the form of list objects and gives the output in the array.
            //Creating a list for storing column datas
            //conversion of list to array.
            List<Object> cellData=new ArrayList<>();
            //use the row iterator object to check the cell iterator for iterating through every column.
            Iterator<Cell> cellIterator = next.cellIterator();
            //check if the column has next datas/elements
            while (cellIterator.hasNext()) {
                //Advance the iterator by using next.
                Cell next1 = cellIterator.next();
                //check the column data cell type, if it is equivalent to string type
                if (next1.getCellType() == CellType.STRING) {
                    //if it is then add the string column data to the main column list which was created initially
                    cellData.add(next1.getStringCellValue());
                    //or if the column data cell type is equivalent to numeric value
                } else if (next1.getCellType() == CellType.NUMERIC) {
                    //then ass the numeric column data to the main column list
                    cellData.add(next1.getNumericCellValue());
                }
            }
            //add the main column data to the main row data
            rowData.add(cellData);
            }
        //return the row data
        return rowData;

        }

    }




package io.pragra.learning.framework.data;

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

public class ExcelReader {
    private static Workbook workbook;
    private static ExcelReader reader;

    private ExcelReader() {
        Path path = Paths.get(Config.getProperty("datafile.location"),Config.getProperty("datafile.name"));
        try (InputStream inputStream = new FileInputStream(path.toFile())) {
            workbook = new XSSFWorkbook(inputStream);
        }catch (FileNotFoundException ex) {

        }catch (IOException e) {

        }
    }

    public static List< List<Object> > getDataFromSheet(String sheetName, boolean skipHeader) {
         if(reader == null) {
             reader = new ExcelReader();
         }
        Sheet sheet = workbook.getSheet(sheetName);
        List< List<Object> >  rowData = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.rowIterator();
        if(skipHeader){
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            List<Object> cellData = new ArrayList<>();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if(cell.getCellType() == CellType.STRING) {
                    cellData.add( cell.getStringCellValue()  );
                }else if(cell.getCellType() == CellType.NUMERIC) {
                    cellData.add(cell.getNumericCellValue());
                }
                //Handle others
            }

            rowData.add(cellData);
        }
        return rowData;

    }
}

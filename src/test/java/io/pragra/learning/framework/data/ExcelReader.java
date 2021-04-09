package io.pragra.learning.framework.data;

import io.pragra.learning.framework.config.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ExcelReader {
    private static  final Logger log=LogManager.getLogger(ExcelReader.class);
    private static Workbook workbook;
    private static ExcelReader reader;


    private ExcelReader() {
        Path path = Paths.get(Config.getProperty("datafile.location"),Config.getProperty("datafile.name"));
        log.info("Setting the path name and location for the excel file {}",path.toString());
        log.info("Reading the file from the location {}", path.toString());
        try (InputStream inputStream = new FileInputStream(path.toFile())) {
            workbook = new XSSFWorkbook(inputStream);
        }catch (FileNotFoundException ex) {
log.fatal("The file name and the location does not exist in the [framework.properties],{} ",path.toString());
        }catch (IOException e) {
            log.error("The file cannot be read {}",e.getMessage());

        }
    }

    public static List< List<Object> > getDataFromSheet(String sheetName, boolean skipHeader) {
        if (reader == null) {
            reader = new ExcelReader();
        }
        Sheet sheet = workbook.getSheet(sheetName);
        List<List<Object>> rowData = new ArrayList<>();
        try {
            Iterator<Row> rowIterator = sheet.rowIterator();
            if (skipHeader) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                List<Object> cellData = new ArrayList<>();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.STRING) {
                        cellData.add(cell.getStringCellValue());
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        cellData.add(cell.getNumericCellValue());
                    }
                    //Handle others
                }

                rowData.add(cellData);
            }


        }
        catch (NoSuchElementException e){
            log.fatal("There's no values presented in the row from the workbook sheet {}",sheet);
            e.printStackTrace();
        }
        return rowData;
    }
}

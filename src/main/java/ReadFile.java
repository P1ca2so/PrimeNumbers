package main.java;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    //Možnost pokud chci číst celý dokument
    public static List readFile(String path) throws IOException {
        List listOfNumbers = new ArrayList();
        File file = new File(path);
        FileInputStream fis = new FileInputStream((file));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        for (Row row : sheet) {
            for (Cell cell : row) {
                listOfNumbers.add(cell.getStringCellValue());
            }
        }

        return listOfNumbers;
    }

    //Možnost pokud chci načíst pouze specifický sloupec
    public static List readFile(String path, String columnName) throws IOException {
        List listOfNumbers = new ArrayList();
        File file = new File(path);
        FileInputStream fis = new FileInputStream((file));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        Integer columnIndex = null;
        Row row = sheet.getRow(0);
        for (Cell cell : row) {
            if (cell.getStringCellValue().equals(columnName)) {
                columnIndex = cell.getColumnIndex();
            }
        }

        if (columnIndex != null) {
            for (Row row1 : sheet) {
                Cell c = row1.getCell(columnIndex);
                if (c != null && c.getCellType() != Cell.CELL_TYPE_BLANK) {
                    listOfNumbers.add(c);
                }
            }
        }

        return listOfNumbers;
    }
}

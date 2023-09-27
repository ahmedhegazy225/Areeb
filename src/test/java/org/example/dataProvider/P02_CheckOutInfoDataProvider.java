package org.example.dataProvider;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class P02_CheckOutInfoDataProvider {
    public String[][] read_checkout() throws IOException, InvalidFormatException {
        File checkoutfile = new File("Test_data/checkout.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(checkoutfile);
        XSSFSheet sheet = wb.getSheet("sheet1");
        int number_of_rows = sheet.getPhysicalNumberOfRows();
        int number_of_columns = sheet.getRow(0).getLastCellNum();
        String[][] myarray = new String[number_of_rows - 1][number_of_columns];
        for (int i = 1; i < number_of_rows; i++) {
            for (int a = 0; a < number_of_columns; a++) {
                XSSFRow row = sheet.getRow(i);
                Cell cell = row.getCell(a);
                if (cell.getCellType() == CellType.NUMERIC) {
                    double numericValue = cell.getNumericCellValue();
                    myarray[i - 1][a] = String.valueOf(numericValue);
                } else if (cell.getCellType() == CellType.STRING) {
                    myarray[i - 1][a] = cell.getStringCellValue();
                } else {
                    myarray[i - 1][a] = "";
                }
            }
        }
        return myarray;
    }
}

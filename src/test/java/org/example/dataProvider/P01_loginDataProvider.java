package org.example.dataProvider;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class P01_loginDataProvider {
    public String [][] read_login() throws IOException, InvalidFormatException {
        File loginfile = new File ("Test_data/Login.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(loginfile);
        XSSFSheet sheet = wb.getSheet("sheet1");
        int number_of_rows = sheet.getPhysicalNumberOfRows();
        int number_of_columns = sheet.getRow(0).getLastCellNum();
        String [][] myarray = new String[number_of_rows-1][number_of_columns];
        for (int i=1;i<number_of_rows;i++){
            for (int a=0;a<number_of_columns;a++)
            {
                XSSFRow row = sheet.getRow(i);
                myarray[i-1][a]=row.getCell(a).getStringCellValue();
            }
        }
        return myarray;
    }
}

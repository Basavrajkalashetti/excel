package excel.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class datadriven {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        XSSFWorkbook ExcelWBook = null;
        XSSFSheet ExcelWSheet;
        
        File excelfile = new File("C:\\Users\\Admin\\Desktop\\basu\\test data.xlsx");
        
        try (FileInputStream inputStream = new FileInputStream(excelfile)) {
            ExcelWBook = new XSSFWorkbook(inputStream);
            ExcelWSheet = ExcelWBook.getSheetAt(0);
            
            int ttRows = ExcelWSheet.getLastRowNum() + 1;
            int ttlcells = ExcelWSheet.getRow(0).getLastCellNum();
            
            for (int currentrow = 0; currentrow < ttRows; currentrow++) {
                for (int currentCell = 0; currentCell < ttlcells; currentCell++) {
                    System.out.print(ExcelWSheet.getRow(currentrow).getCell(currentCell).toString());
                    System.out.print("\t");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ExcelWBook != null) {
                try {
                    ExcelWBook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

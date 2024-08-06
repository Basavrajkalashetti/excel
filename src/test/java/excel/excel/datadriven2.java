package excel.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datadriven2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		XSSFWorkbook ExcelWBook=null;
		
		XSSFSheet ExcelWSheet;
		
		File excelFile=new File("C:\\Users\\Admin\\Desktop\\basu.xlsx");
		FileInputStream inputStream;
		try {
		 inputStream=new FileInputStream(excelFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
		try {
			ExcelWBook =new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ExcelWSheet= ExcelWBook.getSheetAt(0);
		
		int ttlRows=ExcelWSheet.getLastRowNum()+1;
		
		int ttlColumn=ExcelWSheet.getRow(0).getLastCellNum()+1;
		
		for(int currentRow=0;currentRow<ttlRows;ttlRows++)
		{
			for(int currentCell=0;currentCell<ttlColumn;ttlColumn++ )
			{
				System.out.println(ExcelWSheet.getRow(currentRow).getCell(currentCell).toString());
				System.out.println("\t");
			}
			
			System.out.println();
		}
		try {
			ExcelWBook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

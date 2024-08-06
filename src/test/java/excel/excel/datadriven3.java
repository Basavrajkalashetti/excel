package excel.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;


public class datadriven3 {

	public static void main(String[] args) {
		
	XSSFWorkbook Excelworbook=null;
	XSSFSheet Excelsheet;
	XSSFRow row;
	XSSFCell cell;
	
	File excelfile=new File("C:\\Users\\Admin\\Desktop\\basu\\data.xlsx");
	FileInputStream inputstream=null;
    try {
		 inputstream=new FileInputStream(excelfile);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    try {
		Excelworbook=new XSSFWorkbook(inputstream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
    Excelsheet=Excelworbook.getSheetAt(0);
    
    int ttlrow=Excelsheet.getLastRowNum()+1;
    int ttlcell=Excelsheet.getRow(0).getLastCellNum();
    for(int currentrow=0;currentrow<ttlrow;currentrow++)
    {
    	for(int currentcell=0;currentcell<ttlcell;currentcell++)
    		
    	{
    		System.out.print(Excelsheet.getRow(currentrow).getCell(currentcell).toString());
    		
    		System.out.print("\t");
    	}
    	
    	System.out.println();
    }
	  
    
    try {
		Excelworbook.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	

}

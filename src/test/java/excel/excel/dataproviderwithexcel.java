package excel.excel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataproviderwithexcel {
	
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.get("http://www.google.com");
		
		driver.manage().window().maximize();
	}
 @Test(dataProvider="searchDataprovider")
	public void searchKeyword(String keyword)
	
	{
		WebElement searchbox=driver.findElement(By.name("q"));
		
		searchbox.sendKeys(keyword);
		searchbox.sendKeys(Keys.ENTER);
	}
 @DataProvider(name="searchDataprovider")
 public Object[][]  searchDataproviderMethod()
 {
	// Object[][] searchData=new Object[2][1];
	 String filename="C:\\Users\\Admin\\Desktop\\basu.xlxs";
	 Object[][] searchData=getExcelData(filename,"Sheet1");
	 //searchData[0][0]="Taj  Mahal";
	// searchData[1][0]="India Gate";
	 return searchData;
	 
 }
 
 public String[][] getExcelData(String fileName,String sheetName)
 {
	 String[][] data=null;
	 
	 try {
		FileInputStream inputStream=new FileInputStream(fileName);
		XSSFWorkbook workBook=new XSSFWorkbook(inputStream);
		XSSFSheet ExcelWSheet= workBook.getSheet(sheetName);
		int ttRows = ExcelWSheet.getLastRowNum() + 1;
        int ttlcells = ExcelWSheet.getRow(0).getLastCellNum();
        
        for (int currentrow = 0; currentrow < ttRows; currentrow++) {
            for (int currentCell = 0; currentCell < ttlcells; currentCell++) {
                System.out.print(ExcelWSheet.getRow(currentrow).getCell(currentCell).toString());
                System.out.print("\t");
            }
            System.out.println();
        }

		workBook.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return data;
 } 

       
 
 @AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}



package excel.excel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager; 
public class proper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		propertiesoffile fiel= new propertiesoffile();
		
		driver.get(fiel.getURl());
		//driver.get("https://pensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys(fiel.getUserName());
		
		driver.findElement(By.id("txtPassword")).sendKeys(fiel.getPassword());
		
		//driver.findElement(By.id("btnLogin")).click();

	}

}

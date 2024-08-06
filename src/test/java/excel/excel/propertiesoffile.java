package excel.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertiesoffile {
	
	Properties properties;
	
	String path="C:\\Users\\Admin\\Desktop";

	public propertiesoffile()	
	{
		properties=new Properties();
		
		try {
			FileInputStream fis= new FileInputStream(path);
			try {
				properties.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getURl()
	{
		String url= properties.getProperty("url");
		if(url!=null)
			return url;
		else
			throw new RuntimeException("url not specified in config file");
	}
	
	public String getUserName()
	{
		String username= properties.getProperty("username");
		if(username!=null)
			return username;
		else
			throw new RuntimeException("url not specified in config file");
	}
	public String getPassword()
	{
		String password= properties.getProperty("password");
		if(password!=null)
			return password;
		else
			throw new RuntimeException("url not specified in config file");
	}
	
			
}

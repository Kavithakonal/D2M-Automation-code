package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadCofigProperty {
	Properties pro;
	
	public ReadCofigProperty() 
	{
		try{
		File src = new File("./Configuration/config.properties");
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
		}
		catch(Exception e){
			System.out.println("Exception is =="+e.getMessage());
		}
		}
	
	public String getBrowser(){
		return pro.getProperty("Browser");
	}
	
	public  String getChromePath(){
		 return pro.getProperty("ChromeDriver"); 
	}
	
	public  String getFirefoxPath(){
		 return pro.getProperty("FirefoxDriver"); 
	}
	
	public String geturl(){
		return pro.getProperty("URL");
	}
	
	public String getExcelPath(){
		return pro.getProperty("Excel");
	}
	
	public String getDeviceMakeImagesPath(){
		return pro.getProperty("DeviceMakeImages");
	}

}









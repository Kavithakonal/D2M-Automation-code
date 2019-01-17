package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
 public static WebDriver driver;

 @BeforeClass
	public static WebDriver launchBrowser(){
		
		ReadCofigProperty config = new ReadCofigProperty();
		String webBrowser = config.getBrowser();
		
		if(webBrowser.equals("Chrome")){
		System.setProperty("webdriver.chrome.driver",config.getChromePath());
		driver = new ChromeDriver();
		}
		else if(webBrowser.equals("Mozilla")){
			System.setProperty("webdriver.gecko.driver",config.getFirefoxPath());
			driver = new FirefoxDriver();
			}
		
		driver.manage().window().maximize();
		
		driver.get(config.geturl());
		
		return driver;
		
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.quit();
	}
	
}

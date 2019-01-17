package com.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MenubarLinks {
	
	WebDriver driver;
	
	public MenubarLinks(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH, using="(//span[text()='Manage'])[1]")
	WebElement deviceManageLink;
	
	@FindBy(how=How.XPATH, using="//a[text()='Add New Device']")
	WebElement addNewDeviceLink;
	
	
	
	

}

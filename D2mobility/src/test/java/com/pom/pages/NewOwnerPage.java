package com.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewOwnerPage {
	
	WebDriver driver;
	
	public NewOwnerPage(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH, using="(//span[text()='Manage'])[1]")
	WebElement deviceManageLink;
	
	@FindBy(how=How.XPATH, using="//a[text()='Add New Device']")
	WebElement addNewDeviceLink;
	
	@FindBy(how=How.ID, using="createOwnerBtn")
	WebElement addNewOwnerButton;
	
	@FindBy(how=How.XPATH, using="//input[@name='deviceOwnerName']")
	WebElement nameTextBox;
	
	@FindBy(how=How.XPATH, using="//input[@name='deviceOwnerEmailId']")
	WebElement emailIDTextBox;
	
	@FindBy(how=How.ID, using="saveOwner")
	WebElement saveOwnerButton;
	
	public void navigateAddOwnerPage() throws Exception{
		
		/*Actions act = new Actions(driver);
		act.moveToElement(deviceManageLink).click().perform(); ------ using Actions class or just element.click*/
		deviceManageLink.click();
		Thread.sleep(5000);
		addNewDeviceLink.click();
		Thread.sleep(5000);
		
	}
	public void clickAddNewButton(){
		addNewOwnerButton.click();
	}
	
	public void enterOwnerName(String ownerName)
	{
		nameTextBox.sendKeys(ownerName);
	}
	
	public void enterOwnerEmailID(String emailID){
		emailIDTextBox.sendKeys(emailID);
	}
	
	public void clickSaveOwner(){
		saveOwnerButton.click();
	}
	

}

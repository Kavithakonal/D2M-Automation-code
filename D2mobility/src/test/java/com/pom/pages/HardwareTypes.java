package com.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class HardwareTypes {
	WebDriver driver;
	public HardwareTypes(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH, using ="//span[text()='Inventory']")
	WebElement InventoryLink;
	
	@FindBy(how=How.XPATH, using="//a[text()='Hardware Types']")
	WebElement HardwareTypesLink;
	
	@FindBy(how=How.NAME, using="name")
	WebElement makeNameTextBox;
	
	@FindBy(how=How.ID, using="makeimage")
	WebElement makeImage;
	
	@FindBy(how=How.ID, using="submitBtn")
	WebElement addMakeButton;
	
	@FindBy(how=How.ID, using="resetBtn")
	WebElement cancelButton;
	
	@FindBy(how=How.XPATH, using="//select[@name='makeTable_length']")
	WebElement entriesDropDown;
	
	@FindBy(how=How.ID, using="makeTable")
	WebElement makeListingTable;
	
	@FindBy(how=How.XPATH, using="//tr[3]/td[2]/button[@type='button']")
	WebElement editMakeButton;
	
	@FindBy(how=How.XPATH, using="//table[@id='makeTable']/tbody/tr[2]/td[3]")
	WebElement viewModelsButton;
	
	
	public void clickInventoryLink(){
		InventoryLink.click();
	}
	
	public void clickHardwareTypesLink(){
		HardwareTypesLink.click();
	}
	
	public void enterMakeName(String makeName){
		makeNameTextBox.sendKeys(makeName);
	}
	
	public void uploadMakeImage(String imagePath)
	{
		makeImage.sendKeys(imagePath);
	}
	
	public void addMake(){
		addMakeButton.click();
	}
	
	public void entriesToBeDisplayed(String entries)
	{
		Select sc =new  Select(entriesDropDown);
		sc.selectByVisibleText(entries);
	}
	
public void editMake(int rowNum, int colNum){
	editMakeButton.click(); 
}

	
		
	
}

package com.pom.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class OrganizationPage {
	
	WebDriver driver;
	
	public OrganizationPage(WebDriver driver)
	{
		this.driver = driver ;
	}
	
	@FindBy(how=How.ID, using="inputOrganizationName")
	WebElement OrgName;
	
	@FindBy(how=How.ID, using="inputTeamAssignment")
	WebElement teamDropdown;
	
	@FindBy(how=How.ID, using="submitBtn")
	WebElement createButton;
	
	@FindBy(how=How.ID, using="resetBtn")
	WebElement resetButton;
	
	@FindBy(how=How.XPATH, using="//select[@name='orgList_length']")
	WebElement displayEntriesDropdown;
	
	public void enterOrganznName(String orgznName){
		OrgName.sendKeys(orgznName);
	}
	
		public void selectTeamName(String teamName){
			Select team = new Select(teamDropdown);
			team.selectByVisibleText(teamName);
	}
		
		public void clickCreatebtn(){
			createButton.click();
	}
		public void clickResetbtn(){
			resetButton.click();
	}
	
		public void displayAllEntries(){
			Select team = new Select(displayEntriesDropdown);
			team.selectByVisibleText("All");
	}
		
		

}

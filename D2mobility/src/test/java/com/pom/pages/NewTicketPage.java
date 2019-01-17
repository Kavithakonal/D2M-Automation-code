package com.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewTicketPage {
	
	WebDriver driver;
	
	public NewTicketPage(WebDriver driver){
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//span[text()='View']")
	WebElement ViewMenuLink;
	
	@FindBy(how=How.XPATH, using="createTicket")
	WebElement AddNewTicket;
	
	@FindBy(how=How.ID, using="ticketType")
	WebElement ticketTypeDD;
	

	
	
	
	

}

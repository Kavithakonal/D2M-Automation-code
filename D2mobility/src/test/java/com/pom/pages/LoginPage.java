package com.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver= driver;
	}
	
@FindBy(how=How.ID, using="userName") 
WebElement username;

@FindBy(how=How.ID, using="password") 
WebElement password;

@FindBy(how=How.XPATH, using="//button[@type='submit']") 
WebElement loginbutton;

public void enterUsername(String uName){
	username.sendKeys(uName);
}
public void enterPassword(String pwd){
	password.sendKeys(pwd);
}
public void clickLoginButton(){
	loginbutton.click();
}	
	
}

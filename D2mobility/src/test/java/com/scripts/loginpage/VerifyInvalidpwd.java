package com.scripts.loginpage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.pages.LoginPage;
import com.utility.BaseClass;
import com.utility.ExcelActions;

public class VerifyInvalidpwd extends BaseClass{

	
	@Test
	public void checkInValidPassword(){
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		ExcelActions exc = new ExcelActions();
		login.enterUsername(exc.readExcelData(0, 3, 0));
		login.enterPassword(exc.readExcelData(0, 3, 1));
		login.clickLoginButton();
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Login");
		
	}
}

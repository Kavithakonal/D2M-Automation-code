package com.scripts.loginpage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pom.pages.LoginPage;
import com.utility.BaseClass;

public class VerifyLoginWithoutCredentials extends BaseClass {

	
	@Test
	public void checkLoginWithoutUN(){
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.clickLoginButton();
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Login");
		
	}
}

package com.scripts.addnewowner;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pom.pages.LoginPage;
import com.pom.pages.NewOwnerPage;
import com.utility.BaseClass;
import com.utility.ExcelActions;

public class VerifyAddOwnerwithoutName extends BaseClass{
	
	
	@Test(description="Validates the mandatroy validation of Owner Name field")
	public void checkAddOwner() throws Exception{
		
		ExcelActions exc = new ExcelActions();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUsername(exc.readExcelData(0, 1, 0));
		login.enterPassword(exc.readExcelData(0, 1, 1));
		login.clickLoginButton();
		Thread.sleep(5000);
		NewOwnerPage newowner = PageFactory.initElements(driver, NewOwnerPage.class);
		newowner.navigateAddOwnerPage();
		Thread.sleep(5000);
		newowner.clickAddNewButton();
		Thread.sleep(2000);
		newowner.enterOwnerEmailID(exc.readExcelData(2, 1, 1));
		newowner.clickSaveOwner();
		Thread.sleep(5000);
		WebElement errmsg = driver.findElement(By.xpath("//label[text()='Please enter name']"));
		String errorMessage = errmsg.getText();
		System.out.println(errorMessage);
		assertEquals(errorMessage, "Please enter name");
	}

}

package com.scripts.addnewowner;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.pom.pages.LoginPage;
import com.pom.pages.NewOwnerPage;
import com.utility.BaseClass;
import com.utility.ExcelActions;

public class VerifyAddOwner extends BaseClass{
	
	@Test(description="Validates add owner functinality, positive case")
	public void checkAddOwner() throws Exception{
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		ExcelActions exc = new ExcelActions();

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUsername(exc.readExcelData(0, 1, 0));
		login.enterPassword(exc.readExcelData(0, 1, 1));
		login.clickLoginButton();
		Thread.sleep(8000);
		
		NewOwnerPage newowner = PageFactory.initElements(driver, NewOwnerPage.class);
		
		newowner.navigateAddOwnerPage();
		
		Select dOwnerDD1 = new Select(driver.findElement(By.xpath("//select[@id='deviceOwnerId']")));
		List<WebElement> ownersbefore = dOwnerDD1.getOptions();
		int totalOwnersBefore = ownersbefore.size();
		System.out.println("Total owner BeforeAddding " +totalOwnersBefore);
		Thread.sleep(5000);
		
		newowner.clickAddNewButton();
		Thread.sleep(2000);
		String ownerNmae = exc.readExcelData(2, 1, 0);
		newowner.enterOwnerName(ownerNmae);
		newowner.enterOwnerEmailID(exc.readExcelData(2, 1, 1));
		newowner.clickSaveOwner();
		Thread.sleep(5000);
		
		 //Validating the count because we cann't validate the added value as it can be duplicate.
		Select dOwnerDD2 = new Select(driver.findElement(By.id("deviceOwnerId")));
		List<WebElement> ownersafter = dOwnerDD2.getOptions();
		int totalOwnersAfter = ownersafter.size();
		System.out.println("Total owner AfterAddding " +totalOwnersAfter);
		assertEquals(totalOwnersAfter, totalOwnersBefore+1);
		
	}

}

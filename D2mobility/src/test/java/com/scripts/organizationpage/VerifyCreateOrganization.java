package com.scripts.organizationpage;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pom.pages.LoginPage;
import com.pom.pages.OrganizationPage;
import com.utility.BaseClass;
import com.utility.ExcelActions;

public class VerifyCreateOrganization extends BaseClass{
	
	
	@Test(description="Validates the creating organization with valid data")
	public void CheckCreateOrg() throws Exception{
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		ExcelActions exc = new ExcelActions();
		
		login.enterUsername(exc.readExcelData(0, 1, 0));
		login.enterPassword(exc.readExcelData(0, 1, 1));
		login.clickLoginButton();

		String organizationName = exc.readExcelData(1, 1, 0);
		System.out.println(organizationName);
		String teamName = exc.readExcelData(1, 1, 1);
		
		OrganizationPage orgzn = PageFactory.initElements(driver, OrganizationPage.class);
		orgzn.enterOrganznName(organizationName);
		orgzn.selectTeamName(teamName);
		Thread.sleep(3000);
		
		orgzn.clickCreatebtn();
		Thread.sleep(3000);
		orgzn.displayAllEntries();
		Thread.sleep(8000);
		
		WebElement orgName = driver.findElement(By.xpath("//td[text()='"+organizationName+"']"));
		System.out.println(orgName.getText());
		
		boolean result = orgName.isDisplayed();
		assertEquals(result, true);
		
		
	}

}

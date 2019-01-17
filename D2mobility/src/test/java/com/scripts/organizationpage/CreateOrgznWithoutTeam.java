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

public class CreateOrgznWithoutTeam extends BaseClass{
	
	@Test(description="Validates the mandatory validation of Team Assignment")
	public void checkCreateOrgznWithoutTeam() throws Exception{
LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		ExcelActions exc = new ExcelActions();
		String organizationName = exc.readExcelData(1, 1, 0);
		
		login.enterUsername(exc.readExcelData(0, 1, 0));
		login.enterPassword(exc.readExcelData(0, 1, 1));
		login.clickLoginButton();
		
		OrganizationPage orgzn = PageFactory.initElements(driver, OrganizationPage.class);
		
		orgzn.enterOrganznName(organizationName);
		Thread.sleep(3000);
		
		orgzn.clickCreatebtn();
		Thread.sleep(3000);
		
		WebElement errorlabel = driver.findElement(By.xpath("//label[text()='Please assign team']"));
		String errMessage = errorlabel.getText();
		System.out.println(errMessage);
		assertEquals(errMessage, "Please assign team");
		
	}

}

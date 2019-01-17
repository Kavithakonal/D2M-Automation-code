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

public class CreateEmptyOrgzn extends BaseClass{

	@Test(description="Validates the mandatory validation of Organization name field.")
	public void checkCreateEmptyOrg() throws Exception{

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		ExcelActions exc = new ExcelActions();
		String teamName = exc.readExcelData(1, 1, 1);
		
		login.enterUsername(exc.readExcelData(0, 1, 0));
		login.enterPassword(exc.readExcelData(0, 1, 1));
		login.clickLoginButton();
		
		OrganizationPage orgzn = PageFactory.initElements(driver, OrganizationPage.class);
		
		orgzn.selectTeamName(teamName);
		Thread.sleep(3000);
		
		orgzn.clickCreatebtn();
		Thread.sleep(3000);
		
		WebElement errorlabel = driver.findElement(By.xpath("//label[text()='Organization Name is required']"));
		String errMessage = errorlabel.getText();
		System.out.println(errMessage);
		assertEquals(errMessage, "Organization Name is required");
		
	}
	
}

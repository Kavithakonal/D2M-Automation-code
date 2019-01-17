package com.scripts.hardwaretypes;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.pom.pages.HardwareTypes;
import com.pom.pages.LoginPage;
import com.utility.BaseClass;
import com.utility.ExcelActions;
import com.utility.ReadCofigProperty;

public class AddMake extends BaseClass{
	
	@Test(description="Validated functionality of add new Device Make")
	public void addNewMake() throws InterruptedException{
	
	LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	
	ExcelActions exe = new ExcelActions();
	
	login.enterUsername(exe.readExcelData(0, 1, 0));
	login.enterPassword(exe.readExcelData(0, 1, 1));
	login.clickLoginButton();
	
	HardwareTypes hTypes = PageFactory.initElements(driver, HardwareTypes.class);
	Thread.sleep(3000);
	hTypes.clickInventoryLink();
	Thread.sleep(3000);
	hTypes.clickHardwareTypesLink();
	Thread.sleep(3000);
	
	ReadCofigProperty config = new ReadCofigProperty();
	String makeImagePath = config.getDeviceMakeImagesPath();
	
	int totalMakes = exe.getRowCount(3);
	System.out.println(totalMakes);
	
	for(int i=2;i<=totalMakes;i++){
		
	String makeName = exe.readExcelData(3, i, 0);
	hTypes.enterMakeName(makeName);
	
	String imageName = exe.readExcelData(3, i, 1);
	System.out.println(imageName);
	
	Thread.sleep(3000);
	String makeImgAbsolutePath = makeImagePath+imageName;
	
	hTypes.uploadMakeImage(makeImgAbsolutePath);
	Thread.sleep(3000);
	hTypes.addMake();
	Thread.sleep(3000);	
	hTypes.entriesToBeDisplayed("All");
	Thread.sleep(3000);
	WebElement addedMake = driver.findElement(By.xpath("//td[text()='"+makeName+"']"));
	String makeAdded =  addedMake.getText();
	System.out.println(makeAdded);
	
	assertEquals(makeAdded, makeName);
	
	}
	
}
}



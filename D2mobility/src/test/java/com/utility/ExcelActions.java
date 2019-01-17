package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelActions {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	File source;

	public ExcelActions(){
		
		try {
			ReadCofigProperty config = new ReadCofigProperty();
			File src = new File(config.getExcelPath());
			this.source = src;
			FileInputStream fis = new FileInputStream(source);
			 wb = new XSSFWorkbook(fis);     
		} 
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());  
		} 	
	}
	public int getRowCount(int sheetNumber){
		sheet = wb.getSheetAt(sheetNumber);
		int rowcount = sheet.getLastRowNum();
		return rowcount;
	}
	
public String readExcelData(int sheetNumber, int row, int column){
	sheet = wb.getSheetAt(sheetNumber);
	String data = sheet.getRow(row).getCell(column).getStringCellValue();  
	return data;
}

public void writeDataToExcel(int sheetNumber, int row, int column, String datatowrite) throws Exception{

	sheet = wb.getSheetAt(sheetNumber);
	sheet.getRow(row).createCell(column).setCellValue(datatowrite);
	FileOutputStream fout = new FileOutputStream(source);
	wb.write(fout);
	
}
}

package com.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperation {

	public static void main(String[] args) {
		
        Xls_Reader reader = new Xls_Reader("C:\\Users\\user\\eclipse-workspace\\dataDrivenFramework\\src\\com\\testData\\TestData.xlsx");
        
        if(!reader.isSheetExist("HomePage")){
        	reader.addSheet("HomePage");
        
        }	
        
        	int colCount = reader.getColumnCount("RegisterTestData");
        	System.out.println("Total cols present in RegisterTestData sheet:------" + colCount);
        	System.out.println(reader.getCellRowNum("RegisterTestData", "firstName", "Dev"));  
        	
        }
	}


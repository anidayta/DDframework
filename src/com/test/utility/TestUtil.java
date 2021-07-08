package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestUtil {
	static Xls_Reader reader;
	
	public static ArrayList<Object[]>getDataFromExcel(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader =  new Xls_Reader("C:\\Users\\user\\eclipse-workspace\\dataDrivenFramework\\src\\com\\testData\\TestData.xlsx");

		}catch (Exception e) {
			e.printStackTrace();
		}

		for (int rowNum = 2;  rowNum <= reader.getRowCount("RegisterTestData"); rowNum++) {
			
			String ReasonForContact = reader.getCellData("RegisterTestData","ReasonForContact", rowNum);
			String firstName = reader.getCellData("RegisterTestData","firstName", rowNum);
			String Lastname = reader.getCellData("RegisterTestData","Lastname", rowNum);
			String EmailAddress = reader.getCellData("RegisterTestData","EmailAddress", rowNum);
			String PhoneNumber = reader.getCellData("RegisterTestData","PhoneNumber", rowNum);
			String PreferredStore = reader.getCellData("RegisterTestData","PreferredStore", rowNum);
			String Comments = reader.getCellData("RegisterTestData","Comments", rowNum);
			
			
			Object ob[] = {ReasonForContact, firstName, Lastname, EmailAddress, PhoneNumber, PreferredStore,Comments};
			myData.add(ob);
			
			}
return myData;
			
		
	}

}
 

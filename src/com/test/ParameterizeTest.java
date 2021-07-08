package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class ParameterizeTest {

	public static void main(String[] args) {
	
		//Data driven : Driving the data from the excel sheets
		//webdriver code
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver =   new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
        driver.get("https://www.mclendons.com/contact-us");
        
        
        //get data from excel
        
        Xls_Reader reader = new Xls_Reader("C:\\Users\\user\\eclipse-workspace\\dataDrivenFramework\\src\\com\\testData\\TestData.xlsx");
        int rowCount = reader.getRowCount("RegisterTestData");
        reader.addColumn("RegisterTestData", "Status");
        
        
        
        //Parameterization
        
        for(int rowNum=2; rowNum<=rowCount; rowNum++) {
		System.out.println("----------");
		  String ReasonForContact = reader.getCellData("RegisterTestData", "ReasonForContact", rowNum);
	        System.out.println(ReasonForContact);
	        
	        String firstName = reader.getCellData("RegisterTestData", "firstName", rowNum);
	        System.out.println(firstName);

	        String Lastname = reader.getCellData("RegisterTestData", "Lastname", rowNum);
	        System.out.println(Lastname);
	        
	        String EmailAddress = reader.getCellData("RegisterTestData", "EmailAddress", rowNum);
	        System.out.println(EmailAddress);
	        
	        String PhoneNumber = reader.getCellData("RegisterTestData", "PhoneNumber", rowNum);
	        System.out.println(PhoneNumber);
	        
	        String PreferredStore = reader.getCellData("RegisterTestData", "PreferredStore", rowNum);
	        System.out.println(PreferredStore);
	        
	        String Comments = reader.getCellData("RegisterTestData", "Comments", rowNum);
	        System.out.println(Comments);
	        
	      //enterData
	        
	       
	        driver.findElement(By.xpath("//select[@name = 'Reason for Contact']")).sendKeys(ReasonForContact);
			
	        driver.findElement(By.xpath("//input[@name = 'First Name']")).clear();
	        driver.findElement(By.xpath("//input[@name = 'First Name']")).sendKeys(firstName);
	        
	        driver.findElement(By.xpath("//input[@name = 'Last Name']")).clear();
			driver.findElement(By.xpath("//input[@name = 'Last Name']")).sendKeys(Lastname);
			

			driver.findElement(By.name("Email Address")).clear();
			driver.findElement(By.name("Email Address")).sendKeys(EmailAddress);
			
			driver.findElement(By.name("Phone")).clear();
			driver.findElement(By.name("Phone")).sendKeys(PhoneNumber);
			
		
	        driver.findElement(By.xpath("//select[@name = 'Preferred Store']")).sendKeys(PreferredStore);
	        
	        driver.findElement(By.name("Message")).clear();
			driver.findElement(By.name("Message")).sendKeys(Comments);
			
			
			reader.setCellData("RegisterTestData", "Status", rowNum, "Pass"); //write the data into cell
	
	        
	}
	
	}
	
	

}

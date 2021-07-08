package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args)throws InterruptedException {

		//get test data from excel file
		
        Xls_Reader reader = new Xls_Reader("C:\\Users\\user\\eclipse-workspace\\dataDrivenFramework\\src\\com\\testData\\TestData.xlsx");
        String ReasonForContact = reader.getCellData("RegisterTestData", "ReasonForContact", 2);
        System.out.println(ReasonForContact);
        
        String firstName = reader.getCellData("RegisterTestData", "firstName", 2);
        System.out.println(firstName);
        
        String Lastname = reader.getCellData("RegisterTestData", "Lastname", 2);
        System.out.println(Lastname);
        
        String EmailAddress = reader.getCellData("RegisterTestData", "EmailAddress", 2);
        System.out.println(EmailAddress);
        
        String PhoneNumber = reader.getCellData("RegisterTestData", "PhoneNumber", 2);
        System.out.println(PhoneNumber);
        
        String PreferredStore = reader.getCellData("RegisterTestData", "PreferredStore", 2);
        System.out.println(PreferredStore);
        
        String Comments = reader.getCellData("RegisterTestData", "Comments", 2);
        System.out.println(Comments);
        
        
	//webdriver code
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver =   new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
        driver.get("https://www.mclendons.com/contact-us");
        
        
        driver.findElement(By.xpath("//select[@name = 'Reason for Contact']")).sendKeys("Website Questions");
		driver.findElement(By.xpath("//input[@name = 'First Name']")).sendKeys("Daya");
		driver.findElement(By.xpath("//input[@name = 'Last Name']")).sendKeys("Anand");
		driver.findElement(By.name("Email Address")).sendKeys("dayanand.alpha69@gmail.com");
		driver.findElement(By.name("Phone")).sendKeys("12345467890");
        driver.findElement(By.xpath("//select[@name = 'Preferred Store']")).sendKeys("Kent");
		driver.findElement(By.name("Message")).sendKeys("dayaTest");


	}
	

}

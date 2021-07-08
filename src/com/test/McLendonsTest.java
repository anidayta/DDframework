package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class McLendonsTest {

	WebDriver driver;
	
@BeforeMethod
public void setUp() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
    driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.mclendons.com/contact-us");
    
}

@DataProvider
public Iterator<Object[]> getTestData() {
	ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
	return testData.iterator();
	
}

@Test(dataProvider = "getTestData")
public void ContactformTest(String ReasonForContact, String firstName, String Lastname, String EmailAddress, String PhoneNumber, 
		String PreferredStore, String Comments){

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
     
}

	



@AfterMethod
public void tearDown(){
driver.quit();
	
	
	}

}

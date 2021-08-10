package Academy.E2EProject;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.ForGotpassword;
import pageObjects.LogInPage;
import pageObjects.LoginPage2;
import resorces.Base;

public class HomePage extends Base {
	WebDriver driver;
	//extending base class so that base class properties can be used
	//using inheritance here
	//inheriting java class from which we can get utilities

	@BeforeTest
	public void prereq() throws IOException
	{
		System.out.println("i m triggering");
		//here we are not doing again webdriver driver as
				//we have already declared public object in base class which we had inherited
		driver=initializeDriver();
		   
	}
	
	
	@Test(dataProvider="getData")
	public void BasePageNavigation(String username,String pwd,String txt) throws IOException
	{
		
	  
		driver.get(prop.getProperty("url"));
	   
	   //there are two methods we can access other page methods 
	   /*
	    * 1.inheritance
	    * 2.by creating objects of that class(but that class needs to be public)
	    */
	   
	   LogInPage login=new LogInPage(driver);
	   LoginPage2 login2=login.getLogin();
	   login2.entercredentials(username,pwd);
	   ForGotpassword fp=login2.frgtpwd();
	   fp.getEmail().sendKeys("abc@xyz.com");
	   fp.sendMeInstructions().click();
	  // if(driver.findElement(By.xpath("//*[contains(text(),'Invalid email or password')]"))!=null)
		 //  Assert.assertTrue(false);
	   System.out.println(txt);
	   
	   
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[3][3];
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="nonrestricteduser";
		//=================================
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456788";
		data[1][2]="restricteduser";
		//===============================
		data[2][0]="restricteduser@qw.com";
		data[2][1]="45678845";
     	data[2][2]="restricteduser2";
		
		return data;
	}
	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}
}

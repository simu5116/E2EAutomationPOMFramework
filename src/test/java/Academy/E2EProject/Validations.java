package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.LogInPage;
import resorces.Base;

public class Validations extends Base {
	//to overcome issue of overridden webDriver when we need to run tests in parallel mode
	WebDriver driver;
	//declaring this globally to use this in another testcase on same page
	LogInPage login;
	
	//For log4j add resources tag in pom.xml
	public static Logger log =LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void prereq() throws IOException
	{
		driver=initializeDriver();
		log.info("driver is initialized");
		   driver.get(prop.getProperty("url"));
		   //this will log the error but script will continue
		   log.error("navigated to homepage");
	}

	@Test
	public void validatetitle() throws IOException
	{
		
		   
		 //Assert.assertEquals("Featured Courses", driver.findElement(By.xpath("//*[text()='Featured Courses']")));
		   //when this assertion got failed for dataprovider 1 then it stopped the execution and started with another dataprovider 
		   //as soon as it got failed the below steps are not executed
		   //and the control shifts to another data provider
		   
		   //==============================================
		   
		   /*
		    * we can use soft assertions for that
		    */
		   
		    login=new LogInPage(driver);
		   String title=login.validateTitle();
		   SoftAssert softAssertion= new SoftAssert();
		   softAssertion.assertEquals("FEATURED COURSES", title);
		   //if in soft assertion we don't write this assertall then it shows pass only even if its failing
		   //so its imp to write assertAll if we are using soft assertion
		   softAssertion.assertAll();
		   Assert.assertTrue(login.validatenavigationbar());
		   
		  
		   
	}
	@Test
	public void validateText()
	{
		login=new LogInPage(driver);
		Assert.assertEquals(login.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}
	@AfterTest
	public void closedriver()
	{
		driver.quit();
	}
}

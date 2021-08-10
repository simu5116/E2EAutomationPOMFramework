package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
	WebDriver driver;
	public LogInPage(WebDriver driver)
	{
	
	this.driver=driver;
	}
	//a/*[contains(text(),'Login')]
		//input[@id='user_email']
		//input#user_email
		//input[@id='user_password']
		//input[@value='Log In']
		//a[contains(text(),'Forgot Password')]
	
	private By login=By.xpath("//a/*[contains(text(),'Login')]");
	private By title=By.xpath("//div[@class='text-center']/h2");
	private By navigationbar=By.xpath("//*[@class='nav navbar-nav navbar-right']");
	private  By header=By.cssSelector("div[class*='video-banner'] h3");
	
	public LoginPage2 getLogin()
	{
		driver.findElement(login).click();
		LoginPage2 login2=new LoginPage2(driver);
		return login2;
	}
	public String validateTitle()
	{
		return driver.findElement(title).getText();
	}
	public Boolean validatenavigationbar()
	{
		return driver.findElement(navigationbar).isDisplayed();
	}
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}

}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage2 {
	WebDriver driver;
	public LoginPage2(WebDriver driver)
	{
		this.driver=driver;
	}


	//input[@id='user_email']
	//input#user_email
	//input[@id='user_password']
	//input[@value='Log In']
	//a[contains(text(),'Forgot Password')]

	private By username1=By.xpath("//input[@id='user_email']");
	private By userpassword=By.xpath("//input[@id='user_password']");
	private By FrgtPwd= By.xpath("//a[contains(text(),'Forgot Password')]");
	private By sbmt=By.xpath("//input[@value='Log In']");


	public void entercredentials(String username,String password)
	{
		driver.findElement(username1).sendKeys(username);
		driver.findElement(userpassword).sendKeys(password);
		driver.findElement(sbmt).click();

		/*
		 * to write in capital letter we need to click 
		 * WebElement element = driver.findElement(By.xpath("//input[@class='search']"));
		 * Actions act = new Actions(driver);
		 * act.keyDown(element, Keys.SHIFT).sendKeys(TextToBeConvertAndSendInUpperCase).keyDown(element, Keys.SHIFT).build().perform();
		 */
	}
	public ForGotpassword frgtpwd()
	{
		driver.findElement(FrgtPwd).click();
		return new ForGotpassword(driver);
		
	}

}

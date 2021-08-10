package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForGotpassword {

	public WebDriver driver;

	private By email = By.cssSelector("[id='user_email']");
	private By sendMeInstructions = By.cssSelector("[type='submit']");

	public ForGotpassword(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement sendMeInstructions() {
		return driver.findElement(sendMeInstructions);
	}

}

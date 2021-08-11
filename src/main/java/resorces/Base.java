package resorces;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException
	{
		String current = System.getProperty("user.dir");
		System.out.println(current);
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream(current+"\\src\\main\\java\\resorces\\data.properties");
		prop.load(fis);
		/*
		 * Now suppose business people wants to run in different browser so we can't tell them to come and change the browser everytime
		 * so here instead of driving the browser through code ,we can drive it through maven commands which we will integrate with jenkins
		 * so business people can directly select and run in the desired browser
		 */
		//mvn test -Dbrowserr=chrome
		String Browser=System.getProperty("browser");
		//in jenkins after creating choice parameter
		//configure mvn test -Dbrowser="$browser"
		//String Browser=prop.getProperty("browser");
		
		if(Browser.contains("chrome"))
		{
			/*
			 * so if my browser version is suppose 92.xx
			 * and my chromedriver.exe file is 93.xx
			 * then it will not run
			 * and if my chromedriver exe file is 91.xx
			 * then it will 
			 */
			ChromeOptions options =new ChromeOptions();
//			if(Browser.contains("headless"))
//				options.addArguments("--headless");
			System.setProperty("webdriver.chrome.driver", current+"\\src\\main\\java\\resorces\\drivers\\chromedriver.exe");
			driver= new ChromeDriver(options);
			
		}
		else
		{
			//write code for IE and Gecko
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		return driver;
	}
	public String takescreenshot(String testcasename,WebDriver driver) throws IOException
	{
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		String destinationpath=System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		File destination=new File(destinationpath);
		FileUtils.copyFile(src,destination);
		return destinationpath;
	}

}

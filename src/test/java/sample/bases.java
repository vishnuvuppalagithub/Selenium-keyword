package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class bases {

	  public WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
 prop= new Properties();
FileInputStream fis=new FileInputStream("C:\\Users\\vishnu.vuppala\\eclipse-workspace\\original (1)\\E2EProjectCucumber\\src\\main\\java\\resources\\data.properties");

prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome"))
{
	 System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
	driver= new ChromeDriver();
		//execute in chrome driver
	
}
else if (browserName.equals("firefox"))
{
	 driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("IE"))
{
//	IE code
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;


}

public void getScreenshot(String result) throws IOException
{
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrFile, new File("D:\\testScreenShot1.jpg"));
	
}


}

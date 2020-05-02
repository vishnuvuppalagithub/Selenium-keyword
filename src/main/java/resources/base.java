package resources;

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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * 
 * @author vishnu.vuppala
 */

public class base {

	public static WebDriver driver;
	public Properties prop;
	public final String propertyfilepath = "C:\\Users\\vishnu.vuppala\\eclipse-workspace\\keyworddriven\\src\\main\\resources\\data.properties";

	public WebDriver initialize(String browsername) throws Exception {
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
		//	if (prop.getProperty("headless").equalsIgnoreCase("yes")) {
			//	ChromeOptions options = new ChromeOptions();
			//	options.addArguments("--headless");
			//	driver = new ChromeDriver(options);
		//	}else{
				driver = new ChromeDriver();
			//	}

		} else if (browsername.equals("firefox")) {
			System.setProperty("Webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

	public Properties init_properties() {

		try {
			FileInputStream fis = new FileInputStream(propertyfilepath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}
	
	public void getscreenshot(String testcase) throws IOException
	{
		System.out.println("Name of test case is:" + testcase);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\vishnu.vuppala\\eclipse-workspace\\keyworddriven\\"+testcase+"screenshot.png"));
	}

}

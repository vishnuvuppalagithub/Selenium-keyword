package sample;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.bases;
*/
public class HomePage extends bases{
	
	// public static Logger log =LogManager.getLogger(bases.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	@Test
	
	public void basePageNavigation() throws IOException
	{

		//one is inheritance

		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
	
		/*LandingPage l=new LandingPage(driver);
		l.getLogin().click(); //driver.findElement(By.css()
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);

		log.info(text);
		
		lp.getLogin().click();
		*/
		Assert.assertTrue(false);
		
		}

	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}

	

		
		
		
		
		
		
	}
	

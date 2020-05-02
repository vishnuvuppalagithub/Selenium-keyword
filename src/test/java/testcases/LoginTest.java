package testcases;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import resources.base;
import resources.driverscript;


//@Listeners(resources.listener.class)			


public class LoginTest extends base{
	
	//public static Logger log = LogManager.getLogger(LoginTest.class);
	 public static Logger log =LogManager.getLogger(base.class.getName());
	
	public driverscript engine;
	
	  
	/*@Test
  public void logintest() {
	  engine =new driverscript();
	  engine.execute("Signin");
		
	  	  
  
 }
 */
	
  
  @Test
  public void logintest2() {
	// engine =new driverscript();
	  //engine.execute("Login");
	  log.info("This is Info");
	  log.error("This is error");
	  log.debug("This is debug");
	  log.warn("This is warn");

}

	/*
	@Test
	public void init() throws Exception {
		
		driver =initialize("chrome");
		driver.get("https://www.google.com");
		Assert.assertTrue(false);
		
	}
	*/
	
}
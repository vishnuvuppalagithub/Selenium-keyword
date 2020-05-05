package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class NewTest {
	
	 private static Logger log =LogManager.getLogger(NewTest.class.getName());
	
	
  @Test
  public void f() {
	  System.out.println("This is newtestin test folder");
	  log.info("This is in NewTest Info");
	  log.fatal("This is in NewTest Info");
	  log.error("This is in NewTest Info");
	  log.debug("This is in NewTest Info");
	  
  }
}

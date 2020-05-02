package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.base;

public class Login extends base
{

	
	
@BeforeTest
public void init() throws Exception {
	driver =initialize();
	
}


@Test(dataProvider="data")
public void login(String uid, String pass)

{
driver.get(prop.getProperty("url"));
System.out.println("The user id is:  "+ uid + " The password is :"+pass );
}


@DataProvider(name="data")
public Object[][] getdatafromexcel()
{
	String excelfile = prop.getProperty("filepath");
	excelgetsheet sheet = new excelgetsheet(excelfile);
	Object[][] obj;
	obj = sheet.assign(0);
	return obj;

		
}

	
@AfterTest
public void teardown()
{
	
	driver.quit();
}



}

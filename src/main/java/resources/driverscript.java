package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class driverscript {

	public Workbook ws;
	public Sheet sh;
	public WebDriver driver;
	public Properties prop;
	public base b;
	public WebElement element;

	public final String filepath = "C:\\Users\\vishnu.vuppala\\eclipse-workspace\\keyworddriven\\src\\main\\resources\\Testcase.xlsx";

	public void execute(String sheetname) {

		File f = null;
		try {

			f = new File(filepath);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String extn = null;
		FileInputStream fis = null;
		try {
			String filename = f.getName();
			extn = filename.substring(filename.lastIndexOf("."));
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (extn.equalsIgnoreCase(".xlsx")) {
			try {
				ws = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else if (extn.equalsIgnoreCase(".xls")) {
			try {
				ws = new HSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		sh = ws.getSheet(sheetname);

		for (int i = 0; i < sh.getLastRowNum(); i++) {

			try {
				String locatortype = sh.getRow(i + 1).getCell(1).toString().trim();
				String locatorvalue = sh.getRow(i + 1).getCell(2).toString().trim();
				String action = sh.getRow(i + 1).getCell(3).toString().trim();
				String value = sh.getRow(i + 1).getCell(4).toString().trim();

				switch (action.toLowerCase()) {
				case "open browser":
					b = new base();
					prop = b.init_properties();

					if (value.equals("NA") || value.isEmpty()) {
						driver =b.initialize(prop.getProperty("browser"));

					} else {
						driver = b.initialize(value);
					}

					break;

				case "launch url":
					if (value.equals("NA") || value.isEmpty()) {
						driver.get(prop.getProperty("url"));

					} else {
						driver.get(value);

					}

					break;

				case "quit": 
					driver.quit();
					driver = null;
				

				default:
					break;

				}

				switch (locatortype.toLowerCase()) {

				case "name":
					WebElement element = driver.findElement(By.name(locatorvalue));

					if (action.equalsIgnoreCase("sendkeys")) {
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						element.click();
					} else if (action.equalsIgnoreCase("gettext")) {
						String text = element.getText();
						System.out.println("The value is " + text);
					} else if (action.equalsIgnoreCase("isDisplayed")) {
						Boolean display = element.isDisplayed();
					}
					locatortype=null;
					break;

				case "xpath":
					element = driver.findElement(By.xpath(locatorvalue));

					if (action.equalsIgnoreCase("sendkeys")) {
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						element.click();
					} else if (action.equalsIgnoreCase("gettext")) {
						String text = element.getText();
						System.out.println("The value is " + text);
					} else if (action.equalsIgnoreCase("isDisplayed")) {
						Boolean display = element.isDisplayed();
					}
					locatortype=null;
					break;

				case "linktext":
					element = driver.findElement(By.linkText(locatorvalue));

					if (action.equalsIgnoreCase("sendkeys")) {
						element.sendKeys(value);
					} else if (action.equalsIgnoreCase("click")) {
						element.click();
					} else if (action.equalsIgnoreCase("gettext")) {
						String text = element.getText();
						System.out.println();
					} else if (action.equalsIgnoreCase("isDisplayed")) {
						Boolean display = element.isDisplayed();
					}
					
					
					locatortype=null;
					break;

				default:
					break;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}

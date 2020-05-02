package testcases;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelgetsheet {

	Workbook ws;
	Sheet sh;
	int totalcount;

	public excelgetsheet(String filepath) {
		try {
			File f = new File(filepath);
			String filename = f.getName();
			String extn = filename.substring(filename.lastIndexOf("."));
			FileInputStream fis = new FileInputStream(f);
			if (extn.equalsIgnoreCase(".xlsx")) {
				ws = new XSSFWorkbook(fis);
			}

			else if (extn.equalsIgnoreCase(".xls")) {
				ws = new HSSFWorkbook(fis);
			}

			else {
				throw new Exception();
			}

		} catch (Exception e) {
			System.out.println(e + "It is not an valid excel file");
		}
	}

public Object[][] assign(int sheetnumber)
		
		{
	sh=ws.getSheetAt(sheetnumber);
	int rowcount =sh.getPhysicalNumberOfRows();
	int colcount= sh.getRow(0).getPhysicalNumberOfCells();
	Object[][] obj = new Object[rowcount-1][colcount];
	for (int i=0;i<rowcount-1;i++)
	{
		for (int j=0;j<colcount;j++)
	
		{
			obj[i][j]=sh.getRow(i+1).getCell(j).toString();
			System.out.print("["+i+"]"+"["+j+"]"  +obj[i][j]);
		//	System.out.print("    ");
		}
	}
	return obj;
	//	System.out.println();
	
 	/*
 	
 	
 	for (int i = 0; i < 4; i++) {
		//Loop over all the rows
 		
		Row row = sh.getRow(i+1);
		//Create a loop to print cell values in a row
		for (int j = 0; j < row.getLastCellNum(); j++) {
			//Print excel data in console
			obj[i][j] = row.getCell(j).toString();
			System.out.println(obj[i][j]);
			
	
			
		}
		*/
		
		

		}
}



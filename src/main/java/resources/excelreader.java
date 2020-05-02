package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testcases.excelgetsheet;

public class excelreader {
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		excelgetsheet sheet = new excelgetsheet("C:\\Users\\vishnu.vuppala\\eclipse-workspace\\keyworddriven\\src\\main\\resources\\Testcase.xlsx");
		

		
	}
}

	
				
		
	


		
	


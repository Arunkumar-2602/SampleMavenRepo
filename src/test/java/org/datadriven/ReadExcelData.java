package org.datadriven;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	 public static void main(String[] args) throws IOException {
		
		 String fileLocation = "./Test-data/Login-data.xlsx";
		 
		 XSSFWorkbook wb = new XSSFWorkbook(fileLocation);
		  XSSFSheet sheet = wb.getSheet("Sheet1");
		   int rows = sheet.getPhysicalNumberOfRows();
		    System.out.println("number of rows: " + rows);
		  for (int i = 1; i < rows; i++) {
			XSSFRow row = sheet.getRow(i);
			  int columns = row.getPhysicalNumberOfCells();
			  
			for (int j = 0; j < columns; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter df = new DataFormatter();
				String value = df.formatCellValue(cell);
				//String value = cell.getStringCellValue();
				System.out.println(value);
			}
		}
		//wb.close();
	}
	
}


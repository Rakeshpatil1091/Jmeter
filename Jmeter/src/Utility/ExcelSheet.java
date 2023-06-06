package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet {
	
	static String Nstring;
	public static String getData(int r, int c) throws IOException {
		//public static void main(String[] args) throws IOException {
			
		//}
		File src = new File("C:\\Users\\301584\\eclipse-workspace\\Jmeter\\JMETER_WORK.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet Sheet1 = wb.getSheet("Sheet1");
		
		DataFormatter df = new DataFormatter();
		Nstring = df.formatCellValue(Sheet1.getRow(r).getCell(c));
		//System.out.println(Nstring);
		return(Nstring);
		//if dataformatter not used then
		//String value = Sheet1.getRow(0).getCell(0).getStringCellValue();
		//System.out.println(value);
		
		
	}

}

package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlutils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException
	
	{
		fi = new FileInputStream(xlfile); //loading particular file
		wb = new XSSFWorkbook(fi);  //workbook
		ws= wb.getSheet(xlsheet);   //sheet
		int rowcount=ws.getLastRowNum();  //in worksheet it will go and bring last used data
		return rowcount;
	}
	
public static int getcolCount(String xlfile, String xlsheet, int rownum) throws IOException
	
	{
		fi = new FileInputStream(xlfile); //loading particular file
		wb = new XSSFWorkbook(fi);  //workbook
		ws= wb.getSheet(xlsheet);   //sheet
		row=ws.getRow(rownum);      //to set any row in excel
		int colcount=row.getLastCellNum();  //in worksheet it will go and bring last used data
		return colcount;
	}

public static String getcellvalue(String xlfile, String xlsheet, int rownum, int colnum) throws IOException

{
	fi = new FileInputStream(xlfile); //loading particular file
	wb = new XSSFWorkbook(fi);  //workbook
	ws= wb.getSheet(xlsheet);   //sheet
	row=ws.getRow(rownum);      //to set any row in excel
	cell=row.getCell(colnum);
	String data;
	try {
	DataFormatter formatter = new DataFormatter();
	String celldata = formatter.formatCellValue(cell);
	return celldata;
	}catch(Exception e) {
		data = "";
	}
	
return data;
}
}

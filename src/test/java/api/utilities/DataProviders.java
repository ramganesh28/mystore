package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="userdata")
	public Object[][] getData() throws IOException {
		System.out.println("output of system getproperty" +System.getProperty("user.dir"));
		String excelfilepath = System.getProperty("user.dir")+"\\testdata\\testdata.xlsx";
		String sheetname = "Sheet1";
		int rowcount = xlutils.getRowCount(excelfilepath, sheetname);
		int colcount = xlutils.getcolCount(excelfilepath, sheetname, 1);
		
		
		String[][] data = new String[rowcount][colcount];
		for(int i=1; i<=rowcount; i++) {
			for(int j=0; j<colcount; j++) {
				data[i-1][j]=xlutils.getcellvalue(excelfilepath, sheetname, i, j);
			}
			
		}
			
		
			return data;	
	}
	
	
	@DataProvider(name="usernames")
	public String[] getusernames() throws IOException {
		System.out.println("output of system getproperty" +System.getProperty("user.dir"));
		String excelfilepath = System.getProperty("user.dir")+"\\testdata\\testdata.xlsx";
		String sheetname = "Sheet1";
		int rowcount = xlutils.getRowCount(excelfilepath, sheetname);
		//int colcount = xlutils.getcolCount(excelfilepath, sheetname, 1);
		
		
		String[] data = new String[rowcount];
		for(int i=1; i<=rowcount; i++) {
	
				data[i-1]=xlutils.getcellvalue(excelfilepath, sheetname, i, 0);
				System.out.println("values"+data[i-1]);
			
		}
			
		
			return data;	
	}
}

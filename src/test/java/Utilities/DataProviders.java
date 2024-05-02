package Utilities;

import java.io.IOException;

public class DataProviders {
	
	public String[][] getData() throws IOException {
		
		String path="\\TestData\\myfiles.xlsx";
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcol=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcol];
		
		for(int i=1;i<=totalrows;i++) {
			for(int j=1;j<=totalcol;j++) {
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
	return logindata;
	}
	

}

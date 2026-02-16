package utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

public static Object[][] getExcelData(String filepath,String sheetName) throws Exception	{
	
	
	try {
	FileInputStream fis=new FileInputStream(filepath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sheet=wb.getSheet("Sheet1");
	
	int rows=sheet.getPhysicalNumberOfRows();
	int columns=sheet.getRow(0).getPhysicalNumberOfCells();
	
	Object [][] data=new Object [rows-1][columns];
	
	
	for(int i=1;i<rows;i++) {
		for(int j=0;j<columns;j++) {
			
			Cell cell=sheet.getRow(i).getCell(j);
			if(cell==null) {
				data[i-1][j]="";
				
			}else {
				data[i-j][j]=cell.toString().trim();
			}
		}
	}
	wb.close();
	return data;
}catch(Exception e){
	e.printStackTrace();
    return null;	
}
	
	
	
	
	
	
}}

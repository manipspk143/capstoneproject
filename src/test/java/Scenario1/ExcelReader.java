package Scenario1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader {
  @Test
  public void Excelread() throws IOException {
	  //read the file path
	  File f1=new File(System.getProperty("user.dir")+"//Testdata1//Data2.xlsx");
	  
	  //read the file 
	  FileInputStream fs=new FileInputStream(f1);
	  
//	  //read the sheet
  XSSFWorkbook wb=new XSSFWorkbook(fs);
// XSSFSheet sheet1=wb.getSheet("userdata");
//	XSSFRow row1=sheet1.getRow(0);
//	XSSFCell cell1=row1.getCell(0);
//	
//	String cell=cell1.getStringCellValue();
//	  System.out.println(cell);
  
  //short cut of single row:
//  String text=wb.getSheet("userdata").getRow(0).getCell(0).getStringCellValue();
//  System.out.println("sting cell value:"+text);
////	   
  //no.of rows
	int rows=wb.getSheet("userdata").getPhysicalNumberOfRows();
	System.out.println("Number of rows are :"+rows);
	
	//no.of cells
	int cells=wb.getSheet("userdata").getRow(0).getPhysicalNumberOfCells();
	System.out.println("Number of columns are:"+cells);
	
	//create the object
	Object data[][]= new Object[rows-1][cells];
	
	//iterate the loop write in loop in loop
	for(int i=1;i<rows;i++) {
		for(int j=0;j<cells;j++) {
			data[i-1][j]=wb.getSheet("userdata").getRow(i).getCell(j).getStringCellValue();
			
			System.out.println(data[i-1][j]+"  ");
		}
		System.out.println();
	}
  }
}

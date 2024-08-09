package Scenario1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excelutility{
    @Test
	 public static void capture(WebDriver driver)  {
		  //driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  //driver.get("https:www.amazon.com");
		  
		  TakesScreenshot ts=(TakesScreenshot)driver;
		  
		  File temp=ts.getScreenshotAs(OutputType.FILE);
		  
		  File dest=new File(System.getProperty("user.dir")+"//Screenshots"+System.currentTimeMillis()+".png");
		  
		  try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  System.out.println();
	  }

	public XSSFWorkbook wb;
	
	@DataProvider(name="Exceldata")
	public Object[][] Exceldata() {
		  //read the file path
		  File f1=new File(System.getProperty("user.dir")+"//Testdata1//Data2.xlsx");
		  
		  //read the file 
		  FileInputStream fs;
		  Object data[][]=null;

		try {
			fs= new FileInputStream(f1);
			wb=new XSSFWorkbook(fs);
			int rows=wb.getSheet("userdata").getPhysicalNumberOfRows();
			System.out.println("Number of rows:"+rows);
			
			//no.of cells
			int cells=wb.getSheet("userdata").getRow(0).getPhysicalNumberOfCells();
			System.out.println("Number of cells:"+cells);
			
			//create the object
			 data= new Object[rows-1][cells];
			
			//iterate the loop write in loop in loop
			for(int i=1;i<rows;i++) {
				for(int j=0;j<cells;j++) {
					data[i-1][j]=wb.getSheet("userdata").getRow(i).getCell(j).getStringCellValue();
					
					System.out.println(data[i-1][j]+"  ");
				}
				System.out.println();
			}

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		
//		  //read the sheet
	   // XSSFSheet sheet1=wb.getSheet("userdata");
//		XSSFRow row1=sheet1.getRow(0);
//		XSSFCell cell1=row1.getCell(0);
	//	
//		String cell=cell1.getStringCellValue();
//		  System.out.println(cell);
////		  //no.of rows
				return data;
				
				
	}}

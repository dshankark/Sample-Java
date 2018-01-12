package myproj;

import org.testng.annotations.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Sheet;



import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.lang.reflect.InvocationTargetException;

@Test
public class Driver {
	   
 public  static WebDriver initiatebrowser() {
        System.setProperty("webdriver.chrome.driver","C:\\chrome\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        String url ="http://demo.guru99.com/selenium/newtours/index.php";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
        return driver;
	}


	
	public  static void readEx( ) throws IOException, 
	 IllegalAccessException, IllegalArgumentException, 
	 InvocationTargetException, InstantiationException{
	    	

		    String filePath = System.getProperty("user.dir")+"\\src\\";
		    String fileName="ReadExcel.xlsx";
		    String sheetName="ReadExcel";
            Login lo = new Login ();
	    //Create an object of File class to open xlsx file

	    File file =    new File(filePath+"\\"+fileName);

	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook Readwb = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file

	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class
	    	System.out.println("File is xlsx");

	    Readwb = new XSSFWorkbook(inputStream);

	    }

	    //Check condition if the file is xls file

	    else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of XSSFWorkbook class
	    	System.out.println("File is xls");

	        Readwb = new HSSFWorkbook(inputStream);

	    }

	    //Read sheet inside the workbook by its name

	    Sheet Readws = Readwb.getSheet(sheetName);

	    //Find number of rows in excel file

	    int rowCount = Readws.getLastRowNum()-Readws.getFirstRowNum();
	    int colCount = Readws.getRow(0).getLastCellNum();
	    String[]excelData= new String [colCount];
	    
	    System.out.println("Last row number"+Readws.getLastRowNum()+"FirstRowNum"+Readws.getFirstRowNum());
	    System.out.println("RowCount"+ rowCount);
	    System.out.println("coloumnCount"+ colCount);
	    //Create a loop over all the rows of excel file to read it

	    for (int i = 1; i < rowCount+1; i++) {

	        Row row = Readws.getRow(i);
	       // System.out.println("Lastcell num"+row.getLastCellNum());
	        
	       // System.out.println(row);
	        //Create a loop to print cell values in a row

	        for (int j = 2; j < row.getLastCellNum(); j++) {
	        	
	        
	        	System.out.println("Lastcell no"+row.getLastCellNum());
	            //Print Excel data in console
	        	
	        	XSSFCell cell= (XSSFCell)row.getCell(j);
	        //	String Value= cellToString(cell);
	        	String Value =cell.getStringCellValue().toString();
	        	if(Value != null && Value !="") {
	        	excelData[j]=Value;
	      //  	if(excelData[1].equals("Y")){
	        		
	     //   	System.out.println("Value is  "+excelData[j]);
	        	
	        	lo.enter(excelData);
	        	
	        	}
	        	

	       // 	System.out.print((row.getCell(j).getStringCellValue()).toString()+"|| ");
	            
	       //     System.out.println(i+"   "+j);
	           
	        }

	System.out.println();
	      
	    }

	    


	    
	    System.out.println(filePath);
		
		


	}
}



        
        
        
	
	



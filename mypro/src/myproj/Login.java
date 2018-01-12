package myproj;

import java.util.Arrays;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;

import java.lang.reflect.*;
import java.lang.String;

public class Login extends Driver{
	Driver D = new Driver();
//	WebDriver driver= new ChromeDriver();
	public  void enter (String[] arr) throws IllegalAccessException, 
	 IllegalArgumentException, InvocationTargetException,InstantiationException {
		String funct = "Y";
		String Val;
		Login cls = new Login();
	      Class c = cls.getClass();
	      Object t = c.newInstance();
	      

	                    
	         // parameter type is null
	         

		System.out.println("Array Length"+arr.length);
		
 //     for (int i = 0; i < arr.length; ++i) {
	      for(int j = 0; j < arr.length; j++) {
	        	
	    	   if(arr[j] != null && arr[j] !="") {
	    		   
	           System.out.println("The Login Java value is "+ arr[j]);
	   // 	   if(arr[j].equals(funct)) {
	    //		   System.out.println("Special");
	    		   Val =arr[j];
	    		   System.out.println("The value of "+ Val);
	    		   try {   
	    		   Method m = c.getMethod(Val);
	    		   System.out.println("The value of "+ m);
	    		  
	    		   m.setAccessible(true);
	    		   m.invoke(t);
	    	   
	    		   }   catch(NoSuchMethodException e) {
		    	         System.out.println(e.toString());
	    		   }
	    	//   } 	   	   
	           arr[j]= null;
	           
	    	   }
	       }
	
	      }
	
	public void Register(WebDriver driver){
		System.out.println("Method Register executed successfully 1");
		
	
	try {
		driver.findElement(By.xpath("//*[@href='register.php'][text()='REGISTER']")).click();
		System.out.println("Method Register executed successfully");
	}catch(NoSuchElementException e) {
		System.out.println(e.toString());
	}
		
	}
	
	public void Contact() {
		WebDriver driver = null;
		driver.findElement(By.xpath("//*[@href='support.php'][text()='CONTACT']")).click();
		System.out.println("Method Contact executed successfully");
	}
	
	public void notexecute() {
		System.out.println("Method notexecute executed successfully");
	}
}  










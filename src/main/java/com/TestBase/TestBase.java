//propertie = class;
//Rclick surround with try catch
//create constructor to cotact with Properties

//property file how work = key and pair
// why use static variable here?
package com.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;							//2 subclass of hash table communicate read/write with config.properties
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;					//5 import WebDriver to launch web browsers
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.TestUtil.TestUtil;

public class TestBase {
	
// GET DATA FROM CONFIG FILE	
	public static Properties prop;  					//3 make Properties global for all classes (Properties is class, data type String, int, char)
	public static WebDriver driver;						//4 make WebDriver global
	public TestBase() {									//0 create Constructor
		prop = new Properties(); 						//1 create Properties object (like Scanner)
		try {											//8 Rclick surround with try/catch
			FileInputStream fle=new FileInputStream		//6 add FileInputStream (not global) to read Config file. from Apache POI
					("C:\\Users\\Stacie\\eclipse-workspace\\dell.qa\\src\\main\\java\\com\\ConFig\\Config properties");//Rclick property copy path
			prop.load(fle); 							//7 load method from Properties to read Config file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void initil() {
		String browser = prop.getProperty("browser");
		
		if (browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver","\\C:\\Driver\\chromedriver.exe\\");
			driver = new ChromeDriver();  		
		}	
		else if (browser.equalsIgnoreCase("FireFox")){
			System.setProperty("webdriver.gecko.driver","\\C:\\Driver\\geckodriver.exe\\");
			driver = new FirefoxDriver(); 
		}
//		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOADOUTTIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait (TestUtil.IMPLICITYWAIT, TimeUnit.SECONDS); 
		driver.get(prop.getProperty("url"));
	}			
}
                                                                                                                                          

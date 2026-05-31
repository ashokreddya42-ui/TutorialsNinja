package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import com.tutorialsninja.qa.utilits.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	

	WebDriver driver;
	
	public Properties prop;
	public Properties DataProp; 
	public Base() {
	    prop=new Properties();
		File file1=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		DataProp =new Properties();
	
		File file2 =new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		try {
		FileInputStream datafis=new FileInputStream(file2);
		DataProp.load(datafis);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		
		try {
		FileInputStream fis=new FileInputStream(file1);
		prop.load(fis);
		}
		catch(Throwable e){
			e.printStackTrace();
		}
		
	}
	public WebDriver initializeBrowserandOpenApplicationURL(String browserName) {
		
		
		if(browserName.equalsIgnoreCase("Chrome")) {
		   driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("safari")) {
			driver=new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		return driver;
	}
}

package com.hms.Hospital_Management_System.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public FileUtility fileUtility = new FileUtility();
	public WebDriverUtility webDriverUtility = new WebDriverUtility();
	public ExcelUtility excelUtility = new ExcelUtility();

	
	@BeforeSuite
	public void config_BS() {
		System.out.println("-- DataBase is connected.--");
	}

	//@Parameters("browser")
	@BeforeClass
	public void config_BC(/*String browser*/) throws IOException {
		String browser = fileUtility.getPropertyData("browser");
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	}

	@BeforeMethod
	public void config_BM() throws Throwable {
		driver.get(fileUtility.getPropertyData("url"));
	}

	@AfterMethod
	public void config_AM() {
		System.out.println("--Logout Operation performed.--");
	}

	@AfterClass
	public void config_AC() {
		driver.quit();
	}

	@AfterSuite
	public void config_AS() {
		Reporter.log("--DataBase Disconnected.--",true);
		System.out.println("--DataBase Disconnected.--");
	}

}

//package com.hms.Hospital_Management_System.doctorsPom;
//
//import java.io.IOException;
//
//import org.openqa.selenium.WebDriver;
//
//import com.hms.Hospital_Management_System.genericUtility.FileUtility;
//import com.hms.Hospital_Management_System.genericUtility.WebDriverUtility;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class PatientLogIn {
//
//	public static void main(String[] args) throws IOException {
//		FileUtility fileUtility = new FileUtility();
//		String URL = fileUtility.getPropertyData("url");
//		String BROWSER = fileUtility.getPropertyData("browser");
//		String ADMINLOGINID = fileUtility.getPropertyData("adminLoginID");
//		String ADMINPASSWORD = fileUtility.getPropertyData("adminPassword");
//		String PTLOGINID = fileUtility.getPropertyData("ptLoginID");
//		String PTPASSWORD = fileUtility.getPropertyData("ptPassword");
//		String DOCLOGINID = fileUtility.getPropertyData("docLoginID");
//
//		String DOCPASSWORD = fileUtility.getPropertyData("docPassword");
//
//		// open the chrome browser.
//		WebDriver driver = WebDriverManager.chromedriver().create();
//
//		// Maximize the window.
//		WebDriverUtility webDriverUtility = new WebDriverUtility();
//		driver.manage().window().maximize();
//		// Giving implicitly wait.
//		webDriverUtility.waitTillPageGetLoad(driver);
//
//		// enter the url.
//		driver.get(URL);
//
//		// Varifing weather home page is displayed or not.
//		String homePageUrl = driver.getCurrentUrl();
//		if (homePageUrl.contains("Hospital_Management_System")) {
//			System.out.println("Hospital_Management_System web applications home page is displayed.");
//		}
//
//	}
//
//}

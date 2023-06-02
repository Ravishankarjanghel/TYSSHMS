package com.hms.Hospital_Management_System2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hms.Hospital_Management_System.genericUtility.BaseClass;
import com.hms.Hospital_Management_System.genericUtility.FileUtility;
import com.hms.Hospital_Management_System.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PatientLogIn extends BaseClass {

	@Test(groups = "regTest")
	public void patientLogIn() throws IOException {
		FileUtility fileUtility = new FileUtility();
		String URL = fileUtility.getPropertyData("url");
		String BROWSER = fileUtility.getPropertyData("browser");
		String ADMINLOGINID = fileUtility.getPropertyData("adminLoginID");
		String ADMINPASSWORD = fileUtility.getPropertyData("adminPassword");
		String PTLOGINID = fileUtility.getPropertyData("ptLoginID");
		String PTPASSWORD = fileUtility.getPropertyData("ptPassword");
		String DOCLOGINID = fileUtility.getPropertyData("docLoginID");

		String DOCPASSWORD = fileUtility.getPropertyData("docPassword");

		// open the chrome browser.
		WebDriver driver = WebDriverManager.chromedriver().create();

		// Maximize the window.
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		driver.manage().window().maximize();
		// Giving implicitly wait.
		webDriverUtility.waitTillPageGetLoad(driver);

		// enter the url.
		driver.get(URL);

		// Varifing weather home page is displayed or not.
		String homePageUrl = driver.getCurrentUrl();
		Assert.assertTrue(homePageUrl.contains("Hospital_Management_System"), "Hospital_Management_System web applications home page is not displayed.");
		if (homePageUrl.contains("Hospital_Management_System")) {
			Reporter.log("Hospital_Management_System web applications home page is displayed.",true);
		}

		Reporter.log("Testcase passed.",true);
	}

}

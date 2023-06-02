package com.hms.Hospital_Management_System.ExecutionWithBaseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hms.Hospital_Management_System.genericUtility.BaseClass;
import com.hms.Hospital_Management_System.genericUtility.FileUtility;
import com.hms.Hospital_Management_System.genericUtility.WebDriverUtility;
import com.hms.Hospital_Management_System.pom.DoctorHomePage;
import com.hms.Hospital_Management_System.pom.DoctorLogInPage;
import com.hms.Hospital_Management_System.pom.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoctorLogIn extends BaseClass {

	@Test
	public void doctorLogIn() throws IOException {
		String DOCLOGINID = fileUtility.getPropertyData("docLoginID");
		String DOCPASSWORD = fileUtility.getPropertyData("docPassword");

		// Maximize the window.
		driver.manage().window().maximize();
		
		// Giving implicitly wait.
		webDriverUtility.waitTillPageGetLoad(driver);

		// Varifing weather home page is displayed or not.
		String homePageUrl = driver.getCurrentUrl();
		Assert.assertTrue(homePageUrl.contains("Hospital_Management_System"), "Hospital_Management_System web applications home page is not displayed.");
		if (homePageUrl.contains("Hospital_Management_System")) {
			Reporter.log("Hospital_Management_System web applications home page is displayed.",true);
		}

		HomePage homePage = new HomePage(driver);
		homePage.getDoctorGotoPageButton().click();

		DoctorLogInPage doctorLogInPage = new DoctorLogInPage(driver);
		doctorLogInPage.getDoctorUserNameTextField().sendKeys(DOCLOGINID);
		doctorLogInPage.getDoctorPasswordTextfield().sendKeys(DOCPASSWORD);
		doctorLogInPage.getDoctorLoginButton().click();

		DoctorHomePage doctorHomePage = new DoctorHomePage(driver);
		doctorHomePage.getUserNameIcon().click();
		doctorHomePage.getMyProfileOption().click();

		Reporter.log("Test case passed.",true);
	}

}

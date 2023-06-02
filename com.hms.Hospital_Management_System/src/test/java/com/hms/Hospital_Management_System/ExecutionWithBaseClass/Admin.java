package com.hms.Hospital_Management_System.ExecutionWithBaseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hms.Hospital_Management_System.genericUtility.BaseClass;
import com.hms.Hospital_Management_System.genericUtility.FileUtility;
import com.hms.Hospital_Management_System.genericUtility.WebDriverUtility;
import com.hms.Hospital_Management_System.pom.AdminLogInPage;
import com.hms.Hospital_Management_System.pom.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Admin extends BaseClass{

	@Test(groups = "smokeTest")
	public void adminLogin() throws IOException {
		
		
		String ADMINLOGINID = fileUtility.getPropertyData("adminLoginID");
		String ADMINPASSWORD = fileUtility.getPropertyData("adminPassword");

		// Maximize the window.
		webDriverUtility.maximizeWindow(driver);

		// Giving implicitly wait.
		webDriverUtility.waitTillPageGetLoad(driver);


		// Varifing weather home page is displayed or not.
		String homePageUrl = driver.getCurrentUrl();
		Assert.assertTrue(homePageUrl.contains("Hospital_Management_System"), "Hospital_Management_System web applications home page is not displayed.");
		if (homePageUrl.contains("Hospital_Management_System")) {
			Reporter.log("Hospital_Management_System web applications home page is displayed.",true);
		}

		HomePage homePage = new HomePage(driver);
		homePage.getAdminGotoPageButton().click();

		String adminLoginPageUrl = driver.getCurrentUrl();
		Assert.assertTrue(adminLoginPageUrl.contains("Hospital_Management_System/hms/admin"), "Admin Login page is not displayed.");
		if (adminLoginPageUrl.contains("Hospital_Management_System/hms/admin")) {
			Reporter.log("Admin Login page is displayed.",true);
		}

		AdminLogInPage adminLogInPage = new AdminLogInPage(driver);
		adminLogInPage.getAdminUserNameTextField().sendKeys(ADMINLOGINID);
		adminLogInPage.getAdminPasswordTextfield().sendKeys(ADMINPASSWORD);
		adminLogInPage.getAdminLoginButton().click();

		String adminDashBoardPageUrl = driver.getCurrentUrl();
		Assert.assertTrue(adminDashBoardPageUrl.contains("Hospital_Management_System/hms/admin/dashboard"), "Admin dashboard page is not displayed.");
		
		if (adminDashBoardPageUrl.contains("Hospital_Management_System/hms/admin/dashboard")) {
			Reporter.log("Admin dashboard page is displayed.",true);
		}
		Reporter.log("Test Case Passed.",true);
	}

}

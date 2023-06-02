//package com.hms.Hospital_Management_System.doctorsPom;
//
//import java.io.IOException;
//
//import org.openqa.selenium.WebDriver;
//
//import com.hms.Hospital_Management_System.genericUtility.FileUtility;
//import com.hms.Hospital_Management_System.genericUtility.WebDriverUtility;
//import com.hms.Hospital_Management_System.pom.AdminLogInPage;
//import com.hms.Hospital_Management_System.pom.HomePage;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class AdminLogIn {
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
//		HomePage homePage = new HomePage(driver);
//		homePage.getAdminGotoPageButton().click();
//
//		String adminLoginPageUrl = driver.getCurrentUrl();
//		if (adminLoginPageUrl.contains("Hospital_Management_System/hms/admin")) {
//			System.out.println("Admin Login page is displayed.");
//		}
//
//		AdminLogInPage adminLogInPage = new AdminLogInPage(driver);
//		adminLogInPage.getAdminUserNameTextField().sendKeys(ADMINLOGINID);
//		adminLogInPage.getAdminPasswordTextfield().sendKeys(ADMINPASSWORD);
//		adminLogInPage.getAdminLoginButton().click();
//
//		String adminDashBoardPageUrl = driver.getCurrentUrl();
//
//		if (adminDashBoardPageUrl.contains("Hospital_Management_System/hms/admin/dashboard")) {
//			System.out.println("Admin dashboard page is displayed.");
//		}
//	}
//
//}

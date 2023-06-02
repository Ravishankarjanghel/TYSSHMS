//package com.hms.Hospital_Management_System.doctorsPom;
//
//import java.io.IOException;
//
//import org.openqa.selenium.WebDriver;
//
//import com.hms.Hospital_Management_System.genericUtility.FileUtility;
//import com.hms.Hospital_Management_System.genericUtility.WebDriverUtility;
//import com.hms.Hospital_Management_System.pom.DoctorHomePage;
//import com.hms.Hospital_Management_System.pom.DoctorLogInPage;
//import com.hms.Hospital_Management_System.pom.HomePage;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class DoctorLogIn {
//
//	public static void main(String[] args) throws IOException {
//		FileUtility fileUtility = new FileUtility();
//		String URL = fileUtility.getPropertyData("url");
//		String BROWSER = fileUtility.getPropertyData("browser");
//		String DOCLOGINID = fileUtility.getPropertyData("docLoginID");
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
//		homePage.getDoctorGotoPageButton().click();
//
//		DoctorLogInPage doctorLogInPage = new DoctorLogInPage(driver);
//		doctorLogInPage.getDoctorUserNameTextField().sendKeys(DOCLOGINID);
//		doctorLogInPage.getDoctorPasswordTextfield().sendKeys(DOCPASSWORD);
//		doctorLogInPage.getDoctorLoginButton().click();
//
//		DoctorHomePage doctorHomePage = new DoctorHomePage(driver);
//		doctorHomePage.getUserNameIcon().click();
//		doctorHomePage.getMyProfileOption().click();
//
//	}
//
//}

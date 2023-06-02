//package com.hms.Hospital_Management_System.ExecutionWithBaseClass;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.Reporter;
//import org.testng.annotations.Test;
//
//import com.hms.Hospital_Management_System.genericUtility.BaseClass;
//import com.hms.Hospital_Management_System.genericUtility.ExcelUtility;
//import com.hms.Hospital_Management_System.genericUtility.FileUtility;
//import com.hms.Hospital_Management_System.genericUtility.JavaUtility;
//import com.hms.Hospital_Management_System.genericUtility.WebDriverUtility;
//import com.hms.Hospital_Management_System.pom.AdminHomePage;
//import com.hms.Hospital_Management_System.pom.AdminLogInPage;
//import com.hms.Hospital_Management_System.pom.HomePage;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class CreateDoctorSpecialization extends BaseClass {
//
//	@Test(groups = "smokeTest")
//	public void createDoctor() throws EncryptedDocumentException, IOException {
//		String ADMINLOGINID = fileUtility.getPropertyData("adminLoginID");
//		String ADMINPASSWORD = fileUtility.getPropertyData("adminPassword");
//		
//		String dcSp = excelUtility.getExcelData("CreatingDoctorAndBookingAppoint", 1, 0);
//
//		JavaUtility ran = new JavaUtility();
//		int r = ran.getRandomNumber();
//		
//		WebDriverUtility wdu = new WebDriverUtility();
//		wdu.maximizeWindow(driver);
//		wdu.waitTillPageGetLoad(driver);
//
//		
//		String homePageUrl = driver.getCurrentUrl();
//		Assert.assertTrue(homePageUrl.contains("Hospital_Management_System"), "Hospital_Management_System web applications home page is not displayed.");
//		if (homePageUrl.contains("Hospital_Management_System")) {
//			Reporter.log("Hospital_Management_System web applications home page is displayed.",true);
//		}
//		HomePage homePage = new HomePage(driver);
//		homePage.getAdminGotoPageButton().click();
//		
//		String adminLoginPageUrl = driver.getCurrentUrl();
//		Assert.assertTrue(adminLoginPageUrl.contains("Hospital_Management_System/hms/admin"), "Admin Login page is not displayed.");
//		if (adminLoginPageUrl.contains("Hospital_Management_System/hms/admin")) {
//			Reporter.log("Admin Login page is displayed.",true);
//		}
//
//		AdminLogInPage adminLogInPage = new AdminLogInPage(driver);
//		adminLogInPage.getAdminUserNameTextField().sendKeys(ADMINLOGINID);
//		adminLogInPage.getAdminPasswordTextfield().sendKeys(ADMINPASSWORD);
//		adminLogInPage.getAdminLoginButton().click();
//		
//		String adminDashBoardPageUrl = driver.getCurrentUrl();
//		
//		Assert.assertTrue(adminDashBoardPageUrl.contains("Hospital_Management_System/hms/admin/dashboard"), "Admin dashboard page is not displayed.");
//
//		if (adminDashBoardPageUrl.contains("Hospital_Management_System/hms/admin/dashboard")) {
//			Reporter.log("Admin dashboard page is displayed.",true);
//		}
//
//		AdminHomePage adminHomePage = new AdminHomePage(driver);
//		adminHomePage.getDoctorsMenu().click();
//		adminHomePage.getDoctorSpecializationSubMenu().click();
//		
//		String doctorSpecializationUrl = driver.getCurrentUrl();
//
//		Assert.assertTrue(doctorSpecializationUrl.contains("doctor-specilization"), "Doctors specialization page is not displayed.");
//		if (doctorSpecializationUrl.contains("doctor-specilization")) {
//			Reporter.log("Doctors specialization page is displayed.",true);
//		}
//
//		dcSp = dcSp+r;
//		
//		driver.findElement(By.name("doctorspecilization")).sendKeys(dcSp);
//		driver.findElement(By.name("submit")).click();
//		String dSMsg = driver
//				.findElement(By.xpath("//p[normalize-space(text()='Doctor Specialization added successfully !!')]"))
//				.getText();
//		dSMsg = dSMsg.trim();
//		List<WebElement> allSpecialization = driver
//				.findElements(By.xpath("//td[@class='center']/following-sibling::td[@class='hidden-xs']"));
//		List<String> allSpecializationText = allSpecialization.stream().map(i -> i.getText())
//				.collect(Collectors.toList());
//
//		Assert.assertTrue(dSMsg.equalsIgnoreCase("Doctor Specialization added successfully !!"), "Doctor Specialization added successfully. and message have came.");
//		if (dSMsg.equalsIgnoreCase("Doctor Specialization added successfully !!")) {
//			Reporter.log("Doctor Specialization added successfully. and message have came.",true);
//		}
//
//		boolean flag = false;
//		for (String i : allSpecializationText) {
//			if (i.equalsIgnoreCase(dcSp)) {
//				Reporter.log("Doctor Specialization added successfully. Showing On the List of Specialization.",true);
//				flag=true;
//				break;
//			}
//		}
//		if(!flag) {
//			Assert.fail("Doctor Specialization added successfully. Showing On the List of Specialization.");
//		}
//			
//		
//		adminHomePage.getDoctorsMenu().click();
//		adminHomePage.getAddDoctorSubMenu().click();
//		
//		String addDoctorpageUrl = driver.getCurrentUrl();
//		Assert.assertTrue(addDoctorpageUrl.contains("add-doctor"), "Add doctor page is not displayed.");
//		if (addDoctorpageUrl.contains("add-doctor")) {
//			Reporter.log("Add doctor page is displayed.",true);
//		}
//		Reporter.log("Test case passed", true);
//
//	}
//
//}

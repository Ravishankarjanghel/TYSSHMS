//package com.hms.Hospital_Management_System.ExecutionWithBaseClass;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
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
//import com.hms.Hospital_Management_System.pom.PatientLogInpage;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class CreateDoctorAndBookingAppointment extends BaseClass {
//
//	@Test
//	public void createDoctorAndBookingAppointment() throws IOException {
//		
//		
//		String ADMINLOGINID = fileUtility.getPropertyData("adminLoginID");
//		String ADMINPASSWORD = fileUtility.getPropertyData("adminPassword");
//		String PTLOGINID = fileUtility.getPropertyData("ptLoginID");
//		String PTPASSWORD = fileUtility.getPropertyData("ptPassword");
//		
//		ExcelUtility eu = new ExcelUtility();
//		String dcSp = eu.getExcelData("CreatingDoctorAndBookingAppoint", 1, 0);
//		String doctor = eu.getExcelData("CreatingDoctorAndBookingAppoint", 1, 1);
//		String cliAdd = eu.getExcelData("CreatingDoctorAndBookingAppoint", 1, 2);
//		String docFee = eu.getExcelData("CreatingDoctorAndBookingAppoint", 1, 3);
//		String docContact = eu.getExcelData("CreatingDoctorAndBookingAppoint", 1, 4);
//		String docEmail = eu.getExcelData("CreatingDoctorAndBookingAppoint", 1, 5);
//		String nPass = eu.getExcelData("CreatingDoctorAndBookingAppoint", 1, 6);
//		String cPass = eu.getExcelData("CreatingDoctorAndBookingAppoint", 1, 7);
//
//		JavaUtility ran = new JavaUtility();
//		int r = ran.getRandomNumber();
//		webDriverUtility.maximizeWindow(driver);
//		webDriverUtility.waitTillPageGetLoad(driver);
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
//		Assert.assertTrue(adminDashBoardPageUrl.contains("Hospital_Management_System/hms/admin/dashboard"), "Admin dashboard page is displayed.");
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
//		Assert.assertTrue(doctorSpecializationUrl.contains("doctor-specilization"),"Doctors specialization page is not displayed." );
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
//		Assert.assertTrue(dSMsg.equalsIgnoreCase("Doctor Specialization added successfully !!"), "Expected message didn't came.");
//		if (dSMsg.equalsIgnoreCase("Doctor Specialization added successfully !!")) {
//			Reporter.log("Doctor Specialization added successfully. and message have came.",true);
//		}
//		boolean flag = false;
//		for (String i : allSpecializationText) {
//			if (i.equalsIgnoreCase(dcSp)) {
//				Reporter.log("Doctor Specialization added successfully. Showing On the List of Specialization.",true);
//				flag = true;
//				break;
//			}
//		}
//		if(!flag) {
//			Assert.fail("Doctor Specialization is not added successfully. Not Showing On the List of Specialization.");
//		}
//		
//		
//		adminHomePage.getDoctorsMenu().click();
//		adminHomePage.getAddDoctorSubMenu().click();
//		
//		String addDoctorpageUrl = driver.getCurrentUrl();
//		Assert.assertTrue(addDoctorpageUrl.contains("add-doctor"), "Add doctor page is not displayed.");
//		if (addDoctorpageUrl.contains("add-doctor")) {
//			Reporter.log("Add doctor page is displayed.");
//		}
//
//		webDriverUtility.selectElementInDropDown(dcSp, driver.findElement(By.name("Doctorspecialization")));
//		
//		driver.findElement(By.name("docname")).sendKeys(doctor+r);
//
//		driver.findElement(By.name("clinicaddress")).sendKeys(cliAdd+r);
//
//		driver.findElement(By.name("docfees")).sendKeys(docFee+r);
//
//		driver.findElement(By.name("doccontact")).sendKeys(docContact+r);
//		String[] temp = docEmail.split("@");
//		docEmail = temp[0]+r+"@"+temp[1];
//		driver.findElement(By.name("docemail")).sendKeys(docEmail);
//
//		driver.findElement(By.name("npass")).sendKeys(nPass);
//
//		driver.findElement(By.name("cfpass")).sendKeys(cPass);
//		
//		driver.findElement(By.name("submit")).click();
//		
//		String addDoctorAlertText = driver.switchTo().alert().getText();
//		driver.switchTo().alert().accept();
//
//		Assert.assertTrue(addDoctorAlertText.contains("Doctor info added Successfully"), "Alert has came. Doctor is not Added successfully.");
//		if (addDoctorAlertText.contains("Doctor info added Successfully")) {
//			Reporter.log("Alert has came. Doctor Added successfully.",true);
//		}
//
//		String manageDoctorHeading = driver.findElement(By.xpath("//section[@id='page-title']//h1")).getText();
//		
//		Assert.assertTrue(manageDoctorHeading.contains("ADMIN | MANAGE DOCTORS"), "Manage doctor page is not displayed.");
//		if (manageDoctorHeading.contains("Admin | Manage Doctors")) {
//			Reporter.log("Manage doctor page is displayed.",true);
//		}
//
//		driver.findElement(By.xpath("//span[@class='username']")).click();
//
//		driver.findElement(By.xpath("//li/a[contains(text(),'Log Out')]")).click();
//
//		String homePageUrl1 = driver.getCurrentUrl();
//
//		Assert.assertTrue(homePageUrl1.contains("Hospital_Management_System"), "Hospital_Management_System web applications home page is displayed.");
//		if (homePageUrl1.contains("Hospital_Management_System")) {
//			Reporter.log("Hospital_Management_System web applications home page is displayed.",true);
//		}
//		
//		homePage.getPatientGotoPageButton().click();
//		String patientLoginPageUrl = driver.getCurrentUrl();
//
//		Assert.assertTrue(patientLoginPageUrl.contains("Hospital_Management_System/hms/user-login"), "Patient login page is not displayed.");
//		if (patientLoginPageUrl.contains("Hospital_Management_System/hms/user-login")) {
//			Reporter.log("Patient login page is displayed.",true);
//		}
//
//		PatientLogInpage patientLogInpage = new PatientLogInpage(driver);
//		patientLogInpage.getPatientUserNameTextField().sendKeys(PTLOGINID);
//		patientLogInpage.getPatientPasswordTextfield().sendKeys(PTPASSWORD);
//		patientLogInpage.getPatientLoginButton().click();
//		
//		Reporter.log("Test case passed", true);
//	}
//
//}

package com.hms.Hospital_Management_System2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hms.Hospital_Management_System.genericUtility.BaseClass;
import com.hms.Hospital_Management_System.genericUtility.ExcelUtility;
import com.hms.Hospital_Management_System.genericUtility.FileUtility;
import com.hms.Hospital_Management_System.genericUtility.JavaUtility;
import com.hms.Hospital_Management_System.genericUtility.WebDriverUtility;
import com.hms.Hospital_Management_System.pom.AdminHomePage;
import com.hms.Hospital_Management_System.pom.AdminLogInPage;
import com.hms.Hospital_Management_System.pom.DoctorHomePage;
import com.hms.Hospital_Management_System.pom.DoctorLogInPage;
import com.hms.Hospital_Management_System.pom.EditDoctorPage;
import com.hms.Hospital_Management_System.pom.HomePage;
import com.hms.Hospital_Management_System.pom.PatientLogInpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HMSTestCaseTest extends BaseClass {

	@Test
	public void adminLogin() throws IOException {

		String ADMINLOGINID = fileUtility.getPropertyData("adminLoginID");
		String ADMINPASSWORD = fileUtility.getPropertyData("adminPassword");

		// Maximize the window.
		webDriverUtility.maximizeWindow(driver);

		// Giving implicitly wait.
		webDriverUtility.waitTillPageGetLoad(driver);

		// Varifing weather home page is displayed or not.
		String homePageUrl = driver.getCurrentUrl();
		Assert.assertTrue(homePageUrl.contains("Hospital_Management_System"),
				"Hospital_Management_System web applications home page is not displayed.");
		if (homePageUrl.contains("Hospital_Management_System")) {
			Reporter.log("Hospital_Management_System web applications home page is displayed.", true);
		}

		HomePage homePage = new HomePage(driver);
		homePage.getAdminGotoPageButton().click();

		String adminLoginPageUrl = driver.getCurrentUrl();
		Assert.assertTrue(adminLoginPageUrl.contains("Hospital_Management_System/hms/admin"),
				"Admin Login page is not displayed.");
		if (adminLoginPageUrl.contains("Hospital_Management_System/hms/admin")) {
			Reporter.log("Admin Login page is displayed.", true);
		}

		AdminLogInPage adminLogInPage = new AdminLogInPage(driver);
		adminLogInPage.getAdminUserNameTextField().sendKeys(ADMINLOGINID);
		adminLogInPage.getAdminPasswordTextfield().sendKeys(ADMINPASSWORD);
		adminLogInPage.getAdminLoginButton().click();

		String adminDashBoardPageUrl = driver.getCurrentUrl();
		Assert.assertTrue(adminDashBoardPageUrl.contains("Hospital_Management_System/hms/admin/dashboard"),
				"Admin dashboard page is not displayed.");

		if (adminDashBoardPageUrl.contains("Hospital_Management_System/hms/admin/dashboard")) {
			Reporter.log("Admin dashboard page is displayed.", true);
		}
		Reporter.log("Test Case Passed.", true);
	}

	@Test
	public void bookAppointmentCancelAppointment() throws Throwable {

		String URL = fileUtility.getPropertyData("url");
		String PTLOGINID = fileUtility.getPropertyData("ptLoginID");
		String PTPASSWORD = fileUtility.getPropertyData("ptPassword");

		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\hmsTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Row row = wb.getSheet("BookAppointmentCancelAppointmen").getRow(1);
		int day = (int) row.getCell(0).getNumericCellValue();
		String time = row.getCell(1).toString();
		String h = time.split(":")[0];
		String m = time.split(":")[1].replaceAll("[^0-9]", "");
		String ampm = time.replace("[^A-Za-z]", "");

		// Maximize the window.
		webDriverUtility.maximizeWindow(driver);

		// Giving implicitly wait.
		webDriverUtility.waitTillPageGetLoad(driver);

		// Varifing weather home page is displayed or not.
		String homePageUrl = driver.getCurrentUrl();
		Assert.assertTrue(homePageUrl.contains("Hospital_Management_System"),
				"Hospital_Management_System web applications home page is not displayed.");
		if (homePageUrl.contains("Hospital_Management_System")) {
			Reporter.log("Hospital_Management_System web applications home page is displayed.", true);
		}

		// clicking to the patients module
		driver.findElement(By.xpath("//h3[text()='Patients']/..//a")).click();

		String url1 = driver.getCurrentUrl();
		Assert.assertTrue(url1.contains("s/user-login.php"), "Patient LogIn page is not displayed.");
		if (url1.contains("s/user-login.php")) {
			Reporter.log("Booking appionment is displayed", true);
		}
		// giving valid credentials
		driver.findElement(By.name("username")).sendKeys(PTLOGINID);
		driver.findElement(By.name("password")).sendKeys(PTPASSWORD);
		driver.findElement(By.xpath("//button[@class='btn btn-primary pull-right']")).click();
		// click on book appionment
		driver.findElement(By.xpath("//span[text()=' Book Appointment ']")).click();
		// fill up all the data
		WebElement source = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
		Select s = new Select(source);
		s.selectByValue("Dermatologist");
		driver.findElement(By.name("appdate")).click();
		driver.findElement(By.xpath("//td[@class='day' and text()='" + day + "']")).click();
		driver.findElement(By.id("timepicker1")).click();
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-hour form-control']")).sendKeys(h);
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-minute form-control']")).sendKeys(m);
		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-meridian form-control']")).sendKeys(ampm);
		driver.findElement(By.name("submit")).submit();
		// click on appiontment history
		driver.findElement(By.xpath("//span[text()=' Appointment History ']")).click();
		driver.findElement(By.xpath("(//a[text()='Cancel'])[1]")).click();
		Alert a = driver.switchTo().alert();
		a.accept();
		// logout the application
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();

		// Checking weather homepage is displayed or not.
		String homePageUrl2 = driver.getCurrentUrl();
		Assert.assertTrue(homePageUrl2.contains("Hospital_Management_System"),
				"Hospital_Management_System web applications home page is not displayed.");
		if (homePageUrl2.contains("Hospital_Management_System")) {
			Reporter.log("Hospital_Management_System web applications home page is displayed.", true);
		}
		Reporter.log("Test case passed", true);

	}

//	@Test
//	public void createDoctorAndBookingAppointment() throws IOException {
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
//		Assert.assertTrue(homePageUrl.contains("Hospital_Management_System"),
//				"Hospital_Management_System web applications home page is not displayed.");
//		if (homePageUrl.contains("Hospital_Management_System")) {
//			Reporter.log("Hospital_Management_System web applications home page is displayed.", true);
//		}
//		HomePage homePage = new HomePage(driver);
//		homePage.getAdminGotoPageButton().click();
//
//		String adminLoginPageUrl = driver.getCurrentUrl();
//		Assert.assertTrue(adminLoginPageUrl.contains("Hospital_Management_System/hms/admin"),
//				"Admin Login page is not displayed.");
//		if (adminLoginPageUrl.contains("Hospital_Management_System/hms/admin")) {
//			Reporter.log("Admin Login page is displayed.", true);
//		}
//
//		AdminLogInPage adminLogInPage = new AdminLogInPage(driver);
//		adminLogInPage.getAdminUserNameTextField().sendKeys(ADMINLOGINID);
//		adminLogInPage.getAdminPasswordTextfield().sendKeys(ADMINPASSWORD);
//		adminLogInPage.getAdminLoginButton().click();
//
//		String adminDashBoardPageUrl = driver.getCurrentUrl();
//
//		Assert.assertTrue(adminDashBoardPageUrl.contains("Hospital_Management_System/hms/admin/dashboard"),
//				"Admin dashboard page is displayed.");
//		if (adminDashBoardPageUrl.contains("Hospital_Management_System/hms/admin/dashboard")) {
//			Reporter.log("Admin dashboard page is displayed.", true);
//		}
//
//		AdminHomePage adminHomePage = new AdminHomePage(driver);
//		adminHomePage.getDoctorsMenu().click();
//		adminHomePage.getDoctorSpecializationSubMenu().click();
//
//		String doctorSpecializationUrl = driver.getCurrentUrl();
//
//		Assert.assertTrue(doctorSpecializationUrl.contains("doctor-specilization"),
//				"Doctors specialization page is not displayed.");
//		if (doctorSpecializationUrl.contains("doctor-specilization")) {
//			Reporter.log("Doctors specialization page is displayed.", true);
//		}
//
//		dcSp = dcSp + r;
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
//		Assert.assertTrue(dSMsg.equalsIgnoreCase("Doctor Specialization added successfully !!"),
//				"Expected message didn't came.");
//		if (dSMsg.equalsIgnoreCase("Doctor Specialization added successfully !!")) {
//			Reporter.log("Doctor Specialization added successfully. and message have came.", true);
//		}
//		boolean flag = false;
//		for (String i : allSpecializationText) {
//			if (i.equalsIgnoreCase(dcSp)) {
//				Reporter.log("Doctor Specialization added successfully. Showing On the List of Specialization.", true);
//				flag = true;
//				break;
//			}
//		}
//		if (!flag) {
//			Assert.fail("Doctor Specialization is not added successfully. Not Showing On the List of Specialization.");
//		}
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
//		driver.findElement(By.name("docname")).sendKeys(doctor + r);
//
//		driver.findElement(By.name("clinicaddress")).sendKeys(cliAdd + r);
//
//		driver.findElement(By.name("docfees")).sendKeys(docFee + r);
//
//		driver.findElement(By.name("doccontact")).sendKeys(docContact + r);
//		String[] temp = docEmail.split("@");
//		docEmail = temp[0] + r + "@" + temp[1];
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
//		Assert.assertTrue(addDoctorAlertText.contains("Doctor info added Successfully"),
//				"Alert has came. Doctor is not Added successfully.");
//		if (addDoctorAlertText.contains("Doctor info added Successfully")) {
//			Reporter.log("Alert has came. Doctor Added successfully.", true);
//		}
//
//		String manageDoctorHeading = driver.findElement(By.xpath("//section[@id='page-title']//h1")).getText();
//
//		Assert.assertTrue(manageDoctorHeading.contains("ADMIN | MANAGE DOCTORS"),
//				"Manage doctor page is not displayed.");
//		if (manageDoctorHeading.contains("Admin | Manage Doctors")) {
//			Reporter.log("Manage doctor page is displayed.", true);
//		}
//
//		driver.findElement(By.xpath("//span[@class='username']")).click();
//
//		driver.findElement(By.xpath("//li/a[contains(text(),'Log Out')]")).click();
//
//		String homePageUrl1 = driver.getCurrentUrl();
//
//		Assert.assertTrue(homePageUrl1.contains("Hospital_Management_System"),
//				"Hospital_Management_System web applications home page is displayed.");
//		if (homePageUrl1.contains("Hospital_Management_System")) {
//			Reporter.log("Hospital_Management_System web applications home page is displayed.", true);
//		}
//
//		homePage.getPatientGotoPageButton().click();
//		String patientLoginPageUrl = driver.getCurrentUrl();
//
//		Assert.assertTrue(patientLoginPageUrl.contains("Hospital_Management_System/hms/user-login"),
//				"Patient login page is not displayed.");
//		if (patientLoginPageUrl.contains("Hospital_Management_System/hms/user-login")) {
//			Reporter.log("Patient login page is displayed.", true);
//		}
//
//		PatientLogInpage patientLogInpage = new PatientLogInpage(driver);
//		patientLogInpage.getPatientUserNameTextField().sendKeys(PTLOGINID);
//		patientLogInpage.getPatientPasswordTextfield().sendKeys(PTPASSWORD);
//		patientLogInpage.getPatientLoginButton().click();
//
//		Reporter.log("Test case passed", true);
//	}

	

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
		Assert.assertTrue(homePageUrl.contains("Hospital_Management_System"),
				"Hospital_Management_System web applications home page is not displayed.");
		if (homePageUrl.contains("Hospital_Management_System")) {
			Reporter.log("Hospital_Management_System web applications home page is displayed.", true);
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

		Reporter.log("Test case passed.", true);
	}

	@Test
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

		// Maximize the window.
		webDriverUtility.maximizeWindow(driver);
		
		// Giving implicitly wait.
		webDriverUtility.waitTillPageGetLoad(driver);

		// Varifing weather home page is displayed or not.
		String homePageUrl = driver.getCurrentUrl();
		Assert.assertTrue(homePageUrl.contains("Hospital_Management_System"),
				"Hospital_Management_System web applications home page is not displayed.");
		if (homePageUrl.contains("Hospital_Management_System")) {
			Reporter.log("Hospital_Management_System web applications home page is displayed.", true);
		}

		Reporter.log("Testcase passed.", true);
	}

	@Test
	public void updateDoctor() throws IOException {
		FileUtility fileUtility = new FileUtility();
		String URL = fileUtility.getPropertyData("url");
		String BROWSER = fileUtility.getPropertyData("browser");
		String ADMINLOGINID = fileUtility.getPropertyData("adminLoginID");
		String ADMINPASSWORD = fileUtility.getPropertyData("adminPassword");
		String PTLOGINID = fileUtility.getPropertyData("ptLoginID");
		String PTPASSWORD = fileUtility.getPropertyData("ptPassword");
		String DOCLOGINID = fileUtility.getPropertyData("docLoginID");
		String DOCPASSWORD = fileUtility.getPropertyData("docPassword");

		ExcelUtility excelUtility = new ExcelUtility();

		String dcSp = excelUtility.getExcelData("Update_Doctor_Profile", 1, 0);
		String doctor = excelUtility.getExcelData("Update_Doctor_Profile", 1, 1);
		String cliAdd = excelUtility.getExcelData("Update_Doctor_Profile", 1, 2);
		String docFee = excelUtility.getExcelData("Update_Doctor_Profile", 1, 3);
		String docContact = excelUtility.getExcelData("Update_Doctor_Profile", 1, 4);

		

		// Maximize the window.
		
		webDriverUtility.maximizeWindow(driver);
		// Giving implicitly wait.
		webDriverUtility.waitTillPageGetLoad(driver);

		// Varifing weather home page is displayed or not.
		String homePageUrl = driver.getCurrentUrl();
		Assert.assertTrue(homePageUrl.contains("Hospital_Management_System"),
				"Hospital_Management_System web applications home page is not displayed.");
		if (homePageUrl.contains("Hospital_Management_System")) {
			Reporter.log("Hospital_Management_System web applications home page is displayed.", true);
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

		driver.findElement(By.xpath("//span[@class='username']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();

		Select s = new Select(driver.findElement(By.name("Doctorspecialization")));

		s.selectByVisibleText(dcSp);

		EditDoctorPage editDoctorPage = new EditDoctorPage(driver);
		editDoctorPage.getDoctorName().clear();
		editDoctorPage.getDoctorName().sendKeys(doctor);

		editDoctorPage.getDoctorClinicAddress().clear();
		editDoctorPage.getDoctorClinicAddress().sendKeys(cliAdd);

		editDoctorPage.getDocFees().clear();
		editDoctorPage.getDocFees().sendKeys(docFee);

		editDoctorPage.getDocContact().clear();
		editDoctorPage.getDocContact().sendKeys(docContact);

		editDoctorPage.getUpdateButton().click();

		webDriverUtility.switchToAlertPopupAndAccept(driver);
		String editDocPage = driver.getCurrentUrl();

		Assert.assertTrue(editDocPage.contains("Hospital_Management_System/hms/doctor/edit-profile"),
				"Edit doctor page is not displayed.");
		if (editDocPage.contains("Hospital_Management_System/hms/doctor/edit-profile")) {
			Reporter.log("Edit doctor page is displayed.", true);
		}
		Reporter.log("Test case passed.", true);

	}
}

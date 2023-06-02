//package com.hms.Hospital_Management_System.doctorsPom;
//
//import java.io.IOException;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.Select;
//
//import com.hms.Hospital_Management_System.genericUtility.ExcelUtility;
//import com.hms.Hospital_Management_System.genericUtility.FileUtility;
//import com.hms.Hospital_Management_System.genericUtility.WebDriverUtility;
//import com.hms.Hospital_Management_System.pom.DoctorHomePage;
//import com.hms.Hospital_Management_System.pom.DoctorLogInPage;
//import com.hms.Hospital_Management_System.pom.EditDoctorPage;
//import com.hms.Hospital_Management_System.pom.HomePage;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class DoctorVarification {
//
//	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		FileUtility fileUtility = new FileUtility();
//		String URL = fileUtility.getPropertyData("url");
//		String BROWSER = fileUtility.getPropertyData("browser");
//		String ADMINLOGINID = fileUtility.getPropertyData("adminLoginID");
//		String ADMINPASSWORD = fileUtility.getPropertyData("adminPassword");
//		String PTLOGINID = fileUtility.getPropertyData("ptLoginID");
//		String PTPASSWORD = fileUtility.getPropertyData("ptPassword");
//		String DOCLOGINID = fileUtility.getPropertyData("docLoginID");
//		String DOCPASSWORD = fileUtility.getPropertyData("docPassword");
//
//		ExcelUtility excelUtility = new ExcelUtility();
//
//		String dcSp = excelUtility.getExcelData("Update_Doctor_Profile", 1, 0);
//		String doctor = excelUtility.getExcelData("Update_Doctor_Profile", 1, 1);
//		String cliAdd = excelUtility.getExcelData("Update_Doctor_Profile", 1, 2);
//		String docFee = excelUtility.getExcelData("Update_Doctor_Profile", 1, 3);
//		String docContact = excelUtility.getExcelData("Update_Doctor_Profile", 1, 4);
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
//		driver.findElement(By.xpath("//span[@class='username']")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'My Profile')]")).click();
//
//		Select s = new Select(driver.findElement(By.name("Doctorspecialization")));
//
//		s.selectByVisibleText(dcSp);
//		
//		EditDoctorPage editDoctorPage = new EditDoctorPage(driver);
//		editDoctorPage.getDoctorName().clear();
//		editDoctorPage.getDoctorName().sendKeys(doctor);
//		
//		editDoctorPage.getDoctorClinicAddress().clear();
//		editDoctorPage.getDoctorClinicAddress().sendKeys(cliAdd);
//		
//		editDoctorPage.getDocFees().clear();
//		editDoctorPage.getDocFees().sendKeys(docFee);
//		
//		editDoctorPage.getDocContact().clear();
//		editDoctorPage.getDocContact().sendKeys(docContact);
//		
//		editDoctorPage.getUpdateButton().click();
//		
//		webDriverUtility.switchToAlertPopupAndAccept(driver);
//		String editDocPage = driver.getCurrentUrl();
//
//		if (editDocPage.contains("Hospital_Management_System/hms/doctor/edit-profile")) {
//			System.out.println("Edit doctor page is displayed.");
//		}
//
//	}
//
//}

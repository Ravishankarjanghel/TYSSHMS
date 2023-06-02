//package com.hms.Hospital_Management_System.pomExtraOrdinaryTest;
//
//import java.io.IOException;
//import java.util.HashMap;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.openqa.selenium.WebDriver;
//
//import com.hms.Hospital_Management_System.genericUtility.ExcelUtility;
//import com.hms.Hospital_Management_System.genericUtility.FileUtility;
//import com.hms.Hospital_Management_System.genericUtility.JavaUtility;
//import com.hms.Hospital_Management_System.genericUtility.WebDriverUtility;
//import com.hms.Hospital_Management_System.pom.DoctorHomePage;
//import com.hms.Hospital_Management_System.pom.DoctorLogInPage;
//import com.hms.Hospital_Management_System.pom.HomePage;
//import com.hms.Hospital_Management_System.pomExtraOrdinary.AddPatientPomExtraOrdinary;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class AddPatientExtraOrdinary {
//
//	public static void main(String[] args) throws Throwable, IOException {
//		WebDriver driver = WebDriverManager.chromedriver().create();
//		WebDriverUtility wdu = new WebDriverUtility();
//		wdu.waitTillPageGetLoad(driver);
//		FileUtility fu = new FileUtility();
//		String URL = fu.getPropertyData("url");
//		HomePage hp = new HomePage(driver);
//		driver.get(URL);
//		hp.getDoctorGotoPageButton().click();
//		DoctorLogInPage dlp = new DoctorLogInPage(driver);
//		dlp.getDoctorUserNameTextField().sendKeys("suhas@outlook.com");
//		dlp.getDoctorPasswordTextfield().sendKeys("Suhas@123");
//		
//		dlp.getDoctorLoginButton().click();
//		
//		DoctorHomePage dhp = new DoctorHomePage(driver);
//		dhp.getPatientListOption().click();
//		Thread.sleep(5000);
//		dhp.getAddPatientListOption().click();
//
//		ExcelUtility eu = new ExcelUtility();
//		int rowNum = eu.getRowNumber("AddPatientPomData")+1;
//		int cellNum = eu.getCellNumber("AddPatientPomData");
//		HashMap<String, String> map = new HashMap<String, String>();
//		for(int i = 0;i<rowNum;i++) {	
//				map.put(eu.getExcelData("AddPatientPomData", i, 0),eu.getExcelData("AddPatientPomData", i, 1));
//		}
//		AddPatientPomExtraOrdinary ap = new AddPatientPomExtraOrdinary();
//		JavaUtility ju = new JavaUtility();
//		ap.addPatient(map, driver, ju);
//		
//		
//	}
//
//}

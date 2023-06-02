//package com.hms.Hospital_Management_System.doctors;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Properties;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.poi.ss.usermodel.DataFormat;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import com.hms.Hospital_Management_System.genericUtility.ExcelUtility;
//import com.hms.Hospital_Management_System.genericUtility.FileUtility;
//import com.hms.Hospital_Management_System.genericUtility.JavaUtility;
//import com.hms.Hospital_Management_System.genericUtility.WebDriverUtility;
//import com.hms.Hospital_Management_System.pom.DoctorHomePage;
//import com.hms.Hospital_Management_System.pom.DoctorLogInPage;
//import com.hms.Hospital_Management_System.pom.HomePage;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class AddPatient {
//
//	public static void main(String[] args) throws InterruptedException, Throwable {
//		
//		FileUtility fileUtility = new FileUtility();
//		ExcelUtility excelUtility = new ExcelUtility();
//		JavaUtility javaUtility = new JavaUtility();
//		WebDriverUtility webDriverUtility = new WebDriverUtility();
////		FileInputStream fis = new FileInputStream("./src/test/resources/comman.properties");
////		Properties p = new Properties();
////		p.load(fis);
//		
//		
//		String URL = fileUtility.getPropertyData("url");
//		String BROWSER = fileUtility.getPropertyData("browser");
//		String ADMINLOGINID = fileUtility.getPropertyData("adminLoginID");
//		String ADMINPASSWORD = fileUtility.getPropertyData("adminPassword");
//		String PTLOGINID = fileUtility.getPropertyData("ptLoginID");
//		String PTPASSWORD = fileUtility.getPropertyData("ptPassword");
//		String DOCLOGINID = fileUtility.getPropertyData("docLoginID");
//		String DOCPASSWORD = fileUtility.getPropertyData("docPassword");
//		
////		FileInputStream fis1 = new FileInputStream("C:\\Users\\RAVISHANKAR\\OneDrive\\Desktop\\hms\\hmsTestData.xlsx");
////		Workbook wb = WorkbookFactory.create(fis1);
////		Row row = wb.getSheet("AddPatient").getRow(1);
//		
//		String pName = excelUtility.getExcelData("AddPatient", 1, 0);
//		String pContact = excelUtility.getExcelData("AddPatient", 1, 1);
//		String pEmail = excelUtility.getExcelData("AddPatient", 1, 2);
//		String pGender = excelUtility.getExcelData("AddPatient", 1, 3);
//		String pAddress = excelUtility.getExcelData("AddPatient", 1, 4);
//		String pAge = excelUtility.getExcelData("AddPatient", 1, 5);;
//		String pMH = excelUtility.getExcelData("AddPatient", 1, 6);
//		
//		Random ran = new Random();
//		int r = javaUtility.getRandomNumber();
//		
//		// open the chrome browser.
//		WebDriver driver = WebDriverManager.firefoxdriver().create();
//
//		// Maximize the window.
//		webDriverUtility.maximizeWindow(driver);
////		driver.manage().window().maximize();
//
//		// Giving implicitly wait.
//		webDriverUtility.waitTillPageGetLoad(driver);
////		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		// enter the url.
//		driver.get(URL);
//
//		// Varifing weather home page is displayed or not.
//		String homePageUrl = driver.getCurrentUrl();
//		if (homePageUrl.contains("Hospital_Management_System")) {
//			System.out.println("Hospital_Management_System web applications home page is displayed.");
//		}
//		HomePage homePage = new HomePage(driver);
//		homePage.getDoctorGotoPageButton().click();
////		driver.findElement(By
////				.xpath("//h3[text()='Doctors Login']/following-sibling::div[@class='button']//a[text()='Click Here']"))
////				.click();
//		DoctorLogInPage doctorLogInPage = new DoctorLogInPage(driver);
//		doctorLogInPage.getDoctorUserNameTextField().sendKeys(DOCLOGINID);
//		doctorLogInPage.getDoctorPasswordTextfield().sendKeys(DOCPASSWORD);
//		doctorLogInPage.getDoctorLoginButton().click();
//		
////		driver.findElement(By.name("username")).sendKeys(DOCLOGINID);
////		driver.findElement(By.name("password")).sendKeys(DOCPASSWORD);
////		driver.findElement(By.name("submit")).click();
//
//		driver.findElement(By.xpath("//div[@class='item-inner']/span[text()=' Patients ']")).click();
//
//		driver.findElement(By.xpath("//a/span[text()=' Add Patient']")).click();
//		
//		driver.findElement(By.name("patname")).sendKeys(pName+r);
//
////		DataFormatter d = new DataFormatter();
////		String s = d.formatCellValue(row.getCell(1));
////		String s = Long.toString(pContact);
//		pContact=pContact.replaceAll("[.Ee]", "");
//		driver.findElement(By.name("patcontact")).sendKeys(pContact);
//
//		String[] temp = pEmail.split("@");
//		pEmail = temp[0]+r+"@"+temp[1];
//		
//		driver.findElement(By.name("patemail")).sendKeys(pEmail);
//
//		pGender = pGender.toLowerCase();
//		
//		driver.findElement(By.xpath("//label[@for='rg-"+pGender+"']")).click();
//
//		driver.findElement(By.name("pataddress")).sendKeys(pAddress+r);
//
//		driver.findElement(By.name("patage")).sendKeys(pAge);
//
//		driver.findElement(By.name("medhis")).sendKeys(pMH);
//		Thread.sleep(3000);
//		driver.findElement(By.name("submit")).click();
//		
//		driver.findElement(By.xpath("//div[@class='item-inner']/span[text()=' Patients ']")).click();
//		
//		driver.findElement(By.xpath("//a/span[text()=' Manage Patient ']")).click();
//		Thread.sleep(3000);
//		List<WebElement> ptName = driver.findElements(By.xpath("//td[@class='hidden-xs']"));
//		
//		for(WebElement i : ptName) {
//			if(i.getText().contains(pName+r)) {
//				System.out.println("Patient present in the list.");
//				break;
//			}
//		}
//		// logout the application
//		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
//
//		// Checking weather homepage is displayed or not.
//		String homePageUrl2 = driver.getCurrentUrl();
//		if (homePageUrl2.contains("Hospital_Management_System")) {
//			System.out.println("Hospital_Management_System web applications home page is displayed.");
//		}
//	}
//
//}

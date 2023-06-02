//package com.hms.Hospital_Management_System.doctors;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.List;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class Admin_can_view_the_appointment {
//
//	public static void main(String[] args) throws Throwable {
//
//		FileInputStream fis = new FileInputStream("./src/test/resources/comman.properties");
//		Properties p = new Properties();
//		p.load(fis);
//		String URL = p.getProperty("url");
//		String BROWSER = p.getProperty("browser");
//		String ADMINLOGINID = p.getProperty("adminLoginID");
//		String ADMINPASSWORD = p.getProperty("adminPassword");
//		String PTLOGINID = p.getProperty("ptLoginID");
//		String PTPASSWORD = p.getProperty("ptPassword");
//
//		FileInputStream fis1 = new FileInputStream("C:\\Users\\RAVISHANKAR\\OneDrive\\Desktop\\hmsTestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis1);
//		Row row = wb.getSheet("Admin_can_view_the_appointment").getRow(1);
//		int day = (int)row.getCell(0).getNumericCellValue();
//		String time = row.getCell(1).toString();
//		String h = time.split(":")[0];
//		String m = time.split(":")[1].replaceAll("[^0-9]", "");
//		String ampm = time.replace("[^A-Za-z]", "");
//		// open the chrome browser.
//		WebDriver driver = WebDriverManager.chromedriver().create();
//
//		// Maximize the window.
//		driver.manage().window().maximize();
//
//		// Giving implicitly wait.
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		// enter the url.
//		driver.get(URL);
//
//		// varifying weather home page is displayed or not.
//		String homePageUrl = driver.getCurrentUrl();
//		if (homePageUrl.contains("Hospital_Management_System")) {
//			System.out.println("Hospital_Management_System web applications home page is displayed.");
//		}
//
//		// Go to patient login page.
//		driver.findElement(
//				By.xpath("//h3[text()='Patients']/following-sibling::div[@class='button']//a[text()='Click Here']"))
//				.click();
//
//		// varifying weather patient log in page is displayed or not.
//		String patientLoginPageUrl = driver.getCurrentUrl();
//		if (patientLoginPageUrl.contains("Hospital_Management_System/hms/user-login")) {
//			System.out.println("Patient login page is displayed.");
//		}
//
//		// Enter the valid cradential of Patient(User) and click on submit.
//		driver.findElement(By.name("username")).sendKeys(PTLOGINID);///////////////////
//		driver.findElement(By.name("password")).sendKeys(PTPASSWORD);////////////////////
//		driver.findElement(By.name("submit")).click();
//
//		// varifying weather Patient dashboard page is displayed or not.
//		String patientDashboardPageUrl = driver.getCurrentUrl();
//		if (patientDashboardPageUrl.contains("Hospital_Management_System/hms/dashboard")) {
//			System.out.println("Patient Dashboard page is displayed.");
//		}
//
//		// Click on Book appointment Button.
//		driver.findElement(By.xpath("//span[text()=' Book Appointment ']")).click();
//
//		// varifying weather book appointment page is displayed or not.
//		String bookAppointmentUrl = driver.getCurrentUrl();
//		if (bookAppointmentUrl.contains("Hospital_Management_System/hms/book-appointment")) {
//			System.out.println("Book appointment page is displayed in patient module.");
//		}
//
//		// select The doctor specialization.
//		String dcSp = "New medicine";
//		Select s1 = new Select(driver.findElement(By.name("Doctorspecialization")));
//		s1.selectByVisibleText(dcSp);
//
//		// select the doctor.
//		String doctor = "doc1";
//		Select s2 = new Select(driver.findElement(By.name("doctor")));
//		s2.selectByVisibleText(doctor);
//
//		// select the date.
//		driver.findElement(By.name("appdate")).click();
//		driver.findElement(By.xpath("//td[@class='day' and text()='"+day+"']")).click();
//
//		// select the time.
//		driver.findElement(By.name("apptime")).click();
//		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-hour form-control']")).clear();
//		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-hour form-control']")).sendKeys(h);
//		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-minute form-control']")).clear();
//		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-minute form-control']")).sendKeys(m);
//		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-meridian form-control']")).clear();
//		driver.findElement(By.xpath("//input[@class='bootstrap-timepicker-meridian form-control']")).sendKeys(ampm);
//
//		// click on submit button.
//		driver.findElement(By.name("submit")).click();
//
//		// Getting text from Alert pop up.
//		String bookMsg = driver.switchTo().alert().getText();
//
//		// varifying the text of alert pop up.
//		if (bookMsg.contains("Your appointment successfully booked")) {
//			System.out.println("Appointment is booked successfully.");
//		}
//
//		// clicking ok on alert pop up.
//		driver.switchTo().alert().accept();
//
//		// logout as a Patient.
//		driver.findElement(By.xpath("//span[@class='username']")).click();
//		driver.findElement(By.xpath("//li/a[contains(text(),'Log Out')]")).click();
//
//		// varifying weather homepage is displayed or not.
//		String homePageUrl1 = driver.getCurrentUrl();
//		if (homePageUrl1.contains("Hospital_Management_System")) {
//			System.out.println("Hospital_Management_System web applications home page is displayed.");
//		}
//
//		// Go to admin login page.
//		driver.findElement(
//				By.xpath("//h3[text()='Admin Login']/following-sibling::div[@class='button']//a[text()='Click Here']"))
//				.click();
//
//		// varifying weather Admin log in page is displayed or not.
//		String adminLoginPageUrl = driver.getCurrentUrl();
//		if (adminLoginPageUrl.contains("Hospital_Management_System/hms/admin")) {
//			System.out.println("Admin Login page is displayed.");
//		}
//
//		// click on valid cradential of admin.
//		driver.findElement(By.name("username")).sendKeys(ADMINLOGINID);///////////////////
//		driver.findElement(By.name("password")).sendKeys(ADMINPASSWORD);////////////////////////
//		driver.findElement(By.name("submit")).click();
//
//		// varifying weather Admin log in page is displayed or not.
//		String adminDashBoardPageUrl = driver.getCurrentUrl();
//		if (adminDashBoardPageUrl.contains("Hospital_Management_System/hms/admin/dashboard")) {
//			System.out.println("Admin dashboard page is displayed.");
//		}
//
//		// click on appointment history of Admin dashboard page.
//		driver.findElement(By.xpath("//span[text()=' Appointment History ']")).click();
//
//		// varifying weather appointment history page is display or not.
//		String AppointmentHistoryPageHeading = driver.findElement(By.xpath("//section[@id='page-title']//h1"))
//				.getText();
//		if (AppointmentHistoryPageHeading.contains("Patients  | Appointment History")) {
//			System.out.println("Appointment History page is displayed.");
//		}
//
//		// making list of all patient.
//		List<WebElement> allPatient = driver.findElements(By.xpath("//tr/td[@class='hidden-xs'][2]"));
//
//		// taking patient name to varify.
//		String patientName = "Chandan";
//
//		// varifying weather patient's appointment is present in list or not.
//		for (WebElement i : allPatient) {
//			if (i.getText().contains(patientName)) {
//				System.out.println("Booked Appointment by " + patientName + " is showing in the list.");
//				break;
//			}
//		}
//
//		// logout as a admin.
//		driver.findElement(By.xpath("//span[@class='username']")).click();
//		driver.findElement(By.xpath("//li/a[contains(text(),'Log Out')]")).click();
//
//		// Checking weather homepage is displayed or not.
//		String homePageUrl2 = driver.getCurrentUrl();
//		if (homePageUrl2.contains("Hospital_Management_System")) {
//			System.out.println("Hospital_Management_System web applications home page is displayed.");
//		}
//	}
//
//}

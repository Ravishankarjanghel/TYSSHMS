package com.hms.Hospital_Management_System.ExecutionWithBaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hms.Hospital_Management_System.genericUtility.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class BookAppointmentCancelAppointment extends BaseClass{

	@Test
	public void bookAppointmentCancelAppointment() throws Throwable {
		
		
		String URL = fileUtility.getPropertyData("url");
		String PTLOGINID = fileUtility.getPropertyData("ptLoginID");
		String PTPASSWORD = fileUtility.getPropertyData("ptPassword");
		
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\hmsTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Row row = wb.getSheet("BookAppointmentCancelAppointmen").getRow(1);
		int day = (int)row.getCell(0).getNumericCellValue();
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
		Assert.assertTrue(homePageUrl.contains("Hospital_Management_System"), "Hospital_Management_System web applications home page is not displayed.");
		if (homePageUrl.contains("Hospital_Management_System")) {
			Reporter.log("Hospital_Management_System web applications home page is displayed.",true);
		}

		// clicking to the patients module
		driver.findElement(By.xpath("//h3[text()='Patients']/..//a")).click();

		String url1 = driver.getCurrentUrl();
		Assert.assertTrue(url1.contains("s/user-login.php"), "Patient LogIn page is not displayed.");
		if (url1.contains("s/user-login.php")) {
			Reporter.log("Booking appionment is displayed",true);
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
		driver.findElement(By.xpath("//td[@class='day' and text()='"+day+"']")).click();
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
		Assert.assertTrue(homePageUrl2.contains("Hospital_Management_System"), "Hospital_Management_System web applications home page is not displayed.");
		if (homePageUrl2.contains("Hospital_Management_System")) {
			Reporter.log("Hospital_Management_System web applications home page is displayed.",true);
		}
		Reporter.log("Test case passed",true);

	}

}

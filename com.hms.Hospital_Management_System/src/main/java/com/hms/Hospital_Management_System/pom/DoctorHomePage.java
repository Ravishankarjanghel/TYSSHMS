package com.hms.Hospital_Management_System.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorHomePage {

	@FindBy(xpath="//li[@class='active']//span[normalize-space(text())='Dashboard']")
	private WebElement dashboardListOption;
	
	@FindBy(xpath="//span[normalize-space(text())='Appointment History']")
	private WebElement appointmentHistoryListOption;
	
	@FindBy(xpath="//span[normalize-space(text())='Patients']")
	private WebElement patientListOption;
	
	@FindBy(xpath="//span[normalize-space(text())='Add Patient']")
	private WebElement addPatientListOption;
	
	@FindBy(xpath="//span[normalize-space(text())='Manage Patient']")
	private WebElement managePatientListOption;
	
	@FindBy(xpath="//span[normalize-space(text())='Search']")
	private WebElement searchListOption;
	
	@FindBy(xpath="//span[@class='username']")
	private WebElement userNameIcon;
	
	@FindBy(xpath="//a[contains(text(),'My Profile')]")
	private WebElement myProfileOption;
	
	@FindBy(xpath="//a[contains(text(),'Change Password')]")
	private WebElement changePasswordOption;
	
	
	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	private WebElement logOutButton;
	
	public DoctorHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDashboardListOption() {
		return dashboardListOption;
	}

	public WebElement getAppointmentHistoryListOption() {
		return appointmentHistoryListOption;
	}

	public WebElement getPatientListOption() {
		return patientListOption;
	}

	public WebElement getAddPatientListOption() {
		return addPatientListOption;
	}

	public WebElement getManagePatientListOption() {
		return managePatientListOption;
	}

	public WebElement getSearchListOption() {
		return searchListOption;
	}

	public WebElement getUserNameIcon() {
		return userNameIcon;
	}

	public WebElement getMyProfileOption() {
		return myProfileOption;
	}

	public WebElement getChangePasswordOption() {
		return changePasswordOption;
	}

	public WebElement getLogOutButton() {
		return logOutButton;
	}
}

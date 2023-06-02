package com.hms.Hospital_Management_System.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorDashboardPage {

	@FindBy(xpath = "//a[normalize-space(text())='Update Profile']")
	private WebElement updateProfile;

	@FindBy(xpath = "//a[normalize-space(text())='View Appointment History']")
	private WebElement viewAppointmentHistory;

	public DoctorDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUpdateProfile() {
		return updateProfile;
	}

	public WebElement getViewAppointmentHistory() {
		return viewAppointmentHistory;
	}

}

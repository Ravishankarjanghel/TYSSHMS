package com.hms.Hospital_Management_System.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditDoctorPage {

	@FindBy(name="docname")
	private WebElement doctorName;
	@FindBy(name="clinicaddress")
	private WebElement doctorClinicAddress;
	@FindBy(name="docfees")
	private WebElement docFees;
	@FindBy(name="doccontact")
	private WebElement docContact;
	@FindBy(name="submit")
	private WebElement updateButton;
	
	public EditDoctorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getDoctorName() {
		return doctorName;
	}
	public WebElement getDoctorClinicAddress() {
		return doctorClinicAddress;
	}
	public WebElement getDocFees() {
		return docFees;
	}
	public WebElement getDocContact() {
		return docContact;
	}
	public WebElement getUpdateButton() {
		return updateButton;
	}
	
	
}

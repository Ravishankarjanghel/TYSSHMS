package com.hms.Hospital_Management_System.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPatientPage {

	@FindBy(name = "patname")
	private WebElement patientNameTextBox;

	@FindBy(name = "patcontact")
	private WebElement patientContactTextBox;

	@FindBy(name = "patemail")
	private WebElement patientEmailTextBox;

	@FindBy(xpath = "//label[@for='rg-female']")
	private WebElement patientGenderFemale;

	@FindBy(xpath = "//label[@for='rg-male']")
	private WebElement patientGenderMale;

	@FindBy(name = "pataddress")
	private WebElement patientAddress;

	@FindBy(name = "patage")
	private WebElement patientAge;

	@FindBy(name = "medhis")
	private WebElement patientMedicaleHistory;
	
	@FindBy(name="submit")
	private WebElement submitButton;

	public AddPatientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getPatientNameTextBox() {
		return patientNameTextBox;
	}

	public WebElement getPatientContactTextBox() {
		return patientContactTextBox;
	}

	public WebElement getPatientEmailTextBox() {
		return patientEmailTextBox;
	}

	public WebElement getPatientGenderFemale() {
		return patientGenderFemale;
	}

	public WebElement getPatientGenderMale() {
		return patientGenderMale;
	}

	public WebElement getPatientAddress() {
		return patientAddress;
	}

	public WebElement getPatientAge() {
		return patientAge;
	}

	public WebElement getPatientMedicaleHistory() {
		return patientMedicaleHistory;
	}
	
	public WebElement getSubmitButton() {
		return submitButton;
	}

}

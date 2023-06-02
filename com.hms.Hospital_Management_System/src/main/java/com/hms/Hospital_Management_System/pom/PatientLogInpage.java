package com.hms.Hospital_Management_System.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLogInpage {

	
		@FindBy(name="username")
		private WebElement patientUserNameTextField;
		
		@FindBy(name="password")
		private WebElement patientPasswordTextfield;
		
		@FindBy(xpath = "//a[contains(text(),'Forgot Password')]")
		private WebElement forgetPasswordLink;
		
		@FindBy(name = "submit")
		private WebElement patientLoginButton;
		
		@FindBy(xpath = "//a[contains(text(),'Create an account')]")
		private WebElement createAccountLink;

		public PatientLogInpage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		public WebElement getPatientUserNameTextField() {
			return patientUserNameTextField;
		}

		public WebElement getPatientPasswordTextfield() {
			return patientPasswordTextfield;
		}

		public WebElement getForgetPasswordLink() {
			return forgetPasswordLink;
		}

		public WebElement getPatientLoginButton() {
			return patientLoginButton;
		}

		public WebElement getCreateAccountLink() {
			return createAccountLink;
		}
}

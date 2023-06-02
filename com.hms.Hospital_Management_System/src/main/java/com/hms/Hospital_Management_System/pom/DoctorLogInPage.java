package com.hms.Hospital_Management_System.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLogInPage {

	@FindBy(name="username")
	private WebElement doctorUserNameTextField;
	
	@FindBy(name="password")
	private WebElement doctorPasswordTextfield;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot Password')]")
	private WebElement forgetPasswordLink;
	
	@FindBy(name = "submit")
	private WebElement doctorLoginButton;
	
	public DoctorLogInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDoctorUserNameTextField() {
		return doctorUserNameTextField;
	}

	public WebElement getDoctorPasswordTextfield() {
		return doctorPasswordTextfield;
	}

	public WebElement getForgetPasswordLink() {
		return forgetPasswordLink;
	}

	public WebElement getDoctorLoginButton() {
		return doctorLoginButton;
	}
}

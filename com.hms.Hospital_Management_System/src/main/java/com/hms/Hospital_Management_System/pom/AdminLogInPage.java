package com.hms.Hospital_Management_System.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLogInPage {

	@FindBy(name="username")
	private WebElement adminUserNameTextField;
	
	@FindBy(name="password")
	private WebElement adminPasswordTextfield;
	
	@FindBy(name = "submit")
	private WebElement adminLoginButton;
	
	public AdminLogInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAdminUserNameTextField() {
		return adminUserNameTextField;
	}

	public WebElement getAdminPasswordTextfield() {
		return adminPasswordTextfield;
	}

	public WebElement getAdminLoginButton() {
		return adminLoginButton;
	}
}
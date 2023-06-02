package com.hms.Hospital_Management_System.pom;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath="//a[text()='Hospital Management system']")
	private WebElement hmsTitleLink;
	
	@FindBy(xpath = "//div[@class='top-nav']//a[text()='Home']]")
	private WebElement homeButtonTop;
	
	@FindBy(xpath = "//div[@class='top-nav']//a[text()='contact']")
	private WebElement contactButtonTop;
	
	@FindBy(xpath = "//div[@class='footer-left']//a[text()='Home']")
	private WebElement homeButtonDown;
	
	@FindBy(xpath = "//div[@class='footer-left']//a[text()='contact']")
	private WebElement contactButtonDown;
	
	@FindBy(xpath = "//h3[text()='Patients']/following-sibling::div//a[text()='Click Here']")
	private WebElement patientGotoPageButton;
	
	@FindBy(xpath = "//h3[text()='Doctors Login']/following-sibling::div//a[text()='Click Here']")
	private WebElement doctorGotoPageButton;
	
	@FindBy(xpath = "//h3[text()='Admin Login']/following-sibling::div//a[text()='Click Here']")
	private WebElement adminGotoPageButton;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHmsTitleLink() {
		return hmsTitleLink;
	}

	public WebElement getHomeButtonTop() {
		return homeButtonTop;
	}

	public WebElement getContactButtonTop() {
		return contactButtonTop;
	}

	public WebElement getHomeButtonDown() {
		return homeButtonDown;
	}

	public WebElement getContactButtonDown() {
		return contactButtonDown;
	}

	public WebElement getPatientGotoPageButton() {
		return patientGotoPageButton;
	}

	public WebElement getDoctorGotoPageButton() {
		return doctorGotoPageButton;
	}

	public WebElement getAdminGotoPageButton() {
		return adminGotoPageButton;
	}
}

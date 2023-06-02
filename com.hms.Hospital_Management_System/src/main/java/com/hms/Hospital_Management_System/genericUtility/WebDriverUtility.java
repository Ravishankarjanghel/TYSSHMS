package com.hms.Hospital_Management_System.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/**
	 * This method is used to Maximize the browser.
	 * 
	 * @author RAVISHANKAR
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to implement implicit wait.
	 * 
	 * @author RAVISHANKAR
	 * @param driver
	 */
	public void waitTillPageGetLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(IPathConstants.implicitWaitDuration, TimeUnit.SECONDS);
	}

	public void waitTillElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, IPathConstants.explicitWaitDuration);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitTillElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, IPathConstants.explicitWaitDuration);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForAlertPopUp(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, IPathConstants.explicitWaitDuration);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waiForATitle(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, IPathConstants.explicitWaitDuration);
		wait.until(ExpectedConditions.titleContains(title));
	}

	public void waitForAUrl(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, IPathConstants.explicitWaitDuration);
		wait.until(ExpectedConditions.urlContains(url));
	}

	public void ignoreNoSuchElementException(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, IPathConstants.explicitWaitDuration);
		wait.ignoring(NoSuchElementException.class);
	}

	public void selectElementInDropDown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectElementInDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectElementInDropDown(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void getAllOptionsFromDropdown(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allOptions = select.getOptions();

		for (WebElement i : allOptions) {
			System.out.println(i.getText());
		}
	}

	public void mouseHoverOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element);
	}

	public void doubleClickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element);
	}

	public void switchFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchFrame(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}

	public void switchFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToAlertPopupAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();;
	}

	public void switchToAlertPopupAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void fileUpload(WebElement element, String Path) {
		element.sendKeys(Path);
	}

	public void customWait(int duration, WebElement element, long pollingTime) {
		int count = 0;
		while (count < duration) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				count++;
			}
		}
	}

	public void fluentWait(WebDriver driver, int duration, long pollingTime, String title) {
		FluentWait<WebDriver> f = new FluentWait<WebDriver>(driver);
		f.withTimeout(10, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
				.until(ExpectedConditions.titleContains(title));
	}

	public String takeScreenShot(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File src = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File dest = new File(
				"./screenShotPage/" + screenShotName + LocalDateTime.now().toString().replace(":", "_") + ".png");
		FileUtils.copyFile(src, dest);
		return screenShotName;
	}

	public String takeScreenShot(WebElement element, String screenShotName) throws IOException {

		File src = element.getScreenshotAs(OutputType.FILE);
		File dest = new File(
				"./screenShotElement/" + screenShotName + LocalDateTime.now().toString().replace(":", "_") + ".png");
		FileUtils.copyFile(src, dest);
		return screenShotName;
	}

	public void switchWindow(WebDriver driver, String title) {
		Set<String> set = driver.getWindowHandles();
		for (String i : set) {
			driver.switchTo().window(i);
			if (driver.getTitle().equalsIgnoreCase(title)) {
				break;
			}
		}
	}

	public void switchWindow(String url, WebDriver driver) {
		Set<String> set = driver.getWindowHandles();
		for (String i : set) {
			driver.switchTo().window(i);
			if (driver.getCurrentUrl().equalsIgnoreCase(url)) {
				break;
			}
		}
	}

}

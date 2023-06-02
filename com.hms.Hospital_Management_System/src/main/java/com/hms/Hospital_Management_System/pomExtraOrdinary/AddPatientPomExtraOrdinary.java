package com.hms.Hospital_Management_System.pomExtraOrdinary;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hms.Hospital_Management_System.genericUtility.ExcelUtility;
import com.hms.Hospital_Management_System.genericUtility.JavaUtility;

public class AddPatientPomExtraOrdinary {

	public void addPatient(HashMap<String, String> map, WebDriver driver, JavaUtility ju) throws InterruptedException {

		for (String i : map.keySet()) {
			if (i.equalsIgnoreCase("patemail")) {
				driver.findElement(By.name(i)).sendKeys(map.get(i) + ju.getRandomNumber());
				Thread.sleep(1000);
			} else {
				driver.findElement(By.name(i)).sendKeys(map.get(i));
				Thread.sleep(1000);
			}
		}
		driver.findElement(By.xpath("//label[@for='rg-male']")).click();
		driver.findElement(By.name("submit")).click();
	}
}

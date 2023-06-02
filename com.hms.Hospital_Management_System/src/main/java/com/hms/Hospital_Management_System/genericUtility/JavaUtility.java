package com.hms.Hospital_Management_System.genericUtility;


import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * @author RAVISHANKAR
	 * @return
	 */
	public int getRandomNumber() {
		Random ran = new Random();
		return ran.nextInt(1000);
	}
	/**
	 * @author RAVISHANKAR
	 * @return
	 */
	public String getCurrentDate() {
		Date date = new Date();
		return date.toString();
	}
	/**
	 * @author RAVISHANKAR
	 * @return
	 */
	public String getCurrentDateFormate() {
		Date date = new Date();
		String[] d = date.toString().split(" ");
		String weekDay = d[0];
		int month = date.getMonth();
		String cDate = d[2];
		String year = d[5];
		return month+" "+weekDay+" "+cDate+" "+year;
	}
	
	
}

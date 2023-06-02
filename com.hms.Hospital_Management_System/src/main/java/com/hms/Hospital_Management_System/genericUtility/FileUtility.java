package com.hms.Hospital_Management_System.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	/**
	 * This method will return the data from the property file.
	 * @author RAVISHANKAR
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyData(String key) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.propertyFilePath);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		return properties.getProperty(key);
	}
}

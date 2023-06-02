package com.hms.Hospital_Management_System.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * This method is used to insert data on excel sheet.
	 * @author RAVISHANKAR
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param value
	 * @throws IOException
	 */
	public void insertDataIntoExcel(String sheetName, int row, int cell, String value) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet s = workbook.getSheet(sheetName);
		Row r = s.createRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(value);
		
		FileOutputStream fileOutputStream = new FileOutputStream(IPathConstants.excelFilePath);
		workbook.write(fileOutputStream);
		workbook.close();
	}
	/**
	 * This method is used to get data from excel sheet.
	 * @author RAVISHANKAR
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelData(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet s = workbook.getSheet(sheetName);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		return c.toString();
	}
	/**
	 * This method is used to find the last row number of excel sheet.
	 * @author RAVISHANKAR
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowNumber(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet s = workbook.getSheet(sheetName);
		return s.getLastRowNum();
	}
	
	public int getCellNumber(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fileInputStream = new FileInputStream(IPathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet s = workbook.getSheet(sheetName);
		return s.getRow(0).getLastCellNum();
	}
}

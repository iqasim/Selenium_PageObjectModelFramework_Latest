package com.iq.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.iq.constants.FrameworkConstants;
import com.iq.exceptions.FrameworkException;
import com.iq.exceptions.InvalidExcelPathException;
import com.iq.exceptions.InvalidInputOutputException;

public final class ExcelUtils {

	public static List<Map<String, String>> getTestManager(String sheetname) {

		 
		List<Map<String, String>> list = new ArrayList<>();		
		try (FileInputStream fis = new FileInputStream(FrameworkConstants.getTestManagerFilePath());
				XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			XSSFSheet sheet = workbook.getSheet(sheetname);
			int lastrownum = sheet.getLastRowNum();
			int lastcolnum = sheet.getRow(0).getLastCellNum();
			Map<String, String> map = null;
			for(int i=1;i<=lastrownum; i++) {
				map = new HashMap<>();
				for(int j=0; j<lastcolnum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}
		} catch (FileNotFoundException e) {
			throw new InvalidExcelPathException("Excel file not found at the specified path.");
		} catch (IOException e) {
			throw new InvalidInputOutputException("Exception is in IO ");
		} 
		return list;
	}
}

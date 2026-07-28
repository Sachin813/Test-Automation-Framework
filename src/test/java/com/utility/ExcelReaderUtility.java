package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {
	public static Iterator<User> readExcelFile(String fileName) {
		XSSFWorkbook xssfWorkbook = null;
		List<User> userList = null;
		File xlsxFile = new File(System.getProperty("user.dir")+"/testData/"+ fileName);
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		
		
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
			XSSFSheet xssfSheet=xssfWorkbook.getSheet("LoginTestData");
			Iterator<Row> rowIterator= xssfSheet.iterator();
			userList = new ArrayList<User>();
			rowIterator.next();
			User user;
			while(rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);
				user = new User(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);
				xssfWorkbook.close();

			}
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return userList.iterator(); 
	}
}

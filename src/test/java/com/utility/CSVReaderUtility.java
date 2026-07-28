package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String fileName) {
		File csvFile = new File(System.getProperty("user.dir") + "/testData/"+fileName);
		FileReader csvFileReader;
		CSVReader csvReader;
		String [] line;
		List<User> userList = null;
		User userData;
		System.out.println(csvFile);

		try {

			csvFileReader = new FileReader(csvFile);
			csvReader = new CSVReader(csvFileReader);
			csvReader.readNext();
			userList = new ArrayList<User>();
			
			while((line=csvReader.readNext())!=null) {
				 System.out.println("Length = " + line.length);
				  System.out.println(Arrays.toString(line));
				userData = new User(line[0], line[1]);
				userList.add(userData);
				
				
			}
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (CsvValidationException e) {
			
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return userList.iterator();

	}

}

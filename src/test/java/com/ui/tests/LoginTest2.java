package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest2 extends TestBase{
	

	@Test(description = "Verifies with the valid user is able to login into the application", groups = {"e2e", "sanity"}, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void loginTest(User user){
		// TODO Auto-generated method stub
		
		assertEquals( homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUsername(), "Sachin rana");
	
	}	
//	@Test(description = "Verifies with the valid user is able to login into the application", groups = {"e2e", "sanity"}, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
//	public void loginTestCSV(User user){
//		// TODO Auto-generated method stub
//		
//		assertEquals( homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUsername(), "Sachin rana");
//	
//	}	
//	
//	@Test(description = "Verifies with the valid user is able to login into the application", groups = {"e2e", "sanity"}, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
//	public void loginTestFromExcel(User user){
//		// TODO Auto-generated method stub
//		
//		assertEquals( homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUsername(), "Sachin rana");
//	
//	}	

}

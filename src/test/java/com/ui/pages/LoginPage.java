package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class LoginPage extends BrowserUtility{
	private static final By EMAILl_TEXT_BOX_LOCATOR = By.id("email");
	private static final By PASSWORD_Text_BOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_LOGIN_LOCATOR = By.id("SubmitLogin");


	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public MyAccountPage doLoginWith(String emailAddress, String password) {
		enterText(EMAILl_TEXT_BOX_LOCATOR , emailAddress);
		enterText(PASSWORD_Text_BOX_LOCATOR, password);
		clickOn(SUBMIT_LOGIN_LOCATOR);

		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
	}
	
}

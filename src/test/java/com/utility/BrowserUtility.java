package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.constants.Browser;

public abstract class BrowserUtility {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}

	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}

	public BrowserUtility(WebDriver driver) {

		this.driver.set(driver);
	}
	
	public BrowserUtility(String browser) {

		if(browser == "Chrome") {
			driver.set(new ChromeDriver());
		}else if(browser == "Edge") {
			driver.set(new EdgeDriver());
		}else {
			System.err.println("Invalid browser name");
		}
	}
	
	public BrowserUtility(Browser browser) {

		if(browser == browser.CHROME) {
			driver.set(new ChromeDriver());
		}else if(browser == browser.EDGE) {
			driver.set(new EdgeDriver());
		}
	}
	
	public BrowserUtility(Browser browser, boolean isHeadless) {

		if(browser == browser.CHROME) {
			if(isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=192-,1080");
				driver.set(new ChromeDriver(options));
			}else {
			driver.set(new ChromeDriver());
			}
		}else if(browser == browser.EDGE) {
			if(isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			}else {
			
			driver.set(new EdgeDriver());
			}
		}
	}

	
	
	

	public void goToWebsite(String url) {
		driver.get().get(url);
	}

	public void maximizeWindows() {
		driver.get().manage().window().maximize();
	}

	public void enterText(By locator, String text) {
		WebElement webElement = driver.get().findElement(locator);
		webElement.sendKeys(text);
	}

	public void clickOn(By locator) {
		WebElement webElement = driver.get().findElement(locator);
		webElement.click();

	}
	
	public String getVisibleText(By locator) {
		WebElement webElement = driver.get().findElement(locator);
		return webElement.getText();

	}
	
	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot)driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
		 String timestamp= dateFormat.format(date);
		String path = "./screenshots/"+name+" -"+timestamp+".png";
		File screenshotFile = new File(path);
		
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
	}
	
	public void quit() {
	    driver.get().quit();
	}
	

}

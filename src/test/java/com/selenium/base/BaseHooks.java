package com.selenium.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.selenium.api.SeleniumBase;
import com.selenium.pages.LoginPage;
import com.selenium.utils.ExcelUtility;
import com.selenium.utils.ReadProperties;

public class BaseHooks extends SeleniumBase{
//	public static WebDriver driver;
	public String filename;

	@DataProvider(name = "gettestdata")
	public String[][] getExcelData() {
		System.out.print(filename);
		return ExcelUtility.readExcelValue(filename);
	}

	@BeforeMethod
	public void launchApplication() throws IOException {
		remoteBrowser("https://oauth-nitin015reddy-ba437:158eecb9-1322-43e4-b744-78d5d1610b69@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		//browser("CHROME");
		open(ReadProperties.readfile("url"));
	}

	
	@AfterMethod
	public void screenshot(ITestResult result) throws FileNotFoundException,IOException {
		if (!result.isSuccess()) {
			FileOutputStream fos= new FileOutputStream(new File("./images/"+result.getName()+".png"));
			fos.write(takeSnap());
			
		}
		quitBrowser();
		}

}

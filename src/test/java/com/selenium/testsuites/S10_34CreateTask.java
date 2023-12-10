package com.selenium.testsuites;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.base.BaseHooks;
import com.selenium.pages.HomePage;
import com.selenium.pages.LoginPage;
import com.selenium.pages.ViewTasks;

public class S10_34CreateTask extends BaseHooks {
	/*
	 * @DataProvider(name="GetTestData") public String [][] getExcelData(){ return
	 * ExcelUtility.readExcelValue("S10_34CreateTask"); }
	 */

	@BeforeTest(alwaysRun = true)
	public void beforetest() {
		filename = "S10_34CreateTask";
	}
	
	   
	@Test(dataProvider = "gettestdata")
	public void CreateTask(String field, String sub) throws InterruptedException, IOException {
	    new LoginPage()
		.enterUserName("uname")
		.enterPassword("pwd")
		.clickLoginButton()  
	//	new HomePage(driver)
		.clickonAppLaunch()
		.clickonViewAll()
		.searchonAppLaunch(field)
		.clickOnTasksLink()
		.clickOnShowMore()
		.clickOnNewTaskButton()
		.enterSubject(sub)
		.clickOnStatusDropdown()
		.selectStatusValue()
		.clickOnSaveTask();
		
       ViewTasks vp =new ViewTasks();
		Assert.assertEquals(vp.getConfirmationMessage(), "BootCamp");
		System.out.println("Task created successfully");
		

	}
}

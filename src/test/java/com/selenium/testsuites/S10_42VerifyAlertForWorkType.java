package com.selenium.testsuites;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.base.BaseHooks;
import com.selenium.pages.CreateWorkTypePage;
import com.selenium.pages.HomePage;
import com.selenium.pages.LoginPage;



public class S10_42VerifyAlertForWorkType extends BaseHooks {
	
	

	@BeforeTest(alwaysRun = true)
	public void beforetest() {
		filename = "S10_42VerifyAlertForWorkType";
	}
	

	@Test(dataProvider = "gettestdata")
	public void MandatoryFieldForWorkType(String field, String sub) throws InterruptedException, IOException {
		new LoginPage()
		.enterUserName("uname")
		.enterPassword("pwd")
		.clickLoginButton()
		.clickonAppLaunch()
		.clickonViewAll()
		.searchonAppLaunch(field)
		.clickonWorkTypesLink()
		.clickOnNewWorkTypeButton()
		.enterWorkTypeName(sub)
		.clickOnSaveForWorkType();
		
		// verify error for mandatory fields
		CreateWorkTypePage cw =new CreateWorkTypePage();
		Assert.assertEquals(cw.getConfirmationMessage(), "Complete this field.");
		System.out.println("Alert Verified successfully");
		
	

	}
}
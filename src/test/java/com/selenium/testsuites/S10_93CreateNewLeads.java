package com.selenium.testsuites;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.base.BaseHooks;
import com.selenium.pages.CreateLeadsPage;
import com.selenium.pages.HomePage;
import com.selenium.pages.LoginPage;



public class S10_93CreateNewLeads extends BaseHooks {

	

	@BeforeTest(alwaysRun = true)
	public void beforetest() {
		filename = "S10_93CreateNewLeads";
	}

	

//	@Test(dataProvider = "gettestdata", dataProviderClass = TestDataProvider.class)
	
	@Test(dataProvider = "gettestdata")
	public void CreateNewLeads(String fname, String lname, String com) throws InterruptedException, IOException {
		new LoginPage()
		.enterUserName("uname")
		.enterPassword("pwd")
		.clickLoginButton()
		//new HomePage()
		.clickonAppLaunch()
		.clickonViewAll()
		.clickonSalesLink()
		.clickOnLeadsTab()
		.clickOnNewLeadButton()
		.clickOnsalutationDropdown()
		.selectSalutationValue()
		.enterFirstName(fname)
		.enterLastName(lname)
		.enterCompany(com)
		.clickOnLeadStatusDropdown()
		.selectLeadStatusValue()
		.clickOnSaveLead();
	

		// verify Lead message created successfully
		CreateLeadsPage cl =new CreateLeadsPage();
		Assert.assertEquals(cl.getConfirmationMessage(), "Lead");
		System.out.println("Lead created successfully");
		
	}
}
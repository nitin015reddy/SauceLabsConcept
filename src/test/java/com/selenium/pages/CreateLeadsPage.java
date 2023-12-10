package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.base.BaseHooks;
import com.selenium.utils.ReadProperties1;

public class CreateLeadsPage extends BaseHooks {

//	private WebDriver driver;

	public CreateLeadsPage() {
		// this.driver = driver;
	}

	public CreateLeadsPage clickOnLeadsTab() throws InterruptedException {
		// click on leads tab
		javascriptClick(getWebElement(ReadProperties1.getObject("CreateLeadsPage", "Createlead.tab.click")));
		Thread.sleep(5000);
		return this;
	}

	public CreateLeadsPage clickOnNewLeadButton() throws InterruptedException {
		// click on new button on leads page
		click(getWebElement(ReadProperties1.getObject("CreateLeadsPage", "Createlead.new.btn")));
		Thread.sleep(3000);
		return this;
	}

	public CreateLeadsPage clickOnsalutationDropdown() throws InterruptedException {
		// click on salutation drop down
		click(getWebElement(ReadProperties1.getObject("CreateLeadsPage", "Createlead.sal.click")));
		Thread.sleep(3000);
		return this;
	}

	public CreateLeadsPage selectSalutationValue() throws InterruptedException {
		// select salutation value
		click(getWebElement(ReadProperties1.getObject("CreateLeadsPage", "Createlead.sal.value")));
		Thread.sleep(3000);
		return this;
	}

	public CreateLeadsPage enterFirstName(String fname) throws InterruptedException {
		// Enter first name
		type(getWebElement(ReadProperties1.getObject("CreateLeadsPage", "Createlead.fname.enter")), fname);
		Thread.sleep(2000);
		return this;
	}

	public CreateLeadsPage enterLastName(String lname) throws InterruptedException {
		// Enter last name
		type(getWebElement(ReadProperties1.getObject("CreateLeadsPage", "Createlead.lname.enter")), lname);
		Thread.sleep(2000);
		return this;
	}

	public CreateLeadsPage enterCompany(String com) throws InterruptedException {
		// Enter company
		type(getWebElement(ReadProperties1.getObject("CreateLeadsPage", "Createlead.cmp.enter")), com);
		Thread.sleep(2000);
		return this;
	}

	public CreateLeadsPage clickOnLeadStatusDropdown() throws InterruptedException {
		// Select status
		scrollIntoView(getWebElement(ReadProperties1.getObject("CreateLeadsPage", "Createlead.status.click")));
		click(getWebElement(ReadProperties1.getObject("CreateLeadsPage", "Createlead.status.click")));
		return this;
	}

	public CreateLeadsPage selectLeadStatusValue() throws InterruptedException {
		// Select status
		click(getWebElement(ReadProperties1.getObject("CreateLeadsPage", "Createlead.status.value")));
		Thread.sleep(1000);
		return this;
	}

	public CreateLeadsPage clickOnSaveLead() throws InterruptedException {
		// click on Save
		click(getWebElement(ReadProperties1.getObject("CreateLeadsPage", "Createlead.save.click")));
		Thread.sleep(4000);
		System.out.println("created new lead");
		return this;
	}

	public String getConfirmationMessage() {
		// TODO Auto-generated method stub
		return getText(getWebElement(ReadProperties1.getObject("CreateLeadsPage", "Createlead.get.actualvalue")));
	}

}

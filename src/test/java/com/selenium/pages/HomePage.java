package com.selenium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.api.SeleniumBase;
import com.selenium.base.BaseHooks;
import com.selenium.utils.ReadProperties;
import com.selenium.utils.ReadProperties1;

public class HomePage extends BaseHooks {
	public HomePage() {
	}

	public HomePage clickonAppLaunch() throws InterruptedException {
		Thread.sleep(5000);
		// System.out.println(getWebElement("xpath=//*[contains(@class,'slds-icon-waffle')]"));
		click(getWebElement(ReadProperties1.getObject("HomePage", "homepage.applaunch.btn")));
		Thread.sleep(3000);
		return this;
	}

	public HomePage clickonViewAll() throws InterruptedException {
		click(getWebElement(ReadProperties1.getObject("HomePage", "homepage.viewall.link")));
		Thread.sleep(8000);
		return this;
	}

	// enter Tasks in search bar
	public HomePage searchonAppLaunch(String field) throws InterruptedException {
		type(getWebElement(ReadProperties1.getObject("HomePage", "homepage.search.txt")), field);
		return this;
	}

	public CreateTasksPage clickOnTasksLink() throws InterruptedException {
		// click on Tasks link
		javascriptClick(getWebElement(ReadProperties1.getObject("HomePage", "homepage.tasks.link")));
		Thread.sleep(4000);
		return new CreateTasksPage();
	}

	public CreateWorkTypePage clickonWorkTypesLink() throws InterruptedException {
		// click on work types link
		javascriptClick(getWebElement(ReadProperties1.getObject("HomePage", "homepage.worktype.link")));
		Thread.sleep(4000);
		return new CreateWorkTypePage();

	}

	public CreateLeadsPage clickonSalesLink() throws InterruptedException {
		// click on sales link
		click(getWebElement(ReadProperties1.getObject("HomePage", "homepage.sales.link")));
		Thread.sleep(4000);
		return new CreateLeadsPage();
	}

}
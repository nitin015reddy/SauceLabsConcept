package com.selenium.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.api.SeleniumBase;
import com.selenium.base.BaseHooks;
import com.selenium.utils.ReadProperties1;


public class CreateTasksPage extends BaseHooks {
	public CreateTasksPage() {		
	}

	public CreateTasksPage clickOnShowMore() {
		// click on drop down 
		click(getWebElement(ReadProperties1.getObject("CreateTasksPage","createtaskspage.showmore.btn")));
		return this;
	}

	public CreateTasksPage clickOnNewTaskButton() throws InterruptedException {
		// click on new task
		click(getWebElement(ReadProperties1.getObject("CreateTasksPage","createtaskspage.new.btn")));
		Thread.sleep(3000);
		return this;
	}
	
	public CreateTasksPage enterSubject(String sub) throws InterruptedException {
		// Enter subject as "Bootcamp"
		type(getWebElement(ReadProperties1.getObject("CreateTasksPage","createtaskspage.entersubject.txt")), sub);
	//			Thread.sleep(2000);
		return this;
	}
	
	
	public CreateTasksPage clickOnStatusDropdown() throws InterruptedException {
		// Select status as 'Waiting on someone else'
		click(getWebElement(ReadProperties1.getObject("CreateTasksPage","createtaskspage.status.btn")));				
		return this;
	}
	
	
	public CreateTasksPage selectStatusValue() throws InterruptedException {
		// Select status as 'Waiting on someone else'
		click(getWebElement(ReadProperties1.getObject("CreateTasksPage","createtaskspage.statusvalue.btn")));
		return this;
	}
	
	public ViewTasks clickOnSaveTask() throws InterruptedException {
		// click on Save
		click(getWebElement(ReadProperties1.getObject("CreateTasksPage","createtaskspage.save.btn")));
		Thread.sleep(4000);
		return new ViewTasks();
	}
	
	

}

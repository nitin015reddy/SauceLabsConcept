package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.base.BaseHooks;
import com.selenium.utils.ReadProperties1;

public class ViewTasks extends BaseHooks {
	public ViewTasks() {
	
	}
 
	public String getConfirmationMessage() {
		// verify task message created successfully			
		return getText(getWebElement(ReadProperties1.getObject("CreateTasksPage","Createtask.get.actualvalue")));
}
}

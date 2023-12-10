package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.base.BaseHooks;
import com.selenium.utils.ReadProperties1;

public class CreateWorkTypePage extends BaseHooks  {

	//private WebDriver driver;

	public CreateWorkTypePage() {
//		this.driver = driver;
	}
	
	public CreateWorkTypePage clickOnNewWorkTypeButton() throws InterruptedException {
		// click on new worktype button 
		click(getWebElement(ReadProperties1.getObject("Createworktype","Createworktype.new.click")));
	//	driver.findElement(newbutton).click();
		Thread.sleep(3000);
		return this;
	}
	
	public CreateWorkTypePage enterWorkTypeName(String sub) throws InterruptedException {
		// Enter worktypename as "Bootcamp"
		
		type(getWebElement(ReadProperties1.getObject("Createworktype","Createworktype.subject.enter")), sub);
	//			driver.findElement(subject).sendKeys(sub);
				Thread.sleep(2000);
		return this;
	}
	
	public CreateWorkTypePage clickOnSaveForWorkType() throws InterruptedException {
		// click on Save
		click(getWebElement(ReadProperties1.getObject("Createworktype","Createworktype.save.click")));
	//			driver.findElement(save).click();
				Thread.sleep(4000);
				System.out.println("Saved new worktype");
		return this;		

	}


	public String getConfirmationMessage() {
		// TODO Auto-generated method stub
		return getText(getWebElement(ReadProperties1.getObject("Createworktype","Createworktype.get.actualvalue")));
	//	return driver.findElement(actual).getText();
	}
}

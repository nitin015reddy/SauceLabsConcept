package com.selenium.pages;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.api.SeleniumBase;
import com.selenium.base.BaseHooks;
import com.selenium.utils.ReadProperties;
import com.selenium.utils.ReadProperties1;

public class LoginPage extends BaseHooks{
	
	public LoginPage() {
		
	}

	public LoginPage enterUserName(String uname) throws IOException {
		type(getWebElement(ReadProperties1.getObject("LoginPage","loginpage.username.text")), ReadProperties.readfile("uname"));
	//	driver.findElement(By.id("username")).sendKeys(ReadProperties.readfile("uname"));
		return this;

	}

	public LoginPage enterPassword(String pwd) throws IOException {
		type(getWebElement(ReadProperties1.getObject("LoginPage","login.password.txt")), ReadProperties.readfile("pwd"));
		return this;

	}

	public HomePage clickLoginButton() {
		click(getWebElement(ReadProperties1.getObject("LoginPage","loginpage.login.btn")));
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return new HomePage();

	}

}

package com.selenium.api;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class SeleniumBase implements ISeleniumBaseDesign {
	public static WebDriver driver;

	@Override
	public WebDriver browser(String browserName) {
		BrowserType browsers = BrowserType.valueOf(browserName.toUpperCase());
		try {
			switch (browsers) {
			case CHROME:
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--disable-notifications");
				driver = new ChromeDriver(chromeOptions);
				driver.manage().window().maximize();
				break;
			case FIREFOX:
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.addArguments("--disable-notifications");
				driver = new FirefoxDriver(firefoxOptions);
				driver.manage().window().maximize();
				break;
			case EDGE:
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.addArguments("--disable-notifications");
				driver = new EdgeDriver(edgeOptions);
				driver.manage().window().maximize();
			default:
				driver = null;
				break;
			}
		} catch (Exception e) {
			System.out.println("Unable to launch " + browserName + " browser due to: " + e.getMessage());
		}
		return driver;
	}
    
	public WebDriver remoteBrowser(String sauceLabUrl) throws MalformedURLException {
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
		Date date = new Date();
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("latest");
		Map<String, Object> sauceOptions = new HashMap<String, Object>();
		sauceOptions.put("build", "selenium-build-0NR6D");
		sauceOptions.put("name", "test_saucelab" + formatter.format(date));
		browserOptions.setCapability("sauce:options", sauceOptions);
		URL url = new URL(sauceLabUrl);
		return driver = new RemoteWebDriver(url, browserOptions);	
	}
	@Override
	public void closeBrowser() {
		// TODO Auto-generated method stub
		driver.close();
	}

	@Override
	public void quitBrowser() {
		// TODO Auto-generated method stub
		driver.quit();
	}

	@Override
	public void open(String aut) {
		// TODO Auto-generated method stub
		try {
			driver.get(aut);
		} catch (Exception e) {
			System.out.println("unable to hit url" + aut + "due to" + e.getMessage());
		}
	}

	@Override
	public WebElement getWebElement(String locator) {
		WebElement element = null;
		String[] split = locator.split("=", 2);
		LocatorType locatorType = LocatorType.valueOf(split[0].toUpperCase());
		try {
			switch (locatorType) {
			case ID:
				element = driver.findElement(By.id(split[1]));
				break;
			case NAME:
				element = driver.findElement(By.name(split[1]));
				break;
			case CLASSNAME:
				element = driver.findElement(By.className(split[1]));
				break;
			case LINKTEXT:
				element = driver.findElement(By.linkText(split[1]));
				break;
			case PARTCIALLINKTEXT:
				element = driver.findElement(By.partialLinkText(split[1]));
				break;
			case TAGNAME:
				element = driver.findElement(By.tagName(split[1]));
				break;
			case CSSSELECTOR:
				element = driver.findElement(By.cssSelector(split[1]));
				break;
			case XPATH:
				System.out.println(split[1]);
				element = driver.findElement(By.xpath(split[1]));
				break;
			default:
				element = null;
				break;
			}
		} catch (Exception e) {
			System.out.println("element not found in the dom " + locator + " due to: " + e.getMessage());
		}
		return element;
	}

	@Override
	public List<WebElement> getWebElements(String locator) {
		List<WebElement> list1 = null;
		String[] split = locator.split("=", 2);
		LocatorType locatorType = LocatorType.valueOf(split[0].toUpperCase());
		try {
			switch (locatorType) {
			case ID:
				list1 = driver.findElements(By.id(split[1]));
				break;
			case NAME:
				list1 = driver.findElements(By.name(split[1]));
				break;
			case CLASSNAME:
				list1 = driver.findElements(By.className(split[1]));
				break;
			case LINKTEXT:
				list1 = driver.findElements(By.linkText(split[1]));
				break;
			case PARTCIALLINKTEXT:
				list1 = driver.findElements(By.partialLinkText(split[1]));
				break;
			case TAGNAME:
				list1 = driver.findElements(By.tagName(split[1]));
				break;
			case CSSSELECTOR:
				list1 = driver.findElements(By.cssSelector(split[1]));
				break;
			case XPATH:
				list1 = driver.findElements(By.xpath(split[1]));
			default:
				list1 = null;
				break;
			}
		} catch (Exception e) {
			System.out.println("element not found in the dom " + locator + " due to: " + e.getMessage());
		}
		return list1;
	}
	

	@Override
	public void type(WebElement ele, String data) {
		// TODO Auto-generated method stub
		try {
			ele.sendKeys(data);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void click(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			ele.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void javascriptClick(WebElement ele) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ele);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void scrollIntoView(WebElement ele) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", ele);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public boolean verifyTitle(String title) {
		if (driver.getTitle().equals(title)) {
			System.out.println("Page title: " + title + " matched successfully");
			return true;
		} else {
			System.out.println("Page url: " + title + " not matched");

		}
		return false;
	}

	@Override
	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			String text = ele.getText();
			return text;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	@Override
	public void selectValueInDropdown(WebElement ele, String text) {
		// TODO Auto-generated method stub
		try {
			Select sel = new Select(ele);
			sel.selectByVisibleText(text);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void moveToParticularElement(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void switchToWindow(int index) {
		// TODO Auto-generated method stub
		try {
			Set<String> allWindows = driver.getWindowHandles();
			List<String> allhandles = new ArrayList<String>(allWindows);
			driver.switchTo().window(allhandles.get(index));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public boolean switchToWindow(String title) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			for (String eachWindow : allWindows) {
				driver.switchTo().window(eachWindow);
				if (driver.getTitle().equals(title)) {
					break;
				}
			}
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().frame(ele);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void defaultContent() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public byte[] takeSnap() {
		// TODO Auto-generated method stub
		try {

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void waitForVisible(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	public void defaultWindow(String title) {
		try {
			driver.switchTo().window(title);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
	public void dragAndDrop(WebElement eleSource, WebElement eleTarget) {
		Actions act = new Actions(driver);
		act.dragAndDrop(eleSource, eleTarget).perform();
	}

	
	@Override
	public boolean verifyEnabled(WebElement ele) {
		try {
			if (ele.isEnabled()) {
				return true;
			} else {
				System.out.println("The element " + ele + " is not Enabled");
			}
		} catch (Exception e) {
			System.out.println("WebDriverException : \n" + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean verifySelected(WebElement ele) {
		try {
			if (ele.isSelected()) {
				return true;
			} else {
				System.out.println("The element " + ele + " is not Enabled");
			}
		} catch (Exception e) {
			System.out.println("WebDriverException : \n" + e.getMessage());
		}
		return false;
	}

	

}

package com.amazon.runner;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	protected static WebDriver driver;
	String browserName = "chrome";
	protected static String url = "https://www.amazon.in/";
	


	//Launch Browser
	public void LaunchBrowser() throws Exception {
		try {
			System.setProperty("webdriver.chrome.driver", "./setup/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}catch(Exception exp) {
			System.out.println(exp.toString());
			throw new Exception("Failed to Launch the Browser");
		}
	}
	
	//Launch Browser
	public void NavigateToUrl() throws Exception {
		try {
			driver.get(url);
		}catch(Exception exp) {
			System.out.println(exp.toString());
			throw new Exception("Failed to Navigate to the Url");
		}
	}
	
	//Switch Window
	public static void switchWindow(String parentWindow) throws Exception {
		try {
			for(String ele:driver.getWindowHandles()) {
				if(!ele.equals(parentWindow)) {
					driver.switchTo().window(ele);
					break;
				}
			}
		} catch (Exception exp) {
			System.out.println(exp.toString());
			throw new Exception("Failed to Switch the Browser Window");
		}
	}
	
	//Explicitly Wait
	public static void ExplicitWait(WebDriver webDriver, WebElement element, int timeInSeconds) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeInSeconds));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			}
		catch (Exception exp) {
			System.out.println(exp.toString());
			throw new Exception("Failed to Explicitly Wait");
		}
	}
	
	//Explicitly Wait
	public void closeBrowser() throws Exception {
		try {
			driver.quit();
			}
		catch (Exception exp) {
			System.out.println(exp.toString());
			throw new Exception("Failed to Quit the Browser");
		}
	}
	
	
}

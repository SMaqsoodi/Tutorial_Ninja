package com.qa.tutorialsninja.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author saeed
 *
 */
public class BasePage {
	public WebDriver driver;
	public Properties prop;
	
/**
 * This method initialize the browser on the basis of given browser
 * @param browser
 * @return this method returns WebDrive driver
 */
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is : " + browser);
		
		switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			case "EI":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
				
			default:
				System.out.println("please enter a valid browser");
				break;	
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		
		return driver;
	}
		
/**
 * this method is used to make connection to and load properties from config.properties file to avoid hard coded values 
 * @return it returns Properties prop reference 
 */
	public Properties init_prop() {
		prop = new Properties(); // we declare this properties ref in class level so it can be used by other classes also then we initialize it here
		try {
			FileInputStream ip = new FileInputStream("./src/main/java/com/qa/tutorialsninja/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}
	
}

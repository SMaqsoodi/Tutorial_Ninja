package com.qa.tutorialsninja.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.tutorialsninja.base.BasePage;
import com.qa.tutorialsninja.utils.Constants;
import com.qa.tutorialsninja.utils.ElementUtil;


public class LoginPage extends BasePage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;	
	// By locators
	private By emailId = By.id("input-email");
	private By passWord = By.id("input-password");
	private By loginButton = By.xpath("//input[@value ='Login' and @type='submit']");
	private By loginPageHeader = By.cssSelector("#logo a");
	private By forgotPassword = By.linkText("Forgotten Password");
	
	// constructor of the page
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	// page actions
	
	public String getLoginPageTitle() {
		return elementUtil.waitForPageTitle(Constants.LOGIN_PAGE_TITLE, 10);
	}	
			
	public String getHeaderValue() {
		String header = elementUtil.getElementText(loginPageHeader);
		System.out.println("login page headre is : " + header);
		
		return header;
	}
	
	public boolean isForgotPasswordExist() {
		//return driver.findElement(forgotPassword).isDisplayed(); // or using ElementUtil class
		return elementUtil.isDisplayed(forgotPassword);
	}
	
	public AccountPage doLogin(String un, String pwd) {
		System.out.println("Loing with : " + un + " and " + pwd);

		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(passWord, pwd);
		elementUtil.doClick(loginButton);
		
		return new AccountPage(driver);
	}

}


package com.qa.tutorialsninja.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.qa.tutorialsninja.pages.AccountPage;
import com.qa.tutorialsninja.pages.CartPage;
import com.qa.tutorialsninja.pages.LoginPage;
import com.qa.tutorialsninja.pages.ProductInfoPage;



public class BaseTest {
	public BasePage basePage; // creating on object of the BasePage. no need to import since they are in the same package
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPage;
	public AccountPage accountPage;
	public ProductInfoPage productInfoPage;
	public CartPage cartPage;
	
	
	@BeforeTest
	public void setup() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		String browser = prop.getProperty("browser");  // this method returns the value of the key in config.properties
		driver = basePage.init_driver(browser);
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
	}
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}

}

package com.qa.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;

import com.qa.tutorialsninja.base.BasePage;
import com.qa.tutorialsninja.utils.ElementUtil;

public class CheckOutPage extends BasePage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}

}

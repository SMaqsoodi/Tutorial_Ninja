package com.qa.tutorialninja.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.tutorialsninja.base.BaseTest;
import com.qa.tutorialsninja.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	@Test(priority=1)
	public void getLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void getHeaderValueTest() {
		Assert.assertEquals(loginPage.getHeaderValue(), Constants.LOGIN_PAGE_HEADER);
	}
	
	@Test(priority=3)
	public void isForgotPasswordExistTest() {
		Assert.assertTrue(loginPage.isForgotPasswordExist());
	}

	@Test(priority=4)
	public void doLoginTest() {
		loginPage.doLogin(prop.getProperty("emailId"), prop.getProperty("password"));
	}
}


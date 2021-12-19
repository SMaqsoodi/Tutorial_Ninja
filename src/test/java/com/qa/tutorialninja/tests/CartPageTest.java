package com.qa.tutorialninja.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.base.BaseTest;

public class CartPageTest extends BaseTest {
	
	@BeforeClass
	public void cartPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("emailId"), prop.getProperty("password"));
		accountPage.doSearch("MacBook");
		productInfoPage = accountPage.selectProductFromResults("MacBook Pro");
		
	}
	
	@Test(priority=1)
	public void cartPageTitleTest() {
		cartPage = productInfoPage.viewCart();
		Assert.assertEquals(cartPage.getCartPageTitle(), "Shopping Cart");
	}
	
	@Test(priority=2)
	public void getShoppingCartHeaderValueTest() {
		Assert.assertEquals(cartPage.getShoppingCartHeaderValue(), "Shopping Cart  (5.00kg)");
	}
	
	@Test(priority=3)
	public void isContinueShoppingExistTest() {
		Assert.assertTrue(cartPage.isContinueShoppingExist());
	}
	
	@Test(priority=4)
	public void isAlertDisplayed() {
		Assert.assertTrue(cartPage.isAlertDisplayed());
	}
	
	@Test(priority=5)
	public void doRemoveItem() {
		Assert.assertTrue(cartPage.doRemoveItem() == 1);
	}
	
	
	
	
	
	
	
	
	
	
}

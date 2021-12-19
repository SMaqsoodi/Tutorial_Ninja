package com.qa.tutorialninja.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {
	
	@BeforeClass
	public void productInfoPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("emailId"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void productInfoPageTitleTest_iMac() {
		accountPage.doSearch("iMac");
		
		productInfoPage = accountPage.selectProductFromResults("iMac");
		Assert.assertEquals(productInfoPage.getProductInfoPageTitle("iMac"), "iMac");
	}
	
	// we can have multiple assertion in a single @Test and verify all methods from the page class
	@Test(priority=3)
	public void productInfoTest_MacBook() {
		String productName = "MacBook";
		Assert.assertTrue(accountPage.doSearch(productName));
		
		productInfoPage = accountPage.selectProductFromResults("MacBook Pro");
		
		Assert.assertEquals(productInfoPage.getProductImages(), 4);
		
		Map<String, String> productInfoMap = productInfoPage.productInfo();
		System.out.println(productInfoMap);
		Assert.assertEquals(productInfoMap.get("ProductName"), "MacBook Pro");
		Assert.assertEquals(productInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productInfoMap.get("Availability"), "In Stock");
		Assert.assertEquals(productInfoMap.get("Price"), "$2,000.00");
		Assert.assertEquals(productInfoMap.get("Ex Tax"), "$2,000.00");	
		Assert.assertEquals(productInfoMap.get("Product Code"), "Product 18");
		Assert.assertEquals(productInfoMap.get("Reward Points"), "800");
	
		
	}
	
	@Test(priority=2)
	public void productInfoTest_iMac() {
		
		String productName = "iMac";
		
		Assert.assertTrue(accountPage.doSearch(productName));
		
		productInfoPage = accountPage.selectProductFromResults("iMac");
		
		Assert.assertEquals(productInfoPage.getProductImages(), 3);
		
		Map<String, String> productInfoMap = productInfoPage.productInfo();
		System.out.println(productInfoMap);
		Assert.assertEquals(productInfoMap.get("ProductName"), "iMac");
		Assert.assertEquals(productInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(productInfoMap.get("Availability"), "Out Of Stock");
		Assert.assertEquals(productInfoMap.get("Price"), "$100.00");
		Assert.assertEquals(productInfoMap.get("Ex Tax"), "$100.00");	
		Assert.assertEquals(productInfoMap.get("Product Code"), "Product 14");
		//Assert.assertEquals(productInfoMap.get("Reward Points"), "800");
	
		
	}
	
	@Test(priority=4)
	public void addToCartTest() {
		Map<String, String> productInfoMap = productInfoPage.productInfo();
		Assert.assertEquals(productInfoMap.get("ProductName"), productInfoPage.addToCart());
	}

	
}

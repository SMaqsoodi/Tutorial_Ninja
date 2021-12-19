package com.qa.tutorialsninja.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.tutorialsninja.base.BasePage;
import com.qa.tutorialsninja.utils.ElementUtil;

public class ProductInfoPage extends BasePage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By productNameHeader = By.cssSelector("div#content h1");
	
	// an exmample of using nth-of-tyep() in css selector like using (xpath)[] in xpath
	private By productMetaData = By.cssSelector("div#content .list-unstyled:nth-of-type(1) li");
	private By productPrice = By.cssSelector("div#content .list-unstyled:nth-of-type(2) li");
	private By ProductQuantity = By.cssSelector("input-quantity");
	private By addToCartButton = By.cssSelector("button#button-cart");
	private By productImages = By.cssSelector(".thumbnails li img");
	private By addToCartMessage = By.cssSelector("ul.breadcrumb :nth-of-type(3) a");
	private By cartTotal = By.cssSelector("span#cart-total");
	private By viewCart = By.cssSelector("p.text-right a:nth-of-type(1)");
	
	// constructor	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
		
	// page actions
	public Map<String, String> productInfo() {
		
		Map<String, String> productInfoMap = new HashMap<>();
		
		productInfoMap.put("ProductName", elementUtil.getElementText(productNameHeader).trim());
		
		List<WebElement> productMetaDataList = elementUtil.getElements(productMetaData);
		for(WebElement e : productMetaDataList) {
			productInfoMap.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim()); 
		}
		
		List<WebElement> productPriceList = elementUtil.getElements(productPrice);
		productInfoMap.put("Price", productPriceList.get(0).getText().trim());
		productInfoMap.put(productPriceList.get(1).getText().split(":")[0].trim(), productPriceList.get(1).getText().split(":")[1].trim());
		
		return productInfoMap;
		}
	
	public void selectQuantity(String quantity) {
		elementUtil.doSendKeys(ProductQuantity, quantity);
	}
	
	public String addToCart() {
		elementUtil.getElement(addToCartButton).click();
		return elementUtil.getElement(addToCartMessage).getText();
	}
	
	public int getProductImages() {
		int imgCount = elementUtil.getElements(productImages).size();
		System.out.println("total number of images are : " + imgCount);
		return imgCount;
	}

	public String getProductInfoPageTitle(String productName) {
		return elementUtil.waitForPageTitle(productName, 10);
		
	}
	
	public CartPage viewCart() {
		elementUtil.doClick(cartTotal);
		elementUtil.doClick(viewCart);
		
		return new CartPage(driver);
	}
	
	
}

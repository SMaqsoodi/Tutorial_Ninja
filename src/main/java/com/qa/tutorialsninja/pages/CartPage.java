package com.qa.tutorialsninja.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.tutorialsninja.base.BasePage;
import com.qa.tutorialsninja.utils.ElementUtil;

public class CartPage extends BasePage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	//By locators
	private By shoppingCartHeader = By.cssSelector("#content h1");
	private By continueShoppingLink = By.linkText("Continue Shopping");
	private By CheckOutLink = By.linkText("Checkout");
	private By itemsInCart = By.cssSelector("form .table tbody tr");
	
	int rowCount = elementUtil.getElements(itemsInCart).size();
	private String ItemsFirstPartPath = "//div[@class='table-responsive']//tbody/tr[";
	private String ItemsSecondPartPath = "]/td[2]/span";
	private By alertMessage = By.cssSelector("div.alert");
	//private By itemsNotAvailable = By.xpath("//div[@class='table-responsive']//tbody/tr[1]/td[2]/span");
	//private By itemsAvailable = By.xpath("//div[@class='table-responsive']//tbody/tr[1]/td[2]/a");
	//private By removeButton; // 
	String primarXPathRemoveButtonPart1= "(//div[@class='table-responsive']//tbody//tr//td[@class='text-left']//span//button[@type='button'])[";
	String primarXPathRemoveButtonPart2= "]";
	
	// constructor
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// page actions
	public String getCartPageTitle() {
		String cartPageTitle = elementUtil.getPageTitle();
		System.out.println("cart page title is : " + cartPageTitle);
		
		return cartPageTitle;
	}
	
	public String getShoppingCartHeaderValue() {
		String cartPageheader = elementUtil.getElementText(shoppingCartHeader);
		System.out.println("cart page header is : " + cartPageheader);
		
		return cartPageheader;
	}
	
	public boolean isContinueShoppingExist() {
		if(elementUtil.isDisplayed(continueShoppingLink)) {
			return true;
		}
		else { 
			return false;
			
		}
	}
	
	public boolean isAlertDisplayed() {
		if(elementUtil.isDisplayed(alertMessage)) {
			System.out.println("Alert message : \n" + elementUtil.getElementText(alertMessage));
			return true;
		}
		else { 
			return false;
			
		}
	}
	
	public int doRemoveItem() {
		List<WebElement> items = elementUtil.getWebTableItems(ItemsFirstPartPath, ItemsSecondPartPath, rowCount);
		int removedItemscount = 0;
		for(int i=0; i<items.size(); i++) {
			if(items.get(i).getText().equals("***")) {
//				String finalPathRemoveButton = primarXPathRemoveButton+"["+i+"]";
//				removeButton = By.xpath(finalPathRemoveButton);
//				elementUtil.doClick(removeButton);
				List<WebElement> itemRemoveButton = elementUtil.getWebTableItems(primarXPathRemoveButtonPart1, primarXPathRemoveButtonPart2, rowCount);
				itemRemoveButton.get(i).click();
				removedItemscount ++;
			}
		}
		System.out.println(removedItemscount + " Itesm has been removed from yoru cart!");
		return removedItemscount;
		
	
	}
	
	public CheckOutPage doCheckOut() {
		elementUtil.doClick(CheckOutLink);
		
		return new CheckOutPage(driver);
	}
	
	
}

package com.qa.tutorialsninja.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String LOGIN_PAGE_HEADER = "Your Store";
	public static final String ACCOUNT_PAGE_HEADER = "Your Store";
	public static final int ACCOUNT_PAGE_HEADERS_COUNT = 4;
	
	// since the Section Headers are constant we can write a method in Constants class
	public static List<String> getAccountSectionList() {
		List<String> accSecList = new ArrayList<String>();
		accSecList.add("My Account");
		accSecList.add("My Orders");
		accSecList.add("My Affiliate Account");
		accSecList.add("Newsletter");
		
		return accSecList;
	}
}

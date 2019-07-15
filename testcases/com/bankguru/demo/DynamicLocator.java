package com.bankguru.demo;

public class DynamicLocator {

	public static void main(String[] args) {
		  String NEW_CUSTOMER_LINK = "//a[text()='New Customer']";
		  String FUND_TRANSFER_LINK = "//a[text()='Fund Transfer']";
		  String DEPOSIT_LINK = "//a[text()='Deposit']";
		  String NEW_ACCOUNT_LINK = "//a[text()='New Account']";
		  
		  String DYNAMIC_LINK_1_PARAM= "//a[text()='%s']";
		  String DYNAMIC_LINK_2_PARAM= "//a[text()='%s']//a[text()='%s']";
		  String DYNAMIC_LINK_3_PARAM= "//a[text()='%s']//a[text()='%s']//a[text()='%s']";
		  
		  clicktoElement(NEW_ACCOUNT_LINK);
		 
		  clicktoElement(DYNAMIC_LINK_1_PARAM, "DEPOSIT1");
		  clicktoElement2(DYNAMIC_LINK_2_PARAM, "DEPOSIT1","DEPOSIT2");
		  clicktoElement3(DYNAMIC_LINK_3_PARAM, "DEPOSIT1", "DEPOSIT2","DEPOSIT3");

	}
	
	public static void clicktoElement(String pageName) {
		//wait to element
		//click to element
		System.out.println(pageName);
	}
	
	public static void clicktoElement(String pageName, String dynamicValue) {
		//wait to element
		//click to element
		System.out.println(String.format(pageName, dynamicValue));
	}
	public static void clicktoElement2(String pageName, String dynamicValue01, String dynamicValue02 ) {
		//wait to element
		//click to element
		System.out.println(String.format(pageName, dynamicValue01, dynamicValue02));
	}
	public static void clicktoElement3(String pageName, String dynamicValue01, String dynamicValue02, String dynamicValue03) {
		//wait to element
		//click to element
		System.out.println(String.format(pageName, dynamicValue01, dynamicValue02, dynamicValue03 ));
	}

}

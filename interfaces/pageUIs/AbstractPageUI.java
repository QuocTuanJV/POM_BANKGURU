package pageUIs;

public class AbstractPageUI {
	//LINK 
	public static final String NEW_CUSTOMER_LINK = "//a[text()='New Customer']";
	public static final String FUND_TRANSFER_LINK = "//a[text()='Fund Transfer']";
	public static final String DEPOSIT_LINK = "//a[text()='Deposit']";
	public static final String NEW_ACCOUNT_LINK = "//a[text()='New Account']";
	
	//DISPLAY
	public static final String DEPOSIT_DISPLAY = "//p[text()='Amount Deposit Form']";
	public static final String FUND_TRANSFER_DISPLAY_TEXT = "//p[text()='Fund transfer']";
	public static final String NEW_ACCOUNT_DISPLAY_TEXT = "//p[text()='Add new account form']";
	
	public static final String NEW_CUSTOMER_WRONG_TEXT = "//p[text()='Add New Customer123']";////p[text()='Add New Customer123']
	public static final String NEW_CUSTOMER_DISPLAY_TEXT = "//p[text()='Add New Customer']";////p[text()='Add New Customer123']
	
	public static final String NEW_CUSTOMER_UNDISPLAY_TEXT = "//form[@name='addcust']";
	
	
	//DYNAMIC LINK
	public static final String DYNAMIC_LINK = "//a[text()='%s']";
	public static final String DYNAMIC_TEXT_FIELD_LINK = "//input[@name='%s']";
	public static final String DYNAMIC_BUTTON_LINK = "//input[@name='%s']";//with button
	public static final String DYNAMIC_TEXT_AREA_LINK = "//textarea[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_LINK = "//input[@value ='%s']";
	

}

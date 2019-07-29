package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.FundTransferPageUI;
import pageUIs.HomePageUI;
import pageUIs.NewAccountPageUI;
import pageUIs.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPage {
	WebDriver driver;
	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	

	
	public boolean isControlNoDOMNoNote() {
		waitToElementInvisible(driver, AbstractPageUI.NEW_CUSTOMER_WRONG_TEXT);
		return isControlUnDisplayedCustomize(driver, AbstractPageUI.NEW_CUSTOMER_WRONG_TEXT);
	}
	
	public boolean isHomePageNoDOMUnDisplay() {
		waitToElementInvisible(driver, HomePageUI.HOME_TEXT);
		return isControlUnDisplayedCustomize(driver, HomePageUI.HOME_TEXT);
	}
	
	public boolean isNewCustomerDisplay() {
		waitToElementVisible(driver, AbstractPageUI.NEW_CUSTOMER_DISPLAY_TEXT);
		return isControlDisPlayCustomize(driver, AbstractPageUI.NEW_CUSTOMER_DISPLAY_TEXT);
	}
	
		
	public boolean isNewCustomerOnDOMUnDisplay() {
		waitToElementInvisible(driver, AbstractPageUI.NEW_CUSTOMER_UNDISPLAY_TEXT);
		return isControlUnDisplayedCustomize(driver, AbstractPageUI.NEW_CUSTOMER_UNDISPLAY_TEXT);
	}
		
}

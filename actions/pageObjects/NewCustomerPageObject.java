package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.FundTransferPageUI;
import pageUIs.NewAccountPageUI;
import pageUIs.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPage {
	WebDriver driver;
	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isControlDisplay() {
		waitToElementVisible(driver, AbstractPageUI.NEW_CUSTOMER_DISPLAY_TEXT);
		return isControlDisplayed(driver, AbstractPageUI.NEW_CUSTOMER_DISPLAY_TEXT);
	}
		
	public boolean isNewCustomerFormUndisplay() {
		waitToElementInvisible(driver, AbstractPageUI.NEW_CUSTOMER_UNDISPLAY_TEXT);
		return isControlUnDisplayed(driver, AbstractPageUI.NEW_CUSTOMER_UNDISPLAY_TEXT);
	}
		
}

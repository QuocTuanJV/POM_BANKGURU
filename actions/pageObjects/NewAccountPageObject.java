package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.DepositPageUI;
import pageUIs.FundTransferPageUI;
import pageUIs.NewAccountPageUI;
import pageUIs.NewCustomerPageUI;

public class NewAccountPageObject extends AbstractPage {
	WebDriver driver;
	public NewAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
}

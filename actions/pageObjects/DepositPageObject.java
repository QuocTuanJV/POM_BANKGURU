package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.DepositPageUI;
import pageUIs.FundTransferPageUI;
import pageUIs.HomePageUI;

public class DepositPageObject extends AbstractPage {
	WebDriver driver;
	public DepositPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
}

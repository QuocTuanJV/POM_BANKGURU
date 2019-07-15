package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.DepositPageUI;
import pageUIs.FundTransferPageUI;

public class FundTransferPageObject extends AbstractPage {
	WebDriver driver;
	public FundTransferPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isFundTransferPageDisPlay() {
		waitToElementVisible(driver, FundTransferPageUI.FUND_TRANSFER_DISPLAY_TEXT);
		return isControlDisplayed(driver, FundTransferPageUI.FUND_TRANSFER_DISPLAY_TEXT);
	}

}

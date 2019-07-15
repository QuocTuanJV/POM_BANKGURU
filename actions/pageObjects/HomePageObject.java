package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.FundTransferPageUI;
import pageUIs.HomePageUI;
import pageUIs.NewCustomerPageUI;

public class HomePageObject extends AbstractPage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isHomePageDisplay() {
		waitToElementVisible(driver, HomePageUI.HOME_TEXT);
		return isControlDisplayed(driver, HomePageUI.HOME_TEXT);
	}
	
}

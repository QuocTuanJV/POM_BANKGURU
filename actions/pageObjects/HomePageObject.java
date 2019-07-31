package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.FundTransferPageUI;
import pageUIs.HomePageUI;
import pageUIs.NewCustomerPageUI;

public class HomePageObject extends AbstractPage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
//		By Locator = By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank'\"]")
	}
	
	public boolean isHomePageDisplay() {
		waitToElementVisible(driver, HomePageUI.HOME_TEXT);
		return isControlDisplayed(driver, HomePageUI.HOME_TEXT);
	}
	
	public boolean isHomePageNotDisplayWrongLocator() {
		waitToElementInvisible(driver, HomePageUI.HOME_WRONG_TEXT);
		return isControlDisplayed(driver, HomePageUI.HOME_WRONG_TEXT);
	}
	
	public boolean isHomePageUndisPlay() {
		return isControlUnDisplayedCustomize(driver, HomePageUI.HOME_WRONG_TEXT);
	}
	public boolean isPageDisplayDynamic(WebDriver driver,String locator,String...dynamicValue) {
		waitToElementVisible(driver, locator, dynamicValue);
		return isControlDisPlayCustomizeDynamic(driver, locator, dynamicValue);
	}
	
}

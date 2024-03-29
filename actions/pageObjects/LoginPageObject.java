package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openHomePage(String url) {
		openURL(driver, url);
	}
	
	public String getCurrentURL() {
		return getCurrentURL(driver);
	}

	public void inputToUserIDTextbox(String userIDRegister) {
		waitToElementVisible(driver, LoginPageUI.USERID_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERID_TEXTBOX, userIDRegister);
	}

	public void inputToPasswordTextbox(String passwordRegister) {
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordRegister);
	}

	public HomePageObject clickToLoginButton() {
		waitToElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageFactoryManager.getHomePage(driver);
	}

	public RegisterPageObject clickToHereLink() {
		waitToElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageFactoryManager.getRegisterPage(driver);
	}
}

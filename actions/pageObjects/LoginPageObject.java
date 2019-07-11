package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	
	private WebDriver driver;
	
	public void inputToUserIDTextbox(String userIDRegister ) {
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERID_TEXTBOX, userIDRegister);
	}

	public void inputToPasswordTextbox() {

	}

	public void clickToLoginButton() {

	}

	public void clickToHereLink() {

	}
}

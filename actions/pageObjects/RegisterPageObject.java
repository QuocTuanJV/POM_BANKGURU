package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToEmailIDTextbox(String emailResgister) {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_REGISTER);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_REGISTER, emailResgister);
	}
	public void clickToSubmitButton() {
		waitToElementVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}
	public String getUserIDText() {
		waitToElementVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getTextInElement(driver, RegisterPageUI.USER_ID_TEXT);
	}
	public String getPassWordText() {
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_ID_TEXT);
		return getTextInElement(driver, RegisterPageUI.PASSWORD_ID_TEXT);
	}
	
	public LoginPageObject openLoginPage(String loginPageURL) {
		openURL(driver, loginPageURL);
		return PageFactoryManager.getLoginPage(driver);
	}
	
	
	
	
}

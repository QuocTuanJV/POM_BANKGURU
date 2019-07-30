package com.bankguru.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import pageObjects.DepositPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;
import pageUIs.AbstractPageUI;

public class Account_01_Level_9_DynamicPageObject_PageElement_PageUI extends AbstractTest {

	private WebDriver driver;
	private String emailRegister;
	private String userIDRegister;
	private String passwordRegister;
	private String urlHomepage;

	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePageObject;
	private NewCustomerPageObject newCustomerPage;
	private NewAccountPageObject newAccountPage;
	private DepositPageObject depositPage;
	private FundTransferPageObject fundTransferPage;

	private String customerName, gender, dateOfBirth, address, city, state, pin, phone, emailNewCustomer,
			passwordNewCustomer;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		emailRegister = "luongtuan" + randomNumber() + "@gmail.com";

		driver = openMultiBrowser(browserName);
		loginPage = PageFactoryManager.getLoginPage(driver);
		customerName = "Selenium Online";
		gender = "f";
		dateOfBirth = "01/01/2019";
		address = "258 Le duan";
		city = "Sai Gon";
		state = "Thu Duc";
		pin = "362562";
		phone = "01234567899";
		emailNewCustomer = "TUANLQ" + randomNumber() + "@gmail.com";
		passwordNewCustomer = "12345678";

	}

	@Test(description = "Register to system")
	public void TC_01_Register() {
		urlHomepage = loginPage.getCurrentURL();
		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailIDTextbox(emailRegister);
		registerPage.clickToSubmitButton();
		userIDRegister = registerPage.getUserIDText();
		passwordRegister = registerPage.getPassWordText();
	}

	@Test(description = "Login to system")
	public void TC_02_LoginWithAboveInformation() {
		loginPage = registerPage.openLoginPage(urlHomepage);
		loginPage.inputToUserIDTextbox(userIDRegister);
		loginPage.inputToPasswordTextbox(passwordRegister);
		homePageObject = loginPage.clickToLoginButton();
		homePageObject.isHomePageDisplay();
	}
	
	@Test(description = "Open Page")
	public void TC_03_OpenPageDynamic() {
		//Homepage > New Customer > New Account > Deposit > Fund Transfer
		log.info("TC_03_Open New Customer Page");
		newCustomerPage = (NewCustomerPageObject)homePageObject.openPageCustomizeDynamic(driver, AbstractPageUI.DYNAMIC_LINK, "New Customer");
		
		log.info("TC_03_Open New Account Page");
		newAccountPage = (NewAccountPageObject) newCustomerPage.openPageCustomizeDynamic(driver, AbstractPageUI.DYNAMIC_LINK, "New Account");
		
	}
	

	@Test(description = "Create New Customer")
	public void TC_04_DynamicPageObjectPageElementPageUI() {
		// Home Page > New Customer
		log.info("TC 04 Open New Customer Page");
		newCustomerPage = (NewCustomerPageObject) homePageObject.openPageCustomizeDynamic(driver, AbstractPageUI.DYNAMIC_LINK, "New Customer");

		// Verify Page New Customer is Display
		log.info("TC 04 Verify Customer Page Display");
		verifyTrue(newCustomerPage.isNewCustomerDisplay());

		// Input field
		log.info("TC 04 In put field");
//		newCustomerPage.scrollToElementByJavascript(driver, javaExecutor, AbstractPageUI.DYNAMIC_BUTTON_LINK, "sub");
		newCustomerPage.inputTextFieldDynamic(driver, AbstractPageUI.DYNAMIC_TEXT_FIELD_LINK, customerName, "name");
		newCustomerPage.inputRadioButtonDynamic(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON_LINK, "f");
		newCustomerPage.inputTextFieldDynamic(driver, AbstractPageUI.DYNAMIC_TEXT_FIELD_LINK, dateOfBirth, "dob");
		newCustomerPage.inputTextAreaDynamic(driver, AbstractPageUI.DYNAMIC_TEXT_AREA_LINK, address, "addr");
		newCustomerPage.inputTextFieldDynamic(driver, AbstractPageUI.DYNAMIC_TEXT_FIELD_LINK, city, "city");
		newCustomerPage.inputTextFieldDynamic(driver, AbstractPageUI.DYNAMIC_TEXT_FIELD_LINK, state, "state");
		newCustomerPage.inputTextFieldDynamic(driver, AbstractPageUI.DYNAMIC_TEXT_FIELD_LINK, pin, "pinno");
		newCustomerPage.inputTextFieldDynamic(driver, AbstractPageUI.DYNAMIC_TEXT_FIELD_LINK, phone, "telephoneno");
		newCustomerPage.inputTextFieldDynamic(driver, AbstractPageUI.DYNAMIC_TEXT_FIELD_LINK, emailNewCustomer,
				"emailid");
		newCustomerPage.inputTextFieldDynamic(driver, AbstractPageUI.DYNAMIC_TEXT_FIELD_LINK, passwordNewCustomer,
				"password");

		log.info("TC 04 Click button submit");
		newCustomerPage.clickButtonDynamic(driver, AbstractPageUI.DYNAMIC_BUTTON_LINK, "sub");

	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

}

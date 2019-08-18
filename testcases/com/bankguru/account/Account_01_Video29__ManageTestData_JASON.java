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

public class Account_01_Video29__ManageTestData_JASON extends AbstractTest {

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
		dateOfBirth = "2019-01-01";
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
//		System.out.println("========TRINH DUYET========" + brow);
		urlHomepage = loginPage.getCurrentURL();
		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailIDTextbox(emailRegister);
		registerPage.clickToSubmitButton();
		userIDRegister = registerPage.getUserIDText();
		passwordRegister = registerPage.getPassWordText();
	}

	@Test(description = "Login to system")
	public void TC_02_LoginWithAboveInformation() {
//		System.out.println("====TC02====="+ br);
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
		log.info("TC_03_Verify New Customer Page is Display");
		verifyTrue(newCustomerPage.isPageDisplayDynamic(driver, "Add New Customer"));
		log.info("TC_03_Open New Account Page");
		newAccountPage = (NewAccountPageObject) newCustomerPage.openPageCustomizeDynamic(driver, AbstractPageUI.DYNAMIC_LINK, "New Account");
		log.info("TC_03_Verify New Account Page is Display");
		verifyTrue(newAccountPage.isPageDisplayDynamic(driver, "Add new account form"));
		log.info("TC_03_Open Home Page");
		homePageObject = (HomePageObject)newAccountPage.openPageCustomizeDynamic(driver, AbstractPageUI.DYNAMIC_LINK, "Manager");
		log.info("TC_03_Verify Home Page is Display");
		verifyTrue(homePageObject.isPageDisplayDynamic(driver,AbstractPageUI.DYNAMIC_VERIFY_MARQUEE_PAGE_TEXT ,"Welcome To Manager's Page of Guru99 Bank"));
		
		
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
		newCustomerPage.scrollToElementByJavascript(driver, javaExecutor, AbstractPageUI.DYNAMIC_BUTTON_LINK, "sub");
		newCustomerPage.inputTextFieldDynamic(driver, AbstractPageUI.DYNAMIC_TEXT_FIELD_LINK, customerName, "name");
		newCustomerPage.inputRadioButtonDynamic(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON_LINK, "m");
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
		log.info("TC 04 Verify Page Customer Registered Successfully");
		verifyTrue(newCustomerPage.isPageDisplayDynamic(driver, "Customer Registered Successfully!!!"));
		log.info("TC 04 Verify Display Customer ID");
		
		log.info("TC 04 Verify Display Customer Name");
		verifyEquals(customerName,newCustomerPage.getDataDynamic(driver, "Customer Name") );
		
		log.info("TC 04 Verify Display Gender");
		verifyEquals(newCustomerPage.getDataDynamicGender(driver, "Gender"), gender);
		
		log.info("TC 04 Verify Display Birthdate");	
		verifyEquals(dateOfBirth,newCustomerPage.getDataDynamic(driver,"Birthdate"));
		
		log.info("TC 04 Verify Display Address");
		verifyEquals(address,newCustomerPage.getDataDynamic(driver,"Address"));
		
		log.info("TC 04 Verify Display City");
		verifyEquals(city,newCustomerPage.getDataDynamic(driver,"City"));
		
		log.info("TC 04 Verify Display State");
		verifyEquals(state,newCustomerPage.getDataDynamic(driver,"State"));
		
		log.info("TC 04 Verify Display Pin");
		verifyEquals(pin,newCustomerPage.getDataDynamic(driver,"Pin"));
		
		log.info("TC 04 Verify Display Mobile No.");
		verifyEquals(phone,newCustomerPage.getDataDynamic(driver,"Mobile No."));
		
		log.info("TC 04 Verify Display Email");
		verifyEquals(emailNewCustomer,newCustomerPage.getDataDynamic(driver,"Email"));
		
		
		

	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

}

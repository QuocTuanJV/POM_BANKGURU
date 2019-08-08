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

public class Account_01_Video27_Setup_IE11_By_Function_Click extends AbstractTest {

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
	


	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

}

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
import pageUIs.HomePageUI;

public class Account_01_Register_Login_Global extends AbstractTest {

	private WebDriver driver;
	private String emailRegister;
	public static String userIDRegister;
	public static String passwordRegister;
	private String urlHomepage;

	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePageObject;
	private NewCustomerPageObject newCustomerPage;
	private NewAccountPageObject newAccountPage;
	private DepositPageObject depositPage;
	private FundTransferPageObject fundTransferPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		emailRegister = "luongtuan" + randomNumber() + "@gmail.com";
		driver = openMultiBrowser(browserName);
		loginPage = PageFactoryManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Register() {
		log.info("Account_01 - Step 01: Get Login Page URL");
		urlHomepage = loginPage.getCurrentURL();
				
		log.info("Account_01 - Step 02: Click to here link");
		registerPage = loginPage.clickToHereLink();
		
		log.info("Account_01 - Step 03: Input data to Email");
		registerPage.inputToEmailIDTextbox(emailRegister);
		
		log.info("Account_01 - Step 04: Click to Submit button");
		registerPage.clickToSubmitButton();
		
		log.info("Account_01 - Step 05: Get UserID and Password");
		userIDRegister = registerPage.getUserIDText();
		passwordRegister = registerPage.getPassWordText();
		log.info("User: " + userIDRegister);
		log.info("Pass: " + passwordRegister);
	}

//	@Test
//	public void TC_02_LoginWithAboveInformation() {
//		log.info("Account_02 - Step 01: Open URL");
//		loginPage = registerPage.openLoginPage(urlHomepage);
//			
//		log.info("Account_02 - Step 02: Input ID and Pass");
//		loginPage.inputToUserIDTextbox(userIDRegister);
//		loginPage.inputToPasswordTextbox(passwordRegister);
//		
//		log.info("Account_02 - Step 03: Click to Login button");
//		homePageObject = loginPage.clickToLoginButton();
////		Assert.assertTrue(homePageObject.isHomePageNotDisplayWrongLocator());
		
		
		
//		
//	}

//	@Test
//	public void TC_03_CheckUnDisplayed_OverrideTimeout() {
//		//Home Page > New Customer
//		newCustomerPage = (NewCustomerPageObject) homePageObject.openDynamicPage(driver, "New Customer");
//		
//		//locator dung nhung khong tim thay trong 
////		Assert.assertTrue(newCustomerPage.isControlNoDOMNoNote());
//		
//	
//	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

}

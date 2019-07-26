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

public class Account_01_Level_6_DynamicLocator_RestParameter extends AbstractTest {

	private WebDriver driver;
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
//		emailRegister = "luongtuan" + randomNumber() + "@gmail.com";
		driver = openMultiBrowser(browserName);
		loginPage = PageFactoryManager.getLoginPage(driver);
	}

//	@Test
//	public void TC_01_Register() {
//		urlHomepage = loginPage.getCurrentURL();
//		registerPage = loginPage.clickToHereLink();
//		registerPage.inputToEmailIDTextbox(emailRegister);
//		registerPage.clickToSubmitButton();
//		userIDRegister = registerPage.getUserIDText();
//		passwordRegister = registerPage.getPassWordText();
//	}

	@Test
	public void TC_02_LoginWithAboveInformation() {
//		loginPage = registerPage.openLoginPage(urlHomepage);
		loginPage.inputToUserIDTextbox(Account_01_Register_Login_Global.userIDRegister);
		loginPage.inputToPasswordTextbox(Account_01_Register_Login_Global.passwordRegister);
		homePageObject = loginPage.clickToLoginButton();
		homePageObject.isHomePageDisplay();
		log.info("User: " + Account_01_Register_Login_Global.userIDRegister);
		log.info("Pass: " + Account_01_Register_Login_Global.passwordRegister);
	}

//	@Test
//	public void TC_03_DynamicLocator_RestParameter() {
//		//Home Page > New Customer
//		newCustomerPage = (NewCustomerPageObject) homePageObject.openDynamicPage(driver, "New Customer");
//	
//		//Customer Page > New Account Page
//		newAccountPage = (NewAccountPageObject) newCustomerPage.openDynamicPage(driver, "New Account");
//		Assert.assertTrue(newAccountPage.isNewAccountPageDisPlay(driver));
//		//New Account Page > Deposit Page
//		depositPage = (DepositPageObject) newAccountPage.openDynamicPage(driver, "Deposit");
//		Assert.assertTrue(depositPage.isDepositPageDisPlay(driver));
//		//Deposit Page > Fund Transfer Page
//		fundTransferPage = (FundTransferPageObject) depositPage.openDynamicPage(driver, "Fund Transfer");
//		Assert.assertTrue(fundTransferPage.isFundTransferPageDisPlay());
//		//100 -> 1000 page
//		depositPage.openDynamicPage(driver, "Manager");
//		homePageObject = PageFactoryManager.getHomePage(driver);
//		Assert.assertTrue(homePageObject.isHomePageDisplay());
//		
//	
//	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

}

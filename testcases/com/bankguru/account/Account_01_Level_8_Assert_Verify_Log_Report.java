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

public class Account_01_Level_8_Assert_Verify_Log_Report extends AbstractTest {

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

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		emailRegister = "luongtuan" + randomNumber() + "@gmail.com";
		driver = openMultiBrowser(browserName);
		loginPage = PageFactoryManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Register() {
		urlHomepage = loginPage.getCurrentURL();
		registerPage = loginPage.clickToHereLink();
		registerPage.inputToEmailIDTextbox(emailRegister);
		registerPage.clickToSubmitButton();
		userIDRegister = registerPage.getUserIDText();
		passwordRegister = registerPage.getPassWordText();
	}

	@Test
	public void TC_02_LoginWithAboveInformation() {
		loginPage = registerPage.openLoginPage(urlHomepage);
		loginPage.inputToUserIDTextbox(userIDRegister);
		loginPage.inputToPasswordTextbox(passwordRegister);
		homePageObject = loginPage.clickToLoginButton();
		verifyFalse(homePageObject.isHomePageUndisPlay());
		
	}

	@Test
	public void TC_03_CheckUnDisplayed_OverrideTimeout() {
		//Home Page > New Customer
		newCustomerPage = (NewCustomerPageObject) homePageObject.openDynamicPage(driver, "New Customer");
		
		verifyFalse(newCustomerPage.isNewCustomerDisplay());
		//size = 0
		//Khong hien thi vi khong tim thay xpath
		Assert.assertTrue(newCustomerPage.isControlNoDOMNoNote());
		
		//check undisplay HomePage size = 0
//	Assert.assertTrue(newCustomerPage.isControlUnDisplayed(driver, HomePageUI.HOME_TEXT));
		Assert.assertTrue(newCustomerPage.isHomePageNoDOMUnDisplay());
		
		//check undisplay NewCustomer size = 1
//		Assert.assertTrue(newCustomerPage.isNewCustomerFormUndisplay());
		//Ton tai element nhung khong hien thi
		verifyTrue(newCustomerPage.isNewCustomerOnDOMUnDisplay());
		//
//		verifyTrue(newCustomerPage.isNewCustomerDisplay());
		
	
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

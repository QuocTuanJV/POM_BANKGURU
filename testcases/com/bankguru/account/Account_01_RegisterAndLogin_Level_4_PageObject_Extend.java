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
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;

public class Account_01_RegisterAndLogin_Level_4_PageObject_Extend extends AbstractTest {

	private WebDriver driver;
	private String emailRegister;
	private String userIDRegister;
	private String passwordRegister;
	private String urlHomepage;

	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePageObject;

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
		// Step 01
		registerPage.inputToEmailIDTextbox(emailRegister);
		// Step 02
		registerPage.clickToSubmitButton();
		// get information
		userIDRegister = registerPage.getUserIDText();
		passwordRegister = registerPage.getPassWordText();

	}

	@Test
	public void TC_02_LoginWithAboveInformation() {
		// open HomePage
		loginPage = registerPage.openLoginPage(urlHomepage);

		// input information
		loginPage.inputToUserIDTextbox(userIDRegister);
		loginPage.inputToPasswordTextbox(passwordRegister);
		// click login Button
		homePageObject = loginPage.clickToLoginButton();

		// verify homepage
		homePageObject.isHomePageDisplay();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	

}

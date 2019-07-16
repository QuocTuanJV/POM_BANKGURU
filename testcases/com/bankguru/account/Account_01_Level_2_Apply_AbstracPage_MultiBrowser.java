package com.bankguru.account;

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


public class Account_01_Level_2_Apply_AbstracPage_MultiBrowser extends AbstractTest {

    private WebDriver driver;

	private String userIDRegister;
	private String passwordRegister;
	private String urlHompage;
	
	private AbstractPage abstractPage;

	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
	
		driver = openMultiBrowser(browserName);
		System.out.println("Driver Extends: "+ driver.toString());
		
		abstractPage = new AbstractPage();

	}

	@Test
	public void TC_01_Register() {
		String mailRegister = "luongtuan" + abstractPage.randomNumber() + "@gmail.com";
		//Open link
		abstractPage.openURL(driver, "http://demo.guru99.com/v4/");
		
		//get current Link
		urlHompage = abstractPage.getCurrentURL(driver);

		//click element
		abstractPage.clickToElement(driver, "//a[text()='here']");

		// Send mail
		abstractPage.sendkeyToElement(driver, "//input[@name='emailid']", mailRegister);
	
		// click submit
		abstractPage.clickToElement(driver, "//input[@name='btnLogin']");

		// get UserId and Password
		userIDRegister= abstractPage.getTextInElement(driver, "//td[text()='User ID :']//following-sibling::td");
		passwordRegister = abstractPage.getTextInElement(driver, "//td[text()='Password :']//following-sibling::td");

		System.out.println("Email: " + userIDRegister + " PassWord: " + passwordRegister);

	}

	@Test
	public void TC_02_LoginWithAboveInformation() {
		// Back to home page to login form
		abstractPage.openURL(driver, urlHompage);
		

		// send UserID and Password
		abstractPage.sendkeyToElement(driver, "//input[@name = 'uid']", userIDRegister);
		abstractPage.sendkeyToElement(driver, "//input[@name = 'password']", passwordRegister);
		// Click button Login
		abstractPage.clickToElement(driver, "//input[@name = 'btnLogin']");

		// Verify home page display

		Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]"))
				.isDisplayed());
		// Verify user

		Assert.assertTrue(
				driver.findElement(By.xpath("//td[text()='Manger Id : " + userIDRegister + "']")).isDisplayed());

	}

	@AfterClass
	public void afterClass() {
	}

	

}

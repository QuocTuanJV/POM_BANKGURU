package com.bankguru.account;

import org.testng.annotations.Test;

import commons.AbstractPage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import commons.AbstractPage;

public class Account_01_RegisterAndLogin_Level_2_Apply_AbstracPage_MultiBrowser {

	WebDriver driver;

	private String userIDRegister;
	private String passwordRegister;
	private String urlHompage;
	
	private AbstractPage abstractPage;
	
	

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		abstractPage = new AbstractPage();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

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
		System.out.println("--CLICK SUCCESS--");

		// Send mail
		abstractPage.sendkeyToElement(driver, "//input[@name='emailid']", mailRegister);
	
		// click submit
		abstractPage.clickToElement(driver, "//input[@name='btnLogin']");

		// get UserId and Password
		userIDRegister= abstractPage.getTextInElement(driver, "//td[text()='User ID :']//following-sibling::td");
		passwordRegister = abstractPage.getTextInElement(driver, "//td[text()='Password :']//following-sibling::td");

		System.out.println(userIDRegister + "-------" + passwordRegister);

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
		System.out.println(driver
				.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).getText());
		System.out.println("HOM PAGE IS DISPLAY");

		// Verify user

		Assert.assertTrue(
				driver.findElement(By.xpath("//td[text()='Manger Id : " + userIDRegister + "']")).isDisplayed());
		System.out.println("USER IS VERIFY");

	}

	@AfterClass
	public void afterClass() {
	}

	

}

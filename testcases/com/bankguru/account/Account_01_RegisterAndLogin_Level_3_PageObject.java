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
import pageObjects.LoginPageObject;


public class Account_01_RegisterAndLogin_Level_3_PageObject extends AbstractTest {

    private WebDriver driver;
    private String emailRegister;
	private String userIDRegister;
	private String passwordRegister;
	private String urlHompage;
	
	private LoginPageObject loginPage;
	
	

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		emailRegister = "luongtuan" + randomNumber() + "@gmail.com";
		driver = openMultiBrowser(browserName);
		loginPage = new LoginPageObject();
		
	

	}

	@Test
	public void TC_01_Register() {

	}

	@Test
	public void TC_02_LoginWithAboveInformation() {
		
	}
	
	

	@AfterClass
	public void afterClass() {
	}

	public int randomNumber() {
		Random rd = new Random();
		return rd.nextInt(10000);
	}

}

package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLink {
	
	WebDriver driver;
	
	private String userIDRegister;
	private String passwordRegister;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_Register() {
		String mailRegister = "luongtuan" + randomNumber() + "@gmail.com";
		
		driver.get("http://demo.guru99.com/v4/");
		
		//click here
		driver.findElement(By.xpath("//a[text()='here']")).click();
		
		System.out.println("--CLICK SUCCESS--");
		
		//Send mail
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(mailRegister);
		//click submit
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		//get UserId and Password
		 userIDRegister = driver.findElement(By.xpath("//td[text()='User ID :']//following-sibling::td")).getText();
		 passwordRegister = driver.findElement(By.xpath("//td[text()='Password :']//following-sibling::td")).getText();
		 
		 
			
	}
	@Test
	public void TC_02_LoginWithAboveInformation() {
		driver.switchTo().defaultContent();
	}
	

	@AfterClass
	public void afterClass() {
	}
	
	public int randomNumber() {
		Random rd = new Random();	
		return rd.nextInt(10000);
	}

}

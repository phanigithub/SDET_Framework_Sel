package com.inetBanking.testCases; 

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.testng.annotations.Test;

import com.inetBanking.Utilities.ReadConfig;
import com.inetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass{

	 ReadConfig rc = new ReadConfig();

	@Test
	public void LoginTesttScenario() {
		
		driver.get(rc.getConfigProperty("baseURL"));
		driver.manage().window().maximize();
		log.info("URL is opened");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		LoginPage lp = new LoginPage(driver);

		lp.setUserName(rc.getConfigProperty("userName"));
		lp.setPassword(rc.getConfigProperty("password"));
		log.info("UserName password set");

		lp.clickSubmit();		
		log.info("Submit");

		
		//Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
		log.setLevel((Level)Level.FATAL);
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			System.out.println("Login successful");
			log.info("Login is success	");
		}
		else {
			System.out.println("Login is not successful");
			log.error("Login is failed");
			CapureScreen(driver, "logintest");
		}
		
	}
}

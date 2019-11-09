package com.inetBanking.testCases; 

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.Utilities.ReadConfig;
import com.inetBanking.Utilities.XLUtils;
import com.inetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_DDT_001 extends BaseClass{

	 ReadConfig rc = new ReadConfig();

	@Test(dataProvider="Logininfo")
	public void LoginTesttScenario(String uname, String pwd) {
 		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get(rc.getConfigProperty("baseURL"));
		driver.manage().window().maximize();
		log.info("URL is opened");
		LoginPage lp = new LoginPage(driver);

		lp.setUserName(uname);
		lp.setPassword(pwd);
		log.info("UserName password set");

		lp.clickSubmit();		
		log.info("Submit");
 
		if(isAlertPresent())
		{
			System.out.println("ss -isAlertPresent");

			//System.out.println(driver.switchTo().alert().getText());
			
			driver.switchTo().alert().accept(); // close alert
			driver.switchTo().defaultContent(); // focus on main window
			Assert.assertTrue(false); // fail because login is un successful 
			log.warn("fail msg handle");

		}
		else
		{
			System.out.println("nn -isAlertPresent");


			Assert.assertTrue(true); // pass because login is un successful 
			lp.logoff();
			log.info("logoff done handle");

try {
	Thread.sleep(1000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
log.info("b4 msghandle change msg handle");

		//	System.out.println(driver.switchTo().alert().getText());

			driver.switchTo().alert().accept(); // close alert
			driver.switchTo().defaultContent(); // focus on main window

			
		}
			
			
			

		
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
	
	private boolean isAlertPresent() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			driver.switchTo().alert();
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//driver.switchTo().defaultContent();
			return false;
		}
		return true;
	}

	@DataProvider(name="Logininfo")
	public Object[][] getloginData() throws IOException{
		String tdPath = System.getProperty("user.dir")+"/TesT_DaTa/DaTa.xlsx";
		
		int rownum = XLUtils.getRowCount(tdPath, "Sheet1");
		int cellnum = XLUtils.getCellCount(tdPath, "Sheet1", 1);
		
		String logindata[][]  = new String[rownum][cellnum];
		
		for (int i = 1; i < rownum; i++) {
			
			for (int j = 0; j < cellnum; j++) {
				logindata[i-1][j] = XLUtils.getCellData(tdPath, "Sheet1",i,j);
				
				
			}
			
		} 
		 
		return logindata;
	}
	
}

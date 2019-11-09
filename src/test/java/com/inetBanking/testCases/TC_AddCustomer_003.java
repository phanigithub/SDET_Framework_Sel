package com.inetBanking.testCases;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.inetBanking.Utilities.ExtentReporting;
import com.inetBanking.Utilities.ReadConfig;
import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomer_003 extends BaseClass {
	
@Test
	public void AddCustomer() throws InterruptedException
	{
	
	ReadConfig rc = new ReadConfig();
	
	driver.get(rc.getConfigProperty("baseURL"));
	driver.manage().window().maximize();
	log.info("URL is opened");
	
	LoginPage lp = new LoginPage(driver);
	log.info("Login Page OBJ");
	
	
	
	lp.setUserName(rc.getConfigProperty("userName"));
	lp.setPassword(rc.getConfigProperty("password"));
	lp.clickSubmit();
	log.info("Login Page Done");

	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 Random r = new Random();
	IntStream x =  r.ints(100, 1000);
	String ssr = randemail(); //randemail();//// x.mapToObj(String::valueOf).collect(Collectors.joining(", ", "[", "]"));
	
	log.info("Add Customer Page OBJ");
	Reporter.log("Add Customer Page OBJ");

	AddCustomerPage ac = new AddCustomerPage(driver);
	ac.clickAddCustomer();
	log.info("Add Customer loading"+"User1"+ssr);
	Thread.sleep(5000);
	log.info("9000 loading");

	ac.CustomerName("Useru"+ssr);
	log.info("User Name provided");
	ExtentReporting.repoDescribe("User Name provided");

	
	ac.CustomerGender("male");
	log.info("gender provided");
	ExtentReporting.repoDescribe("gender provided");


	ac.Customerdob("10", "12", "1991");
	Thread.sleep(3000);
	log.info("dob provided");
	ExtentReporting.repoDescribe("dob provided");


	ac.CustomerAddress("INDIA");
	log.info("counr provided");
	ExtentReporting.repoDescribe("INDIA provided");


	ac.Customercity("bengaluru");
	log.info("place/ci provided");
	ExtentReporting.repoDescribe("place provided");


	ac.Customerstate("AP");
	log.info("sae provided");
	ExtentReporting.repoDescribe("sae provided");

	log.info(randnum());

	ac.Customerpinno("994897");
	log.info("pin provided");
	ExtentReporting.repoDescribe("pin provided");

	String mailid = randemail()+"nani."+ssr+"@gmail.com";
	ac.Customeremailid(mailid);
	log.info("email provided. "+mailid);
	ExtentReporting.repoDescribe(mailid+" email Name provided");


	
	ac.Customerphone("99826934");
	log.info("Phone # provided");
	ExtentReporting.repoDescribe("phone# Name provided");


	ac.Customerpassword("one");
	log.info("Password # provided");

	ac.FormSub();
	log.info("Done ...FormSub ");
	ExtentReporting.repoDescribe("Done ...FormSub ");


	Thread.sleep(5000);

	
	boolean isPresent = driver.getPageSource().contains("Customer Registered Successfully!!!");
	
			if(isPresent) {
				Assert.assertTrue(true);
				ExtentReporting.repoDescribe("Customer Registered Successfully!!! ");
			}
				

			else
			{
				CapureScreen(driver,"AddCustomer");
				Assert.assertTrue(false);
				ExtentReporting.repoDescribe("Customer Registered un -- Successfull!! ");
				
			}
				
			
	}

 public String randemail() {
	 return RandomStringUtils.randomAlphabetic(3);
	
 }
 public String randnum() {
	 return RandomStringUtils.randomNumeric(4);
	
 }
	
}

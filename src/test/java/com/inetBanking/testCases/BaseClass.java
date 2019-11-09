package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.beust.jcommander.Parameter;
import com.inetBanking.pageObjects.BasePage;

public class BaseClass extends BasePage {

	Logger log = null;
	
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String br) {
		System.out.println(br.toString());
		 log = Logger.getLogger("iSmart_Logger");
		 PropertyConfigurator.configure("log4j.propories");
		  
		if(br.equals("IE")) {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			
			System.out.println(System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
		}
		else if(br.equals("chrome")){
		
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else {
		System.out.println("Invalid browser");
		}
		 
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void CapureScreen(WebDriver driver,String sname) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("./Screenshots/Screen.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

package com.inetBanking.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.api.robot.Key;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Repo {

	public static ExtentReports extReports;
	public static ExtentHtmlReporter extHtmlRep;
	public static ExtentTest logger;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_MM_ss").format(new Date());
		String repName ="Test-Report"+timeStamp+".html";
			
		extHtmlRep = new ExtentHtmlReporter( repName);//"
		extHtmlRep.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
		
		System.out.println(System.getProperty("user.dir")+"\\test-output\\"+repName);
		System.out.println(System.getProperty("user.dir")+"\\extent-config.xml");

		
		extReports = new ExtentReports();
		
		extReports.attachReporter(extHtmlRep);

		extReports.setSystemInfo("Host Name", "Krishna-PC/Phanindra");
		extReports.setSystemInfo("Environment", "UAT/QA");
		extReports.setSystemInfo("User", "M Phanindra");
 		
		extHtmlRep.config().setDocumentTitle("SDE guru 99 bank");	
		extHtmlRep.config().setReportName("Automation Report");
		extHtmlRep.config().setTheme(Theme.DARK);
		
		logger= extReports.createTest("Google search","A simple and quick example for google search");
		//logger.log(Status.PASS, MarkupHelper.createLabel("One 11", ExtentColor.GREEN));
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		 logger.log(Status.INFO,"BeginRun");

 WebDriver driver = new ChromeDriver();
 logger.log(Status.INFO,"Driver launched");
 
 driver.get("https://www.google.com/");
 logger.log(Status.INFO,"URL google launched");

 WebElement xSearch = driver.findElement(By.name("q"));
 xSearch.sendKeys("Phanindra");
 logger.log(Status.INFO,"Search words sent");

  driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
  logger.log(Status.INFO,"Search ....");

  driver.close(); 
  driver.quit();
  logger.log(Status.INFO,"Close Quit");

  extReports.flush();
 
	}

}

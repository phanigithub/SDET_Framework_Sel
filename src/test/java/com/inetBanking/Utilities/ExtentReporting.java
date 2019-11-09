package com.inetBanking.Utilities;
//com.inetBanking.Utilities.ExtentReporting
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import freemarker.template.SimpleDate;
// Listener Class
public class ExtentReporting extends TestListenerAdapter{
	
	public ExtentReports extReports;
	public ExtentHtmlReporter extHtmlRep;
	public static ExtentTest logger;
	
	public void onStart(ITestContext testContest) {
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_MM_ss").format(new Date());
		String repName ="Test-Report"+timeStamp+".html";
			
		extHtmlRep = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\"+repName);//"
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
		
		//extReports.createTest("dumm sar");
		logger = extReports.createTest(testContest.getName());

 	}
	
	public void onTestSuccess(ITestResult i) {
		
		logger.log(Status.PASS, MarkupHelper.createLabel(i.getName(), ExtentColor.GREEN));
	}
	
public void onTestFailure(ITestResult i) {
	System.out.println("xxxxxxxxxxxxxxxxx");

	//logger = extReports.createTest(i.getName());
	logger.log(Status.FAIL,  MarkupHelper.createLabel(i.getName(), ExtentColor.RED));
	
	String spa = System.getProperty("user.dir")+"\\Screenshos\\"+i.getName()+".png";
	File f = new File(spa);
	if(f.exists()) {
		try {
			logger.fail("Screen below - "+logger.addScreencastFromPath(spa));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
}
	}

public void onTestSkipped(ITestResult i) {
	logger = extReports.createTest(i.getName());
	logger.log(Status.SKIP, MarkupHelper.createLabel(i.getName(), ExtentColor.ORANGE));
}

public void onFinish(ITestContext i) {
	extReports.flush();
}

public static void repoDescribe(String msg)
{
	System.out.println("repodescribe");
	//logger.log(Status.FAIL,  MarkupHelper.createLabel(i.getName(), ExtentColor.RED));
	logger.log(Status.INFO,  MarkupHelper.createLabel(msg, ExtentColor.RED));
	Reporter.log(msg);
}
	

}

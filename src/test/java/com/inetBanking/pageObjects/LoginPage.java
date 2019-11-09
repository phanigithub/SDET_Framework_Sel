package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	
	@FindBy(name="uid")
	WebElement txtUserName;	
	
	@FindBy(name="password")
	WebElement txtPassWord;	

	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	WebElement lnklogoff;

	
	public void setUserName(String Uname) {
		txtUserName.sendKeys(Uname);
	}
	
	public void setPassword(String pwd) {
		txtPassWord.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	public void logoff() {
		lnklogoff.click();
	}


}

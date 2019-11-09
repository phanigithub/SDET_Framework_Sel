package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver driver;
	public AddCustomerPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH,using="/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.NAME,using="name")
	WebElement CustomerName;
	
	@FindBy(how = How.NAME,using="rad1")
	WebElement rdGender;
	
	@FindBy(how = How.ID_OR_NAME,using="dob")
	WebElement dob;
	
	@FindBy(how = How.NAME,using="addr")
	WebElement addr;
	
	@FindBy(how = How.NAME,using="city")
	WebElement city;
	
	@FindBy(how = How.NAME,using="state")
	WebElement state;
	
	@FindBy(how = How.NAME,using="pinno")
	WebElement pinno;
	
	@FindBy(how = How.NAME,using="telephoneno")
	WebElement phoneno;
	
	@FindBy(how = How.NAME,using="emailid")
	WebElement emailid;
	
	@FindBy(how = How.NAME,using="password")
	WebElement password;
	
	@FindBy(how = How.NAME,using="sub")
	WebElement bSub;
	
	public void clickAddCustomer() {
		lnkAddNewCustomer.click();
	}
	public void CustomerName(String name) {
		CustomerName.sendKeys(name);
	}
	public void CustomerGender(String gndr) {
		rdGender.click();
	}
	
	public void Customerdob(String mon,String dd,String yyyy) {
		dob.sendKeys(mon);
		dob.sendKeys(dd);
		dob.sendKeys(yyyy);
	}
	public void CustomerAddress(String addr1) {
		addr.sendKeys(addr1);
	}
	
	public void Customercity(String cityv) {
		city.sendKeys(cityv);
	}
	public void Customerstate(String statev) {
		state.sendKeys(statev);
	}
	public void Customerpinno(String pinnov) {
		pinno.sendKeys(String.valueOf(pinnov)); //String.valueOf(num) o change number
	}
	public void Customerphone(String phonenov) {
		phoneno.sendKeys(String.valueOf(phonenov)); //String.valueOf(num) o change number
	}
	public void Customeremailid(String emailidv) {
		emailid.sendKeys(emailidv);
	}
	public void Customerpassword(String passwordv) {
		password.sendKeys(passwordv);
	}
	public void FormSub( ) {
             bSub.click();
}
	
	
	}

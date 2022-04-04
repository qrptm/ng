package com.inetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	/**
	 * User ID : mngr396721 Password : dYzujyn
	 */

	WebDriver localDriver;

	public LoginPage(WebDriver remoteDriver) {
		this.localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}

	@FindBy(name = "uid")
	WebElement username;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement password;
	
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement loginButton;
	
	public void setUsername(String uid) {
		username.sendKeys(uid);
	}
	
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickSubmit() {
		loginButton.click();
	}

}

package com.tutorialsninja.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-password")
	WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	WebElement emailPasswordNotMatchingWarning;

	
	public LoginPage(WebDriver driver) {
		
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	 
	
	}
	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);
	}
	public void enterPassword(String Password) {
		passwordField.sendKeys(Password);
	}
	public AccountPage loginBtn() {
		loginBtn.click();
		return new AccountPage(driver);
	}
	
	public String retriveEmailPasswordNotMatchingWarningMessegeText() {
		String WarningText= emailPasswordNotMatchingWarning.getText();
		return WarningText;
	}
	
}

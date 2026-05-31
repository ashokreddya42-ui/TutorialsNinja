package com.tutorialsninja.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	@FindBy(name="firstname")
	WebElement firstName;
	
	@FindBy(name="lastname")
	WebElement lastName;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(xpath="//input[@placeholder='Telephone']")
	WebElement telephoneField;
	
	@FindBy(name="password")
	WebElement passwordField;
	
	@FindBy(id="input-confirm")
	WebElement passwordConfirmField;
	
	@FindBy(name="agree")
	WebElement privacyPolocyField;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueButton;
	
	@FindBy(name="newsletter")
	WebElement yesNewsLetterOption;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement duplicateEmailWarningMessege;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement privacyPolicyWarningMessege;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	WebElement fristNameWarningMessege;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	WebElement lastnameWarningMessege;
	
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	WebElement emailWarningMessege;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	WebElement telephoneWarningMessege;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	WebElement passwordWarning;
	
	
	
	
	
	
	
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		
	}
	public void enterFirstName(String firstNameText) {
		firstName.sendKeys(firstNameText);
	}
	public void enterLastName(String lastNameText) {
		lastName.sendKeys(lastNameText);
		
	}
	public void enterEmail(String emailText) {
		email.sendKeys(emailText);
	}
	public void enterTelephone(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}
	public void passwordField(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	public void passwordConfirmField(String passwordConfirm) {
		passwordConfirmField.sendKeys(passwordConfirm);
		
	}
	public String duplicateWarningMessege() {
		String duplicateEmailWarning=duplicateEmailWarningMessege.getText();
		return duplicateEmailWarning;
	}
	
	public String privacyPolicyWarningMessege(){
		String privacyPolicyWarning=privacyPolicyWarningMessege.getText();
		return privacyPolicyWarning;
	}
	public String fristNameWarningMessege() {
		String fristNameWarning=fristNameWarningMessege.getText();
		return fristNameWarning;
	}
	public String lastnameWarningMessege() {
		String lastnameWarning=lastnameWarningMessege.getText();
		return lastnameWarning;
	}
	public String emailWarningMessege() {
		String emailWarning=emailWarningMessege.getText();
		return emailWarning;
	}
	public String telephoneWarningMessege() {
		String telephoneWarning=telephoneWarningMessege.getText();
		return telephoneWarning;
	}
	public String passwordWarning() {
		String passwordWarningMessege=passwordWarning.getText();
		return passwordWarningMessege;
	}
	
	
	
	
	public void selectNewsLetterOption() {
		yesNewsLetterOption.click();
	}
	public void privacyPolicy() {
		privacyPolocyField.click();
	}
	public void continueButton() {
		continueButton.click();
	}
	
	
	
	
	
	
}

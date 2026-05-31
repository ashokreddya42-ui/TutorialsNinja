 package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageObjects.AccountSuccessPage;
import com.tutorialsninja.qa.pageObjects.HomePage;
import com.tutorialsninja.qa.pageObjects.RegisterPage;
import com.tutorialsninja.qa.utilits.Utilities;

public class Register extends Base {
	public Register() {
		super();
	}
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserandOpenApplicationURL(prop.getProperty("browserName"));	
		HomePage hp=new HomePage(driver);
		hp.clickOnMyAccount();
		hp.selectRegisterOption();
		
	}
	@AfterMethod
	public void tearDown() {
	        driver.quit();
	    }
	

	@Test(priority=1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {
		RegisterPage rp=new RegisterPage(driver);
		rp.enterFirstName(DataProp.getProperty("firstName"));
		rp.enterLastName(DataProp.getProperty("lastName"));
		rp.enterEmail(Utilities.generateEmailIdWithTimeStamp());
		rp.enterTelephone(DataProp.getProperty("validTelephone"));
		rp.passwordField(prop.getProperty("validPassword"));
		rp.passwordConfirmField(prop.getProperty("validPassword"));
		rp.privacyPolicy();
		rp.continueButton();
		
		AccountSuccessPage asp=new AccountSuccessPage(driver);
		String SucessesMessege= asp.retriveAccoutnSuccessPageHeading();
		Assert.assertEquals(SucessesMessege,DataProp.getProperty("accountSuccessfullyCreatedHeadingHeading"),"Account page is not displayed");
		
	}
	@Test(priority=2)
	public void verifyRegisteringAccountByProvidingAllFields() {
		RegisterPage rp=new RegisterPage(driver);
		rp.enterFirstName(DataProp.getProperty("firstName"));
		rp.enterLastName(DataProp.getProperty("lastName"));
		rp.enterEmail(Utilities.generateEmailIdWithTimeStamp());
		rp.enterTelephone(DataProp.getProperty("validTelephone"));
		rp.passwordField(prop.getProperty("validPassword"));
		rp.passwordConfirmField(prop.getProperty("validPassword"));
		rp.selectNewsLetterOption();
		rp.privacyPolicy();
		rp.continueButton();
		
			AccountSuccessPage asp=new AccountSuccessPage(driver);	
			String SucessesMessege= asp.retriveAccoutnSuccessPageHeading();
			Assert.assertEquals(SucessesMessege,DataProp.getProperty("accountSuccessfullyCreatedHeadingHeading"),"Account page is not displayed");
		
	}
	@Test(priority=3)
	public void verifyRegisteringwithExistingEmail() {
		RegisterPage rp=new RegisterPage(driver);
		rp.enterFirstName(DataProp.getProperty("firstName"));
		rp.enterLastName(DataProp.getProperty("lastName"));
		rp.enterEmail(prop.getProperty("validEmailId"));
		rp.enterTelephone(DataProp.getProperty("validTelephone"));
		rp.passwordField(prop.getProperty("validPassword"));
		rp.passwordConfirmField(prop.getProperty("validPassword"));
		rp.selectNewsLetterOption();
		rp.privacyPolicy();
		rp.continueButton();
		
		String EmailExistingwarning=rp.duplicateWarningMessege();
		Assert.assertEquals(EmailExistingwarning,DataProp.getProperty("duplicateEmailWarning"),"Waring Messege regarding duplicate email address is not displayed");

	}
	@Test(priority=4)
	public void verifyRegisterwithoutDetails() {
			RegisterPage rp =new RegisterPage(driver);
			rp.continueButton();
			
			String privacyPolicy= rp.duplicateWarningMessege();
			Assert.assertEquals(privacyPolicy,DataProp.getProperty("privacyPolicyWarning"),"privacy policy messege is not displayed");
			
			String firstNameWarning=rp.fristNameWarningMessege();
			Assert.assertEquals(firstNameWarning,DataProp.getProperty("fristNameWarningMessege"),"First Name Warning Messege is not displayed");
			
			String lastNameWaring =rp.lastnameWarningMessege();
			Assert.assertEquals(lastNameWaring,DataProp.getProperty("lastNameWarningMessege"),"Last Name Warning messege is not displayed");
			
			String EmailWarning =rp.emailWarningMessege();
			Assert.assertEquals(EmailWarning,DataProp.getProperty("emailWarningMessege"),"Email address warning messege is not displayed");
			
			String Telephonewarning=rp.telephoneWarningMessege();
			Assert.assertEquals(Telephonewarning,DataProp.getProperty("telephoneWarningMessege"),"Telephone warning messege");
			
			String passwordwarning =rp.passwordWarning();
			Assert.assertEquals(passwordwarning,DataProp.getProperty("passwordWarningMessege"),"password messege is not displayed");
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	}
}

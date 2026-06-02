package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageObjects.AccountPage;
import com.tutorialsninja.qa.pageObjects.HomePage;
import com.tutorialsninja.qa.pageObjects.LoginPage;
import com.tutorialsninja.qa.utilits.Utilities;

public class Login extends Base {

	public Login() {
		super();
	}

	//WebDriver is Interface
	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = initializeBrowserandOpenApplicationURL(prop.getProperty("browserName"));
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccount();
		hp.loginOption();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1, dataProvider = "supplyTestData")
	public void verifyLoginWithValidCredentials(String email, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.enterEmailAddress(email);
		lp.enterPassword(password);
		lp.loginBtn();

		AccountPage AP = new AccountPage(driver);
		Assert.assertTrue(AP.getDisplayStatusOfEditYourAccountInformationOption(),
				"Edit Your Account Information Optio is Not Displayed");
	}

	@DataProvider
	public Object[][] supplyTestData() {
		Object[][] data = Utilities.getTestDataFromExcel("Sheet1");

		return data;
	}

	@Test(priority = 2)
	public void verifyLoginWithInValidCredentials() {
		LoginPage lp = new LoginPage(driver);
		lp.enterEmailAddress(Utilities.generateEmailIdWithTimeStamp());
		lp.enterPassword(DataProp.getProperty("invalidPassword"));
		lp.loginBtn();
		String actuallyWarningMessege = lp.retriveEmailPasswordNotMatchingWarningMessegeText();
		String expectedWaringMessege = DataProp.getProperty("emailPasswordNoMatchingMessege");
		Assert.assertTrue(actuallyWarningMessege.contains(expectedWaringMessege),
				"Expected Warning Messege is not displayed");

	}

	@Test(priority = 3)
	public void verifyLoginWithInValidEmailAndValidPassword() {
		LoginPage lp = new LoginPage(driver);
		lp.enterEmailAddress(Utilities.generateEmailIdWithTimeStamp());
		lp.enterPassword(prop.getProperty("validPassword"));
		lp.loginBtn();
		String actuallyWarningMessege = lp.retriveEmailPasswordNotMatchingWarningMessegeText();
		String expectedWaringMessege = DataProp.getProperty("emailPasswordNoMatchingMessege");
		Assert.assertTrue(actuallyWarningMessege.contains(expectedWaringMessege),
				"Expected Warning Messege is not displayed");

	}

	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInValidPassword() {
		LoginPage lp = new LoginPage(driver);
		lp.enterEmailAddress(prop.getProperty("validEmailId"));
		lp.enterPassword(DataProp.getProperty("invalidPassword"));
		lp.loginBtn();
		String actuallyWarningMessege = lp.retriveEmailPasswordNotMatchingWarningMessegeText();
		String expectedWaringMessege = DataProp.getProperty("emailPasswordNoMatchingMessege");
		Assert.assertTrue(actuallyWarningMessege.contains(expectedWaringMessege),
				"Expected Warning Messege is not displayed");

	}

	@Test(priority = 5)
	public void verifyLoginWithOutCredentials() {

		LoginPage lp = new LoginPage(driver);
		lp.loginBtn();
		String actuallyWarningMessege = lp.retriveEmailPasswordNotMatchingWarningMessegeText();
		String expectedWaringMessege = DataProp.getProperty("emailPasswordNoMatchingMessege");
		Assert.assertTrue(actuallyWarningMessege.contains(expectedWaringMessege),
				"Expected Warning Messege is not displayed");

	}

}

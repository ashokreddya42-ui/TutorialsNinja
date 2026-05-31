package com.tutorialsninja.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	//Objects
	@FindBy(xpath="//a[@title='My Account']") 
	 WebElement myAccountMenu;
	
	@FindBy(linkText="Login")
    WebElement loginOption;
	
	@FindBy(linkText="Register")
	WebElement selectRegisterOption;
	
	@FindBy(xpath="//input[@name='search']")
	WebElement searchbox;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	WebElement clickOnSearchBtn;
	

	
	//create constructor
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//Actions
	
	public void clickOnMyAccount() {
		myAccountMenu.click();
	}
	public LoginPage loginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	public void selectRegisterOption() {
		selectRegisterOption.click();
	}
	public void enterProduct(String ProductText) {
		searchbox.sendKeys(ProductText);
	}
	public void searchClick() {
		clickOnSearchBtn.click();
	}

}

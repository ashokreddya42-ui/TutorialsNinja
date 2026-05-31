package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageObjects.HomePage;
import com.tutorialsninja.qa.pageObjects.SearchPage;

public class Search extends Base{
	public Search() {
		super();
	}

	WebDriver driver;
	@BeforeMethod
		
	public void setUp() {
	
		driver =initializeBrowserandOpenApplicationURL(prop.getProperty("browserName"));
		
	}
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		HomePage HP=new HomePage(driver);
		HP.enterProduct(DataProp.getProperty("valiProduct"));
		HP.searchClick();
		SearchPage sp=new SearchPage(driver);
		Assert.assertTrue(sp.displayofHPProuduct(),"Valid Product HP is not displayed in the search result Page");
	}
	@Test(priority=2)
    public void verifySearchWithInValidProduct() {
		HomePage HP=new HomePage(driver);
		HP.enterProduct(DataProp.getProperty("inValidProduct"));
		HP.searchClick();
		
		SearchPage sp=new SearchPage(driver);
		String ActuallyWarningMessegge = sp.productNotDisplayed();
		Assert.assertEquals(ActuallyWarningMessegge,DataProp.getProperty("noProductTextInSearchResult"));
	}
	@Test(priority=3)
    public void verifySearchWithOutProduct() {
		
		HomePage hp=new HomePage(driver);
		hp.searchClick();
		SearchPage sp=new SearchPage(driver);
		
		String ActuallyWarningMessegge = sp.productNotDisplayed();
		Assert.assertEquals(ActuallyWarningMessegge,DataProp.getProperty("noProductTextInSearchResult"));
	
		
    }
}

package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.ConstantsUtil;

public class HomePageTest extends BaseTest {
	
	
	@BeforeClass
	public void homePageSetup(){
	homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	
	}	
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title=homePage.homePageTitle();
		System.out.println("The title of the Home Page:"+title);
		Assert.assertEquals(title,ConstantsUtil.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyHomePageHeaderTest(){
		String header =homePage.getHeaderValue();
		System.out.println("The Header of HomePage is:"+ header);
		Assert.assertEquals(header, ConstantsUtil.HOME_PAGE_HEADER);
	}
	
	@Test(priority=3)
	public void verifySettingsIconTest(){
	Assert.assertTrue(homePage.isSettingIconExists());
	}


}

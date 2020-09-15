package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.listeners.TestAllureListener;
import com.qa.hubspot.utils.ConstantsUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners(TestAllureListener.class)
@Epic("Epic-100: Design Login Page Module for the Hubspot Application")
@Story("User Story: Login Page Functionality Validation and verification")
public class LoginPageTest extends BaseTest {
	@Description("Verify LoginPageTitle")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void verifyLoginPageTitleTest(){
		String title=loginPage.getLoginPageTitle();	
		System.out.println("LoginPage title is :"+title);
		Assert.assertEquals(title, ConstantsUtil.LOGIN_PAGE_TITLE);
	}
	
	@Description("Verify Sign up Link Test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=1)
	public void verifySignUpLinkText(){
		Assert.assertTrue(loginPage.isSignUpLinkExists());
	}
	
	@Description("Verify User login")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=3)
	public void verifyDoLogin(){
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	

}

package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ConstantsUtil;
import com.qa.hubspot.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	//By locators - OR 
	private By emailId= By.id("username");
	private By password=By.id("password");
	private By loginBtn=By.id("loginBtn");
	private By signUpLink=By.linkText("Sign up");
	
	//Constructor of the Page
	public LoginPage(WebDriver driver){
		elementUtil=new ElementUtil(driver);
		this.driver=driver;
	}
	
	//Page Actions
	@Step("Getting Login Page Title")
	public String getLoginPageTitle(){
		//return driver.getTitle();
		return elementUtil.waitForTitlePresent(ConstantsUtil.LOGIN_PAGE_TITLE, 20);
	}
	
	@Step("Verify if SignUp Link Exists on Login Page")
	public Boolean isSignUpLinkExists(){
		//return driver.findElement(signUpLink).isDisplayed();
		return elementUtil.doIsDisplayed(signUpLink);
	}
	
	@Step("User login with username :{0} and password :{1}")
	public HomePage doLogin(String un,String pwd){
//		driver.findElement(emailId).sendKeys(un);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginBtn).click();
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		return new HomePage(driver);
	}

}
